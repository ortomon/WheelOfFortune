package org.javaacadmey.wonder_field.components;

import org.javaacadmey.wonder_field.components.gamequestion.GameQuestion;
import org.javaacadmey.wonder_field.components.player.Player;
import org.javaacadmey.wonder_field.components.player.answer.TypeAnswer;
import org.javaacadmey.wonder_field.components.yakubovich.Yakubovich;

public class SuperGame {
    public static boolean play(GameQuestion gameQuestion, Player winner, Yakubovich yakubovich, Tableau tableau) {
        tableau.init(gameQuestion.getAnswer());
        yakubovich.sayWelcomeSuperGame();

        yakubovich.askQuestion(gameQuestion);
        winnerGuessLetter(gameQuestion, winner, yakubovich, tableau);

        yakubovich.sayGuessAnswerSuperGame();
        return winnerGuessWord(gameQuestion, winner, yakubovich, tableau);
    }

    private static void winnerGuessLetter(GameQuestion gameQuestion, Player winner, Yakubovich yakubovich, Tableau tableau) {
        System.out.println("Введите букву.");
        int trying = 1;

        while (trying < 4) {
            System.out.println("Попытка №" + trying);
            winner.move(TypeAnswer.LETTER);
            boolean correctmove = yakubovich.checkWinnerAnswer(winner, gameQuestion.getAnswer(), tableau);

            if (correctmove) {
                tableau.displayTableau();
            }

            trying++;
        }
    }

    private static boolean winnerGuessWord(GameQuestion gameQuestion, Player winner, Yakubovich yakubovich, Tableau tableau) {
        winner.move(TypeAnswer.WORD);
        return yakubovich.checkWinnerAnswer(winner, gameQuestion.getAnswer(), tableau);
    }
}
