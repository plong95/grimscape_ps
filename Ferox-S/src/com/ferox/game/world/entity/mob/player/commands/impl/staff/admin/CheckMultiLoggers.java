package com.ferox.game.world.entity.mob.player.commands.impl.staff.admin;

import com.ferox.game.world.World;
import com.ferox.game.world.entity.mob.player.Player;
import com.ferox.game.world.entity.mob.player.commands.Command;
import com.ferox.game.world.position.areas.impl.WildernessArea;
import com.ferox.util.Color;
import com.ferox.util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Patrick van Elderen | June, 28, 2021, 10:41
 * @see <a href="https://github.com/PVE95">Github profile</a>
 */
public class CheckMultiLoggers implements Command {

    @Override
    public void execute(Player player, String command, String[] parts) {
        List<String> names = new ArrayList<>();

        if (parts.length < 2) {
            player.message("Invalid syntax. Please use: ::checkmulti [name]");
            return;
        }

        String username = Utils.formatText(command.substring(11)); // after "checkmulti "
        Optional<Player> playerToCheck = World.getWorld().getPlayerByName(username);
        if(playerToCheck.isEmpty()) {
            player.message(Color.RED.wrap(username+" is not online."));
            return;
        }

        World.getWorld().getPlayers().forEach(p -> {
            //When the player matches the IP of the player being checked add the names to a list.
            if(p.getHostAddress().equalsIgnoreCase(playerToCheck.get().getHostAddress())) {
                names.add(p.getUsername()+" in wild: "+ WildernessArea.inWilderness(p.tile()));
            }
        });

        player.message("Accounts online: " + names.toString());
        //Clear list now
        names.clear();
    }

    @Override
    public boolean canUse(Player player) {
        return player.getPlayerRights().isSupportOrGreater(player) || player.getPlayerRights().isYoutuber(player);
    }
}
