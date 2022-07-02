package com.ruse.world.content.wellForGlobalBosses;

import com.ruse.model.input.impl.DonateToGlobalBossSpawns;
import com.ruse.world.entity.impl.player.Player;

import java.util.ArrayList;

public class WellForGlobalBossesInterface {

    public static ArrayList<String> donators = new ArrayList<String>();
    private Player player;

    public WellForGlobalBossesInterface(Player player) {
        this.player = player;
    }

    public void open() {
        sendStrings();
        player.getPA().sendInterface(16550);
        player.getPA().sendMessage("Donate to active a global boss for everyone to have a go at!");
    }

    public void sendStrings() {
        player.getPA().sendFrame126("" + donators, 16562);
    }

    public void button(int id) {
        switch (id) {
            case 16553:
                player.setInputHandling(new DonateToGlobalBossSpawns());
                player.getPacketSender().sendInterfaceRemoval()
                        .sendEnterAmountPrompt("How much money would you like to contribute with?");
                break;
        }
    }
}
