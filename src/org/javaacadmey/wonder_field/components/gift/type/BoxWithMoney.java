package org.javaacadmey.wonder_field.components.gift.type;

import org.javaacadmey.wonder_field.components.gift.Gift;

public class BoxWithMoney extends Gift {
    private int money;

    public BoxWithMoney(int money) {
        super("шкатулка с деньгами");
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "BoxWithMoney{" +
                "money=" + money +
                '}';
    }
}
