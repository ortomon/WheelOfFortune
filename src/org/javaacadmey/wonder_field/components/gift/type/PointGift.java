package org.javaacadmey.wonder_field.components.gift.type;

import org.javaacadmey.wonder_field.components.gift.Gift;

public class PointGift extends Gift {
    private int cost;

    public PointGift(String name, int cost) {
        super(name);
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
