package org.javaacadmey.wonder_field.components;

import org.javaacadmey.wonder_field.components.gamequestion.components.Answer;
import java.util.Arrays;

public class Tableau {
    private static final char SYMBOL_OF_UNSOLVED_LETTERS = '_';
    private Answer correctAnswer;
    private char[] letters;

    public void init(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
        letters = new char[correctAnswer.getText().length()];
        Arrays.fill(letters, SYMBOL_OF_UNSOLVED_LETTERS);
    }

    public void displayTableau() {
        if (attributesNotEmpty()) {
            for (char letter : letters) {
                System.out.print(letter + " ");
            }
            System.out.println();
        }
    }

    public boolean containsUnknownLetters() {
        for (char letter : letters) {
            if (letter == SYMBOL_OF_UNSOLVED_LETTERS) {
                return true;
            }
        }
        return false;
    }

    public void openLetter(char guess) {
        if (attributesNotEmpty()) {
            for (int i = 0; i < correctAnswer.getText().length(); i++) {
                if (correctAnswer.getText().charAt(i) == guess) {
                    letters[i] = guess;
                }
            }
        }
    }

    public void openWord() {
        for (int i = 0; i < letters.length; i++) {
            letters[i] = correctAnswer.getText().charAt(i);
        }
    }

    private boolean attributesNotEmpty() {
        if (correctAnswer == null || correctAnswer.getText().isEmpty() || letters == null) {
            System.out.println("атрибуты Tableau пусты");
            return false;
        }
        return true;
    }
}
