package com.ferox.game.content.consumables.potions.impl;

import com.ferox.game.content.EffectTimer;
import com.ferox.game.task.Task;
import com.ferox.game.task.TaskManager;
import com.ferox.game.world.entity.AttributeKey;
import com.ferox.game.world.entity.mob.player.Player;
import com.ferox.util.Color;
import com.ferox.util.Utils;

/**
 * @author PVE
 * @Since juli 28, 2020
 */
public class AntifirePotion {

    public static void onLogin(Player player) {
        int ticks = player.getAttribOr(AttributeKey.ANTIFIRE_POTION, 0);
        setTimer(player);
        int seconds = (int) Utils.ticksToSeconds(ticks);
        player.getPacketSender().sendEffectTimer(seconds, EffectTimer.ANTIFIRE);
    }

    public static void setTimer(Player player) {
        player.putAttrib(AttributeKey.ANTIFIRE_TASK_RUNNING, true);
        TaskManager.submit(new Task("AntifireTask", 1, false) {

            @Override
            protected void execute() {
                int ticks = player.getAttribOr(AttributeKey.ANTIFIRE_POTION, 0);

                if (!player.isRegistered() || player.dead() || ticks == 0) {
                    stop();
                    player.clearAttrib(AttributeKey.ANTIFIRE_TASK_RUNNING);
                    return;
                }

                if (ticks > 0) {
                    ticks -= 1;

                    if (ticks == 0) {
                        player.message(Color.RED.tag() + "Your antifire potion has expired.");
                        player.putAttrib(AttributeKey.ANTIFIRE_POTION, 0);
                        player.putAttrib(AttributeKey.SUPER_ANTIFIRE_POTION, false);
                        player.clearAttrib(AttributeKey.ANTIFIRE_TASK_RUNNING);
                        player.getPacketSender().sendEffectTimer(0, EffectTimer.ANTIFIRE);
                        stop();
                    } else {
                        player.putAttrib(AttributeKey.ANTIFIRE_POTION, ticks);
                        if (ticks == 3) {
                            player.message(Color.RED.tag() + "Your antifire potion is about to expire.");
                        }
                    }
                }
            }
        });
    }
}
