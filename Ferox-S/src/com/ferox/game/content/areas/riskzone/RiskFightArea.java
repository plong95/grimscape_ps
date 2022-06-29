package com.ferox.game.content.areas.riskzone;

import com.ferox.game.world.World;
import com.ferox.game.world.entity.AttributeKey;
import com.ferox.game.world.entity.combat.skull.SkullType;
import com.ferox.game.world.entity.combat.skull.Skulling;
import com.ferox.game.world.entity.mob.player.Player;
import com.ferox.game.world.object.GameObject;
import com.ferox.game.world.position.Area;
import com.ferox.net.packet.interaction.PacketInteraction;
import com.ferox.util.Color;
import com.ferox.util.Utils;
import com.ferox.util.timers.TimerKey;

import static com.ferox.util.ObjectIdentifiers.*;

public class RiskFightArea extends PacketInteraction {

    public static final Area NH_AREA = new Area(3117, 3505, 3122, 3517);
    public static final Area ONE_V_ONE_1 = new Area(3111, 3505, 3116, 3509);
    public static final Area ONE_V_ONE_2 = new Area(3103, 3513, 3110, 3517);
    public static final Area ONE_V_ONE_3 = new Area(3111, 3513, 3116, 3517);

    @Override
    public boolean handleObjectInteraction(Player player, GameObject object, int option) {
        if(option == 1) {
            var risk = player.<Long>getAttribOr(AttributeKey.RISKED_WEALTH, 0L);
            if(object.getId() == BELL_21394) {
                if (player.getTimers().has(TimerKey.RISK_FIGHT_BELL)) {
                    player.message(Color.RED.wrap("You can ring the bell again in " + player.getTimers().asMinutesAndSecondsLeft(TimerKey.RISK_FIGHT_BELL) + "."));
                } else {
                    player.getTimers().register(TimerKey.RISK_FIGHT_BELL, 300);
                    World.getWorld().sendWorldMessage("<img=162>" + Color.BLUE.wrap(player.getUsername()) + Color.RAID_PURPLE.wrap(" has just rung the bell at the risk zone and is looking for a fight!"));
                }
                return true;
            }
            if(object.getId() == MAGICAL_BARRIER_31808) {
                player.teleport(player.tile().transform(0, player.tile().y <= 3504 ? +1 : -1));
                return true;
            }
            if(object.getId() == ENERGY_BARRIER_4470) {
                //500k risk area
                if(object.tile().equals(3106,3512,0) || object.tile().equals(3107,3512,0)) {
                    player.getRisk().update(); // make sure our wealth is up to date.
                    if (risk <= 500_000) {
                        player.message(Color.RED.wrap("You need to risk at least 500K blood money to enter this risk zone."));
                        return true;
                    }
                    if (player.tile().y == 3512 && (player.tile().x == 3106 || player.tile().x == 3107)) {
                        Skulling.assignSkullState(player, SkullType.RED_SKULL);
                        player.forceChat("I am currently risking "+ Utils.formatNumber(risk)+" BM!");
                        player.teleport(player.tile().transform(0, 1));
                    } else if (player.tile().y == 3513 && (player.tile().x == 3106 || player.tile().x == 3107)) {
                        Skulling.unskull(player);
                        player.teleport(player.tile().transform(0, -1));
                    }
                    return true;
                }
                //250k risk area
                if(object.tile().equals(3110,3508,0) || object.tile().equals(3110,3507,0)) {
                    player.getRisk().update(); // make sure our wealth is up to date.
                    if (risk <= 250_000) {
                        player.message(Color.RED.wrap("You need to risk at least 250K blood money to enter this risk zone."));
                        return true;
                    }
                    if (player.tile().x == 3110 && (player.tile().y == 3507 || player.tile().y == 3508)) {
                        Skulling.assignSkullState(player, SkullType.RED_SKULL);
                        player.forceChat("I am currently risking "+ Utils.formatNumber(risk)+" BM!");
                        player.teleport(player.tile().transform(1, 0));
                    } else if(player.tile().x == 3111 && (player.tile().y == 3507 || player.tile().y == 3508)) {
                        Skulling.unskull(player);
                        player.teleport(player.tile().transform(-1, 0));
                    }
                    return true;
                }
                //1M risk area
                if(object.tile().equals(3112,3512,0) || object.tile().equals(3113,3512,0)) {
                    player.getRisk().update(); // make sure our wealth is up to date.
                    if (risk <= 1_000_000) {
                        player.message(Color.RED.wrap("You need to risk at least 1M blood money to enter this risk zone."));
                        return true;
                    }
                    if (player.tile().y == 3512 && (player.tile().x == 3112 || player.tile().x == 3113)) {
                        Skulling.assignSkullState(player, SkullType.RED_SKULL);
                        player.forceChat("I am currently risking "+ Utils.formatNumber(risk)+" BM!");
                        player.teleport(player.tile().transform(0, +1));
                    } else if(player.tile().y == 3513 && (player.tile().x == 3112 || player.tile().x == 3113)) {
                        Skulling.unskull(player);
                        player.teleport(player.tile().transform(0, -1));
                    }
                    return true;
                }
                //No restrictions here
                if(object.tile().equals(3117,3512,0) || object.tile().equals(3117,3511,0) || object.tile().equals(3117,3510,0)) {
                    if (player.tile().x == 3116 && (player.tile().y == 3510 || player.tile().y == 3511 || player.tile().y == 3512)) {
                        Skulling.assignSkullState(player, SkullType.RED_SKULL);
                        player.forceChat("I am currently risking "+ Utils.formatNumber(risk)+" BM!");
                        player.teleport(player.tile().transform(+1, 0));
                    } else if(player.tile().x == 3117 && (player.tile().y == 3510 || player.tile().y == 3511 || player.tile().y == 3512)) {
                        Skulling.unskull(player);
                        player.teleport(player.tile().transform(-1, 0));
                    }
                    return true;
                }
                return true;
            }
        }
        return false;
    }
}
