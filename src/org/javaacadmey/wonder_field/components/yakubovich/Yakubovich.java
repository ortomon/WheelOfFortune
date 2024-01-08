package org.javaacadmey.wonder_field.components.yakubovich;

import org.javaacadmey.wonder_field.logic.Game;
import org.javaacadmey.wonder_field.components.gift.type.BoxWithMoney;
import org.javaacadmey.wonder_field.components.Drum;
import org.javaacadmey.wonder_field.components.Tableau;
import org.javaacadmey.wonder_field.components.gamequestion.GameQuestion;
import org.javaacadmey.wonder_field.components.gamequestion.components.Answer;
import org.javaacadmey.wonder_field.components.gift.type.Gift;
import org.javaacadmey.wonder_field.components.player.Player;
import org.javaacadmey.wonder_field.components.player.answer.PlayerAnswer;
import org.javaacadmey.wonder_field.components.player.answer.TypeAnswer;

public final class Yakubovich {
    private static final String SEPARATOR = "__________________________________";

    public static boolean checkWinnerAnswer(Player player, Answer correctAnswer, Tableau tableau) {
        PlayerAnswer winnerAnswer = player.getPlayerAnswer();
        String winnerAnswerText = winnerAnswer.getText();

        if (winnerAnswer.getTypeAnswer() == TypeAnswer.LETTER) {
            if (checkPlayerAnswer(winnerAnswerText.charAt(0), correctAnswer)) {
                tableau.openLetter(winnerAnswerText.charAt(0));
                System.out.println(YakubovichPhrases.CORRECT_LETTER_GUESS.getText());
                return true;
            } else {
                System.out.println(YakubovichPhrases.NO_SUCH_LETTER.getText());
            }
        } else {
            if (checkPlayerAnswer(winnerAnswerText, correctAnswer)) {
                tableau.openWord();
                System.out.printf(YakubovichPhrases.CORRECT_WORD_GUESS.getText(), winnerAnswerText);
                return true;
            } else {
                System.out.println(YakubovichPhrases.WRONG_WORD_GUESS.getText());
            }
        }
        return false;
    }

    public static boolean checkPlayerAnswer(Player player, Answer correctAnswer, Tableau tableau) {
        PlayerAnswer playerAnswer = player.getPlayerAnswer();
        String playerAnswerText = playerAnswer.getText();

        if (playerAnswer.getTypeAnswer() == TypeAnswer.LETTER) {
            return checkPlayerAnswer(playerAnswerText.charAt(0), correctAnswer, tableau);
        } else {
            return checkPlayerAnswer(playerAnswerText, correctAnswer, tableau);
        }
    }

    private static boolean checkPlayerAnswer(char guess, Answer correctAnswer, Tableau tableau) {
        if (checkPlayerAnswer(guess, correctAnswer)) {
            tableau.openLetter(guess);
            System.out.println(YakubovichPhrases.CORRECT_LETTER_GUESS.getText());
            return true;
        } else {
            System.out.println(YakubovichPhrases.NO_SUCH_LETTER.getText() + YakubovichPhrases.NEXT_PLAYER.getText());
            System.out.println(SEPARATOR);
            return false;
        }
    }

    private static boolean checkPlayerAnswer(String guess, Answer correctAnswer, Tableau tableau) {
        if (checkPlayerAnswer(guess, correctAnswer)) {
            tableau.openWord();
            System.out.printf(YakubovichPhrases.CORRECT_WORD_GUESS.getText(), guess);
            return true;
        } else {
            System.out.println(YakubovichPhrases.WRONG_WORD_GUESS.getText() + YakubovichPhrases.NEXT_PLAYER.getText());
            System.out.println(SEPARATOR);
            return false;
        }
    }

    private static boolean checkPlayerAnswer(String guess, Answer correctAnswer) {
        return correctAnswer.getText().equals(guess);
    }

    private static boolean checkPlayerAnswer(char guess, Answer correctAnswer) {
        return correctAnswer.getText().contains(String.valueOf(guess));
    }

    public static void saySector(String sector) {
        try {
            int pointsDrumSector = Integer.parseInt(sector);
            System.out.printf(YakubovichPhrases.DRUM_SECTOR_WITH_POINT.getText(), pointsDrumSector);
        } catch (NumberFormatException e) {
            System.out.print(YakubovichPhrases.YAKUBOVICH.getText() + sector);

            if (sector.equals(Drum.SECTOR_DOUBLING)) {
                System.out.println(YakubovichPhrases.DRUM_SECTOR_DOUBLING.getText());
            } else {
                System.out.println(YakubovichPhrases.DRUM_SECTOR_SKIP_MOVE.getText());
            }
        }
    }

    public static void sayBoxesWithMoney() {
        System.out.println(YakubovichPhrases.BOX_WITH_MONEY_CHANCE.getText());
    }

    public static void sayHowManyMoneyInBox(BoxWithMoney boxWithMoney) {
        System.out.printf(YakubovichPhrases.HOW_MANY_MONEY_IN_BOX.getText(), boxWithMoney.getMoney());
    }

    public static void sayIfPlayerWins(Player player, boolean isFinalRound) {
        String playerName = player.getName();
        String playerCity = player.getCity();
        int playerPoints = player.getPoints();

        if (isFinalRound) {
            System.out.printf(YakubovichPhrases.PLAYER_WINS_FINAL_ROUND.getText(), playerName, playerCity, playerPoints);
        } else {
            System.out.printf(YakubovichPhrases.PLAYER_WINS_GROUP_ROUND.getText(), playerName, playerCity);
        }
    }

    public static void askQuestion(GameQuestion gameQuestion) {
        System.out.printf(YakubovichPhrases.ASK_QUESTION.getText(), gameQuestion.getText());
    }

    public static void saySpinDrum(Player player) {
        System.out.printf(YakubovichPhrases.SPIN_DRUM.getText(), player.getName());
    }

    public static void startShow() {
        System.out.println(YakubovichPhrases.START_SHOW.getText());
    }

    public static void endShow() {
        System.out.println(YakubovichPhrases.END_SHOW.getText());
    }

    public static void invitePlayers(String playersName, int numberOfRound) {
        if (numberOfRound == Game.FINAL_GROUP_ROUND_INDEX) {
            System.out.printf(YakubovichPhrases.INVITE_WINNERS.getText(), playersName);
        } else {
            System.out.printf(YakubovichPhrases.INVITE_PLAYERS.getText(), (numberOfRound + 1),  playersName);
        }
    }

    public static void sayWelcomeSuperGame() {
        System.out.println(YakubovichPhrases.SUPER_GAME.getText());
    }

    public static void sayGuessAnswerSuperGame() {
        System.out.println(YakubovichPhrases.GUESS_WORD_SUPER_GAME.getText());
    }

    public static void saySuperGift(Gift gift) {
        System.out.println(YakubovichPhrases.SUPER_GIFT + gift.getName());
    }
}

