package com.ferox.game.world.entity.mob.player.commands.impl.players;

import com.ferox.game.world.entity.mob.player.Player;
import com.ferox.game.world.entity.mob.player.commands.Command;

public class FeaturesCommand implements Command {

    @Override
    public void execute(Player player, String command, String[] parts) {
        player.getPacketSender().sendURL("https://ferox-os.com/features/");
        player.message("Opening the donator features in your web browser...");
    }

    @Override
    public boolean canUse(Player player) {
        return true;
    }

}
