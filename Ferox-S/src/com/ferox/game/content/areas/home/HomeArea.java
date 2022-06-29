package com.ferox.game.content.areas.home;

import com.ferox.game.content.areas.edgevile.IronManTutor;
import com.ferox.game.content.packet_actions.interactions.objects.Ladders;
import com.ferox.game.content.tradingpost.TradingPost;
import com.ferox.game.world.World;
import com.ferox.game.world.entity.mob.npc.Npc;
import com.ferox.game.world.entity.mob.player.Player;
import com.ferox.game.world.entity.mob.player.Skills;
import com.ferox.game.world.object.GameObject;
import com.ferox.game.world.position.Tile;
import com.ferox.game.world.route.StepType;
import com.ferox.net.packet.interaction.PacketInteraction;
import com.ferox.util.chainedwork.Chain;

import static com.ferox.util.NpcIdentifiers.*;
import static com.ferox.util.ObjectIdentifiers.STAIRCASE_25801;
import static com.ferox.util.ObjectIdentifiers.STAIRCASE_25935;

/**
 * @author Patrick van Elderen | April, 23, 2021, 10:49
 * @see <a href="https://github.com/PVE95">Github profile</a>
 */
public class HomeArea extends PacketInteraction {

    @Override
    public boolean handleObjectInteraction(Player player, GameObject object, int option) {
        if(option == 1) {
            if(object.getId() == 14398) {
                if(object.tile().equals(2037,3621,0)) {
                    player.lockDelayDamage();
                    Chain.bound(player).name("FaladorTightrope1Task").runFn(1, () -> {
                        player.looks().render(763, 762, 762, 762, 762, 762, -1);
                        player.agilityWalk(false);
                        player.stepAbs(2053, 3621, StepType.FORCE_WALK);
                    }).waitForTile(new Tile(2053, 3621), () -> {
                        player.agilityWalk(true);
                        player.looks().resetRender();
                        player.skills().addXp(Skills.AGILITY, 17.0);
                        player.unlock();
                    });
                    return true;
                }
                player.lockDelayDamage();
                Chain.bound(player).name("FaladorTightrope1Task").runFn(1, () -> {
                    player.looks().render(763, 762, 762, 762, 762, 762, -1);
                    player.agilityWalk(false);
                    player.stepAbs(2037, 3621, StepType.FORCE_WALK);
                }).waitForTile(new Tile(2037, 3621), () -> {
                    player.agilityWalk(true);
                    player.looks().resetRender();
                    player.skills().addXp(Skills.AGILITY, 17.0);
                    player.unlock();
                });
                return true;
            }
            if(object.getId() == 31675) {
                player.getSlayerKey().open();
                return true;
            }
            if(object.getId() == 23311) {
                player.getPacketSender().sendString(29078, "World Teleports - Favourite");
                player.setCurrentTabIndex(1);
                player.getTeleportInterface().displayFavorites();
                player.getInterfaceManager().open(29050);
                return true;
            }
            if (object.getId() == STAIRCASE_25801) {
                Ladders.ladderDown(player, new Tile(2021, 3567, 0), true);
                return true;
            }
            if (object.getId() == STAIRCASE_25935) {
                Ladders.ladderUp(player, new Tile(2021, 3567, 1), true);
                return true;
            }
        }
        if(option == 2) {
        }
        return false;
    }

    @Override
    public boolean handleNpcInteraction(Player player, Npc npc, int option) {
        if(option == 1) {
            if(npc.id() == GERRANT_2891) {
                World.getWorld().shop(46).open(player);
                return true;
            }
            if(npc.id() == GRAND_EXCHANGE_CLERK) {
                TradingPost.open(player);
                return true;
            }
            if(npc.id() == TRAIBORN) {
                World.getWorld().shop(30).open(player);
                return true;
            }
            if(npc.id() == GUNNJORN) {
                World.getWorld().shop(33).open(player);
                return true;
            }
            if(npc.id() == RADIGAD_PONFIT) {
                World.getWorld().shop(36).open(player);
                return true;
            }
            if(npc.id() == SHOP_ASSISTANT_2820) {
                World.getWorld().shop(1).open(player);
                return true;
            }
        }
        if(option == 2) {
            if(npc.id() == GERRANT_2891) {
                World.getWorld().shop(46).open(player);
                return true;
            }
            if(npc.id() == TRAIBORN) {
                World.getWorld().shop(29).open(player);
                return true;
            }
            if(npc.id() == GUNNJORN) {
                World.getWorld().shop(32).open(player);
                return true;
            }
            if(npc.id() == RADIGAD_PONFIT) {
                World.getWorld().shop(35).open(player);
                return true;
            }
            if(npc.id() == GRUM_2889) {
                World.getWorld().shop(38).open(player);
                return true;
            }
            if(npc.id() == JATIX) {
                World.getWorld().shop(40).open(player);
                return true;
            }
        }
        if(option == 3) {
            if(npc.id() == TRAIBORN) {
                World.getWorld().shop(31).open(player);
                return true;
            }
            if(npc.id() == GUNNJORN) {
                World.getWorld().shop(34).open(player);
                return true;
            }
            if(npc.id() == RADIGAD_PONFIT) {
                World.getWorld().shop(37).open(player);
                return true;
            }
        }
        if(option == 4) {

        }
        return false;
    }
}
