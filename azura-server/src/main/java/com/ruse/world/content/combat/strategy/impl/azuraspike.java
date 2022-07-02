package com.ruse.world.content.combat.strategy.impl;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.Animation;
import com.ruse.model.Projectile;
import com.ruse.world.content.combat.CombatContainer;
import com.ruse.world.content.combat.CombatType;
import com.ruse.world.content.combat.strategy.CombatStrategy;
import com.ruse.world.entity.impl.Character;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

public class azuraspike implements CombatStrategy {

    @Override
    public boolean canAttack(Character entity, Character victim) {
        return victim.isPlayer()
                && ((Player) victim).getMinigameAttributes().getGodwarsDungeonAttributes().hasEnteredRoom();
    }

    @Override
    public CombatContainer attack(Character entity, Character victim) {
        return null;
    }

    @Override
    public boolean customContainerAttack(Character entity, Character victim) {
        NPC azuraspike = (NPC) entity;
        if (azuraspike.isChargingAttack() || victim.getConstitution() <= 0) {
            return true;
        }

        azuraspike.performAnimation(new Animation(azuraspike.getDefinition().getAttackAnimation()));
        azuraspike.setChargingAttack(true);

        azuraspike.getCombatBuilder()
                .setContainer(new CombatContainer(azuraspike, victim, 1, 3, CombatType.RANGED, true));

        TaskManager.submit(new Task(1, azuraspike, false) {
            int tick = 0;

            @Override
            public void execute() {
                if (tick == 1) {
                    new Projectile(azuraspike, victim, 37, 44, 3, 43, 43, 0).sendProjectile();
                    azuraspike.setChargingAttack(false);
                    stop();
                }
                tick++;
            }
        });
        return true;
    }

    @Override
    public int attackDelay(Character entity) {
        return entity.getAttackSpeed();
    }

    @Override
    public int attackDistance(Character entity) {
        return 6;
    }

    @Override
    public CombatType getCombatType() {
        return CombatType.RANGED;
    }
}
