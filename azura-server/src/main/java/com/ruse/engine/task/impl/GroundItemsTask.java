package com.ruse.engine.task.impl;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.GroundItem;
import com.ruse.world.entity.impl.GroundItemManager;

import java.util.List;

public class GroundItemsTask extends Task {

    private static boolean running;

    public GroundItemsTask() {
        super(1);
    }

    public static void fireTask() {
        if (running)
            return;
        running = true;
        TaskManager.submit(new GroundItemsTask());
    }

    @Override
    protected void execute() {
        for (List<GroundItem> pile : GroundItemManager.getGroundTilesByTile().values()) {
            for (GroundItem gi : pile) {
                if (gi == null || !gi.shouldProcess())
                    continue;
                if (gi.isRefreshNeeded()) { // Is a refresh needed?
                    GroundItemManager.remove(gi, false); // Removes the ground item
                    GroundItemManager.add(gi, false); // Spawns the ground item
                    gi.setRefreshNeeded(false);
                }
                if (!gi.getItem().tradeable() && gi.shouldGoGlobal())
                    gi.setGoGlobal(false);
                final int showDelay = gi.getShowDelay();
                if (showDelay > 0) // Decrease the grounditems show delay.
                    gi.setShowDelay(showDelay - 1);
                if (showDelay == 0 && gi.shouldGoGlobal() && !gi.isGlobal()) {
                    gi.setGlobalStatus(true); // Set the global status too true as we're going global.
                    gi.setGoGlobal(false); // Set that it has gone global and shouldn't go global again
                    gi.setShowDelay(gi.getGlobalTimer()); // Set the new delay (when it should be deleted)
                    gi.setRefreshNeeded(true);
                } else if (showDelay == 0 && !gi.shouldGoGlobal() || showDelay == 0 && gi.isGlobal()
                        || gi.hasBeenPickedUp()) {
                    GroundItemManager.remove(gi, true); // The timer is 0 and it shouldn't go global, so remove it
                    continue;
                }
            }
        }
        if (GroundItemManager.getGroundTilesByTile().isEmpty())
            stop();
    }

    @Override
    public void stop() {
        setEventRunning(false);
        running = false;
    }
}
