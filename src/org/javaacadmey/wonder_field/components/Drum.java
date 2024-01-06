package org.javaacadmey.wonder_field.components;

import java.util.Arrays;
import java.util.Random;

public class Drum {
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
        for (int i = 0; i < (points.length - 1); i++) {
            points[i] = String.valueOf(step * i);
        }
        points[points.length - 1] = "Сектор удвоение!";
    }

    @Override
    public String toString() {
        return "Drum{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
}
