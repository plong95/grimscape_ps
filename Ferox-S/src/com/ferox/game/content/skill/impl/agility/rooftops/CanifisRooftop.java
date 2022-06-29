package com.ferox.game.content.skill.impl.agility.rooftops;

import com.ferox.game.content.skill.impl.agility.MarksOfGrace;
import com.ferox.game.content.skill.impl.agility.UnlockAgilityPet;
import com.ferox.game.task.TaskManager;
import com.ferox.game.task.impl.ForceMovementTask;
import com.ferox.game.world.World;
import com.ferox.game.world.entity.mob.Direction;
import com.ferox.game.world.entity.mob.movement.MovementQueue;
import com.ferox.game.world.entity.mob.player.ForceMovement;
import com.ferox.game.world.entity.mob.player.Player;
import com.ferox.game.world.entity.mob.player.Skills;
import com.ferox.game.world.object.GameObject;
import com.ferox.game.world.position.Tile;
import com.ferox.net.packet.interaction.PacketInteraction;
import com.ferox.util.chainedwork.Chain;

import java.util.Arrays;
import java.util.List;

import static com.ferox.util.ObjectIdentifiers.*;

/**
 * @author Patrick van Elderen <patrick.vanelderen@live.nl>
 * juni 14, 2020
 */
public class CanifisRooftop extends PacketInteraction {
    
    private static final List<Tile> MARK_SPOTS = Arrays.asList(new Tile(3508, 3494, 2), new Tile(3502, 3506, 2), new Tile(3499, 3505, 2), new Tile(3489, 3500, 2), new Tile(3492, 3499, 2), new Tile(3476, 3496, 3), new Tile(3475, 3493, 3), new Tile(3482, 3486, 2), new Tile(3478, 3484, 2), new Tile(3493, 3476, 3), new Tile(3495, 3472, 3), new Tile(3491, 3472, 3), new Tile(3513, 3479, 2), new Tile(3512, 3481, 2), new Tile(3510, 3476, 2));

    @Override
    public boolean handleObjectInteraction(Player player, GameObject obj, int option) {
        if (obj.getId() == TALL_TREE_14843) {
            if (player.skills().level(Skills.AGILITY) >= 40) {
                player.lockNoDamage();
                player.getMovementQueue().interpolate(3507, 3488, MovementQueue.StepType.FORCED_WALK);
                Chain.bound(player).name("CanifisRooftopTallTreeTask").waitForTile(new Tile(3507, 3488), () -> {
                    player.animate(1765, 60);
                    TaskManager.submit(new ForceMovementTask(player, 1, new ForceMovement(player.tile().clone(), new Tile(0, 1), 30, 60, Direction.EAST.toInteger())));
                }).then(1, () -> TaskManager.submit(new ForceMovementTask(player, 1, new ForceMovement(player.tile().clone(), new Tile(-3, 0), 60, 115, Direction.WEST.toInteger())))).then(5, () -> {
                    player.teleport(3506, 3492, 2);
                    player.animate(-1);
                    player.unlock();
                    player.skills().addXp(Skills.AGILITY, 10.0);

                    MarksOfGrace.trySpawn(player, MARK_SPOTS, 40, 10);
                });
            } else {
                player.message("You need at least 40 Agility to attempt this course.");
            }
            return true;
        }

        if (obj.getId() == GAP_14844) { // gap 1
            player.lockNoDamage();
            player.getMovementQueue().interpolate(3505, 3497, MovementQueue.StepType.FORCED_WALK);
            Chain.bound(player).name("CanifisRooftopGap1Task").waitForTile(new Tile(3505, 3497, 2), () -> {
                player.animate(1995, 15);
                TaskManager.submit(new ForceMovementTask(player, 0, new ForceMovement(player.tile().clone(), new Tile(0, +1), 15, 45, Direction.NORTH.toInteger())));
            }).then(1, () -> {
                player.animate(2586, 15);
                TaskManager.submit(new ForceMovementTask(player, 0, new ForceMovement(player.tile().clone(), new Tile(-2, +6), 25, 30, Direction.NORTH.toInteger())));
                player.animate(2588);
            }).then(2, () -> {
                player.teleport(3503, 3504, 2);
                player.unlock();
                player.skills().addXp(Skills.AGILITY, 8.0);
                MarksOfGrace.trySpawn(player, MARK_SPOTS, 40, 10);
            });
            return true;
        }

        if (obj.getId() == GAP_14845) { // gap 2
            player.lockNoDamage();
            player.animate(2588, 0);
            Chain.bound(player).name("CanifisRooftopGap2Task").runFn(1, () -> {
                player.teleport(3492, 3504, 2);
                player.animate(-1);
                player.unlock();
                player.skills().addXp(Skills.AGILITY, 8.0);
                MarksOfGrace.trySpawn(player, MARK_SPOTS, 40, 10);
            });
            return true;
        }

        if (obj.getId() == GAP_14848) { // gap 3
            Tile startPos = obj.tile().transform(2, 0);
            player.smartPathTo(startPos);
            player.waitForTile(startPos, player::lockNoDamage)
                .name("CanifisRooftopGap3Task").then(1, () -> {
                player.teleport(3479, 3499, 3);
                player.animate(2585);
            }).then(1, () -> {
                player.unlock();
                player.skills().addXp(Skills.AGILITY, 10.0);
                MarksOfGrace.trySpawn(player, MARK_SPOTS, 40, 10);
            });
            return true;
        }

        if (obj.getId() == GAP_14846) { // gap 4
            Tile startPos = obj.tile().transform(0, 2);
            player.smartPathTo(startPos);
            Chain.bound(player).name("CanifisRooftopGap4Task").waitForTile(startPos, () -> player.lockNoDamage())
                .then(1, () -> player.animate(2586, 0)).then(1, () -> {
                player.teleport(3479, 3486, 2);
                player.animate(2588);
                player.unlock();
                player.skills().addXp(Skills.AGILITY, 8.0);
                MarksOfGrace.trySpawn(player, MARK_SPOTS, 40, 10);
            });
            return true;
        }
        if (obj.getId() == POLEVAULT) { // pole vault
            Tile startPos = obj.tile().transform(-1, 0);
            player.smartPathTo(startPos);
            player.waitForTile(startPos, player::lockNoDamage)
                .name("CanifisRooftopGap5Task").then(1, () -> {
                player.face(3489, 3476);
                player.animate(1995);
            }).then(1, () -> player.teleport(3485, 3481, 3)).then(1, () -> {
                player.animate(7132);
                TaskManager.submit(new ForceMovementTask(player, 1, new ForceMovement(player.tile().clone(), new Tile(+4, -5), 15, 250, Direction.NORTH.toInteger())));
            }).then(8, () -> {
                player.animate(2588);
                player.unlock();
                player.skills().addXp(Skills.AGILITY, 10.0);
                MarksOfGrace.trySpawn(player, MARK_SPOTS, 40, 10);
            });
            return true;
        }
        if (obj.getId() == GAP_14847) { // gap 5
            Tile startPos = obj.tile().transform(-3, -1);
            player.smartPathTo(startPos);
            player.waitForTile(startPos, player::lockNoDamage).name("CanifisRooftopGap6Task").then(1, () -> player.animate(2586, 0)).then(1, () -> {
                player.teleport(3510, 3476, 2);
                player.animate(2588);
                player.unlock();
                player.skills().addXp(Skills.AGILITY, 11.0);
                MarksOfGrace.trySpawn(player, MARK_SPOTS, 40, 10);
            });
            return true;
        }
        if (obj.getId() == GAP_14897) { // last gap 7
            Tile startPos = obj.tile().transform(0, -1);
            //player.smartPathTo(startPos, obj.getSize());
            player.smartPathTo(startPos);
            player.waitForTile(startPos, player::lockNoDamage).name("CanifisRooftopGap7Task").then(1, () -> player.animate(2586, 0)).then(1, () -> {
                player.teleport(3510, 3485, 0);
                player.animate(2588);
                player.unlock();
                player.skills().addXp(Skills.AGILITY, 175);
                MarksOfGrace.trySpawn(player, MARK_SPOTS, 40, 10);

                // Woo! A pet!
                var odds = (int) (32000 * player.getMemberRights().petRateMultiplier());
                if (World.getWorld().rollDie(odds, 1)) {
                    UnlockAgilityPet.unlockGiantSquirrel(player);
                }

            });
            return true;
        }
        return false;
    }
}
