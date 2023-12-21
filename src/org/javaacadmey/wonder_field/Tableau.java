package org.javaacadmey.wonder_field;

import java.util.Arrays;

public class Tableau {
    private String correctAnswer;
    private String[] tableauLetters;
    private static final String SYMBOL_OF_UNSOLVED_LETTERS = " _ ";

    // инициализация табло
    public void init(String correctAnswer) {
        if (checkAttributes()) {
            this.correctAnswer = correctAnswer.toUpperCase();
            this.tableauLetters = new String[correctAnswer.length()];
            Arrays.fill(tableauLetters, SYMBOL_OF_UNSOLVED_LETTERS);
        }
    }

    // отображает в консоли все буквы (отгаданные и неотгаданных)
    public void printLetters() {
        System.out.println(Arrays.toString(tableauLetters));
    }

    // открывает букву(ы)
    public void openLetter(char letter) {
        if (checkAttributes()) {
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
        if (word.equals(correctAnswer)) {
            tableauLetters = word.toUpperCase().split("");
        }
    }

    // если есть неразгаданные буквы - вернет истину, иначе ложь.
    public boolean containsUnknownLetters() {
        for (int i = 0; i < tableauLetters.length; i++) {
            if (tableauLetters[i].equals(SYMBOL_OF_UNSOLVED_LETTERS)) {
                return true;
            }
        }
        return false;
    }

    // метод, проверяющий что атрибуты не пусты
    private boolean checkAttributes() {
        if (correctAnswer == null || tableauLetters == null) {
            System.out.println("Ошибка: Табло не инициализировано.");
            return false;
        }
        return true;
    }
}
