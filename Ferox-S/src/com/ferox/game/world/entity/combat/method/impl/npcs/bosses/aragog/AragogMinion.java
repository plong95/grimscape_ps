package com.ferox.game.world.entity.combat.method.impl.npcs.bosses.aragog;

import com.ferox.game.world.entity.Mob;
import com.ferox.game.world.entity.combat.method.impl.CommonCombatMethod;

/**
 * @author Patrick van Elderen | April, 07, 2021, 18:54
 * @see <a href="https://www.rune-server.ee/members/Zerikoth/">Rune-Server profile</a>
 */
public class AragogMinion extends CommonCombatMethod {

    @Override
    public void prepareAttack(Mob mob, Mob target) {
        mob.animate(mob.attackAnimation());
    }

    @Override
    public int getAttackSpeed(Mob mob) {
        return mob.getBaseAttackSpeed();
    }

    @Override
    public int getAttackDistance(Mob mob) {
        return 1;
    }
}
