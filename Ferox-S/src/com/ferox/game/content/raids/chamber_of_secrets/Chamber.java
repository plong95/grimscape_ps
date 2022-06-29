package com.ferox.game.content.raids.chamber_of_secrets;

import com.ferox.game.content.raids.chamber_of_xeric.great_olm.GreatOlm;
import com.ferox.game.content.raids.party.Party;
import com.ferox.game.world.World;
import com.ferox.game.world.entity.mob.player.Player;
import com.ferox.game.world.object.GameObject;
import com.ferox.game.world.position.Tile;
import com.ferox.net.packet.interaction.PacketInteraction;
import com.ferox.util.Color;

import static com.ferox.util.ObjectIdentifiers.*;

/**
 * @author Patrick van Elderen | May, 10, 2021, 11:09
 * @see <a href="https://github.com/PVE95">Github profile</a>
 */
public class Chamber extends PacketInteraction {

    private static final String[] QUOTES = {
        "It's got horrible breath!",
        "The floor? I wasn’t looking at its feet, I was too busy with its heads.",
        "It’s obviously guarding something.",
    };

    @Override
    public boolean handleObjectInteraction(Player player, GameObject object, int option) {
        if (option == 1) {
            //Passage movement
            if (object.getId() == PASSAGE_29789 || object.getId() == HOLE_29734) {
                for (Chambers chambers : Chambers.values()) {
                    if (object.tile().equals(chambers.objToNextChamberTile)) {
                        Party party = player.raidsParty;

                        if (party != null) {
                            //System.out.println("Party is not null, current stage "+party.getRaidStage()+ " required stage "+chambers.stage);

                            var requiredStage = chambers.stage;
                            var partyStage = party.getRaidStage();

                            //If the party stage is equal or higher then the requirement we can always move trough.
                            if (partyStage >= requiredStage) {
                                Tile tile = new Tile(chambers.tile.x, chambers.tile.y, player.tile().level);

                                if (object.tile().equals(3311, 5341)) {
                                    player.teleport(tile.transform(0, 0, 1));
                                    return true;
                                } else if (object.tile().equals(3308, 5337)) {
                                    player.teleport(tile.transform(0, 0, -1));
                                    return true;
                                } else if (object.tile().equals(3311, 5308)) {
                                    player.forceChat(QUOTES[World.getWorld().random(QUOTES.length - 1)]);
                                    player.teleport(tile);
                                    return true;
                                }

                                player.teleport(tile);
                            } else {
                                player.message("Their are still creatures alive, you cannot progress until they're all dead!");
                            }
                            return true;
                        }
                        return true;
                    }
                }
            }

            if (object.getId() == MYSTICAL_BARRIER) {
                Party party = player.raidsParty;
                if (party != null) {
                    Tile bossRoomTile = new Tile(3232, 5730, player.tile().level);
                    player.teleport(bossRoomTile);
                    if(!party.bossFightStarted()) {
                        GreatOlm.start(party);
                    }
                }
                return true;
            }

            if(object.getId() == ANCIENT_CHEST) {
                if(player.getRaidRewards().isEmpty()) {
                    player.message(Color.RED.wrap("You have already looted the chest, or your points are below 1,000."));
                    return true;
                }
                ChamberOfSecretsReward.displayRewards(player);
                ChamberOfSecretsReward.withdrawReward(player);
                return true;
            }

            if(object.getId() == STEPS_29778) {
                player.getChamberOfSecrets().exit();
                player.healPlayer();
                return true;
            }
        }
        return false;
    }

    public enum Chambers {
        ENTRY_CHAMBER(null, new Tile(3299, 5189), -1),
        CENTAUR_CHAMBER(new Tile(3307, 5205), new Tile(3308, 5208), 1),
        DEMENTOR_CHAMBER(new Tile(3311, 5276), new Tile(3312, 5279), 2),
        FLUFFY_CHAMBER(new Tile(3311, 5308), new Tile(3312, 5311), 3),
        ARAGOG_CHAMBER(new Tile(3311, 5341), new Tile(3311, 5309), 4),
        HUNGARIAN_HORNTAIL_CHAMBER(new Tile(3308, 5337, 1), new Tile(3275, 5159), 6),
        FENRIR_GREYBACK_CHAMBER(new Tile(3310, 5306), new Tile(3232, 5721), 7),
        OLM_ROOM_WAIT(new Tile(3277, 5169), new Tile(3232, 5721), 7);

        public final Tile objToNextChamberTile;
        public final Tile tile;
        public final int stage;

        Chambers(Tile objToNextChamberTile, Tile tile, int stage) {
            this.objToNextChamberTile = objToNextChamberTile;
            this.tile = tile;
            this.stage = stage;
        }
    }
}
