package org.javaacadmey.wonder_field;

import java.util.Arrays;

public class Tableau {
    private String correctAnswer;
    private String[] tableauLetters;
    private static final String SYMBOL_OF_UNSOLVED_LETTERS = " _ ";

    // инициализация табло
    public Tableau(String correctAnswer) {
        this.correctAnswer = correctAnswer.toUpperCase();
        init();
    }

    public void init() {
        if (attributesNotEmpty()) {
            tableauLetters = new String[correctAnswer.length()];
            Arrays.fill(tableauLetters, SYMBOL_OF_UNSOLVED_LETTERS);
        }
    }

    // отображает в консоли все буквы (отгаданные и неотгаданных)
    public void printLetters() {
        if (attributesNotEmpty()) {
            System.out.println(Arrays.toString(tableauLetters));
        }
    }

    // открывает букву(ы)
    public void openLetter(char letter) {
        if (attributesNotEmpty()) {
            letter = Character.toUpperCase(letter);

            for (int i = 0; i < correctAnswer.length(); i++) {
                if (correctAnswer.charAt(i) == letter) {
                    tableauLetters[i] = String.valueOf(letter);
                }
            }
        }
    }

    // открывает слово целиком.
    public void openWord(String word) {
        if (attributesNotEmpty()) {
            word = word.toUpperCase();

            if (correctAnswer.equals(word)) {
                tableauLetters = correctAnswer.split("");
            }
        }
    }

    // если есть неразгаданные буквы - вернет истину, иначе ложь.
    public boolean containsUnknownLetters() {
        if (attributesNotEmpty()) {
            for (String letter : tableauLetters) {
                if (SYMBOL_OF_UNSOLVED_LETTERS.equals(letter)) {
                    return true;
                }
            }
        }
        return false;
    }

    // метод, проверяющий что атрибуты не пусты
    public boolean attributesNotEmpty() {
        return correctAnswer != null && tableauLetters != null;
    }
}
