package org.javaacadmey.wonder_field;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        Game game = new Game();
        game.initGame();
        System.out.println(Arrays.toString(game.getGameQuestions()));
    }
}