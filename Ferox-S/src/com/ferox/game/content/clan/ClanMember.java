package com.ferox.game.content.clan;

import com.ferox.game.world.entity.mob.player.Player;

import java.util.Objects;

/**
 * Represents the member of Clan chat.
 * @author PVE
 * @Since juli 07, 2020
 */
public class ClanMember {

    /**
     * The player of the member.
     */
    private final transient Player player;

    /**
     * The rank of the member.
     */
    private ClanRank rank;

    /**
     * Creates the member.
     * @param player
     * @param rank
     */
    public ClanMember(Player player, ClanRank rank) {
        this.player = player;
        this.rank = rank;
    }

    public String getName() {
        return player.getUsername().toLowerCase().trim();
    }

    public Player getPlayer() {
        return player;
    }

    public ClanRank getRank() {
        return rank;
    }

    public void setRank(ClanRank rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ClanMember) {
            ClanMember member = (ClanMember) obj;

            return member.hashCode() == hashCode();
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(player.getUsername(), rank);
    }

    @Override
    public String toString() {
        return String.format("name=%s, rank=%s", getName(), getRank());
    }

}
