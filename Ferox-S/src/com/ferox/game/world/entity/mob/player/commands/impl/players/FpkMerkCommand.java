package com.ferox.game.world.entity.mob.player.commands.impl.players;

import com.ferox.game.world.entity.mob.player.Player;
import com.ferox.game.world.entity.mob.player.commands.Command;

public class FpkMerkCommand implements Command {

    @Override
    public void execute(Player player, String command, String[] parts) {
        player.getPacketSender().sendURL("https://www.youtube.com/channel/UCeVDQGzCI3dxp8NAT_YBIkQ");
        player.message("Opening FPK Merk's channel in your web browser...");
    }

    @Override
    public boolean canUse(Player player) {
        return true;
    }

}
