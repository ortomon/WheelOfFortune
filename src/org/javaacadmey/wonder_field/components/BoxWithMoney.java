package org.javaacadmey.wonder_field.components;

public class BoxWithMoney {
    private int money;

    public BoxWithMoney(int money) {
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
