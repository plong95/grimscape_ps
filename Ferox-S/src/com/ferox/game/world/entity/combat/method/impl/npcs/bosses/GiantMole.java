package com.ferox.game.world.entity.combat.method.impl.npcs.bosses;

import com.ferox.game.world.entity.Mob;
import com.ferox.game.world.entity.combat.CombatFactory;
import com.ferox.game.world.entity.combat.CombatType;
import com.ferox.game.world.entity.combat.method.impl.CommonCombatMethod;
import com.ferox.game.world.entity.mob.npc.Npc;
import com.ferox.game.world.position.Tile;
import com.ferox.util.Utils;
import com.ferox.util.chainedwork.Chain;

public class GiantMole extends CommonCombatMethod {

    private static final int BURROW_DOWN_ANIM = 3314;
    private static final int BURROW_SURFACE_ANIM = 3315;

    private static final int[][] BURROW_POINTS = {
        {-21, 38},
        {-15, 22},
        {-19, 1},
        {-15, -14},
        {-20, -33},
        {-3, -33},
        {1, -22},
        {12, -11},
        {10, 15},
        {22, 35},
        {18, 51},
    };

    @Override
    public void prepareAttack(Mob mob, Mob target) {
        mob.animate(mob.attackAnimation());
        target.hit(mob, CombatFactory.calcDamageFromType(mob, target, CombatType.MELEE), 0, CombatType.MELEE).checkAccuracy().submit();
    }

    @Override
    public int getAttackSpeed(Mob mob) {
        return mob.getBaseAttackSpeed();
    }

    @Override
    public int getAttackDistance(Mob mob) {
        return 1;
    }

    private void burrow(Npc npc, Mob target) {
        int[] offsets = Utils.randomElement(BURROW_POINTS);
        Tile burrowDestination = npc.spawnTile().relative(offsets[0], offsets[1]);
        target.getCombat().reset();//When mole digs reset combat
        npc.lockNoDamage();
        npc.faceEntity(null);
        npc.getMovement().reset();
        npc.animate(BURROW_DOWN_ANIM);
        Chain.bound(null).runFn(3, () -> {
            npc.teleport(burrowDestination);
            npc.animate(BURROW_SURFACE_ANIM);
        }).then(2, npc::unlock);
    }

}
