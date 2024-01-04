package org.javaacadmey.wonder_field;

import org.javaacadmey.wonder_field.gamequestion.GameQuestion;
import org.javaacadmey.wonder_field.gamequestion.components.Answer;
import org.javaacadmey.wonder_field.player.Player;
import org.javaacadmey.wonder_field.player.PlayerAnswer;

public class Yakubovich {
    private int numberOfRound;

    public Yakubovich() {
        this.numberOfRound = 0;
    }

    public boolean checkPlayerAnswer(Player player, PlayerAnswer playerAnswer, Answer correctAnswer, Tableau tableau, boolean isFinalRound) {
        String playerAnswerText = player.getPlayerAnswer().getText();

        if (playerAnswer.getTypeAnswer() == TypeAnswer.LETTER) {
            if (checkPlayerAnswer(playerAnswerText.charAt(0), correctAnswer)) {
                tableau.openLetter(playerAnswerText.charAt(0));
                System.out.println("Якубович: Есть такая буква, откройте ее!");
                return true;
            } else {
                System.out.println("Якубович: Нет такой буквы! Следующий игрок, крутите барабан!");
                printSeparator();
                return false;
            }
        } else {
            if (checkPlayerAnswer(playerAnswerText, correctAnswer)) {
                tableau.openWord();
                System.out.println("Якубович: " + playerAnswer + "! Абсолютно верно!");
                sayIfPlayerWins(player, isFinalRound);
                return true;
            } else {
                System.out.println("Якубович: Неверно! Следующий игрок!");
                printSeparator();
                return false;
            }
        }
    }

    private boolean checkPlayerAnswer(String guess, Answer correctAnswer) {
        return correctAnswer.getText().equals(guess);
    }

    private boolean checkPlayerAnswer(char guess, Answer correctAnswer) {
        for (int i = 0; i < correctAnswer.getText().length(); i++) {
            if (correctAnswer.getText().charAt(i) == guess) {
                return true;
            }
        }
        return false;
    }

    public void sayIfPlayerWins(Player player, boolean isFinalRound) {
        String playerName = player.getName();
        String playerCity = player.getCity();

        if (isFinalRound) {
            System.out.println(
                    "Якубович: И перед нами победитель Капитал шоу поле чудес! " +
                    "Это " + playerName + " из " + playerCity);
        } else {
            System.out.println(
                    "Якубович: Молодец! " +
                    playerName+ " из " + playerCity + " проходит в финал!");
        }
    }

    public void askQuestion(GameQuestion gameQuestion) {
        System.out.println("Якубович: Внимание вопрос! \n" + gameQuestion.getText());
    }

    public void startShow() {
        System.out.println(
                "Якубович: Здравствуйте, уважаемые дамы и господа! " +
                "Пятница! В эфире капитал-шоу «Поле чудес»!");
    }

    public void endShow() {
        System.out.println(
                "Якубович: Мы прощаемся с вами ровно на одну неделю! Здоровья вам, до встречи!");
    }

    public void invitePlayers(Player[] players, int numberOfRound) {
        this.numberOfRound = numberOfRound;
        if (numberOfRound != Game.FINAL_ROUND_INDEX) {
            System.out.printf("Якубович: приглашаю %d тройку игроков: %s", numberOfRound,  joinStrings(players));
        } else {
            System.out.printf(
                    "Якубович: приглашаю победителей групповых этапов: %s через запятую",
                    joinStrings(players));
        }
    }

    private String joinStrings(Player[] players) {
        if (players == null || players.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < players.length; i++) {
            result.append(players[i].getName());
            if (i < players.length - 1) {
                result.append(", ");
            }
        }
        return result.toString();
    }


    private void printSeparator() {
        System.out.println("__________________________________");
    }
}

