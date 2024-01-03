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

    public void displayTableau() {
        if (attributesNotEmpty()) {
            System.out.print("\" ");

            for (char letter : letters) {
                System.out.print(letter + " ");
            }

            System.out.println("\"");
        } else {
            System.out.println("атрибуты Tableau пусты");
        }
    }

//    public void reveal(String guess) {
//        if (attributesNotEmpty()) {
//            guess = guess.toUpperCase();
//            if (guess.length() == 1) {
//                openLetter(guess.charAt(0));
//            } else {
//                openWord(guess);
//            }
//        } else {
//            System.out.println("атрибуты Tableau пусты");
//        }
//    }

    public boolean containsUnknownLetters() {
        for (char letter : letters) {
            if (letter == SYMBOL_OF_UNSOLVED_LETTERS) {
                return true;
            }
        }
        return false;
    }

    public void openLetter(char guess) {
        for (int i = 0; i < correctAnswer.getText().length(); i++) {
            if (correctAnswer.getText().charAt(i) == guess) {
                letters[i] = guess;
            }
        }
    }

    public void openWord() {
        for (int i = 0; i < letters.length; i++) {
            letters[i] = correctAnswer.getText().charAt(i);
        }
    }

    private boolean attributesNotEmpty() {
        return correctAnswer != null && letters != null;
    }
}
