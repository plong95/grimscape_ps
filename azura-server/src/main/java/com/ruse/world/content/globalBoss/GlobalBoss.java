package com.ruse.world.content.globalBoss;

import com.ruse.GameSettings;
import com.ruse.model.Locations;
import com.ruse.model.Position;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.npc.NPCMovementCoordinator;
import com.ruse.world.entity.impl.player.Player;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Created by Stan van der Bend on 16/12/2017. project: runeworld-game-server
 * package: runeworld.world.entity.combat.strategy
 */
public abstract class GlobalBoss extends NPC {

    private final int cyclesTillDespawn = Math
            .toIntExact(TimeUnit.MINUTES.toMillis(minutesTillDespawn()) / GameSettings.GAME_PROCESSING_CYCLE_RATE);
    private final SpawnLocation spawnLocation = Misc.random(Arrays.asList(spawnLocations()));
    int cyclesOutOfCombat = 0;
    private boolean respawn = true;
    private NPCMovementCoordinator movementCoordinator = new NPCMovementCoordinator(this);

    public GlobalBoss(int id) {
        super(id, new Position(2918, 3053, 0));
    }

    @Override
    public void sequence() {
        super.sequence();
    }

    public abstract GlobalBoss reincarnate();

    /**
     * Handles any additional behaviour upon the spawning of this
     * {@link GlobalBoss}.
     */
    protected void spawn() {
        World.sendMessage(constructSpawnMessage());
        this.setAttackDistance(12);
        this.getDefinition().setAggressive(true);
        this.getDefinition().setMulti(true);
        this.getDefinition().setRespawnTime(-1);
        setLocation(Locations.Location.getLocation(this));
        World.register(this);
    }

    private String constructSpawnMessage() {
        return "<shad=0>@bla@[@mag@Multi Boss@bla@] @mag@" + getDefinition().getName() + "@bla@ Has just respawned! ";

    }

    /**
     * Handles the drop after this {@link GlobalBoss} has been killed for the top
     * {@link GlobalBoss#maximumDrops()} players.
     *
     * @param player a rewarded {@link Player}.
     */
    protected abstract void handleDrop(Player player);

    /**
     * The potential {@link SpawnLocation}s this {@link GlobalBoss} can spawn at.
     *
     * @return all potential {@link SpawnLocation}s.
     */
    protected abstract SpawnLocation[] spawnLocations();

    /**
     * The amount of time it takes for this {@link GlobalBoss} to respawn after it
     * has de-spawned.
     *
     * @return respawn time in minutes.
     */
    protected abstract int minutesTillRespawn();

    /**
     * The amount of time after which this {@link GlobalBoss} de-spawns due to lack
     * of combat engagement.
     *
     * @return de-spawn time in minutes.
     */
    protected abstract int minutesTillDespawn();

    public boolean getRespawn() {
        return this.respawn;
    }

    public void setRespawn(boolean respawn) {
        this.respawn = respawn;
    }

    /**
     * The maximum amount of players that can receive a drop based on their damage.
     *
     * @return the maximum amount of drops.
     */
    public abstract int maximumDrops();

    public NPCMovementCoordinator getMovementCoordinator() {
        return movementCoordinator;
    }

}
