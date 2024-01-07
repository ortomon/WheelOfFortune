package org.javaacadmey.wonder_field.components.player;

import org.javaacadmey.wonder_field.Game;
import org.javaacadmey.wonder_field.Gift;
import org.javaacadmey.wonder_field.components.Drum;
import org.javaacadmey.wonder_field.components.player.answer.PlayerAnswer;
import org.javaacadmey.wonder_field.components.player.answer.TypeAnswer;

import java.util.Random;

public class Player{
    private static final int MAX_GIFTS = 100;

    private String name;
    private String city;
    private PlayerAnswer playerAnswer;
    private int points;
    private int giftMoney;
    private Gift[] gifts;

    public Player() {
        this.playerAnswer = new PlayerAnswer("");
    }

    public Player(String name, String city) {
        this.name = name;
        this.city = city;
        this.playerAnswer = new PlayerAnswer("");
        this.points = 0;
        this.giftMoney = 0;
        this.gifts = new Gift[MAX_GIFTS];
    }

    public String chooseGift() {
        return Game.scanner.nextLine().toLowerCase();
    }

    public void takeGift(Gift gift) {
        for (int i = 0; i < MAX_GIFTS; i++) {
            if (gifts[i] == null) {
                gifts[i] = gift;
                return;
            } else {
                System.out.println("Упс! Не хватает рук унести все подарки!");
            }
        }
    }

    public void move() {
        System.out.printf("Ход игрока %s, город %s\n", name, city);

        while (true) {
            System.out.println("Если хотите букву нажмите 'б' и enter, если хотите слово нажмите 'c' и enter");
            String command = Game.scanner.nextLine().toLowerCase();

            if (symbolIsCyrillic(command.charAt(0))) {
                switch (command) {
                    case "б":
                        setPlayerAnswer(TypeAnswer.LETTER, String.valueOf(sayLetter()));
                        return;
                    case "с":
                        setPlayerAnswer(TypeAnswer.WORD, sayWord());
                        return;
                    default:
                        System.out.println("Некорректное значение, введите 'б' или 'с'.");
                }
            }
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
                if (symbolIsCyrillic(letter.charAt(0))) {
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

    public boolean symbolIsCyrillic(char letter) {
        return SymbolChecker.symbolIsCyrillic(letter);
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
        this.points += points;
    }

    public int getGiftMoney() {
        return giftMoney;
    }

    public void setGiftMoney(int giftMoney) {
        this.giftMoney = giftMoney;
    }
}
