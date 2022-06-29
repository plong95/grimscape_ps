package com.ferox.game.content.title.req.impl.other;

import com.ferox.game.content.title.req.TitleRequirement;
import com.ferox.game.world.entity.AttributeKey;
import com.ferox.game.world.entity.mob.player.Player;

/**
 * Created by Kaleem on 25/03/2018.
 */
public class WinStakeRequirement extends TitleRequirement {

    private final int amount;

    public WinStakeRequirement(int amount) {
        super("Win " + amount + " stakes");
        this.amount = amount;
    }

    @Override
    public boolean satisfies(Player player) {
        int stakesWon = player.getAttribOr(AttributeKey.STAKES_WON, 0);
        return stakesWon >= amount;
    }
}
