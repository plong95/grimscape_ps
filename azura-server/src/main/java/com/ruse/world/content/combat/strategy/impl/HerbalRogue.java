package com.ruse.world.content.combat.strategy.impl;

import com.ruse.model.*;
import com.ruse.util.Misc;
import com.ruse.util.RandomUtility;
import com.ruse.world.World;
import com.ruse.world.content.combat.CombatContainer;
import com.ruse.world.content.combat.CombatType;
import com.ruse.world.content.combat.strategy.CombatStrategy;
import com.ruse.world.entity.impl.Character;
import com.ruse.world.entity.impl.npc.NPC;

import java.util.Random;


public class HerbalRogue implements CombatStrategy {
    public static final int NPC = 2342;
    private static int[] MinionId = {2950};

    private final int[] MELEEANIMS = {401, 402, 624, 407, 410};
    private final int[] MAGICANIMS = {401, 402, 624, 407, 410};
    private final int[] RANGEANIMS = {0};
    private final int[] GFX = {500, 520, 540, 650, 750};
    /**
     * Attacking melee
     */
    private Animation animationsmelee = new Animation(getRandomAnimationMelee());
    //	private Animation animationsmagic = new Animation(getRandomAnimationMagic());
    //private Animation animationsrange = new Animation(getRandomAnimationRange());
    private Graphic graphics = new Graphic(getRandomGfx());

    public static void spawnMinion(Character victim) {

        Random random = new Random();

        boolean success = random.nextInt(100) <= 37 ? true : false;
        if (success) {

            for (int i = 0; i < MinionId.length; i++) {
                Position MinionSpawn = new Position(victim.getPosition().getX(), victim.getPosition().getY());
                NPC monster = new NPC(MinionId[i], MinionSpawn);
                World.register(monster);
                monster.getCombatBuilder().attack(victim);
            }
        }

    }

    private int getRandomAnimationMelee() {
        return MELEEANIMS[RandomUtility.exclusiveRandom(0, MELEEANIMS.length)];
    }

    private int getRandomAnimationMagic() {
        return MELEEANIMS[RandomUtility.exclusiveRandom(0, MAGICANIMS.length)];
    }

    private int getRandomAnimationRange() {
        return RANGEANIMS[RandomUtility.exclusiveRandom(0, RANGEANIMS.length)];
    }

    private int getRandomGfx() {
        return GFX[RandomUtility.exclusiveRandom(0, GFX.length)];
    }

    @Override
    public boolean canAttack(Character entity, Character victim) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public CombatContainer attack(Character entity, Character victim) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean customContainerAttack(Character entity, Character victim) {
        NPC Boss = (NPC) entity;
        animationsmelee = new Animation(getRandomAnimationMelee());
        //	animationsmagic = new Animation(getRandomAnimationMagic());
        //	animationsrange = new Animation(getRandomAnimationRange());
        graphics = new Graphic(getRandomGfx());
        if (Locations.goodDistance(Boss.getPosition().copy(), victim.getPosition().copy(), 1)
                && Misc.getRandom(5) <= 3) {
            Boss.performAnimation(animationsmelee);
            //freiza.performGraphic(graphics);
            new Projectile(entity, victim, graphics.getId(), 44, 3, 43, 31, 0).sendProjectile();
            //HerbalRogue.spawnMinion(victim);

            Boss.getCombatBuilder().setContainer(new CombatContainer(Boss, victim, 1, 1, CombatType.MAGIC, true));
            //	new Projectile(entity, victim, graphics.getId(), 44, 3, 43, 31, 0).sendProjectile();

        } else {

            Boss.performAnimation(animationsmelee);
            //	HerbalRogue.spawnMinion(victim);

            new Projectile(entity, victim, graphics.getId(), 44, 3, 43, 31, 0).sendProjectile();
            Boss.getCombatBuilder().setContainer(new CombatContainer(Boss, victim, 1, 2, CombatType.MELEE,
                    Misc.getRandom(10) <= 2 ? false : true));
        }
        return true;
    }

    @Override
    public int attackDelay(Character entity) {
        // TODO Auto-generated method stub
        return entity.getAttackSpeed();
    }

    @Override
    public int attackDistance(Character entity) {
        // TODO Auto-generated method stub
        return 4;
    }

    @Override
    public CombatType getCombatType() {
        // TODO Auto-generated method stub
        return CombatType.MELEE;
    }

}
