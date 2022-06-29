package com.ferox.game.content.raids.chamber_of_secrets;

import com.ferox.game.content.daily_tasks.DailyTaskManager;
import com.ferox.game.content.daily_tasks.DailyTasks;
import com.ferox.game.content.mechanics.Poison;
import com.ferox.game.content.raids.party.Party;
import com.ferox.game.world.World;
import com.ferox.game.world.entity.AttributeKey;
import com.ferox.game.world.entity.combat.Venom;
import com.ferox.game.world.entity.mob.npc.Npc;
import com.ferox.game.world.entity.mob.player.Player;
import com.ferox.game.world.entity.mob.player.Skills;
import com.ferox.game.world.position.Area;
import com.ferox.game.world.position.Tile;
import com.ferox.util.Color;

import java.time.Duration;
import java.time.Instant;

import static com.ferox.game.world.entity.AttributeKey.PERSONAL_POINTS;

/**
 * @author Patrick van Elderen | April, 26, 2021, 16:58
 * @see <a href="https://github.com/PVE95">Github profile</a>
 */
public class ChamberOfSecrets {

    private static final Area OLM_ROOM = new Area(3228, 5730, 3237, 5748);
    private static final Area OLM = new Area(3217, 5711, 3260, 5760);

    public static final int REWARD_WIDGET = 12020;
    public final static int MALE_CENTAUR = 15030;
    public final static int FEMALE_CENTAUR = 15032;
    public final static int DEMENTOR = 15028;
    public final static int ARAGOG = 15020;
    public final static int FLUFFY = 15026;
    public final static int HUNGARIAN_HORNTAIL = 15034;
    public final static int FENRIR_GREYBACK = 15050;

    private final Player player;

    public ChamberOfSecrets(Player player) {
        this.player = player;
    }

    private Instant startTime = Instant.now();
    private final double combatPointsFactor = 1;

    public boolean handleDeath(Player player) {
        Party party = player.raidsParty;
        if (party == null) return false;
        player.teleport(getRespawnPosition(party, player.tile().level));
        int pointsLost = (int) (player.<Integer>getAttribOr(PERSONAL_POINTS, 0) * 0.4);
        if (pointsLost > 0)
            addPoints(-pointsLost);

        //Make sure to heal
        player.healPlayer();
        return true;
    }


    private Tile getRespawnPosition(Party party, int level) {
        return switch (party.getRaidStage()) {
            case 1 -> new Tile(3307, 5204, level);
            case 2 -> new Tile(3311, 5275, level);
            case 3 -> new Tile(3311, 5307, level);
            case 4 -> new Tile(3311, 5340, level - 1);
            case 5 -> new Tile(3308, 5336, level);
            case 6 -> new Tile(3308, 5336, level + 1);
            case 7 -> new Tile(3232, 5721, level);
            default -> new Tile(3299, 5189, level);
        };
    }

    public void exit() {
        Party party = player.raidsParty;

        //Remove players from the party if they are not the leader
        if(party != null) {
            party.removeMember(player);
            //Last player in the party leaves clear the whole thing
            if(party.getMembers().size() == 0) {
                //Clear all party members that are left
                party.getMembers().clear();
                clearParty();
            }
            player.raidsParty = null;
        }

        //Reset points
        player.putAttrib(PERSONAL_POINTS,0);
        player.message("<col=" + Color.BLUE.getColorValue() + ">You have restored your hitpoints, run energy and prayer.");
        player.message("<col=" + Color.HOTPINK.getColorValue() + ">You've also been cured of poison and venom.");
        player.skills().resetStats();
        int increase = player.getEquipment().hpIncrease();
        player.hp(Math.max(increase > 0 ? player.skills().level(Skills.HITPOINTS) + increase : player.skills().level(Skills.HITPOINTS), player.skills().xpLevel(Skills.HITPOINTS)), 39); //Set hitpoints to 100%
        player.skills().replenishSkill(5, player.skills().xpLevel(5)); //Set the players prayer level to fullplayer.putAttrib(AttributeKey.RUN_ENERGY, 100.0);
        player.setRunningEnergy(100.0, true);
        Poison.cure(player);
        Venom.cure(2, player);

        //Move outside of raids
        player.teleport(1245, 3561, 0);
        player.getInterfaceManager().close();
    }

    public boolean isRaiding() {
        return player.raidsParty != null && player.raidsParty.getHPRaid() != null;
    }

    public void addPoints(int points) {
        if (!isRaiding())
            return;
        player.raidsParty.addPersonalPoints(player, points);
    }

    public void addDamagePoints(Npc target, int points) {
        if (!isRaiding())
            return;
        if (target.getAttribOr(AttributeKey.RAIDS_NO_POINTS, false))
            return;
        points *= 5;
        points *= player.raidsParty.getHPRaid().combatPointsFactor;
        addPoints(points);
    }

    private String getTimeSinceStart() {
        Duration d = Duration.between(startTime, Instant.now());
        return String.format("%02d:%02d", d.toMinutes(), d.getSeconds() % 60);
    }

    public void completeRaid(Party party) {
        String time = getTimeSinceStart();
        party.forPlayers(p -> {
            p.message(Color.RAID_PURPLE.wrap("Congratulations - your raid is complete! Duration: " + Color.RED.wrap(time) + "."));
            var completed = p.<Integer>getAttribOr(AttributeKey.CHAMBER_OF_SECRET_RUNS_COMPLETED, 0) + 1;
            p.putAttrib(AttributeKey.CHAMBER_OF_SECRET_RUNS_COMPLETED, completed);
            p.message(String.format("Total points: " + Color.RAID_PURPLE.wrap("%,d") + ", Personal points: " + Color.RAID_PURPLE.wrap("%,d") + " (" + Color.RAID_PURPLE.wrap("%.2f") + "%%)",
                party.totalPoints(), p.<Integer>getAttribOr(PERSONAL_POINTS, 0), (double) (p.<Integer>getAttribOr(PERSONAL_POINTS, 0) / party.totalPoints()) * 100));

            //Daily raids task
            DailyTaskManager.increase(DailyTasks.DAILY_RAIDS, p);

            //Roll a reward for each individual player
            ChamberOfSecretsReward.giveRewards(p);
        });
        World.getWorld().unregisterAll(OLM);
        World.getWorld().unregisterAll(OLM_ROOM);
    }

    public void startHPRaid() {
        Party party = player.raidsParty;
        if (party == null) return;
        party.setRaidStage(1);
        startTime = Instant.now();
        final int height = party.getLeader().getIndex() * 4;

        for (Player member : party.getMembers()) {
            member.teleport(new Tile(3299, 5189, height));
            party.setHeight(height);
        }

        //Clear kills
        party.setKills(0);

        //Clear npcs that somehow survived first:
        clearParty();

        //Spawn all creatures
        spawnCentaurs();
        spawnDementors();
        spawnFluffy();
        spawnAragog();
        spawnHungarianHorntail();
        spawnFenrirGreyback();
    }
    
    private void spawnCentaurs() {
        //Get the raids party
        Party party = player.raidsParty;

        //Create centaurs
        Npc centaurMale = new ChamberOfSecretsNpc(MALE_CENTAUR, new Tile(3311, 5260, party.getHeight()), party.getSize());
        Npc centaurMale2 = new ChamberOfSecretsNpc(MALE_CENTAUR, new Tile(3304, 5268, party.getHeight()), party.getSize());
        Npc centaurMale3 = new ChamberOfSecretsNpc(MALE_CENTAUR, new Tile(3306, 5260, party.getHeight()), party.getSize());
        Npc centaurMale4 = new ChamberOfSecretsNpc(MALE_CENTAUR, new Tile(3319, 5256, party.getHeight()), party.getSize());
        Npc centaurMale5 = new ChamberOfSecretsNpc(MALE_CENTAUR, new Tile(3319, 5269, party.getHeight()), party.getSize());
        Npc centaurFemale = new ChamberOfSecretsNpc(FEMALE_CENTAUR, new Tile(3314, 5269, party.getHeight()), party.getSize());
        Npc centaurFemale2 = new ChamberOfSecretsNpc(FEMALE_CENTAUR, new Tile(3315, 5263, party.getHeight()), party.getSize());
        Npc centaurFemale3 = new ChamberOfSecretsNpc(FEMALE_CENTAUR, new Tile(3307, 5263, party.getHeight()), party.getSize());
        Npc centaurFemale4 = new ChamberOfSecretsNpc(FEMALE_CENTAUR, new Tile(3314, 5266, party.getHeight()), party.getSize());
        Npc centaurFemale5 = new ChamberOfSecretsNpc(FEMALE_CENTAUR, new Tile(3305, 5257, party.getHeight()), party.getSize());

        //Spawn centaurs
        World.getWorld().registerNpc(centaurMale);
        party.monsters.add(centaurMale);
        World.getWorld().registerNpc(centaurMale2);
        party.monsters.add(centaurMale2);
        World.getWorld().registerNpc(centaurMale3);
        party.monsters.add(centaurMale3);
        World.getWorld().registerNpc(centaurMale4);
        party.monsters.add(centaurMale4);
        World.getWorld().registerNpc(centaurMale5);
        party.monsters.add(centaurMale5);
        World.getWorld().registerNpc(centaurFemale);
        party.monsters.add(centaurFemale);
        World.getWorld().registerNpc(centaurFemale2);
        party.monsters.add(centaurFemale2);
        World.getWorld().registerNpc(centaurFemale3);
        party.monsters.add(centaurFemale3);
        World.getWorld().registerNpc(centaurFemale4);
        party.monsters.add(centaurFemale4);
        World.getWorld().registerNpc(centaurFemale5);
        party.monsters.add(centaurFemale5);
    }

    private void spawnDementors() {
        //Get the raids party
        Party party = player.raidsParty;

        //Create dementors
        Npc dementor = new ChamberOfSecretsNpc(DEMENTOR, new Tile(3321, 5300, party.getHeight()), party.getSize());
        Npc dementor2 = new ChamberOfSecretsNpc(DEMENTOR, new Tile(3319, 5295, party.getHeight()), party.getSize());
        Npc dementor3 = new ChamberOfSecretsNpc(DEMENTOR, new Tile(3317, 5286, party.getHeight()), party.getSize());
        Npc dementor4 = new ChamberOfSecretsNpc(DEMENTOR, new Tile(3301, 5290, party.getHeight()), party.getSize());
        Npc dementor5 = new ChamberOfSecretsNpc(DEMENTOR, new Tile(3304, 5296, party.getHeight()), party.getSize());
        Npc dementor6 = new ChamberOfSecretsNpc(DEMENTOR, new Tile(3306, 5304, party.getHeight()), party.getSize());
        Npc dementor7 = new ChamberOfSecretsNpc(DEMENTOR, new Tile(3312, 5296, party.getHeight()), party.getSize());
        //Spawn dementors
        World.getWorld().registerNpc(dementor);
        party.monsters.add(dementor);
        World.getWorld().registerNpc(dementor2);
        party.monsters.add(dementor2);
        World.getWorld().registerNpc(dementor3);
        party.monsters.add(dementor3);
        World.getWorld().registerNpc(dementor4);
        party.monsters.add(dementor4);
        World.getWorld().registerNpc(dementor5);
        party.monsters.add(dementor5);
        World.getWorld().registerNpc(dementor6);
        party.monsters.add(dementor6);
        World.getWorld().registerNpc(dementor7);
        party.monsters.add(dementor7);
    }

    private void spawnFluffy() {
        //Get the raids party
        Party party = player.raidsParty;

        //Create fluffy
        Npc fluffy = new ChamberOfSecretsNpc(FLUFFY, new Tile(3309, 5328, party.getHeight()), party.getSize());
        //Spawn fluffy
        World.getWorld().registerNpc(fluffy);
        party.monsters.add(fluffy);
    }

    private void spawnAragog() {
        //Get the raids party
        Party party = player.raidsParty;

        //Create fluffy
        Npc aragog = new ChamberOfSecretsNpc(ARAGOG, new Tile(3309, 5325, party.getHeight() + 1), party.getSize());

        //Spawn fluffy
        World.getWorld().registerNpc(aragog);
        party.monsters.add(aragog);
    }

    private void spawnHungarianHorntail() {
        //Get the raids party
        Party party = player.raidsParty;

        //Create hungarian horntails
        Npc hungarianHorntail = new ChamberOfSecretsNpc(HUNGARIAN_HORNTAIL, new Tile(3309, 5332, party.getHeight() + 1), party.getSize());
        Npc hungarianHorntail2 = new ChamberOfSecretsNpc(HUNGARIAN_HORNTAIL, new Tile(3304, 5322, party.getHeight() + 1), party.getSize());
        //Spawn horntails
        World.getWorld().registerNpc(hungarianHorntail);
        party.monsters.add(hungarianHorntail);
        World.getWorld().registerNpc(hungarianHorntail2);
        party.monsters.add(hungarianHorntail2);
    }

    private void spawnFenrirGreyback() {
        //Get the raids party
        Party party = player.raidsParty;

        //Create fenrir greyback
        Npc fenrirGreyback = new ChamberOfSecretsNpc(FENRIR_GREYBACK, new Tile(3279, 5166, party.getHeight()), party.getSize());
        //Spawn fenrir greyback
        World.getWorld().registerNpc(fenrirGreyback);
        party.monsters.add(fenrirGreyback);
    }

    private void clearParty() {
        Party party = player.raidsParty;
        if(party == null) return;
        if(party.monsters == null) {
            return;
        }
        for(Npc npc : party.monsters) {
            //If npc is alive remove them
            if(npc.isRegistered() || !npc.dead()) {
                World.getWorld().unregisterNpc(npc);
            }
        }
        party.monsters.clear();
    }

}
