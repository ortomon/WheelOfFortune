package org.javaacadmey.wonder_field.components;

public class Drum {
    public static final String SECTOR_DOUBLING = "Сектор удвоение!";
    public static final String SECTOR_SKIPPING_MOVE = "Сектор пропуск хода!";

    private final String[] sectors = new String[15];

    public Drum() {
        initPoint();
    }

    private void initPoint() {
        int step = 100;

        for (int i = 0; i < (sectors.length - 2); i++) {
            sectors[i] = String.valueOf(step * i);
        }

        sectors[sectors.length - 1] = SECTOR_DOUBLING;
        sectors[sectors.length - 2] = SECTOR_SKIPPING_MOVE;
    }

    public String[] getSectors() {
        return sectors;
    }
}
