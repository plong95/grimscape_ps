package com.ferox.game.world.entity.combat.method.impl.npcs.slayer;

import com.ferox.game.world.entity.Mob;
import com.ferox.game.world.entity.combat.CombatFactory;
import com.ferox.game.world.entity.combat.CombatType;
import com.ferox.game.world.entity.combat.method.impl.CommonCombatMethod;
import com.ferox.game.world.entity.masks.Projectile;
import com.ferox.game.world.entity.mob.player.Player;
import com.ferox.game.world.entity.mob.player.Skills;
import com.ferox.util.ItemIdentifiers;

public class AberrantSpectre extends CommonCombatMethod {

    private static final int[] DRAIN = { Skills.ATTACK, Skills.STRENGTH, Skills.DEFENCE, Skills.RANGED, Skills.MAGIC};

    @Override
    public void prepareAttack(Mob mob, Mob target) {
        mob.animate(mob.attackAnimation());
        new Projectile(mob, target, 336, 5, 45, 37, 38, 0,16, 0).sendProjectile();

        Player player = (Player) target;

        if(!player.getEquipment().contains(ItemIdentifiers.NOSE_PEG) && !player.getEquipment().wearingSlayerHelm()) {
            player.hit(mob, CombatFactory.calcDamageFromType(mob, target, CombatType.MAGIC) + 3, CombatType.MAGIC).submit();
            for (int skill : DRAIN) {
                player.skills().alterSkill(skill, -6);
            }
            player.message("<col=ff0000>The aberrant spectre's stench disorients you!");
            player.message("<col=ff0000>A nose peg can protect you from this attack.");
        } else {
            player.hit(mob, CombatFactory.calcDamageFromType(mob, target, CombatType.MAGIC), CombatType.MAGIC).checkAccuracy().submit();
        }
    }

    @Override
    public int getAttackSpeed(Mob mob) {
        return mob.getBaseAttackSpeed();
    }

    @Override
    public int getAttackDistance(Mob mob) {
        return 8;
    }
}
