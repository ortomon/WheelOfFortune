package org.javaacadmey.wonder_field.logic;

import org.javaacadmey.wonder_field.components.Tableau;
import org.javaacadmey.wonder_field.components.gamequestion.GameQuestion;
import org.javaacadmey.wonder_field.components.player.Player;
import org.javaacadmey.wonder_field.components.player.answer.TypeAnswer;
import org.javaacadmey.wonder_field.components.yakubovich.Yakubovich;

public class SuperGame {
    public static boolean play(GameQuestion gameQuestion, Player winner, Tableau tableau) {
        tableau.init(gameQuestion.getAnswer());
        Yakubovich.sayWelcomeSuperGame();

        Yakubovich.askQuestion(gameQuestion);
        winnerGuessLetter(gameQuestion, winner, tableau);

        Yakubovich.sayGuessAnswerSuperGame();
        return winnerGuessWord(gameQuestion, winner, tableau);
    }

    private static void winnerGuessLetter(GameQuestion gameQuestion, Player winner, Tableau tableau) {
        System.out.println("Введите букву.");
        int trying = 1;

        while (trying < 4) {
            System.out.println("Попытка №" + trying);
            winner.move(TypeAnswer.LETTER);
            boolean correctMove = Yakubovich.checkWinnerAnswer(winner, gameQuestion.getAnswer(), tableau);

            if (correctMove) {
                tableau.displayTableau();
            }

            trying++;
        }
    }

    private static boolean winnerGuessWord(GameQuestion gameQuestion, Player winner, Tableau tableau) {
        winner.move(TypeAnswer.WORD);
        return Yakubovich.checkWinnerAnswer(winner, gameQuestion.getAnswer(), tableau);
    }
}
