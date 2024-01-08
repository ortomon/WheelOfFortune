package org.javaacadmey.wonder_field.components.player;

import org.javaacadmey.wonder_field.logic.Game;
import org.javaacadmey.wonder_field.components.SymbolChecker;
import org.javaacadmey.wonder_field.components.gift.type.Gift;
import org.javaacadmey.wonder_field.components.Drum;
import org.javaacadmey.wonder_field.components.player.answer.PlayerAnswer;
import org.javaacadmey.wonder_field.components.player.answer.TypeAnswer;

import java.util.Random;

public class Player {
    private static final int MAX_GIFTS = 15;
    private static final int MIN_POINTS = 0;

    private String name;
    private String city;
    private PlayerAnswer playerAnswer;
    private int points;
    private Gift[] gifts;

    public Player() {
        this("", "");
    }

    public Player(String name, String city) {
        this.name = name;
        this.city = city;
        this.playerAnswer = new PlayerAnswer("");
        this.points = MIN_POINTS;
        this.gifts = new Gift[MAX_GIFTS];
    }

    public void takeGift(Gift gift) {
        for (int i = 0; i < MAX_GIFTS; i++) {
            if (gifts[i] == null) {
                gifts[i] = gift;
                return;
            }
        }
        System.out.println("Упс! Не хватает рук унести все подарки!");
    }

    public void printGifts() {
        for (Gift gift : gifts) {
            if (gift != null) {
                System.out.print(gift + ", ");
            }
        }
        System.out.println();
    }

    public void move(TypeAnswer answerType) {
        if (answerType == TypeAnswer.LETTER) {
            setPlayerAnswer(TypeAnswer.LETTER, String.valueOf(sayLetter()));
        } else {
            setPlayerAnswer(TypeAnswer.WORD, sayWord());
        }
    }

    private void setPlayerAnswer(TypeAnswer typeAnswer, String text) {
        playerAnswer.setTypeAnswer(typeAnswer);
        playerAnswer.setText(text);
    }

    public String spinDrum(Drum drum) {
        Random random = new Random();
        int randomIndex = random.nextInt(Drum.NUMBER_SECTORS_FOR_GAME);
        return drum.getSectors()[randomIndex];
    }

    public int chooseBoxWithMoney() {
        int choose = Game.scanner.nextInt();
        Game.scanner.nextLine();
        return choose;
    }

    private char sayLetter() {
        while (true) {
            String letter = Game.scanner.nextLine().trim().toUpperCase();

            if (letter.length() == 1) {
                if (SymbolChecker.symbolIsCyrillic(letter.charAt(0))) {
                    System.out.printf("Игрок %s: буква %s\n", name, letter);
                    return letter.charAt(0);
                }
            } else {
                System.out.println("Введите только одну букву.");
            }
        }
    }

    private String sayWord() {
        while (true) {
            String word = Game.scanner.nextLine().trim().toUpperCase();

            if (!word.isEmpty()) {
                System.out.printf("Игрок %s: слово %s\n", name, word);
                return word;
            } else {
                System.out.println("Вы не ввели слово, попробуйте еще раз.");
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public PlayerAnswer getPlayerAnswer() {
        return playerAnswer;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        if ((this.points + points) >= MIN_POINTS) {
            this.points += points;
        }
    }

    public Gift[] getGifts() {
        return gifts;
    }
}
