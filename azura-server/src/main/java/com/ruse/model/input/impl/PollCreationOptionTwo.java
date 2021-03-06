package com.ruse.model.input.impl;

import com.ruse.model.input.EnterAmount;
import com.ruse.world.content.polling.PollCreation;
import com.ruse.world.entity.impl.player.Player;

public class PollCreationOptionTwo extends EnterAmount {

    @Override
    public void handleSyntax(Player player, String amount) {
        player.getPacketSender().sendClientRightClickRemoval();
        PollCreation.updateOptionTwo(player, amount);
    }
}
