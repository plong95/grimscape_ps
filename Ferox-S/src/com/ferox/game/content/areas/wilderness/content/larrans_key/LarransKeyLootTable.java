package com.ferox.game.content.areas.wilderness.content.larrans_key;

import com.ferox.game.world.items.Item;
import com.ferox.util.Utils;

import java.util.Arrays;
import java.util.List;

import static com.ferox.util.CustomItemIdentifiers.*;
import static com.ferox.util.ItemIdentifiers.*;

/**
 * @author Patrick van Elderen | February, 17, 2021, 14:19
 * @see <a href="https://www.rune-server.ee/members/Zerikoth/">Rune-Server profile</a>
 */
public class LarransKeyLootTable {

    private static final List<Item> COMMON_TABLE_TIER_I = Arrays.asList(
        new Item(BLOOD_MONEY, 1500),
        new Item(DRAGON_DART, 25),
        new Item(DRAGON_KNIFE, 15),
        new Item(DRAGON_JAVELIN, 25),
        new Item(DRAGON_THROWNAXE, 25),
        new Item(ANTIVENOM4+1, 5),
        new Item(GUTHIX_REST4+1, 5),
        new Item(OBSIDIAN_HELMET, 1),
        new Item(OBSIDIAN_PLATEBODY, 1),
        new Item(OBSIDIAN_PLATELEGS, 1),
        new Item(RANGERS_TUNIC, 1),
        new Item(REGEN_BRACELET, 1),
        new Item(GRANITE_MAUL_24225, 1),
        new Item(BERSERKER_RING_I, 1),
        new Item(ARCHERS_RING_I, 1),
        new Item(SEERS_RING_I, 1),
        new Item(WARRIOR_RING_I, 1),
        new Item(OPAL_DRAGON_BOLTS_E, 25),
        new Item(DIAMOND_DRAGON_BOLTS_E, 25),
        new Item(DRAGONSTONE_DRAGON_BOLTS_E, 25),
        new Item(ONYX_DRAGON_BOLTS_E, 25)
        );

    private static final List<Item> UNCOMMON_TABLE_TIER_I = Arrays.asList(

        new Item(ABYSSAL_TENTACLE),
        new Item(BANDOS_CHESTPLATE),
        new Item(BANDOS_TASSETS),
        new Item(BLADE_OF_SAELDOR),
        new Item(BANDOS_GODSWORD),
        new Item(SARADOMIN_GODSWORD),
        new Item(ZAMORAK_GODSWORD),
        new Item(BLOOD_MONEY, 15000),
        new Item(ZAMORAKIAN_HASTA),
        new Item(DRAGON_CROSSBOW),
        new Item(DRAGON_SCIMITAR_OR),
        new Item(ABYSSAL_DAGGER)
    );

    private static final List<Item> RARE_TABLE_TIER_I = Arrays.asList(
        new Item(ARMADYL_GODSWORD),
        new Item(TORMENTED_BRACELET),
        new Item(DRAGON_CLAWS),
        new Item(UNCHARGED_TOXIC_TRIDENT),
        new Item(ABYSSAL_BLUDGEON),
        new Item(STATIUSS_WARHAMMER),
        new Item(DRAGON_WARHAMMER),
        new Item(DINHS_BULWARK),
        new Item(ARMADYL_CHAINSKIRT),
        new Item(ARMADYL_CHESTPLATE),
        new Item(PRIMORDIAL_BOOTS),
        new Item(PEGASIAN_BOOTS),
        new Item(ETERNAL_BOOTS),
        new Item(FREMENNIK_KILT)
    );

    private static final List<Item> EXTREMELY_RARE_TABLE_TIER_I = Arrays.asList(
        new Item(ELDER_MAUL),
        new Item(VESTAS_LONGSWORD),
        new Item(AMULET_OF_TORTURE),
        new Item(NECKLACE_OF_ANGUISH),
        new Item(TOXIC_STAFF_OF_THE_DEAD),
        new Item(SERPENTINE_HELM),
        new Item(TOXIC_BLOWPIPE)
        );

    private static final List<Item> COMMON_TABLE_TIER_II = Arrays.asList(
        new Item(ABYSSAL_TENTACLE),
        new Item(BANDOS_CHESTPLATE),
        new Item(BANDOS_TASSETS),
        new Item(BANDOS_GODSWORD),
        new Item(SARADOMIN_GODSWORD),
        new Item(ZAMORAK_GODSWORD),
        new Item(ARMADYL_HELMET),
        new Item(BLOOD_MONEY,3500),
        new Item(ZAMORAKIAN_HASTA),
        new Item(DRAGON_CROSSBOW),
        new Item(OPAL_DRAGON_BOLTS_E, 75),
        new Item(DIAMOND_DRAGON_BOLTS_E, 75),
        new Item(DRAGONSTONE_DRAGON_BOLTS_E, 75),
        new Item(ONYX_DRAGON_BOLTS_E, 75)
        );

    private static final List<Item> UNCOMMON_TABLE_TIER_II = Arrays.asList(
        new Item(ARMADYL_GODSWORD),
        new Item(ABYSSAL_DAGGER),
        new Item(TOXIC_BLOWPIPE),
        new Item(UNCHARGED_TOXIC_TRIDENT),
        new Item(ABYSSAL_BLUDGEON),
        new Item(DINHS_BULWARK),
        new Item(ARMADYL_CHAINSKIRT),
        new Item(ARMADYL_CHESTPLATE),
        new Item(MORRIGANS_COIF),
        new Item(ZURIELS_HOOD),
        new Item(FREMENNIK_KILT),
        new Item(DRAGON_SCIMITAR_OR),
        new Item(BLADE_OF_SAELDOR),
        new Item(DRAGON_WARHAMMER)
    );

    private static final List<Item> RARE_TABLE_TIER_II = Arrays.asList(
        new Item(STATIUSS_WARHAMMER),
        new Item(DRAGON_WARHAMMER),
        new Item(GHRAZI_RAPIER),
        new Item(KODAI_WAND),
        new Item(ZURIELS_STAFF),
        new Item(TORMENTED_BRACELET),
        new Item(AMULET_OF_TORTURE),
        new Item(NECKLACE_OF_ANGUISH),
        new Item(TOXIC_STAFF_OF_THE_DEAD),
        new Item(SERPENTINE_HELM),
        new Item(DRAGON_CLAWS)
    );

    private static final List<Item> EXTREMELY_RARE_TABLE_TIER_II = Arrays.asList(
        new Item(VOLATILE_ORB),
        new Item(ELDRITCH_ORB),
        new Item(HARMONISED_ORB),
        new Item(ARMADYL_GODSWORD_OR),
        new Item(MORRIGANS_LEATHER_BODY),
        new Item(MORRIGANS_LEATHER_CHAPS),
        new Item(ZURIELS_ROBE_TOP),
        new Item(ZURIELS_ROBE_BOTTOM),
        new Item(ELDER_MAUL),
        new Item(VESTAS_LONGSWORD)
    );

    private static final List<Item> COMMON_TABLE_TIER_III = Arrays.asList(
        new Item(ARMADYL_GODSWORD),
        new Item(ARMADYL_CROSSBOW),
        new Item(DRAGON_CLAWS),
        new Item(TOXIC_BLOWPIPE),
        new Item(TOXIC_STAFF_OF_THE_DEAD),
        new Item(UNCHARGED_TOXIC_TRIDENT),
        new Item(ABYSSAL_BLUDGEON),
        new Item(DINHS_BULWARK),
        new Item(MORRIGANS_COIF),
        new Item(ZURIELS_STAFF),
        new Item(ZURIELS_HOOD),
        new Item(ABYSSAL_BLUDGEON)
        );

    private static final List<Item> UNCOMMON_TABLE_TIER_III = Arrays.asList(
        new Item(STATIUSS_FULL_HELM),
        new Item(STATIUSS_WARHAMMER),
        new Item(DRAGON_WARHAMMER),
        new Item(MORRIGANS_LEATHER_BODY),
        new Item(MORRIGANS_LEATHER_CHAPS),
        new Item(ZURIELS_ROBE_TOP),
        new Item(ZURIELS_ROBE_BOTTOM),
        new Item(AMULET_OF_TORTURE),
        new Item(NECKLACE_OF_ANGUISH),
        new Item(TORMENTED_BRACELET)
    );

    private static final List<Item> RARE_TABLE_TIER_III = Arrays.asList(
        new Item(VOLATILE_ORB),
        new Item(ELDRITCH_ORB),
        new Item(HARMONISED_ORB),
        new Item(GHRAZI_RAPIER),
        new Item(FEROX_COINS, 500),
        new Item(BARRELCHEST_PET),
        new Item(SANGUINESTI_STAFF),
        new Item(KODAI_WAND),
        new Item(VESTAS_LONGSWORD)
    );

    private static final List<Item> EXTREMELY_RARE_TABLE_TIER_III = Arrays.asList(
        new Item(VESTAS_CHAINBODY),
        new Item(VESTAS_PLATESKIRT),
        new Item(ELDER_MAUL),
        new Item(STATIUSS_PLATEBODY),
        new Item(STATIUSS_PLATELEGS),
        new Item(NIGHTMARE_STAFF),
        new Item(ARMADYL_GODSWORD_OR),
        new Item(DRAGON_CLAWS_OR)
        );

    public static Item rewardTables(int key) {
        List<Item> items = null;
        if(key == LARRANS_KEY_TIER_I) {
            if(Utils.rollDie(150, 1)) {
                items = EXTREMELY_RARE_TABLE_TIER_I;
            } else if (Utils.rollDie(30, 1)) {
                items = RARE_TABLE_TIER_I;
            } else if (Utils.rollDie(7, 1)) {
                items = UNCOMMON_TABLE_TIER_I;
            } else {
                items = COMMON_TABLE_TIER_I;
            }
        } else if(key == LARRANS_KEY_TIER_II) {
            if(Utils.rollDie(150, 1)) {
                items = EXTREMELY_RARE_TABLE_TIER_II;
            } else if (Utils.rollDie(30, 1)) {
                items = RARE_TABLE_TIER_II;
            } else if (Utils.rollDie(7, 1)) {
                items = UNCOMMON_TABLE_TIER_II;
            } else {
                items = COMMON_TABLE_TIER_II;
            }
        } else if(key == LARRANS_KEY_TIER_III) {
            if(Utils.rollDie(150, 1)) {
                items = EXTREMELY_RARE_TABLE_TIER_III;
            } else if (Utils.rollDie(30, 1)) {
                items = RARE_TABLE_TIER_III;
            } else if (Utils.rollDie(7, 1)) {
                items = UNCOMMON_TABLE_TIER_III;
            } else {
                items = COMMON_TABLE_TIER_III;
            }
        }
        return Utils.randomElement(items);
    }
}
