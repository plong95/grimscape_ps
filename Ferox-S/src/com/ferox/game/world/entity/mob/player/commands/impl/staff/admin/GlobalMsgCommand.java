package com.ferox.game.world.entity.mob.player.commands.impl.staff.admin;

import com.ferox.game.world.World;
import com.ferox.game.world.entity.mob.player.Player;
import com.ferox.game.world.entity.mob.player.commands.Command;
import com.ferox.util.Utils;

public class GlobalMsgCommand implements Command {

    @Override
    public void execute(Player player, String command, String[] parts) {
        String msg = "";
        for (int i = 1; i < parts.length; i++) {
            msg += parts[i] + " ";
        }
        World.getWorld().sendWorldMessage("<col=004f00>Broadcast:</col> "  + Utils.capitalizeFirst(msg));
    }

    @Override
    public boolean canUse(Player player) {
        return (player.getPlayerRights().isAdminOrGreater(player));
    }
}
