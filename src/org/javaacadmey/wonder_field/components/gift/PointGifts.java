package org.javaacadmey.wonder_field.components.gift;

import org.javaacadmey.wonder_field.components.gift.type.PointGift;

public enum PointGifts {
    LASER_POINTER(new PointGift("лазер", 111)),
    POWER_BANK(new PointGift("зарядка", 222)),
    HEADPHONES(new PointGift("наушники", 333)),
    GRILL(new PointGift("гриль", 444)),
    SMART_WATCH(new PointGift("часы", 555)),
    GLASSES(new PointGift("очки", 666)),
    QUADCOPTER(new PointGift("квадракоптер", 777)),
    ROBOT(new PointGift("робот", 888)),
    HOVERBOARD(new PointGift("гироскутер", 999)),
    SPEAKER(new PointGift("колонка", 1000)),
    FITNESS(new PointGift("фитнес", 2000)),
    PRINTER(new PointGift("принтер", 3000));

    private final PointGift pointGift;

    PointGifts(PointGift pointGift) {
        this.pointGift = pointGift;
    }

    public static PointGifts getByGiftName(String giftName) {
        for (PointGifts pointGift : PointGifts.values()) {
            if (pointGift.getPointGift().getName().equalsIgnoreCase(giftName)) {
                return pointGift;
            }
        }
        return null;
    }

    public static int cheapestPointGift() {
        return LASER_POINTER.pointGift.getCost();
    }

    public PointGift getPointGift() {
        return pointGift;
    }
}
