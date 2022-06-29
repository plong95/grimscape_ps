package com.ferox.game.world.entity.mob.player.commands.impl.players;

import com.ferox.GameServer;
import com.ferox.db.transactions.CollectVotes;
import com.ferox.game.world.entity.AttributeKey;
import com.ferox.game.world.entity.mob.player.Player;
import com.ferox.game.world.entity.mob.player.commands.Command;

/**
 * @author Patrick van Elderen | May, 29, 2021, 11:13
 * @see <a href="https://github.com/PVE95">Github profile</a>
 */
public class ClaimVoteCommand implements Command {

    private long lastCommandUsed;

    @Override
    public void execute(Player player, String command, String[] parts) {
        var current_mac = player.<String>getAttribOr(AttributeKey.MAC_ADDRESS, "invalid");
        if(current_mac.equalsIgnoreCase("invalid") || current_mac.isEmpty()) {
            player.message("You're not connected to a real machine and there for cannot claim votes.");
            return;
        }

        if (GameServer.properties().enableSql) {
            if (System.currentTimeMillis() - lastCommandUsed >= 10000) {
                lastCommandUsed = System.currentTimeMillis();
                CollectVotes.INSTANCE.collectVotes(player);
            }
        } else {
            player.message("The database is offline at this moment.");
        }
    }

    @Override
    public boolean canUse(Player player) {
        return true;
    }
}
