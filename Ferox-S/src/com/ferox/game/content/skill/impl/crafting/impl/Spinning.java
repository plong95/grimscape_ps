package com.ferox.game.content.skill.impl.crafting.impl;

import com.ferox.game.action.Action;
import com.ferox.game.action.policy.WalkablePolicy;
import com.ferox.game.content.syntax.EnterSyntax;
import com.ferox.game.world.entity.dialogue.ChatBoxItemDialogue;
import com.ferox.game.world.entity.dialogue.Dialogue;
import com.ferox.game.world.entity.dialogue.DialogueManager;
import com.ferox.game.world.entity.dialogue.DialogueType;
import com.ferox.game.world.entity.mob.player.Player;
import com.ferox.game.world.entity.mob.player.Skills;
import com.ferox.game.world.items.Item;
import com.ferox.util.ItemIdentifiers;
import com.ferox.util.Utils;

import static com.ferox.util.ItemIdentifiers.*;

/**
 * Handles spinning items on the spinning wheel.
 * @author PVE
 * @Since juli 08, 2020
 */
public class Spinning {

    /**
     * The spinnable data.
     */
    public enum Spinnable {
        BOWSTRING(new Item(FLAX), new Item(BOW_STRING), 15.0D, 10),
        WOOL(new Item(ItemIdentifiers.WOOL), new Item(BALL_OF_WOOL), 2.5D, 1),
        ROPE(new Item(HAIR), new Item(ItemIdentifiers.ROPE), 25.0D, 30),
        MAGIC_STRING(new Item(MAGIC_ROOTS), new Item(ItemIdentifiers.MAGIC_STRING), 30.0D, 19),
        YEW_STRING(new Item(YEW_ROOTS), new Item(CROSSBOW_STRING), 15.0D, 10),
        SINEW_STRING(new Item(SINEW), new Item(CROSSBOW_STRING), 15.0D, 10);

        /**
         * The spinnable item.
         */
        public Item item;

        /**
         * The spinnable outcome item.
         */
        public Item outcome;

        /**
         * The spinnable experience.
         */
        public double experience;

        /**
         * The level required to spin.
         */
        public int requiredLevel;

        /**
         * Constructs a new <code>Spinnable</code>.
         *
         * @param item          The item required.
         * @param outcome       The outcome item.
         * @param experience    The experience rewarded.
         * @param requiredLevel The level required.
         */
        Spinnable(Item item, Item outcome, double experience, int requiredLevel) {
            this.item = item;
            this.outcome = outcome;
            this.experience = experience;
            this.requiredLevel = requiredLevel;
        }
    }

    /**
     * Handles opening the spinning dialogue.
     *
     * @param player The player instance.
     */
    public static void open(Player player) {
        player.getDialogueManager().start(new Dialogue() {
            @Override
            protected void start(Object... parameters) {
                send(DialogueType.OPTION, "What would you like to spin?", "Ball of wool (wool)", "Bow string (flax)", "Rope (yak hair)", "Nevermind");
                setPhase(0);
            }

            @Override
            protected void select(int option) {
                if(isPhase(0)) {
                    if(option == 1) {
                        stop();
                        click(player, Spinnable.WOOL);
                    } else if(option == 2) {
                        stop();
                        click(player, Spinnable.BOWSTRING);
                    } else if(option == 3) {
                        stop();
                        click(player, Spinnable.ROPE);
                    } else if(option == 4) {
                        stop();
                    }
                }
            }
        });
    }



    /**
     * Opens the spinnable dialogue.
     *
     * @param player    The player instance.
     * @param spinnable The spinnable data.
     */
    public static void click(Player player, Spinnable spinnable) {
        if (player.skills().level(Skills.CRAFTING) < spinnable.requiredLevel) {
            DialogueManager.sendStatement(player, "You need a crafting level of " + spinnable.requiredLevel + " to spin this!");
            return;
        }

        if (!player.inventory().contains(spinnable.item)) {
            DialogueManager.sendStatement(player,"You do not have the required items to do this!");
            return;
        }

        ChatBoxItemDialogue.sendInterface(player, 1746, 170, spinnable.item);
        player.chatBoxItemDialogue = new ChatBoxItemDialogue(player) {
            @Override
            public void firstOption(Player player) {
                player.action.execute(spin(player, spinnable, 1), true);
            }

            @Override
            public void secondOption(Player player) {
                player.action.execute(spin(player, spinnable, 5), true);
            }

            @Override
            public void thirdOption(Player player) {
                player.setEnterSyntax(new EnterSyntax() {
                    @Override
                    public void handleSyntax(Player player, long input) {
                        spin(player, spinnable, (int) input);
                        player.action.execute(spin(player, spinnable, (int) input));
                    }
                });
                player.getPacketSender().sendEnterAmountPrompt("Enter amount.");
            }

            @Override
            public void fourthOption(Player player) {
                player.action.execute(spin(player, spinnable, 28), true);
            }
        };
    }

    /**
     * The spinnable action.
     *
     * @param player    The player instance.
     * @param spinnable The spinnable data.
     * @param amount    The amount beeing spun.
     * @return The spinnable action.
     */
    private static Action<Player> spin(Player player, Spinnable spinnable, int amount) {
        return new Action<Player>(player, 2, true) {

            int ticks = 0;

            @Override
            public void execute() {
                if (!player.inventory().contains(spinnable.item)) {
                    DialogueManager.sendStatement(player,"You have run out of materials!");
                    stop();
                    return;
                }

                player.animate(896);
                player.inventory().remove(spinnable.item);
                player.inventory().add(spinnable.outcome);
                player.skills().addXp(Skills.CRAFTING, spinnable.experience);
                player.message("You spin the " + spinnable.item.name() + " into " + Utils.getAOrAn(spinnable.outcome.name()) + " " + spinnable.outcome.name() + ".");

                if (++ticks == amount) {
                    stop();
                }
            }

            @Override
            public String getName() {
                return "Spinning";
            }

            @Override
            public WalkablePolicy getWalkablePolicy() {
                return WalkablePolicy.NON_WALKABLE;
            }
        };
    }
}
