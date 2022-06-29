package com.ferox.game.world.entity.mob.player.commands.impl.players;

import com.ferox.game.world.entity.mob.player.Player;
import com.ferox.game.world.entity.mob.player.commands.Command;

import java.text.DateFormatSymbols;
import java.util.Calendar;

public class CreationDateCommand implements Command {

    @Override
    public void execute(Player player, String command, String[] parts) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(player.getCreationDate().getTime());

        String dateSuffix;

        switch (calendar.get(Calendar.DATE) % 10) {
        case 1:
            dateSuffix = "st";
            break;
        case 2:
            dateSuffix = "nd";
            break;
        case 3:
            dateSuffix = "rd";
            break;
        default:
            dateSuffix = "th";
            break;
        }

        player.forceChat("I started playing on the " + calendar.get(Calendar.DATE) + dateSuffix + " of "
                + new DateFormatSymbols().getMonths()[calendar.get(Calendar.MONTH)] + ", " + calendar.get(Calendar.YEAR)
                + "!");
    }

    @Override
    public boolean canUse(Player player) {
        return true;
    }

}
