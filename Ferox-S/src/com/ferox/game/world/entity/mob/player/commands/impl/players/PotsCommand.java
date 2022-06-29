package com.ferox.game.world.entity.mob.player.commands.impl.players;

import com.ferox.game.world.entity.mob.player.IronMode;
import com.ferox.game.world.entity.mob.player.Player;
import com.ferox.game.world.entity.mob.player.commands.Command;
import com.ferox.game.world.items.Item;
import com.ferox.game.world.position.areas.impl.WildernessArea;
import com.ferox.util.ItemIdentifiers;

/**
 * @author Patrick van Elderen | Zerikoth | PVE
 * @date maart 20, 2020 16:50
 */
public class PotsCommand implements Command {

    @Override
    public void execute(Player player, String command, String[] parts) {
        if (player.ironMode() != IronMode.NONE) {
            player.message("As an ironman you cannot use this command.");
            return;
        }

        if (!player.tile().inSafeZone() && !player.getPlayerRights().isDeveloperOrGreater(player)) {
            player.message("You can only use this command at safe zones.");
            return;
        }

        if(WildernessArea.inWilderness(player.tile())) {
            player.message("You can only use this command at safe zones.");
            return;
        }

        Item superCombatPotion = new Item(ItemIdentifiers.SUPER_COMBAT_POTION4);
        Item superRestorePotion = new Item(ItemIdentifiers.SUPER_RESTORE4, 2);
        Item saradominBrew = new Item(ItemIdentifiers.SARADOMIN_BREW4);

        if (player.inventory().hasCapacityFor(superCombatPotion, superRestorePotion, saradominBrew)) {
            player.inventory().add(superCombatPotion);
            player.inventory().add(saradominBrew);
            player.inventory().add(superRestorePotion);
        } else {
            player.message("Your inventory does not have enough free space to do that.");
        }
    }

    @Override
    public boolean canUse(Player player) {
        return true;
    }
}