package com.ferox.game.content.items.equipment;

import com.ferox.game.world.entity.AttributeKey;
import com.ferox.game.world.entity.mob.player.EquipSlot;
import com.ferox.game.world.entity.mob.player.Player;
import com.ferox.game.world.items.Item;
import com.ferox.net.packet.interaction.PacketInteraction;

/**
 * @author Patrick van Elderen | March, 16, 2021, 15:19
 * @see <a href="https://www.rune-server.ee/members/Zerikoth/">Rune-Server profile</a>
 */
public class RingOfForging extends PacketInteraction {

    private final static int RING_OF_FORGING = 2568;

    @Override
    public boolean handleEquipmentAction(Player player, Item item, int slot) {
        if (item.getId() == RING_OF_FORGING && slot == EquipSlot.RING) {
            int charges = player.getAttribOr(AttributeKey.RING_OF_FORGING_CHARGES, 140);
            if (charges == 1) {
                player.message("You can smelt one more piece of iron ore before a ring melts.");
            } else {
                player.message("You can smelt "+charges+" more pieces of iron ore before a ring melts.");
            }
            return true;
        }
        return false;
    }
}
