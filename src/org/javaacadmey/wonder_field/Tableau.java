package org.javaacadmey.wonder_field;

import org.javaacadmey.wonder_field.gamequestion.components.Answer;

import java.util.Arrays;

public class Tableau {
    private static final char SYMBOL_OF_UNSOLVED_LETTERS = '_';
    private Answer correctAnswer;
    private char[] letters;

    public Tableau(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
        letters = new char[correctAnswer.getText().length()];
        Arrays.fill(letters, SYMBOL_OF_UNSOLVED_LETTERS);
    }

    // отображает в консоли все буквы (отгаданные и неотгаданных)
    public void printLetters() {
        if (attributesAreNotEmpty()) {
            System.out.print("\" ");

            for (char letter : letters) {
                System.out.print(letter + " ");
            }

            System.out.println("\"");
        } else {
            System.out.println("атрибуты Tableau пусты");
        }
    }

    // открывает букву(ы)
    public void openLetter(char letter) {
        if (attributesNotEmpty()) {
            letter = Character.toUpperCase(letter);

            // Проверяем, содержится ли буква в правильном ответе
            boolean found = false;

            for (int i = 0; i < correctAnswer.getText().length(); i++) {
                if (correctAnswer.getText().charAt(i) == letter) {
                    letters[i] = letter;
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Буквы '" + letter + "' нет в ответе.");
            }
        } else {
            System.out.println("атрибуты Tableau пусты");
        }
    }

    // открывает слово целиком.
    public void openWord(String word) {
        word = word.toUpperCase();
        if (correctAnswer.getText().equals(word)) {
            for (int i = 0; i < letters.length; i++) {
                letters[i] = correctAnswer.getText().charAt(i);
            }
        } else {
            System.out.println("Неверное слово.");
        }
    }

    private boolean attributesAreNotEmpty() {
        if (correctAnswer != null && letters != null) {
            return true;
        }
        return false;
    }


























    // инициализация табло
    public Tableau(String correctAnswer) {
        this.correctAnswer = correctAnswer.toUpperCase();
        init();
    }

    public void init() {
        if (attributesNotEmpty()) {
            letters = new String[correctAnswer.length()];
            Arrays.fill(letters, SYMBOL_OF_UNSOLVED_LETTERS);
        }
    }

//    // отображает в консоли все буквы (отгаданные и неотгаданных)
//    public void printLetters() {
//        if (attributesNotEmpty()) {
//            System.out.println(Arrays.toString(letters));
//        }
//    }

//    // открывает букву(ы)
//    public void openLetter(char letter) {
//        if (attributesNotEmpty()) {
//            letter = Character.toUpperCase(letter);
//
//            for (int i = 0; i < correctAnswer.length(); i++) {
//                if (correctAnswer.charAt(i) == letter) {
//                    letters[i] = String.valueOf(letter);
//                }
//            }
//        }
//    }

//    // открывает слово целиком.
//    public void openWord(String word) {
//        if (attributesNotEmpty()) {
//            word = word.toUpperCase();
//
//            if (correctAnswer.equals(word)) {
//                letters = correctAnswer.split("");
//            }
//        }
//    }

    // если есть неразгаданные буквы - вернет истину, иначе ложь.
    public boolean containsUnknownLetters() {
        if (attributesNotEmpty()) {
            for (String letter : letters) {
                if (SYMBOL_OF_UNSOLVED_LETTERS.equals(letter)) {
                    return true;
                }
            }
        }
        return false;
    }

    // метод, проверяющий что атрибуты не пусты
    public boolean attributesNotEmpty() {
        return correctAnswer != null && letters != null;
    }
}
