package com.ferox.game.content.areas.wilderness.content.todays_top_pkers;

import com.ferox.GameServer;
import com.ferox.game.GameEngine;
import com.ferox.game.task.Task;
import com.ferox.game.task.TaskManager;
import com.ferox.game.world.World;
import com.ferox.game.world.entity.AttributeKey;
import com.ferox.game.world.entity.combat.skull.Skulling;
import com.ferox.game.world.entity.mob.player.GameMode;
import com.ferox.game.world.entity.mob.player.IronMode;
import com.ferox.game.world.entity.mob.player.Player;
import com.ferox.game.world.entity.mob.player.rights.PlayerRights;
import com.ferox.game.world.entity.mob.player.save.PlayerSave;
import com.ferox.game.world.items.Item;
import com.ferox.util.Color;
import com.ferox.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;
import java.util.*;

import static com.ferox.game.world.entity.AttributeKey.*;
import static com.ferox.util.CustomItemIdentifiers.*;

/**
 * Created by Kaleem on 24/11/2017.
 */
public final class TopPkers {

    private static final Logger logger = LoggerFactory.getLogger(TopPkers.class);

    public static final TopPkers SINGLETON = new TopPkers();

    private static final LocalTime ANNOUNCEMENT_TIME = LocalTime.of(22, 0, 0); //10PM

    private static final int ANNOUNCEMENT_AMOUNT = 3;

    private final Map<String, Integer> totalKills = new HashMap<>();

    public final Task announcementTask = new Task("TopPkersAnnouncementTask") {
        private boolean announced = false;

        @Override
        protected void execute() {
            LocalTime currentTime = LocalTime.now();
            if (currentTime.isAfter(ANNOUNCEMENT_TIME)) {
                if (!announced) {
                    announce();
                    announced = true;
                }
            } else {
                announced = false;
            }
        }
    };

    public void init() {
        TaskManager.submit(announcementTask);
    }

    public void increase(String username) {
        totalKills.merge(username, 1, Integer::sum);
    }

    public void announce() {
        broadcast("<sprite=780> <col=800000>Today's top PKers are now being announced:");

        for (int i = 0; i < ANNOUNCEMENT_AMOUNT; i++) {
            var entry = getAndTakeTop();
            var position = i + 1;
            var details = "Nobody";

            var sprite = position == 1 ? 203 : position == 2 ? 202 : 201;

            if (entry != null) {
                var reward = position == 1 ? new Item(TWENTY_DOLLAR_BOND) : position == 2 ? new Item(TEN_DOLLAR_BOND) : new Item(FIVE_DOLLAR_BOND);
                logger.trace("{} was selected as todays {} best PK-er, being awarded with a {}.", entry.getUsername(), position, reward.name());
                String rewardMsg = "who has been awarded with a " + reward.name() + "!";
                details = Color.BLUE.tag() + "" + entry.getUsername() + " " + Color.BLACK.tag() + "with " + entry.getKills() + " kills - " + rewardMsg;
                give(entry, position, reward);
            }

            broadcast("<sprite=" + sprite + ">" + position + getSuffix(position) + ": " + details);
        }

        totalKills.clear();
    }

    private void broadcast(String message) {
        World.getWorld().getPlayers().forEach(player -> player.message(message));
    }

    private void give(KillEntry entry, int position, Item reward) {
        String playerName = entry.getUsername();
        Optional<Player> playerToGive = World.getWorld().getPlayerByName(playerName);
        if (playerToGive.isEmpty()) {
            Player player = new Player();
            player.setUsername(playerName);
            GameEngine.getInstance().submitLowPriority(() -> {
                try {
                    if (PlayerSave.loadOfflineWithoutPassword(player)) {
                        player.putAttrib(TOP_PKER_REWARD_UNCLAIMED, true);
                        player.putAttrib(TOP_PKER_POSITION, position);
                        player.putAttrib(TOP_PKER_REWARD, reward);
                        PlayerSave.save(player);
                    } else {
                        logger.error("Something went wrong offline reward for offline Player " + player.getUsername());
                    }
                } catch (Exception e) {
                    logger.error("Something went wrong offline reward for offline Player " + player.getUsername());
                    logger.error("TopPkers give() error: ", e);
                }
            });
            return;
        }
        playerToGive.get().inventory().addOrBank(reward);
        playerToGive.get().message("Congratulations, you finished " + position + getSuffix(position) + " in the top PKers!");
    }

    public void checkForReward(Player player) {
        var position = player.<Integer>getAttribOr(TOP_PKER_POSITION, 0);
        var rewardUnclaimed = player.<Boolean>getAttribOr(TOP_PKER_REWARD_UNCLAIMED, false);

        //Player is infact a top pker
        if (position > 0) {
            System.out.println("enter");
            //Reward wasn't claimed yet, lets claim.
            if (rewardUnclaimed) {
                System.out.println("enter2");
                Item reward = player.getAttribOr(TOP_PKER_REWARD, null);
                if (reward != null) {
                    System.out.println("enter3");
                    player.inventory().addOrBank(reward);
                    player.message("Congratulations, you finished " + position + getSuffix(position) + " in todays top PKers!");
                    player.clearAttrib(TOP_PKER_POSITION);
                    player.clearAttrib(TOP_PKER_REWARD_UNCLAIMED);
                    player.clearAttrib(TOP_PKER_REWARD);
                }
            }
        }
    }

    public KillEntry getAndTakeTop() {
        KillEntry top = getTop();
        if (top != null) {
            totalKills.remove(top.getUsername());
        }
        return top;
    }

    public KillEntry getTop() {
        Optional<Map.Entry<String, Integer>> entry = totalKills.entrySet().stream().max(Map.Entry.comparingByValue());
        return entry.map(stringIntegerEntry -> new KillEntry(stringIntegerEntry.getKey(), stringIntegerEntry.getValue())).orElse(null);
    }

    public void openLeaderboard(Player player) {
        if (totalKills.isEmpty()) {
            player.sendScroll("<col=800000>Today's Top Pkers", "Nobody");
            return;
        }

        //System.out.println(totalKills.toString());
        List<String> info = new ArrayList<>();

        totalKills.forEach((name, killCount) -> info.add(name + " Kills - " + killCount));

        player.sendScroll("<col=800000>Today's Top Pkers", info.toArray(new String[0]));
    }

    private static String getSuffix(int position) {
        if (position == 1) {
            return "st";
        } else if (position == 2) {
            return "nd";
        } else if (position == 3) {
            return "rd";
        }
        return "th";
    }

}
