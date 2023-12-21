package org.javaacadmey.wonder_field.player;

import org.javaacadmey.wonder_field.Game;

public class Player {
    private String name;
    private String city;

    public Player(String name, String city) {
        this.name = name;
        this.city = city;
    }

    // игрок ходит
    public PlayerAnswer move() throws Exception {
        System.out.println("Если хотите букву, нажмите 'б' и Enter, если хотите слово, нажмите 'с' и Enter");

        while (true) {
            String choice = Game.scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "б":
                    return new PlayerAnswer(false, sayLetter());
                case "с":
                    return new PlayerAnswer(true, sayWord());
                default:
                    System.out.println("Некорректное значение, введите 'б' или 'с'");
            }
        }
    }

    // игрок кричит букву
    private String sayLetter() throws Exception {
        String letter = Game.scanner.nextLine();
        while (true) {
            if (letter.length() == 1 && isRussianLetter(letter.charAt(0))) {
                System.out.printf("Игрок %s: буква %s", name, letter.toUpperCase());
                return letter.substring(0);
            } else {
                throw new Exception("Ошибка! это не русская буква, введите русскую букву");
            }
        }
    }

    // игрок кричит слово
    private String sayWord() {
        String word = Game.scanner.nextLine();
        System.out.printf("Игрок %s: слово %s", name, word);
        return word;
    }

    // проверка на русский алфавит
    private static boolean isRussianLetter(char letter) {
        return Character.UnicodeBlock.CYRILLIC.equals(Character.UnicodeBlock.of(letter));
    }
}
