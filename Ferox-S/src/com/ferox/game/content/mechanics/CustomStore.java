package com.ferox.game.content.mechanics;

import com.ferox.game.world.World;
import com.ferox.game.world.entity.AttributeKey;
import com.ferox.game.world.entity.mob.player.Player;
import com.ferox.net.packet.interaction.PacketInteraction;

import static com.ferox.game.world.entity.AttributeKey.MAC_ADDRESS;

/**
 * @author Patrick van Elderen | May, 24, 2021, 12:34
 * @see <a href="https://github.com/PVE95">Github profile</a>
 */
public class CustomStore extends PacketInteraction {

    @Override
    public boolean handleButtonInteraction(Player player, int button) {
        if(button == 28061) {
            player.getPacketSender().sendConfig(1125, 1);
            player.getPacketSender().sendConfig(1126, 0);
            player.getPacketSender().sendConfig(1127, 0);
            if(player.<Integer>getAttribOr(AttributeKey.CUSTOM_SHOP_ACTION,0) == 1) {
                World.getWorld().shop(4).open(player);
            } else {
                World.getWorld().shop(43).open(player);
            }
            return true;
        }
        if(button == 28062) {
            player.getPacketSender().sendConfig(1125, 0);
            player.getPacketSender().sendConfig(1126, 1);
            player.getPacketSender().sendConfig(1127, 0);
            if(player.<Integer>getAttribOr(AttributeKey.CUSTOM_SHOP_ACTION,0) == 1) {
                World.getWorld().shop(5).open(player);
            } else {
                World.getWorld().shop(44).open(player);
            }
            return true;
        }
        if(button == 28063) {
            player.getPacketSender().sendConfig(1125, 0);
            player.getPacketSender().sendConfig(1126, 0);
            player.getPacketSender().sendConfig(1127, 1);
            if(player.<Integer>getAttribOr(AttributeKey.CUSTOM_SHOP_ACTION,0) == 1) {
                World.getWorld().shop(18).open(player);
            } else {
                World.getWorld().shop(45).open(player);
            }
            return true;
        }
        return false;
    }
}
