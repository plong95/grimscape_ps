package com.ferox.game.content.items.mystery_box.impl;

import com.ferox.game.world.World;
import com.ferox.game.world.entity.mob.player.Player;
import com.ferox.game.world.items.Item;
import com.ferox.net.packet.interaction.PacketInteraction;
import com.ferox.util.Color;
import com.ferox.util.CustomItemIdentifiers;
import com.ferox.util.ItemIdentifiers;
import com.ferox.util.Utils;

import static com.ferox.util.CustomItemIdentifiers.REVENANT_MYSTER_BOX;

/**
 * @author Patrick van Elderen <https://github.com/PVE95>
 * @Since October 15, 2021
 */
public class RevenantMysteryBox extends PacketInteraction {

    private boolean broadcast = false;

    @Override
    public boolean handleItemInteraction(Player player, Item item, int option) {
        if (option == 1) {
            if (item.getId() == REVENANT_MYSTER_BOX) {
                open(player);
                return true;
            }
        }
        return false;
    }

    private void open(Player player) {
        if (player.inventory().contains(REVENANT_MYSTER_BOX)) {
            player.inventory().remove(new Item(REVENANT_MYSTER_BOX), true);
            Item reward = rollReward();
            player.inventory().add(reward, true);
            Utils.sendDiscordInfoLog("Player " + player.getUsername() + " received a "+reward.unnote().name()+" from a revenant mystery box.", "box_and_tickets");
            if(broadcast && !player.getUsername().equalsIgnoreCase("Box test")) {
                String worldMessage = "<img=505><shad=0>[<col=" + Color.MEDRED.getColorValue() + ">Revenant Mystery Box</col>]</shad>:<col=AD800F> " + player.getUsername() + " received a <shad=0>" + reward.name() + "</shad>!";
                World.getWorld().sendWorldMessage(worldMessage);
            }
        }
    }

    private static final int RARE_ROLL = 10;

    private static final Item[] RARE = new Item[]{
        new Item(CustomItemIdentifiers.CRAWS_BOW_C),
        new Item(CustomItemIdentifiers.VIGGORAS_CHAINMACE_C),
        new Item(CustomItemIdentifiers.THAMMARONS_STAFF_C),
    };

    private static final Item[] COMMON = new Item[]{
        new Item(ItemIdentifiers.VIGGORAS_CHAINMACE),
        new Item(ItemIdentifiers.CRAWS_BOW),
        new Item(ItemIdentifiers.THAMMARONS_SCEPTRE),
        new Item(ItemIdentifiers.AMULET_OF_AVARICE),
    };

    public Item rollReward() {
        if (Utils.rollDie(RARE_ROLL,1)) {
            broadcast = true;
            return Utils.randomElement(RARE);
        } else {
            broadcast = false;
            return Utils.randomElement(COMMON);
        }
    }
}
