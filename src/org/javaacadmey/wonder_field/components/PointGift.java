package org.javaacadmey.wonder_field.components;

import org.javaacadmey.wonder_field.Gift;

public enum PointGift {
    LASER_POINTER(new Gift("лазер", 100)),
    POWER_BANK(new Gift("зарядка", 200)),
    HEADPHONES(new Gift("наушники", 300)),
    GRILL(new Gift("гриль", 400)),
    SMART_WATCH(new Gift("часы", 500)),
    GLASSES(new Gift("очки", 600)),
    QUADCOPTER(new Gift("квадракоптер", 700)),
    ROBOT(new Gift("робот", 800)),
    HOVERBOARD(new Gift("гироскутер", 900)),
    SPEAKER(new Gift("колонка", 1000)),
    FITNESS(new Gift("фитнес", 1100)),
    PRINTER(new Gift("принтер", 1200));

    private final Gift gift;

    PointGift(Gift gift) {
        this.gift = gift;
    }

    public static PointGift getByGiftName(String giftName) {
        for (PointGift pointGift : PointGift.values()) {
            if (pointGift.getGift().getName().equalsIgnoreCase(giftName)) {
                return pointGift;
            }
        }
        return null;
    }

    public Gift getGift() {
        return gift;
    }
}
