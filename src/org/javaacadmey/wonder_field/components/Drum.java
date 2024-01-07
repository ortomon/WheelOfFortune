package org.javaacadmey.wonder_field.components;

public class Drum {
    public static final String SECTOR_DOUBLING = "Сектор удвоение!";
    public static final String SECTOR_SKIPPING_MOVE = "Сектор пропуск хода!";
    public static final int NUMBER_SECTORS_FOR_GAME = 15;

    private String[] sectors;

    public Drum() {
        this.sectors = new String[NUMBER_SECTORS_FOR_GAME];
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
