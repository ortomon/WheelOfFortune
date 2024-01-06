package org.javaacadmey.wonder_field.components;

import java.util.Arrays;
import java.util.Random;

public class Drum {
    public static final String SECTOR_DOUBLING = "Сектор удвоение!";
    public static final String SECTOR_SKIPPING_MOVE = "Сектор пропуск хода!";
    private final String[] points = new String[14];

    public Drum() {
        initPoint();
    }

    public String spin() {
        Random random = new Random();
        int randomIndex = random.nextInt(points.length);
        return points[randomIndex];
    }

    private void initPoint() {
        int step = 100;

        for (int i = 0; i < (points.length - 2); i++) {
            points[i] = String.valueOf(step * i);
        }

        points[points.length - 1] = SECTOR_DOUBLING;
        points[points.length - 2] = SECTOR_SKIPPING_MOVE;
    }
}
