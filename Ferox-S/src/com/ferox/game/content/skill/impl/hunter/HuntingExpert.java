package com.ferox.game.content.skill.impl.hunter;

import com.ferox.game.world.entity.dialogue.Dialogue;
import com.ferox.game.world.entity.dialogue.DialogueType;
import com.ferox.game.world.entity.dialogue.Expression;
import com.ferox.game.world.entity.mob.npc.Npc;
import com.ferox.game.world.entity.mob.player.Player;
import com.ferox.util.NpcIdentifiers;

/**
 * @author Patrick van Elderen <patrick.vanelderen@live.nl>
 * juni 18, 2020
 */
public class HuntingExpert extends Dialogue {

    public static boolean onNpcOption1(Player player, Npc npc) {
        if(npc.id() == NpcIdentifiers.HUNTING_EXPERT_1504) {
            player.getDialogueManager().start(new HuntingExpert());
        }
        return false;
    }

    @Override
    protected void start(Object... parameters) {
        send(DialogueType.NPC_STATEMENT, NpcIdentifiers.HUNTING_EXPERT_1504, Expression.HAPPY, "Hello there " + player.getUsername() + "! Interested in a bit of Hunter are we?");
        setPhase(0);
    }

    @Override
    protected void next() {
        if (isPhase(0)) {
            send(DialogueType.PLAYER_STATEMENT, Expression.HAPPY, "We sure are! Can give you sell me some supplies?");
            setPhase(1);
        } else if (isPhase(1)) {
            send(DialogueType.NPC_STATEMENT, NpcIdentifiers.HUNTING_EXPERT_1504, Expression.HAPPY, "I can do more than that my friend. If you use your hunting loot on me,", "I'll offer you some cash in exchange for your finds.");
            setPhase(2);
        } else if (isPhase(2)) {
            send(DialogueType.PLAYER_STATEMENT, Expression.HAPPY, "I'll keep that in mind! So, how about this shop?");
            setPhase(3);
        } else if (isPhase(3)) {
            stop();
        }
    }
}
