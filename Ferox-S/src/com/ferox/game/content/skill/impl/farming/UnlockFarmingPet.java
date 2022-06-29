package com.ferox.game.content.skill.impl.farming;

import com.ferox.game.world.World;
import com.ferox.game.world.entity.mob.npc.pets.Pet;
import com.ferox.game.world.entity.mob.npc.pets.PetAI;
import com.ferox.game.world.entity.mob.player.Player;
import com.ferox.game.world.items.Item;
import com.ferox.util.Color;

/**
 * @author Patrick van Elderen | May, 26, 2021, 09:14
 * @see <a href="https://github.com/PVE95">Github profile</a>
 */
public class UnlockFarmingPet {

    public static void unlockTangleroot(Player player) {
        if (!PetAI.hasUnlocked(player, Pet.TANGLEROOT)) {
            // Unlock the varbit. Just do it, rather safe than sorry.
            player.addUnlockedPet(Pet.TANGLEROOT.varbit);

            // RS tries to add it as follower first. That only works if you don't have one.
            var currentPet = player.pet();
            if (currentPet == null) {
                player.message("You have a funny feeling like you're being followed.");
                PetAI.spawnPet(player, Pet.TANGLEROOT, false);
            } else {
                // Sneak it into their inventory. If that fails, fuck you, no pet for you!
                if (player.inventory().add(new Item(Pet.TANGLEROOT.item), true)) {
                    player.message("You feel something weird sneaking into your backpack.");
                } else {
                    player.message("Speak to Probita to claim your pet!");
                }
            }

            World.getWorld().sendWorldMessage("<img=1081> " + player.getUsername() + " has unlocked the pet: <col="+Color.HOTPINK.getColorValue()+">" + new Item(Pet.TANGLEROOT.item).name()+ "</col>.");
        } else {
            player.message("You have a funny feeling like you would have been followed...");
        }
    }
}
