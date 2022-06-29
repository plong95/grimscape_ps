package com.ferox.db.transactions

import com.ferox.GameServer
import com.ferox.db.makeQuery
import com.ferox.db.onDatabase
import com.ferox.db.query
import com.ferox.game.GameEngine
import com.ferox.game.content.achievements.Achievements
import com.ferox.game.content.achievements.AchievementsManager
import com.ferox.game.content.skill.impl.slayer.SlayerConstants
import com.ferox.game.world.World
import com.ferox.game.world.entity.AttributeKey
import com.ferox.game.world.entity.mob.player.Player
import com.ferox.game.world.entity.mob.player.QuestTab
import com.ferox.game.world.entity.mob.player.rights.MemberRights
import com.ferox.game.world.items.Item
import com.ferox.util.Color
import com.ferox.util.CustomItemIdentifiers
import com.ferox.util.CustomItemIdentifiers.DOUBLE_DROPS_LAMP
import com.ferox.util.ItemIdentifiers.BLOOD_MONEY
import com.ferox.util.Utils
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import java.time.Duration
import java.time.LocalDateTime
import java.util.concurrent.atomic.AtomicInteger
import kotlin.math.abs

object CollectVotes {

    class VoteLog(val ip: String, val mac: String, val timestamp: LocalDateTime)

    var voteHistory: MutableList<VoteLog> = ArrayList()

    private val logger: Logger = LogManager.getLogger(CollectVotes::class)

    fun Player.collectVotes() {
        // get a list of siteID, rowId, IP
        query<List<Triple<Int, Int, String>>> {
            val list = mutableListOf<Triple<Int, Int, String>>()
            prepareStatement(
                connection,
                "SELECT * FROM votes WHERE lower(username) = :user AND claimed=0 AND voted_on != -1"
            ).apply {
                setString("user", username.toLowerCase())
                execute()
                while (resultSet.next()) {
                    // so the result here is site_id, id and ip. for 1 vote.
                    list.add(
                        Triple(
                            resultSet.getInt("site_id"),
                            resultSet.getInt("id"),
                            resultSet.getString("ip_address")
                        )
                    )
                }
            }
            list
        }.onDatabase(GameServer.votesDb) { list ->
            if (list.isEmpty()) {
                message("There are no pending votes to claim. Wait a minute and try again, or contact an")
                message("Administrator.")
            }
            val votes = AtomicInteger(0)
            // heres the list loop for each single vote
            list.forEachIndexed { index, row ->

                // now query again, setting claimed after we've confirmed they have space
                makeQuery {
                    prepareStatement(connection, "UPDATE votes SET claimed=1 WHERE id=:id").apply {
                        setInt("id", row.second)
                        execute()
                    }
                }.onDatabase(GameServer.votesDb) {

                    votes.incrementAndGet()

                    if (index == list.size - 1) {
                        // the last one in the loop.
                        GameEngine.getInstance().addSyncTask {
                            val now = LocalDateTime.now()
                            val currentMac: String = getAttribOr(AttributeKey.MAC_ADDRESS, "invalid")
                            //Either IP or Mac matches check if 12 hours have passed.

                            val inLast12h = voteHistory.stream()
                                    .filter { v -> v.mac == currentMac || v.ip == hostAddress }
                                    .anyMatch { v ->
                                        val duration2 = Duration.between(v.timestamp, now)
                                        val diff2 = abs(duration2.toHours())
                                        diff2 < 12
                                    }

                            if (inLast12h) {
                                message(Color.RED.wrap("You have already voted the past 12 hours."))
                                return@addSyncTask
                            }
                            var points = votes.toInt()

                            val electionDay = slayerRewards.unlocks.containsKey(SlayerConstants.ELECTION_DAY) && World.getWorld().rollDie(5,1)
                            if(electionDay) {
                                points *= 2
                            }

                            if(World.getWorld().doubleVotePoints())
                                points *= 2

                            //World message is important people like "shine"
                            World.getWorld()
                                .sendWorldMessage("<img=1081>" + username.toString() + " just received <col=" + Color.BLUE.colorValue.toString() + ">" + points + " vote points</col> for voting! Support us at <col=" + Color.BLUE.colorValue.toString() + ">::vote</col>!")
                            message("You have claimed your vote points.")

                            val changeForDonatorMysteryBox: Int = when (memberRights) {
                                MemberRights.SPONSOR_MEMBER -> 7
                                MemberRights.VIP -> 6
                                MemberRights.LEGENDARY_MEMBER -> 5
                                MemberRights.EXTREME_MEMBER -> 4
                                MemberRights.ELITE_MEMBER -> 3
                                MemberRights.SUPER_MEMBER -> 2
                                MemberRights.MEMBER -> 1
                                else -> 0
                            }

                            if (Utils.percentageChance(changeForDonatorMysteryBox)) {
                                inventory().addOrBank(Item(CustomItemIdentifiers.DONATOR_MYSTERY_BOX, 1))
                                World.getWorld().sendWorldMessage("<img=1081>" + username.toString() + " was lucky and received <col=" + Color.HOTPINK.colorValue.toString() + "> a Donator mystery box from voting!")
                                //logger.info("$username was lucky and received a Donator mystery box from voting!")
                                Utils.sendDiscordInfoLog("$username was lucky and received a Donator mystery box from voting!")
                            }

                            val bm = World.getWorld().random(500, 5000)
                            inventory().addOrBank(Item(BLOOD_MONEY, bm))
                            message("You have received "+Utils.formatNumber(bm)+" blood money for voting.")

                            inventory().addOrBank(Item(DOUBLE_DROPS_LAMP, 1))
                            message("You have received x1 double drops lamp for voting.")

                            //Increase achievements
                            AchievementsManager.activate(this, Achievements.VOTE_FOR_US_I, votes.toInt())
                            AchievementsManager.activate(this, Achievements.VOTE_FOR_US_II, votes.toInt())
                            AchievementsManager.activate(this, Achievements.VOTE_FOR_US_III, votes.toInt())

                            if(electionDay) {
                                World.getWorld().sendWorldMessage("<img=1081>" + Color.PURPLE.wrap(username.toString()) + " just activated his "+Color.RED.wrap("Election day")+" perk and doubled their vote points!")
                            }

                            // and here is reward inside the loop for 1 vote. so this code runs x times how many votes
                            val increaseBy = getAttribOr<Int>(AttributeKey.VOTE_POINS, 0) + points
                            putAttrib(AttributeKey.VOTE_POINS, increaseBy)
                            packetSender.sendString(QuestTab.InfoTab.VOTE_POINTS.childId, QuestTab.InfoTab.INFO_TAB[QuestTab.InfoTab.VOTE_POINTS.childId]!!.fetchLineData(this))

                            voteHistory.add(VoteLog(hostAddress, currentMac, now))
                        }
                    }
                }
            }
        }
    }
}
