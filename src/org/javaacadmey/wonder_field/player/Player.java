package org.javaacadmey.wonder_field.player;

import org.javaacadmey.wonder_field.Game;
import org.javaacadmey.wonder_field.SymbolChecker;
import org.javaacadmey.wonder_field.TypeAnswer;
import org.javaacadmey.wonder_field.gamequestion.components.Answer;

public class Player implements SymbolChecker {
    private String name;
    private String city;
    private PlayerAnswer playerAnswer;

    public Player() {
        this.playerAnswer = new PlayerAnswer("");
    }

    public Player(String name, String city) {
        this.name = name;
        this.city = city;
        this.playerAnswer = new PlayerAnswer("");
    }

    public PlayerAnswer move() {
        System.out.printf("Ход игрока %s, город %s\n", name, city);
        while (true) {
            System.out.println("Если хотите букву нажмите 'б' и enter, если хотите слово нажмите 'c' и enter");
            String command = Game.scanner.nextLine().toLowerCase();

            switch (command) {
                case "б":
                    playerAnswer.setTypeAnswer(TypeAnswer.LETTER);
                    playerAnswer.setText(String.valueOf(sayLetter()));
                    return playerAnswer;
                case "с":
                    playerAnswer.setTypeAnswer(TypeAnswer.WORD);
                    playerAnswer.setText(sayWord());
                    return playerAnswer;
                default:
                    System.out.println("Некорректное значение, введите 'б' или 'с'.");
            }
        }
    }

    private char sayLetter() {
        while (true) {
            String letter = Game.scanner.nextLine().trim().toUpperCase();

            if (letter.length() == 1) {
                if (symbolIsCyrillic(letter.charAt(0))) {
                    System.out.printf("Игрок %s: буква %s\n", name, letter);
                    return letter.charAt(0);
                } else {
                    System.out.println("Введите русскую букву");
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

    @Override
    public boolean symbolIsCyrillic(char letter) {
        return SymbolChecker.super.symbolIsCyrillic(letter);
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
}
