package com.ruse;

import com.ruse.model.Item;

public enum ReducedSellPrice {

    Cannonball(2, 1000), DragonstoneBoltTips(9193, 675), GroundMudRune(9594, 300), UnicornHornDust(235, 550);

    private final int sellValue;
    private final int unNotedId;
    private ReducedSellPrice(int unNotedId, int sellValue) {
        this.unNotedId = unNotedId;
        this.sellValue = sellValue;
    }

    public static ReducedSellPrice forId(int id) {
        for (ReducedSellPrice rsp : ReducedSellPrice.values()) {
            if (rsp.getUnNotedId() == id) {
                return rsp;
            }
            if (rsp.getNotedId() == id) {
                return rsp;
            }
        }
        return null;
    }

    public int getNotedId() {
        return Item.getNoted(unNotedId);
    }

    public int getSellValue() {
        return sellValue;
    }

    public int getUnNotedId() {
        return unNotedId;
    }

}
