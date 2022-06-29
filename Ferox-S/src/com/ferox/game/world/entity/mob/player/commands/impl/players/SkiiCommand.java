package com.ferox.game.world.entity.mob.player.commands.impl.players;

import com.ferox.game.world.entity.mob.player.Player;
import com.ferox.game.world.entity.mob.player.commands.Command;

public class SkiiCommand implements Command {

    @Override
    public void execute(Player player, String command, String[] parts) {
        player.getPacketSender().sendURL("https://youtube.com/channel/UCzwqwQgjkW9ZSMqlCt-n3jQ");
        player.message("Opening skii's channel in your web browser...");
    }

    @Override
    public boolean canUse(Player player) {
        return true;
    }

}
