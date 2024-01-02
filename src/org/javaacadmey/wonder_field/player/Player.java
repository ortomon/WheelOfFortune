package org.javaacadmey.wonder_field.player;

import org.javaacadmey.wonder_field.Game;

public class Player {
    private String name;
    private String city;

    public Player(String name, String city) {
        this.name = name;
        this.city = city;
    }

    // игрок кричит букву
    public char sayLetter() throws Exception {
        char letter;
        do {
            String input = Game.scanner.next().toLowerCase();
            if (input.length() == 1 && Character.isLetter(input.charAt(0)) && Character.UnicodeBlock.CYRILLIC.equals(Character.UnicodeBlock.of(input.charAt(0)))) {
                letter = Character.toUpperCase(input.charAt(0));
                System.out.println("Игрок " + name + ": буква " + letter);
                return letter;
            }
            System.out.println("Ошибка! Введите русскую букву.");
        } while (true);
    }

    // игрок кричит слово
    public String sayWord() {
        String word = Game.scanner.nextLine();
        System.out.println("Игрок " + name + ": слово " + word);
        return word;
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
}
