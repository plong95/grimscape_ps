package com.ferox.game;

import com.ferox.GameServer;
import com.ferox.game.world.InterfaceConstants;
import com.ferox.game.world.items.Item;
import com.ferox.util.ItemIdentifiers;

import static com.ferox.util.ItemIdentifiers.*;

/**
 * A class containing different attributes
 * which affect the game in different ways.
 *
 * @author Professor Oak
 */
public class GameConstants {

    public static final String VOTE_URL = "https://ferox-os.com/vote/";
    public static final String WEBSITE_URL = "https://ferox-os.com/";

    /**
     * Starter items for game mode.
     */
    public static final Item[] STARTER_ITEMS = {
        //Iron armour
        new Item(IRON_FULL_HELM), new Item(IRON_PLATEBODY), new Item(IRON_PLATELEGS), new Item(IRON_KITESHIELD),
        //Iron scimitar and rune scimitar
        new Item(IRON_SCIMITAR), new Item(RUNE_SCIMITAR),
        //Regular bow and bronze arrows
        new Item(SHORTBOW), new Item(BRONZE_ARROW, 1000),
        //Glory (6) and climbing boots
        new Item(AMULET_OF_GLORY6), new Item(CLIMBING_BOOTS),
        //Standard runes
        new Item(FIRE_RUNE, 1000), new Item(WATER_RUNE, 1000), new Item(AIR_RUNE, 1000), new Item(EARTH_RUNE, 1000), new Item(MIND_RUNE, 1000),
        //Food (Lobsters, noted)
        new Item(LOBSTER+1, 50)

    };

    /**
     * The server currency
     */
    public static int CURRENCY = GameServer.properties().pvpMode ? BLOOD_MONEY : ItemIdentifiers.COINS_995;

    public static String CURRENCY_STRING = GameServer.properties().pvpMode ? "BM" : "coins";

    public static final String SERVER_NAME = "Ferox";

    public static final int[] DONATOR_ITEMS = {DARK_CRAB, DARK_CRAB + 1, ItemIdentifiers.ANGLERFISH, ItemIdentifiers.ANGLERFISH + 1, ItemIdentifiers.SUPER_COMBAT_POTION1, ItemIdentifiers.SUPER_COMBAT_POTION2, ItemIdentifiers.SUPER_COMBAT_POTION3, ItemIdentifiers.SUPER_COMBAT_POTION4, ItemIdentifiers.SUPER_COMBAT_POTION1 + 1, ItemIdentifiers.SUPER_COMBAT_POTION2 + 1, ItemIdentifiers.SUPER_COMBAT_POTION3 + 1, ItemIdentifiers.SUPER_COMBAT_POTION4 + 1};

    /**
     * Spawnable Items
     */
    public static final int[] PVP_ALLOWED_SPAWNS = {
        COOKED_KARAMBWAN, WRATH_RUNE, ABYSSAL_WHIP,
        ANGLERFISH,SUPER_COMBAT_POTION4, MUSIC_HOOD, MUSIC_CAPE_13224, MUSIC_CAPET,
        BUCKET, WEEDS, BOLT_RACK, RAW_SHARK, MUD_RUNE, LAVA_RUNE, SMOKE_RUNE,
        NOSE_PEG, FACEMASK, EARMUFFS, SPINY_HELMET, ENCHANTED_GEM, SLAYER_RING_8, SLAYER_RING_7, SLAYER_RING_6, SLAYER_RING_5, SLAYER_RING_4, SLAYER_RING_3, SLAYER_RING_2, SLAYER_RING_1,
        BONES, BIG_BONES, BURNT_BONES, BAT_BONES, MONKEY_BONES, KNIFE, ASHES, OAK_STOCK, MAPLE_STOCK, WILLOW_STOCK, ARROW_SHAFT, YEW_STOCK, MAGIC_STOCK,
        GUAM_POTION_UNF, MARRENTILL_POTION_UNF, TARROMIN_POTION_UNF, HARRALANDER_POTION_UNF, RANARR_POTION_UNF, IRIT_POTION_UNF, AVANTOE_POTION_UNF, KWUARM_POTION_UNF, CADANTINE_POTION_UNF, DWARF_WEED_POTION_UNF, TORSTOL_POTION_UNF, STRENGTH_POTION4, STRENGTH_POTION3, STRENGTH_POTION2, STRENGTH_POTION1,
        ATTACK_POTION3, ATTACK_POTION2, ATTACK_POTION1, RESTORE_POTION3, RESTORE_POTION2, RESTORE_POTION1, DEFENCE_POTION3, DEFENCE_POTION2, DEFENCE_POTION1, PRAYER_POTION3, PRAYER_POTION2, PRAYER_POTION1, SUPER_ATTACK3, SUPER_ATTACK2, SUPER_ATTACK1, FISHING_POTION3, FISHING_POTION2, FISHING_POTION1, SUPER_STRENGTH3, SUPER_STRENGTH2, SUPER_STRENGTH1,
        SUPER_DEFENCE3, SUPER_DEFENCE2, SUPER_DEFENCE1, RANGING_POTION3, RANGING_POTION2, RANGING_POTION1, ANTIPOISON3, ANTIPOISON2, ANTIPOISON1, SUPERANTIPOISON3, SUPERANTIPOISON2, SUPERANTIPOISON1, WEAPON_POISON, ZAMORAK_BREW3, ZAMORAK_BREW2, ZAMORAK_BREW1, LONGBOW_U, SHORTBOW_U, HEADLESS_ARROW, OAK_SHORTBOW_U, OAK_LONGBOW_U, WILLOW_LONGBOW_U,
        WILLOW_SHORTBOW_U, MAPLE_LONGBOW_U, MAPLE_SHORTBOW_U, YEW_LONGBOW_U, YEW_SHORTBOW_U, MAGIC_LONGBOW_U, MAGIC_SHORTBOW_U, BRONZE_ARROWTIPS, IRON_ARROWTIPS, STEEL_ARROWTIPS, MITHRIL_ARROWTIPS, ADAMANT_ARROWTIPS, RUNE_ARROWTIPS, OPAL_BOLT_TIPS, PEARL_BOLT_TIPS, GRIMY_GUAM_LEAF, GRIMY_MARRENTILL, GRIMY_TARROMIN, GRIMY_HARRALANDER, GRIMY_RANARR_WEED, GRIMY_IRIT_LEAF, GRIMY_AVANTOE, GRIMY_KWUARM, GRIMY_CADANTINE,
        GRIMY_DWARF_WEED, GRIMY_TORSTOL, EYE_OF_NEWT, RED_SPIDERS_EGGS, LIMPWURT_ROOT, VIAL_OF_WATER, VIAL, SNAPE_GRASS, PESTLE_AND_MORTAR, UNICORN_HORN_DUST, UNICORN_HORN, WHITE_BERRIES, DRAGON_SCALE_DUST, BLUE_DRAGON_SCALE, WINE_OF_ZAMORAK, JANGERBERRIES, GUAM_LEAF, MARRENTILL, TARROMIN, HARRALANDER, RANARR_WEED,
        IRIT_LEAF, AVANTOE, KWUARM, CADANTINE, DWARF_WEED, TORSTOL, LOBSTER_POT, SMALL_FISHING_NET, BIG_FISHING_NET, FISHING_ROD, FLY_FISHING_ROD, HARPOON, FISHING_BAIT, FEATHER, SHRIMPS, RAW_SHRIMPS, ANCHOVIES, RAW_ANCHOVIES, SARDINE, RAW_SARDINE, SALMON,
        RAW_SALMON, TROUT, RAW_TROUT, GIANT_CARP, RAW_GIANT_CARP, COD, RAW_COD, RAW_HERRING, HERRING, RAW_PIKE, PIKE, RAW_MACKEREL, MACKEREL, RAW_TUNA, TUNA, RAW_BASS, BASS, RAW_SWORDFISH, SWORDFISH, RAW_LOBSTER, LOBSTER,
        SHARK, CLAY, COPPER_ORE, TIN_ORE, IRON_ORE, SILVER_ORE, GOLD_ORE, PERFECT_GOLD_ORE, MITHRIL_ORE, COAL, MONKS_ROBE,
        MONKS_ROBE_TOP, FIRE_RUNE, WATER_RUNE, AIR_RUNE, EARTH_RUNE, MIND_RUNE, BODY_RUNE, DEATH_RUNE, NATURE_RUNE, CHAOS_RUNE, LAW_RUNE, COSMIC_RUNE, BLOOD_RUNE, SOUL_RUNE, TINDERBOX, BRONZE_THROWNAXE, IRON_THROWNAXE, STEEL_THROWNAXE, MITHRIL_THROWNAXE, ADAMANT_THROWNAXE, RUNE_THROWNAXE,
        BRONZE_DART, IRON_DART, STEEL_DART, MITHRIL_DART, ADAMANT_DART, RUNE_DART, BRONZE_DARTP, IRON_DARTP, STEEL_DARTP, MITHRIL_DARTP, ADAMANT_DARTP, RUNE_DARTP, POISONED_DARTP, BRONZE_DART_TIP, IRON_DART_TIP, STEEL_DART_TIP, MITHRIL_DART_TIP, ADAMANT_DART_TIP, RUNE_DART_TIP, BRONZE_JAVELIN, IRON_JAVELIN,
        STEEL_JAVELIN, MITHRIL_JAVELIN, ADAMANT_JAVELIN, RUNE_JAVELIN, BRONZE_JAVELINP, IRON_JAVELINP, STEEL_JAVELINP, MITHRIL_JAVELINP, ADAMANT_JAVELINP, RUNE_JAVELINP, CROSSBOW, LONGBOW, SHORTBOW, OAK_SHORTBOW, OAK_LONGBOW, WILLOW_LONGBOW, WILLOW_SHORTBOW, MAPLE_LONGBOW, MAPLE_SHORTBOW, YEW_LONGBOW, YEW_SHORTBOW,
        MAGIC_LONGBOW, MAGIC_SHORTBOW, IRON_KNIFE, BRONZE_KNIFE, STEEL_KNIFE, MITHRIL_KNIFE, ADAMANT_KNIFE, RUNE_KNIFE, BLACK_KNIFE, BRONZE_KNIFEP, IRON_KNIFEP, STEEL_KNIFEP, MITHRIL_KNIFEP, BLACK_KNIFEP, ADAMANT_KNIFEP, RUNE_KNIFEP,
        BRONZE_BOLTS, BRONZE_BOLTS_P, OPAL_BOLTS, PEARL_BOLTS, BARBED_BOLTS, BRONZE_ARROW, BRONZE_ARROWP, IRON_ARROW, IRON_ARROWP, STEEL_ARROW, STEEL_ARROWP, MITHRIL_ARROW, MITHRIL_ARROWP, ADAMANT_ARROW, ADAMANT_ARROWP, RUNE_ARROW, RUNE_ARROWP, SPADE, GREEN_DHIDE_VAMBRACES, IRON_PLATELEGS, STEEL_PLATELEGS, MITHRIL_PLATELEGS, ADAMANT_PLATELEGS, BRONZE_PLATELEGS, BLACK_PLATELEGS, RUNE_PLATELEGS, IRON_PLATESKIRT, STEEL_PLATESKIRT, MITHRIL_PLATESKIRT, BRONZE_PLATESKIRT, BLACK_PLATESKIRT, ADAMANT_PLATESKIRT, RUNE_PLATESKIRT, LEATHER_CHAPS, STUDDED_CHAPS, GREEN_DHIDE_CHAPS, IRON_CHAINBODY, BRONZE_CHAINBODY, STEEL_CHAINBODY, BLACK_CHAINBODY, MITHRIL_CHAINBODY, ADAMANT_CHAINBODY, RUNE_CHAINBODY, IRON_PLATEBODY, BRONZE_PLATEBODY, STEEL_PLATEBODY, MITHRIL_PLATEBODY, ADAMANT_PLATEBODY, BLACK_PLATEBODY, RUNE_PLATEBODY, LEATHER_BODY, HARDLEATHER_BODY, STUDDED_BODY, GREEN_DHIDE_BODY, IRON_MED_HELM, BRONZE_MED_HELM, STEEL_MED_HELM, MITHRIL_MED_HELM, ADAMANT_MED_HELM, RUNE_MED_HELM, DRAGON_MED_HELM, BLACK_MED_HELM, IRON_FULL_HELM, BRONZE_FULL_HELM, STEEL_FULL_HELM, MITHRIL_FULL_HELM, ADAMANT_FULL_HELM, RUNE_FULL_HELM, BLACK_FULL_HELM, LEATHER_COWL, COIF, WOODEN_SHIELD, BRONZE_SQ_SHIELD, IRON_SQ_SHIELD, STEEL_SQ_SHIELD, BLACK_SQ_SHIELD, MITHRIL_SQ_SHIELD, ADAMANT_SQ_SHIELD, RUNE_SQ_SHIELD, DRAGON_SQ_SHIELD, BRONZE_KITESHIELD, IRON_KITESHIELD, STEEL_KITESHIELD, BLACK_KITESHIELD, MITHRIL_KITESHIELD, ADAMANT_KITESHIELD, RUNE_KITESHIELD, IRON_DAGGER, BRONZE_DAGGER, STEEL_DAGGER, MITHRIL_DAGGER, ADAMANT_DAGGER, RUNE_DAGGER, DRAGON_DAGGER, BLACK_DAGGER, IRON_DAGGERP, BRONZE_DAGGERP, STEEL_DAGGERP, MITHRIL_DAGGERP, ADAMANT_DAGGERP, RUNE_DAGGERP, DRAGON_DAGGERP, BLACK_DAGGERP, POISONED_DAGGERP, BRONZE_SPEAR, IRON_SPEAR, STEEL_SPEAR, MITHRIL_SPEAR, ADAMANT_SPEAR, RUNE_SPEAR, BRONZE_SPEARP, IRON_SPEARP, STEEL_SPEARP, MITHRIL_SPEARP, ADAMANT_SPEARP, RUNE_SPEARP, BRONZE_PICKAXE, IRON_PICKAXE, STEEL_PICKAXE, ADAMANT_PICKAXE, MITHRIL_PICKAXE, RUNE_PICKAXE, BRONZE_SWORD, IRON_SWORD, STEEL_SWORD, BLACK_SWORD, MITHRIL_SWORD, ADAMANT_SWORD, RUNE_SWORD, BRONZE_LONGSWORD, IRON_LONGSWORD, STEEL_LONGSWORD, BLACK_LONGSWORD, MITHRIL_LONGSWORD, ADAMANT_LONGSWORD, RUNE_LONGSWORD, DRAGON_LONGSWORD, BRONZE_2H_SWORD, IRON_2H_SWORD, STEEL_2H_SWORD, BLACK_2H_SWORD, MITHRIL_2H_SWORD, ADAMANT_2H_SWORD, RUNE_2H_SWORD, BRONZE_SCIMITAR, IRON_SCIMITAR, STEEL_SCIMITAR, BLACK_SCIMITAR, MITHRIL_SCIMITAR, ADAMANT_SCIMITAR, RUNE_SCIMITAR, IRON_WARHAMMER, BRONZE_WARHAMMER, STEEL_WARHAMMER, BLACK_WARHAMMER, MITHRIL_WARHAMMER, ADAMANT_WARHAMMER, RUNE_WARHAMMER, IRON_AXE, BRONZE_AXE, STEEL_AXE, MITHRIL_AXE, ADAMANT_AXE, RUNE_AXE, BLACK_AXE, IRON_BATTLEAXE, STEEL_BATTLEAXE, BLACK_BATTLEAXE, MITHRIL_BATTLEAXE, ADAMANT_BATTLEAXE, RUNE_BATTLEAXE, BRONZE_BATTLEAXE, DRAGON_BATTLEAXE, STAFF, STAFF_OF_AIR, STAFF_OF_WATER, STAFF_OF_EARTH, STAFF_OF_FIRE, MAGIC_STAFF, BATTLESTAFF, FIRE_BATTLESTAFF, WATER_BATTLESTAFF, AIR_BATTLESTAFF, EARTH_BATTLESTAFF, MYSTIC_FIRE_STAFF, MYSTIC_WATER_STAFF, MYSTIC_AIR_STAFF, MYSTIC_EARTH_STAFF, IRON_MACE, BRONZE_MACE, STEEL_MACE, BLACK_MACE, MITHRIL_MACE, ADAMANT_MACE, RUNE_MACE, DRAGON_MACE, RUNE_ESSENCE, AIR_TALISMAN, EARTH_TALISMAN, FIRE_TALISMAN, WATER_TALISMAN, BODY_TALISMAN, MIND_TALISMAN, CHAOS_TALISMAN, COSMIC_TALISMAN, DEATH_TALISMAN, LAW_TALISMAN, NATURE_TALISMAN, LOGS, WILLOW_LOGS, OAK_LOGS, LOCKPICK, RING_MOULD, UNHOLY_MOULD, AMULET_MOULD, NECKLACE_MOULD, HOLY_MOULD, DIAMOND, RUBY, EMERALD, SAPPHIRE, OPAL, JADE, RED_TOPAZ, DRAGONSTONE, UNCUT_DIAMOND, UNCUT_RUBY, UNCUT_EMERALD, UNCUT_SAPPHIRE, UNCUT_OPAL, UNCUT_JADE, UNCUT_RED_TOPAZ, UNCUT_DRAGONSTONE, AMULET_OF_GLORY, AMULET_OF_GLORY1, AMULET_OF_GLORY2, AMULET_OF_GLORY3, AMULET_OF_GLORY4, AMULET_OF_STRENGTH, AMULET_OF_MAGIC, AMULET_OF_DEFENCE, AMULET_OF_POWER, NEEDLE, THREAD, LEATHER, HARD_LEATHER, GREEN_DRAGON_LEATHER, BLACK_DRAGONHIDE, RED_DRAGONHIDE, BLUE_DRAGONHIDE, GREEN_DRAGONHIDE, CHISEL, HAMMER, BRONZE_BAR, IRON_BAR, STEEL_BAR, SILVER_BAR, GOLD_BAR, SARADOMIN_CAPE, GUTHIX_CAPE, ZAMORAK_CAPE, SARADOMIN_STAFF, GUTHIX_STAFF, ZAMORAK_STAFF, ATTACK_POTION4, RESTORE_POTION4, DEFENCE_POTION4, PRAYER_POTION4, SUPER_ATTACK4, FISHING_POTION4, SUPER_STRENGTH4, SUPER_DEFENCE4, RANGING_POTION4, ANTIPOISON4, SUPERANTIPOISON4, ZAMORAK_BREW4, ANTIFIRE_POTION4, ANTIFIRE_POTION3, ANTIFIRE_POTION2, ANTIFIRE_POTION1, LANTADYME, LANTADYME_POTION_UNF, GRIMY_LANTADYME, BLUE_DHIDE_VAMBRACES, RED_DHIDE_VAMBRACES, BLACK_DHIDE_VAMBRACES, BLUE_DHIDE_CHAPS, RED_DHIDE_CHAPS, BLACK_DHIDE_CHAPS, BLUE_DHIDE_BODY, RED_DHIDE_BODY, BLACK_DHIDE_BODY, BLUE_DRAGON_LEATHER, RED_DRAGON_LEATHER, BLACK_DRAGON_LEATHER, BLACK_PLATEBODY_T, BLACK_PLATELEGS_T, BLACK_FULL_HELM_T, BLACK_KITESHIELD_T, BLACK_PLATEBODY_G, BLACK_PLATELEGS_G, BLACK_FULL_HELM_G, BLACK_KITESHIELD_G, ADAMANT_PLATEBODY_T, ADAMANT_PLATELEGS_T, ADAMANT_KITESHIELD_T, ADAMANT_FULL_HELM_T, ADAMANT_PLATEBODY_G, ADAMANT_PLATELEGS_G, ADAMANT_KITESHIELD_G, ADAMANT_FULL_HELM_G, RUNE_PLATEBODY_G, RUNE_PLATELEGS_G, RUNE_FULL_HELM_G, RUNE_KITESHIELD_G, RUNE_PLATEBODY_T, RUNE_PLATELEGS_T, RUNE_FULL_HELM_T, RUNE_KITESHIELD_T, HIGHWAYMAN_MASK, BLUE_BERET, BLACK_BERET, WHITE_BERET, TAN_CAVALIER, DARK_CAVALIER, BLACK_CAVALIER, RED_HEADBAND, BLACK_HEADBAND, BROWN_HEADBAND, PIRATES_HAT, ZAMORAK_PLATEBODY, ZAMORAK_PLATELEGS, ZAMORAK_FULL_HELM, ZAMORAK_KITESHIELD, SARADOMIN_PLATEBODY, SARADOMIN_PLATELEGS, SARADOMIN_FULL_HELM, SARADOMIN_KITESHIELD, GUTHIX_PLATEBODY, GUTHIX_PLATELEGS, GUTHIX_FULL_HELM, GUTHIX_KITESHIELD, CHOMPY_BIRD_HAT, CHOMPY_BIRD_HAT_2979, CHOMPY_BIRD_HAT_2980, CHOMPY_BIRD_HAT_2981, CHOMPY_BIRD_HAT_2982, CHOMPY_BIRD_HAT_2983, CHOMPY_BIRD_HAT_2984, CHOMPY_BIRD_HAT_2985, CHOMPY_BIRD_HAT_2986, CHOMPY_BIRD_HAT_2987, CHOMPY_BIRD_HAT_2988, CHOMPY_BIRD_HAT_2989, CHOMPY_BIRD_HAT_2990, CHOMPY_BIRD_HAT_2991, CHOMPY_BIRD_HAT_2992, CHOMPY_BIRD_HAT_2993, CHOMPY_BIRD_HAT_2994, CHOMPY_BIRD_HAT_2995, TOADFLAX, SNAPDRAGON, TOADFLAX_POTION_UNF, SNAPDRAGON_POTION_UNF, ENERGY_POTION4, ENERGY_POTION3, ENERGY_POTION2, ENERGY_POTION1, SUPER_ENERGY4, SUPER_ENERGY3, SUPER_ENERGY2, SUPER_ENERGY1, SUPER_RESTORE4, SUPER_RESTORE3, SUPER_RESTORE2, SUPER_RESTORE1, AGILITY_POTION4, AGILITY_POTION3, AGILITY_POTION2, AGILITY_POTION1, MAGIC_POTION4, MAGIC_POTION3, MAGIC_POTION2, MAGIC_POTION1, GRIMY_TOADFLAX, GRIMY_SNAPDRAGON, MIME_MASK, MIME_TOP, MIME_LEGS, MIME_GLOVES, MIME_BOOTS, BLACK_DART, BLACK_DARTP, BRONZE_CLAWS, IRON_CLAWS, STEEL_CLAWS, BLACK_CLAWS, MITHRIL_CLAWS, ADAMANT_CLAWS, RUNE_CLAWS, GRANITE_SHIELD, BRONZE_HALBERD, IRON_HALBERD, STEEL_HALBERD, BLACK_HALBERD, MITHRIL_HALBERD, ADAMANT_HALBERD, RUNE_HALBERD, SPLITBARK_HELM, SPLITBARK_BODY, SPLITBARK_LEGS, SPLITBARK_GAUNTLETS, SPLITBARK_BOOTS, BLACK_PLATESKIRT_T, BLACK_PLATESKIRT_G, ADAMANT_PLATESKIRT_T, ADAMANT_PLATESKIRT_G, RUNE_PLATESKIRT_G, RUNE_PLATESKIRT_T, ZAMORAK_PLATESKIRT, SARADOMIN_PLATESKIRT, GUTHIX_PLATESKIRT, GILDED_PLATEBODY, GILDED_PLATELEGS, GILDED_PLATESKIRT, GILDED_FULL_HELM, GILDED_KITESHIELD, ARCHER_HELM, BERSERKER_HELM, WARRIOR_HELM, FARSEER_HELM, HOLY_BOOK, UNHOLY_BOOK, BOOK_OF_BALANCE, DRAGON_PLATELEGS, MYSTIC_HAT, MYSTIC_ROBE_TOP, MYSTIC_ROBE_BOTTOM, MYSTIC_GLOVES, MYSTIC_BOOTS, MYSTIC_HAT_DARK, MYSTIC_ROBE_TOP_DARK, MYSTIC_ROBE_BOTTOM_DARK, MYSTIC_GLOVES_DARK, MYSTIC_BOOTS_DARK, MYSTIC_HAT_LIGHT, MYSTIC_ROBE_TOP_LIGHT, MYSTIC_ROBE_BOTTOM_LIGHT, MYSTIC_GLOVES_LIGHT, MYSTIC_BOOTS_LIGHT, BRONZE_BOOTS, IRON_BOOTS, STEEL_BOOTS, BLACK_BOOTS, MITHRIL_BOOTS, ADAMANT_BOOTS, RUNE_BOOTS, SLAYERS_STAFF, TEAM1_CAPE, TEAM2_CAPE, TEAM3_CAPE, TEAM4_CAPE, TEAM5_CAPE, TEAM6_CAPE, TEAM7_CAPE, TEAM8_CAPE, TEAM9_CAPE, TEAM10_CAPE, TEAM11_CAPE, TEAM12_CAPE, TEAM13_CAPE, TEAM14_CAPE, TEAM15_CAPE, TEAM16_CAPE, TEAM17_CAPE, TEAM18_CAPE, TEAM19_CAPE, TEAM20_CAPE, TEAM21_CAPE, TEAM22_CAPE, TEAM23_CAPE, TEAM24_CAPE, TEAM25_CAPE, TEAM26_CAPE, TEAM27_CAPE, TEAM28_CAPE, TEAM29_CAPE, TEAM30_CAPE, TEAM31_CAPE, TEAM32_CAPE, TEAM33_CAPE, TEAM34_CAPE, TEAM35_CAPE, TEAM36_CAPE, TEAM37_CAPE, TEAM38_CAPE, TEAM39_CAPE, TEAM40_CAPE, TEAM41_CAPE, TEAM42_CAPE, TEAM43_CAPE, TEAM44_CAPE, TEAM45_CAPE, TEAM46_CAPE, TEAM47_CAPE, TEAM48_CAPE, TEAM49_CAPE, TEAM50_CAPE, DECORATIVE_SWORD, DECORATIVE_ARMOUR, DECORATIVE_ARMOUR_4070, DECORATIVE_HELM, DECORATIVE_SHIELD, DECORATIVE_SWORD_4503, DECORATIVE_ARMOUR_4504, DECORATIVE_ARMOUR_4505, DECORATIVE_HELM_4506, DECORATIVE_SHIELD_4507, DRAGON_PLATESKIRT, DRAGON_SCIMITAR, GUAM_SEED, MARRENTILL_SEED, TARROMIN_SEED, HARRALANDER_SEED, AIR_TIARA, MIND_TIARA, WATER_TIARA, BODY_TIARA, EARTH_TIARA, FIRE_TIARA, COSMIC_TIARA, NATURE_TIARA, CHAOS_TIARA, LAW_TIARA, DEATH_TIARA, ROGUE_TOP, ROGUE_MASK, ROGUE_TROUSERS, ROGUE_GLOVES, ROGUE_BOOTS, ROGUE_KIT, BRONZE_ARROWP_5616, IRON_ARROWP_5617, STEEL_ARROWP_5618, MITHRIL_ARROWP_5619, ADAMANT_ARROWP_5620, RUNE_ARROWP_5621, BRONZE_ARROWP_5622, IRON_ARROWP_5623, STEEL_ARROWP_5624, MITHRIL_ARROWP_5625, ADAMANT_ARROWP_5626, RUNE_ARROWP_5627, BRONZE_DARTP_5628, IRON_DARTP_5629, STEEL_DARTP_5630, BLACK_DARTP_5631, MITHRIL_DARTP_5632, ADAMANT_DARTP_5633, RUNE_DARTP_5634, BRONZE_DARTP_5635, IRON_DARTP_5636, STEEL_DARTP_5637, BLACK_DARTP_5638, MITHRIL_DARTP_5639, ADAMANT_DARTP_5640, RUNE_DARTP_5641, BRONZE_JAVELINP_5642, IRON_JAVELINP_5643, STEEL_JAVELINP_5644, MITHRIL_JAVELINP_5645, ADAMANT_JAVELINP_5646, RUNE_JAVELINP_5647, BRONZE_JAVELINP_5648, IRON_JAVELINP_5649, STEEL_JAVELINP_5650, MITHRIL_JAVELINP_5651, ADAMANT_JAVELINP_5652, RUNE_JAVELINP_5653, BRONZE_KNIFEP_5654, IRON_KNIFEP_5655, STEEL_KNIFEP_5656, MITHRIL_KNIFEP_5657, BLACK_KNIFEP_5658, ADAMANT_KNIFEP_5659, RUNE_KNIFEP_5660, BRONZE_KNIFEP_5661, IRON_KNIFEP_5662, STEEL_KNIFEP_5663, MITHRIL_KNIFEP_5664, BLACK_KNIFEP_5665, ADAMANT_KNIFEP_5666, RUNE_KNIFEP_5667, IRON_DAGGERP_5668, BRONZE_DAGGERP_5670, STEEL_DAGGERP_5672, MITHRIL_DAGGERP_5674, ADAMANT_DAGGERP_5676, RUNE_DAGGERP_5678, DRAGON_DAGGERP_5680, BLACK_DAGGERP_5682, POISON_DAGGERP, IRON_DAGGERP_5686, BRONZE_DAGGERP_5688, STEEL_DAGGERP_5690, MITHRIL_DAGGERP_5692, ADAMANT_DAGGERP_5694, RUNE_DAGGERP_5696, DRAGON_DAGGERP_5698, BLACK_DAGGERP_5700, POISON_DAGGERP_5702, BRONZE_SPEARP_5704, IRON_SPEARP_5706, STEEL_SPEARP_5708, MITHRIL_SPEARP_5710, ADAMANT_SPEARP_5712, RUNE_SPEARP_5714, BRONZE_SPEARP_5718, IRON_SPEARP_5720, STEEL_SPEARP_5722, MITHRIL_SPEARP_5724, ADAMANT_SPEARP_5726, RUNE_SPEARP_5728, GHOSTLY_BOOTS, GHOSTLY_ROBE, GHOSTLY_ROBE_6108, GHOSTLY_HOOD, GHOSTLY_GLOVES, GHOSTLY_CLOAK, ROCKSHELL_HELM, ROCKSHELL_PLATE, ROCKSHELL_LEGS, SPINED_HELM, SPINED_BODY, SPINED_CHAPS, SKELETAL_HELM, SKELETAL_TOP, SKELETAL_BOTTOMS, SPINED_BOOTS, ROCKSHELL_BOOTS, SKELETAL_BOOTS, SPINED_GLOVES, ROCKSHELL_GLOVES, SKELETAL_GLOVES, SNAKESKIN_BODY, SNAKESKIN_CHAPS, SNAKESKIN_BANDANA, SNAKESKIN_BOOTS, SNAKESKIN_VAMBRACES, TOKTZXILUL, TOKTZXILAK, TOKTZKETXIL, TOKTZXILEK, TOKTZMEJTAL, TZHAARKETEM, OBSIDIAN_CAPE, SARADOMIN_BREW4, SARADOMIN_BREW3, SARADOMIN_BREW2, SARADOMIN_BREW1, TUNA_POTATO, BLACK_SHIELD_H1_10665, ADAMANT_SHIELD_H1_10666, RUNE_SHIELD_H1_10667, BLACK_SHIELD_H2_10668, ADAMANT_SHIELD_H2_10669, RUNE_SHIELD_H2_10670, BLACK_SHIELD_H3_10671, ADAMANT_SHIELD_H3_10672, RUNE_SHIELD_H3_10673, BLACK_SHIELD_H4_10674, ADAMANT_SHIELD_H4_10675, RUNE_SHIELD_H4_10676, BLACK_SHIELD_H5_10677, ADAMANT_SHIELD_H5_10678, RUNE_SHIELD_H5_10679, STUDDED_BODY_G_10680, STUDDED_BODY_T_10681, STUDDED_CHAPS_G, STUDDED_CHAPS_T, GREEN_DHIDE_BODY_G, GREEN_DHIDE_BODY_T, BLUE_DHIDE_BODY_G, BLUE_DHIDE_BODY_T, GREEN_DHIDE_CHAPS_G, GREEN_DHIDE_CHAPS_T, BLUE_DHIDE_CHAPS_G, BLUE_DHIDE_CHAPS_T, BLUE_SKIRT_G, BLUE_SKIRT_T, BLUE_WIZARD_ROBE_G, BLUE_WIZARD_ROBE_T, BLUE_WIZARD_HAT_G, BLUE_WIZARD_HAT_T, ENCHANTED_ROBE, ENCHANTED_TOP, ENCHANTED_HAT, BRONZE_GLOVES, IRON_GLOVES, STEEL_GLOVES, BLACK_GLOVES, MITHRIL_GLOVES, ADAMANT_GLOVES, RUNE_GLOVES, DRAGON_GLOVES, RAW_MONKFISH, MONKFISH, VARROCK_TELEPORT, LUMBRIDGE_TELEPORT, FALADOR_TELEPORT, CAMELOT_TELEPORT, ARDOUGNE_TELEPORT, WATCHTOWER_TELEPORT, TELEPORT_TO_HOUSE, DORGESHUUN_CROSSBOW, BONE_BOLTS, MOONCLAN_HELM, MOONCLAN_HAT, MOONCLAN_ARMOUR, MOONCLAN_SKIRT, MOONCLAN_GLOVES, MOONCLAN_BOOTS, MOONCLAN_CAPE, ASTRAL_RUNE, LUNAR_HELM, LUNAR_TORSO, LUNAR_LEGS, LUNAR_GLOVES, LUNAR_BOOTS, LUNAR_CAPE, LUNAR_AMULET, ASTRAL_TIARA, IRON_BOLTS, STEEL_BOLTS, MITHRIL_BOLTS, ADAMANT_BOLTS, RUNITE_BOLTS, SILVER_BOLTS, BRONZE_CROSSBOW, BLURITE_CROSSBOW, IRON_CROSSBOW, STEEL_CROSSBOW, MITH_CROSSBOW, ADAMANT_CROSSBOW, RUNE_CROSSBOW, JADE_BOLT_TIPS, TOPAZ_BOLT_TIPS, SAPPHIRE_BOLT_TIPS, EMERALD_BOLT_TIPS, RUBY_BOLT_TIPS, DIAMOND_BOLT_TIPS, DRAGONSTONE_BOLT_TIPS, ONYX_BOLT_TIPS, OPAL_BOLTS_E, JADE_BOLTS_E, PEARL_BOLTS_E, TOPAZ_BOLTS_E, SAPPHIRE_BOLTS_E, EMERALD_BOLTS_E, RUBY_BOLTS_E, DIAMOND_BOLTS_E, DRAGONSTONE_BOLTS_E, ONYX_BOLTS_E, BLURITE_BOLTS_P, IRON_BOLTS_P, STEEL_BOLTS_P, MITHRIL_BOLTS_P, ADAMANT_BOLTS_P, RUNITE_BOLTS_P, SILVER_BOLTS_P, BLURITE_BOLTS_P_9293, IRON_BOLTS_P_9294, STEEL_BOLTS_P_9295, MITHRIL_BOLTS_P_9296, ADAMANT_BOLTS_P_9297, RUNITE_BOLTS_P_9298, SILVER_BOLTS_P_9299, BLURITE_BOLTS_P_9300, IRON_BOLTS_P_9301, STEEL_BOLTS_P_9302, MITHRIL_BOLTS_P_9303, ADAMANT_BOLTS_P_9304, RUNITE_BOLTS_P_9305, SILVER_BOLTS_P_9306, JADE_BOLTS, TOPAZ_BOLTS, SAPPHIRE_BOLTS, EMERALD_BOLTS, RUBY_BOLTS, DIAMOND_BOLTS, DRAGON_BOLTS, ONYX_BOLTS, BRONZE_BOLTS_UNF, BLURITE_BOLTS_UNF, IRON_BOLTS_UNF, STEEL_BOLTS_UNF, MITHRIL_BOLTS_UNF, ADAMANT_BOLTSUNF, RUNITE_BOLTS_UNF, SILVER_BOLTS_UNF, BRONZE_LIMBS, BLURITE_LIMBS, IRON_LIMBS, STEEL_LIMBS, MITHRIL_LIMBS, ADAMANTITE_LIMBS, RUNITE_LIMBS, BRONZE_CROSSBOW_U, BLURITE_CROSSBOW_U, IRON_CROSSBOW_U, STEEL_CROSSBOW_U, MITHRIL_CROSSBOW_U, ADAMANT_CROSSBOW_U, RUNITE_CROSSBOW_U, PROSELYTE_SALLET, PROSELYTE_HAUBERK, PROSELYTE_CUISSE, PROSELYTE_TASSET, COMBAT_POTION4, COMBAT_POTION3, COMBAT_POTION2, COMBAT_POTION1, ATTACK_CAPE, ATTACK_CAPET, ATTACK_HOOD, STRENGTH_CAPE, STRENGTH_CAPET, STRENGTH_HOOD, DEFENCE_CAPE, DEFENCE_CAPET, DEFENCE_HOOD, RANGING_CAPE, RANGING_CAPET, RANGING_HOOD, PRAYER_CAPE, PRAYER_CAPET, PRAYER_HOOD, MAGIC_CAPE, MAGIC_CAPET, MAGIC_HOOD, RUNECRAFT_CAPE, RUNECRAFT_CAPET, RUNECRAFT_HOOD, HITPOINTS_CAPE, HITPOINTS_CAPET, HITPOINTS_HOOD, AGILITY_CAPE, AGILITY_CAPET, AGILITY_HOOD, HERBLORE_CAPE, HERBLORE_CAPET, HERBLORE_HOOD, THIEVING_CAPE, THIEVING_CAPET, THIEVING_HOOD, CRAFTING_CAPE, CRAFTING_CAPET, CRAFTING_HOOD, FLETCHING_CAPE, FLETCHING_CAPET, FLETCHING_HOOD, SLAYER_CAPE, SLAYER_CAPET, SLAYER_HOOD, CONSTRUCT_CAPE, CONSTRUCT_CAPET, CONSTRUCT_HOOD, MINING_CAPE, MINING_CAPET, MINING_HOOD, SMITHING_CAPE, SMITHING_CAPET, SMITHING_HOOD, FISHING_CAPE, FISHING_CAPET, FISHING_HOOD, COOKING_CAPE, COOKING_CAPET, COOKING_HOOD, FIREMAKING_CAPE, FIREMAKING_CAPET, FIREMAKING_HOOD, WOODCUTTING_CAPE, WOODCUT_CAPET, WOODCUTTING_HOOD, FARMING_CAPE, FARMING_CAPET, FARMING_HOOD, QUEST_POINT_CAPE, QUEST_POINT_HOOD, HUNTER_CAPE, HUNTER_CAPET, HUNTER_HOOD, HUNTER_POTION4, HUNTER_POTION3, HUNTER_POTION2, HUNTER_POTION1, KYATT_LEGS, KYATT_TOP, KYATT_HAT, LARUPIA_LEGS, LARUPIA_TOP, LARUPIA_HAT, GRAAHK_LEGS, GRAAHK_TOP, GRAAHK_HEADDRESS, SPOTTED_CAPE, SPOTTIER_CAPE, SPOTTED_CAPE_10073, SPOTTIER_CAPE_10074, SPIKY_VAMBRACES, GREEN_SPIKY_VAMBRACES, BLUE_SPIKY_VAMBRACES, RED_SPIKY_VAMBRACES, BLACK_SPIKY_VAMBRACES, HUNTERS_CROSSBOW, KEBBIT_BOLTS, LONG_KEBBIT_BOLTS, AMULET_OF_GLORY_T4, AMULET_OF_GLORY_T3, AMULET_OF_GLORY_T2, AMULET_OF_GLORY_T1, AMULET_OF_GLORY_T, STRENGTH_AMULET_T, AMULET_OF_MAGIC_T, ZAMORAK_BRACERS, ZAMORAK_DHIDE_BODY, ZAMORAK_CHAPS, ZAMORAK_COIF, GUTHIX_BRACERS, GUTHIX_DHIDE_BODY, GUTHIX_CHAPS, GUTHIX_COIF, SARADOMIN_BRACERS, SARADOMIN_DHIDE_BODY, SARADOMIN_CHAPS, SARADOMIN_COIF, BLACK_ELEGANT_SHIRT, BLACK_ELEGANT_LEGS, RED_ELEGANT_SHIRT, RED_ELEGANT_LEGS, BLUE_ELEGANT_SHIRT, BLUE_ELEGANT_LEGS, GREEN_ELEGANT_SHIRT, GREEN_ELEGANT_LEGS, PURPLE_ELEGANT_SHIRT, PURPLE_ELEGANT_LEGS, WHITE_ELEGANT_BLOUSE, WHITE_ELEGANT_SKIRT, RED_ELEGANT_BLOUSE, RED_ELEGANT_SKIRT, BLUE_ELEGANT_BLOUSE, BLUE_ELEGANT_SKIRT, GREEN_ELEGANT_BLOUSE, GREEN_ELEGANT_SKIRT, PURPLE_ELEGANT_BLOUSE, PURPLE_ELEGANT_SKIRT, SARADOMIN_CROZIER, GUTHIX_CROZIER, ZAMORAK_CROZIER, SARADOMIN_CLOAK, GUTHIX_CLOAK, ZAMORAK_CLOAK, SARADOMIN_MITRE, GUTHIX_MITRE, ZAMORAK_MITRE, SARADOMIN_ROBE_TOP, ZAMORAK_ROBE_TOP, GUTHIX_ROBE_TOP, SARADOMIN_ROBE_LEGS, GUTHIX_ROBE_LEGS, ZAMORAK_ROBE_LEGS, SARADOMIN_STOLE, GUTHIX_STOLE, ZAMORAK_STOLE, AVAS_ATTRACTOR, AVAS_ACCUMULATOR, CAPE_OF_LEGENDS, ATTACK_CAPE_10639, STRENGTH_CAPE_10640, DEFENCE_CAPE_10641, RANGING_CAPE_10642, PRAYER_CAPE_10643, MAGIC_CAPE_10644, RUNECRAFT_CAPE_10645, HUNTER_CAPE_10646, HITPOINTS_CAPE_10647, AGILITY_CAPE_10648, HERBLORE_CAPE_10649, THIEVING_CAPE_10650, CRAFTING_CAPE_10651, FLETCHING_CAPE_10652, SLAYER_CAPE_10653, CONSTRUCT_CAPE_10654, MINING_CAPE_10655, SMITHING_CAPE_10656, FISHING_CAPE_10657, COOKING_CAPE_10658, FIREMAKING_CAPE_10659, WOODCUTTING_CAPE_10660, FARMING_CAPE_10661, QUEST_POINT_CAPE_10662, SPOTTED_CAPE_10663, SPOTTIER_CAPE_10664, BLACK_SHIELD_H1, ADAMANT_SHIELD_H1, RUNE_SHIELD_H1, BLACK_SHIELD_H2, ADAMANT_SHIELD_H2, RUNE_SHIELD_H2, BLACK_SHIELD_H3, ADAMANT_SHIELD_H3, RUNE_SHIELD_H3, BLACK_SHIELD_H4, ADAMANT_SHIELD_H4, RUNE_SHIELD_H4, BLACK_SHIELD_H5, ADAMANT_SHIELD_H5, RUNE_SHIELD_H5, STUDDED_BODY_G, STUDDED_BODY_T, DHIDE_BODY_G, DHIDE_BODY_T, DHIDE_BODY_G_10684, DHIDE_BODY_T_10685, WIZARD_ROBE_G, WIZARD_ROBE_T, ENCHANTED_TOP_10688, BLACK_PLATEBODY_T_10690, HIGHWAYMAN_MASK_10692, ADAMANT_PLATEBODY_T_10697, BLACK_PLATEBODY_G_10691, BLACK_HELM_H1, BLACK_HELM_H2, BLACK_HELM_H3, BLACK_HELM_H4, BLACK_HELM_H5, RUNE_HELM_H1, RUNE_HELM_H2, RUNE_HELM_H3, RUNE_HELM_H4, RUNE_HELM_H5, ADAMANT_HELM_H1, ADAMANT_HELM_H2, ADAMANT_HELM_H3, ADAMANT_HELM_H4, ADAMANT_HELM_H5, BOBS_RED_SHIRT_10714, BOBS_BLUE_SHIRT_10715, BOBS_GREEN_SHIRT_10716, BOBS_BLACK_SHIRT_10717, BOBS_PURPLE_SHIRT_10718, AMULET_OF_GLORY_T_10719, GUTHIX_CAPE_10720, FROG_MASK_10721, REINDEER_HAT_10722, JACK_LANTERN_MASK_10723, SKELETON_BOOTS_10724, SKELETON_GLOVES_10725, SKELETON_LEGGINGS_10726, SKELETON_SHIRT_10727, SKELETON_MASK_10728, EASTER_RING_10729, STRENGTH_AMULET_T_10736, AMULET_OF_MAGIC_T_10738, BLACK_ELEGANT_SHIRT_10748, RED_ELEGANT_SHIRT_10750, BLUE_ELEGANT_SHIRT_10752, GREEN_ELEGANT_SHIRT_10754, PURPLE_ELEGANT_SHIRT_10756, RED_BOATER, ORANGE_BOATER, GREEN_BOATER, BLUE_BOATER, BLACK_BOATER, RED_HEADBAND_10768, BLACK_HEADBAND_10770, BROWN_HEADBAND_10772, PIRATES_HAT_10774, ZAMORAK_PLATEBODY_10776, SARADOMIN_PLATE, GUTHIX_PLATEBODY_10780, GILDED_PLATEBODY_10782, SARADOMIN_ROBE_TOP_10784, ZAMORAK_ROBE_TOP_10786, GUTHIX_ROBE_TOP_10788, ZAMORAK_DHIDE_BODY_10790, RUNE_PLATEBODY_G_10798, RUNE_PLATEBODY_T_10800, TAN_CAVALIER_10802, DARK_CAVALIER_10804, BLACK_CAVALIER_10806, HELM_OF_NEITIZNOT, DRAGON_ARROW, DRAGON_ARROWP, DRAGON_ARROWP_11228, DRAGON_ARROWP_11229, AMULET_OF_GLORY5, AMULET_OF_GLORY6, ANCIENT_ROBE_TOP, ANCIENT_ROBE_LEGS, ANCIENT_CLOAK, ANCIENT_CROZIER, ANCIENT_STOLE, ANCIENT_MITRE, BRONZE_PLATEBODY_G, BRONZE_PLATELEGS_G, BRONZE_PLATESKIRT_G, BRONZE_FULL_HELM_G, BRONZE_KITESHIELD_G, BRONZE_PLATEBODY_T, BRONZE_PLATELEGS_T, BRONZE_PLATESKIRT_T, BRONZE_FULL_HELM_T, BRONZE_KITESHIELD_T, IRON_PLATEBODY_T, IRON_PLATELEGS_T, IRON_PLATESKIRT_T, IRON_FULL_HELM_T, IRON_KITESHIELD_T, IRON_PLATEBODY_G, IRON_PLATELEGS_G, IRON_PLATESKIRT_G, IRON_FULL_HELM_G, IRON_KITESHIELD_G, BEANIE, RED_BERET, IMP_MASK, GOBLIN_MASK, ARMADYL_ROBE_TOP, ARMADYL_ROBE_LEGS, ARMADYL_STOLE, ARMADYL_MITRE, ARMADYL_CLOAK, ARMADYL_CROZIER, BANDOS_ROBE_TOP, BANDOS_ROBE_LEGS, BANDOS_STOLE, BANDOS_MITRE, BANDOS_CLOAK, BANDOS_CROZIER, MITHRIL_PLATEBODY_G, MITHRIL_PLATELEGS_G, MITHRIL_KITESHIELD_G, MITHRIL_FULL_HELM_G, MITHRIL_PLATESKIRT_G, MITHRIL_PLATEBODY_T, MITHRIL_PLATELEGS_T, MITHRIL_KITESHIELD_T, MITHRIL_FULL_HELM_T, MITHRIL_PLATESKIRT_T, BLACK_PICKAXE, WHITE_HEADBAND, BLUE_HEADBAND, GOLD_HEADBAND, PINK_HEADBAND, GREEN_HEADBAND, PINK_BOATER, PURPLE_BOATER, WHITE_BOATER, PINK_ELEGANT_SHIRT, PINK_ELEGANT_LEGS, CRIER_HAT, WHITE_CAVALIER, RED_CAVALIER, NAVY_CAVALIER, RED_DHIDE_BODY_G, RED_DHIDE_CHAPS_G, RED_DHIDE_BODY_T, RED_DHIDE_CHAPS_T, GREY_HAT, RED_CAPE, BLUE_SKIRT, BLUE_WIZARD_ROBE, BLUE_WIZARD_HAT, CLIMBING_BOOTS, ANTIDRAGON_SHIELD, ANCIENT_STAFF, SPIRIT_SHIELD, LEATHER_BOOTS, ZAMORAK_MONK_TOP, ZAMORAK_MONK_BOTTOM, BOOK_OF_DARKNESS, BOOK_OF_WAR, BARROWS_GLOVES, BRONZE_DEFENDER, IRON_DEFENDER, STEEL_DEFENDER, BLACK_DEFENDER, MITHRIL_DEFENDER, ADAMANT_DEFENDER, RUNE_DEFENDER, TZHAARKETOM, RAKE, WATERING_CAN8, SEED_DIBBER, WATERING_CAN7, WATERING_CAN6, WATERING_CAN5, WATERING_CAN4, WATERING_CAN3, WATERING_CAN2, WATERING_CAN1, COMPOST, SUPERCOMPOST, ULTRACOMPOST, KARAMBWAN_VESSEL, MAPLE_LOGS, WATERING_CAN, SECATEURS, BASKET, EMPTY_SACK, EMPTY_PLANT_POT, FILLED_PLANT_POT, PLANT_CURE, MARIGOLD_SEED, ROSEMARY_SEED, NASTURTIUM_SEED, WOAD_SEED, LIMPWURT_SEED, REDBERRY_SEED, CADAVABERRY_SEED, DWELLBERRY_SEED, JANGERBERRY_SEED, WHITEBERRY_SEED, POISON_IVY_SEED, CACTUS_SEED, BELLADONNA_SEED, MUSHROOM_SPORE, APPLE_TREE_SEED, BANANA_TREE_SEED, ORANGE_TREE_SEED, CURRY_TREE_SEED, PINEAPPLE_SEED, PAPAYA_TREE_SEED, PALM_TREE_SEED, CALQUAT_TREE_SEED, BARLEY_SEED, JUTE_SEED, HAMMERSTONE_SEED, ASGARNIAN_SEED, YANILLIAN_SEED, KRANDORIAN_SEED, WILDBLOOD_SEED, ACORN, WILLOW_SEED, POTATO_SEED, ONION_SEED, SWEETCORN_SEED, WATERMELON_SEED, TOMATO_SEED, STRAWBERRY_SEED, CABBAGE_SEED, BIRD_SNARE, BOX_TRAP, BUTTERFLY_NET, BUTTERFLY_JAR, MAGIC_BUTTERFLY_NET, IMPLING_JAR, STEEL_NAILS, MITHRIL_NAILS, ADAMANTITE_NAILS, RUNE_NAILS, BOW_STRING, BARB_BOLTTIPS, MITHRIL_BAR, PURE_ESSENCE, CHOCOLATE_DUST, POTATO_CACTUS, CRUSHED_NEST,
        RANARR_SEED,
        TOADFLAX_SEED,
        IRIT_SEED,
        AVANTOE_SEED,
        KWUARM_SEED,
        SNAPDRAGON_SEED,
        CADANTINE_SEED,
        LANTADYME_SEED,
        TORSTOL_SEED,
        MAGIC_LOGS,
        YEW_LOGS,
        ADAMANTITE_ORE,
        ADAMANTITE_BAR,
        RUNITE_ORE,
        RUNITE_BAR,
        MORT_MYRE_FUNGUS,
        JUG_OF_WATER,
        GRAPES,
        GNOME_SCARF,
        SARADOMIN_HALO,
        ZAMORAK_HALO,
        GUTHIX_HALO,
        A_POWDERED_WIG,
        FLARED_TROUSERS,
        PANTALOONS,
        SLEEPING_CAP,
        BRIEFCASE,
        SAGACIOUS_SPECTACLES,
        PINK_ELEGANT_BLOUSE,
        PINK_ELEGANT_SKIRT,
        GOLD_ELEGANT_BLOUSE,
        GOLD_ELEGANT_SKIRT,
        GOLD_ELEGANT_SHIRT,
        GOLD_ELEGANT_LEGS,
        MUSKETEER_HAT,
        MONOCLE,
        BIG_PIRATE_HAT,
        KATANA,
        LEPRECHAUN_HAT,
        CAT_MASK,
        BRONZE_DRAGON_MASK,
        IRON_DRAGON_MASK,
        STEEL_DRAGON_MASK,
        MITHRIL_DRAGON_MASK,
        LAVA_DRAGON_MASK,
        DESERT_BOOTS,
        BOOK_OF_LAW,
        BLACK_CAPE,
        SHORTS,
        SHORTS_5044,
        SHORTS_5046,
        SHIRT,
        SHIRT_5032,
        SHIRT_5034,
        COLLECTION_LOG,
        GARDENING_TROWEL,
        SUPERCOMPOST + 1,
        DWARF_WEED_SEED,
        BOWL,
        BOWL_OF_WATER,
        BUCKET_OF_MILK,
        BUCKET_OF_WATER,
        POT,
        POT_OF_FLOUR,
        JUG,
        BALL_OF_WOOL,
        ROPE,
        GLASSBLOWING_PIPE,
        FLAX,
        BIRD_SNARE_PACK,
        BOX_TRAP_PACK,
        MAGIC_SECATEURS,
        EMPTY_VIAL_PACK,
        EMPTY_VIAL,
        WATERFILLED_VIAL_PACK,
        WATERFILLED_VIAL,
        SANFEW_SERUM1,
        SANFEW_SERUM2,
        SANFEW_SERUM3,
        SANFEW_SERUM4
    };

    /**
     * Holds the array of all the side-bar identification and their
     * corresponding itemcontainer identification.
     */
    public static final int[][] SIDEBAR_INTERFACE =
    {
        {GameConstants.ATTACK_TAB, 2423}, {GameConstants.SKILL_TAB, 10000}, {GameConstants.QUEST_TAB, 12650}, {GameConstants.INVENTORY_TAB, 3213}, {GameConstants.EQUIPMENT_TAB, 1644}, {GameConstants.PRAYER_TAB, 5608}, {GameConstants.MAGIC_TAB, 938}, //Row 1

        {GameConstants.CLAN_TAB, InterfaceConstants.CLAN_CHAT}, {GameConstants.FRIENDS_TAB, 5065}, {GameConstants.IGNORE_TAB, 5715}, {GameConstants.LOGOUT_TAB, 2449}, {GameConstants.WRENCH_TAB, 42500}, {GameConstants.EMOTE_TAB, 147}, {GameConstants.MUSIC_TAB, 72000} //Row 2
    };
    
    /**
     * All the tab identifications
     */
    public static final int ATTACK_TAB = 0, SKILL_TAB = 1, QUEST_TAB = 2, INVENTORY_TAB = 3, EQUIPMENT_TAB = 4,
            PRAYER_TAB = 5, MAGIC_TAB = 6, CLAN_TAB = 7, FRIENDS_TAB = 8, IGNORE_TAB = 9, LOGOUT_TAB = 10,
            WRENCH_TAB = 11, EMOTE_TAB = 12, MUSIC_TAB = 13;

    public static final int PLAYERS_LIMIT = 2047; //This must be capped to 2047 because 11 bits - 1
    public static final int NPCS_LIMIT = 16383; //This must be capped to 16384 because 14 bits - 1

    /**
     * Strings that are classified as bad
     */
    public static final String[] BAD_STRINGS = { };

    public final static int[] TAB_AMOUNT = {48, 58, 0, 0, 0, 0, 0, 0, 0, 0};
    public final static Item[] BANK_ITEMS = {
        new Item(4587, 20000), // Scim
        new Item(1215, 20000), // Dagger
        new Item(4089, 20000), // Mystic
        new Item(4109, 20000), // Mystic
        new Item(4099, 20000), // Mystic
        new Item(7400, 20000), // Enchanted
        new Item(3755, 20000), // farseer helm
        new Item(1163, 20000), // rune full helm
        new Item(1305, 20000), // d long
        new Item(4675, 20000), // ancient staff
        new Item(4091, 20000), // Mystic
        new Item(4111, 20000), // Mystic
        new Item(4101, 20000), // Mystic
        new Item(7399, 20000), // enchanted
        new Item(3751, 20000), // hat
        new Item(1127, 20000), // rune
        new Item(1434, 20000), // mace
        new Item(9185, 20000), // crossbow
        new Item(4093, 20000), // Mystic
        new Item(4113, 20000), // Mystic
        new Item(4103, 20000), // Mystic
        new Item(7398, 20000), // enchanted
        new Item(3753, 20000), // helm
        new Item(1079, 20000), // rune
        new Item(5698, 20000), // dagger
        new Item(10499, 20000), // avas
        new Item(4097, 20000), // Mystic
        new Item(4117, 20000), // Mystic
        new Item(4107, 20000), // Mystic
        new Item(2579, 20000), // wiz boots
        new Item(3749, 20000), // helm
        new Item(4131, 20000), // rune boots
        new Item(2503, 20000), // hides
        new Item(2497, 20000), // hides
        new Item(12492, 20000), // hides
        new Item(12508, 20000), // hides
        new Item(12500, 20000), // hides
        new Item(3105, 20000), // climbers
        new Item(1093, 20000), // rune
        new Item(1201, 20000), // rune
        new Item(3842, 20000), // god book
        new Item(12612, 20000), // god book
        new Item(12494, 20000), // hides
        new Item(12510, 20000), // hides
        new Item(12502, 20000), // hides
        new Item(6108, 20000), // ghostly
        new Item(6107, 20000), // ghostly
        new Item(6109, 20000), // ghostly

        // END OF TAB 1
        new Item(2436, 20000), // pots
        new Item(2440, 20000), // pots
        new Item(2442, 20000), // pots
        new Item(2444, 20000), // pots
        new Item(3040, 20000), // pots
        new Item(10925, 20000), // pots
        new Item(3024, 20000), // pots
        new Item(6685, 20000), // pots
        new Item(145, 20000), // pots
        new Item(157, 20000), // pots
        new Item(163, 20000), // pots
        new Item(169, 20000), // pots
        new Item(3042, 20000), // pots
        new Item(10927, 20000), // pots
        new Item(3026, 20000), // pots
        new Item(6689, 20000), // pots
        new Item(147, 20000), // pots
        new Item(159, 20000), // pots
        new Item(165, 20000), // pots
        new Item(171, 20000), // pots
        new Item(3044, 20000), // pots
        new Item(10929, 20000), // pots
        new Item(3028, 20000), // pots
        new Item(6687, 20000), // pots
        new Item(149, 20000), // pots
        new Item(161, 20000), // pots
        new Item(167, 20000), // pots
        new Item(173, 20000), // pots
        new Item(3046, 20000), // pots
        new Item(10931, 20000), // pots
        new Item(3030, 20000), // pots
        new Item(6691, 20000), // pots
        new Item(385, 20000), // sharks
        new Item(3144, 20000), // karambwan
        new Item(560, 20000000), // runes
        new Item(565, 20000000), // runes
        new Item(555, 20000000), // runes
        new Item(562, 20000000), // runes
        new Item(557, 20000000), // runes
        new Item(559, 20000000), // runes
        new Item(564, 20000000), // runes
        new Item(554, 20000000), // runes
        new Item(9075, 20000000), // runes
        new Item(556, 20000000), // runes
        new Item(563, 20000000), // runes
        new Item(559, 20000000), // runes
        new Item(566, 20000000), // runes
        new Item(561, 20000000), // runes
        new Item(9241, 20000), // bolts
        new Item(9244, 20000), // bolts
        new Item(9245, 20000), // bolts
        new Item(9243, 20000), // bolts
        new Item(9242, 20000), // bolts
        new Item(892, 20000), // rune arrows
        new Item(10828, 20000), // neit helm
        new Item(2412, 20000), // sara god cape
        new Item(7458, 20000), // mithril gloves for pures
        new Item(7462, 20000), // gloves
        new Item(11978, 20000), // glory (6)
    };
}
