package org.javaacadmey.wonder_field.components.gift;

import org.javaacadmey.wonder_field.components.gift.type.Gift;

import java.util.Random;

public enum SuperGifts {
    CARTIER_WATCH(new Gift("часы картье")),
    VINTAGE_WINE(new Gift("Винтажное вино")),
    DIAMOND_RING(new Gift("Бриллиантовое кольцо")),
    EXOTIC_VACATION(new Gift("Экзотический отпуск")),
    SPORTS_CAR(new Gift("Спортивный автомобиль")),
    LUXURY_CRUISE(new Gift("Роскошный круиз")),
    PRIVATE_ISLAND(new Gift("Частный остров")),
    CHILD(new Gift("ребенок"));

    private final Gift gift;

    SuperGifts(Gift gift) {
        this.gift = gift;
    }

    public static SuperGifts getRandomSuperGift() {
        SuperGifts[] superGifts = SuperGifts.values();
        Random random = new Random();
        int randomIndex = random.nextInt(superGifts.length);
        return superGifts[randomIndex];
    }

    public Gift getGift() {
        return gift;
    }
}
