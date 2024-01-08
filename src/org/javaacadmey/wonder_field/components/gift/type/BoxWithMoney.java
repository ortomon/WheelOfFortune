package org.javaacadmey.wonder_field.components.gift.type;

import java.util.Random;

public class BoxWithMoney extends Gift {
    public static int NUMBER_BOXES_FOR_GAME = 2;
    private int money;

    public BoxWithMoney(int money) {
        super("шкатулка с деньгами");
        this.money = money;
    }

    public static BoxWithMoney[] initForGame() {
        Random random = new Random();
        BoxWithMoney[] boxWithMoney = new BoxWithMoney[NUMBER_BOXES_FOR_GAME];

        int randomIndex = random.nextInt(0, NUMBER_BOXES_FOR_GAME);
        int step = 1000;
        int minValue = 1000;
        int randomValueGreaterZero = minValue + step * random.nextInt(0, 100);

        boxWithMoney[randomIndex] = new BoxWithMoney(0);
        boxWithMoney[NUMBER_BOXES_FOR_GAME - 1 - randomIndex] = new BoxWithMoney(randomValueGreaterZero);
        return boxWithMoney;
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
