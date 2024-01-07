package org.javaacadmey.wonder_field.components;

import org.javaacadmey.wonder_field.Game;
import org.javaacadmey.wonder_field.components.gamequestion.GameQuestion;
import org.javaacadmey.wonder_field.components.gamequestion.components.Answer;
import org.javaacadmey.wonder_field.components.player.Player;
import org.javaacadmey.wonder_field.components.player.answer.PlayerAnswer;
import org.javaacadmey.wonder_field.components.player.answer.TypeAnswer;

public class Yakubovich {
    private static final String SEPARATOR = "__________________________________";
    private static final String YAKUBOVICH = "Якубович:";

    public boolean checkPlayerAnswer(Player player, Answer correctAnswer, Tableau tableau) {
        PlayerAnswer playerAnswer = player.getPlayerAnswer();
        String playerAnswerText = playerAnswer.getText();

        if (playerAnswer.getTypeAnswer() == TypeAnswer.LETTER) {
            return checkPlayerAnswer(playerAnswerText.charAt(0), correctAnswer, tableau);
        } else {
            return checkPlayerAnswer(playerAnswerText, correctAnswer, tableau);
        }
    }

    private boolean checkPlayerAnswer(char guess, Answer correctAnswer, Tableau tableau) {
        if (checkPlayerAnswer(guess, correctAnswer)) {
            tableau.openLetter(guess);
            System.out.println(YAKUBOVICH + " Есть такая буква, откройте ее!");
            return true;
        } else {
            System.out.println(YAKUBOVICH + " Нет такой буквы! Следующий игрок.");
            System.out.println(SEPARATOR);
            return false;
        }
    }

    private boolean checkPlayerAnswer(String guess, Answer correctAnswer, Tableau tableau) {
        if (checkPlayerAnswer(guess, correctAnswer)) {
            tableau.openWord();
            System.out.printf("%s %s! Абсолютно верно!\n", YAKUBOVICH, guess);
            return true;
        } else {
            System.out.println(YAKUBOVICH + " Неверно! Следующий игрок!");
            System.out.println(SEPARATOR);
            return false;
        }
    }

    private boolean checkPlayerAnswer(String guess, Answer correctAnswer) {
        return correctAnswer.getText().equals(guess);
    }

    private boolean checkPlayerAnswer(char guess, Answer correctAnswer) {
        return correctAnswer.getText().contains(String.valueOf(guess));
    }

    public void saySector(String sector) {
        try {
            int pointsDrumSector = Integer.parseInt(sector);
            System.out.printf("%s %d очков на барабане!\n", YAKUBOVICH, pointsDrumSector);
        } catch (NumberFormatException e) {
            System.out.print(YAKUBOVICH + sector);

            if (sector.equals(Drum.SECTOR_DOUBLING)) {
                System.out.println(" Заработанные игроком очки удваиваются, если он назовёт верную букву.");
            } else {
                System.out.println(" Игрок пропускает ход.");
            }
        }
    }

    public void sayIfPlayerWins(Player player, boolean isFinalRound) {
        String playerName = player.getName();
        String playerCity = player.getCity();
        int playerPoints = player.getPoints();

        if (isFinalRound) {
            System.out.print(YAKUBOVICH + " И перед нами победитель Капитал шоу поле чудес! ");
            System.out.printf("Это %s из %s.\n", playerName, playerCity);
            System.out.printf("Он набрал %d очков.\n", playerPoints);
        } else {
            System.out.printf("%s Молодец! %s из %s проходит в финал!\n", YAKUBOVICH, playerName, playerCity);
        }
    }

    public void askQuestion(GameQuestion gameQuestion) {
        System.out.printf("%s Внимание вопрос! %s\n", YAKUBOVICH, gameQuestion.getText());
    }

    public void saySpinDrum(Player player) {
        System.out.printf("%s %s, крутите барабан!\n", YAKUBOVICH, player.getName());
    }

    public void startShow() {
        System.out.print(YAKUBOVICH + " Здравствуйте, уважаемые дамы и господа! ");
        System.out.println("Пятница! В эфире капитал-шоу «Поле чудес»!");
    }

    public void endShow() {
        System.out.print(YAKUBOVICH + " Мы прощаемся с вами ровно на одну неделю! ");
        System.out.println("Здоровья вам, до встречи!");
    }

    public void invitePlayers(String playersName, int numberOfRound) {
        if (numberOfRound != Game.FINAL_ROUND_INDEX) {
            System.out.printf("%s приглашаю %d тройку игроков: %s\n", YAKUBOVICH, (numberOfRound + 1),  playersName);
        } else {
            System.out.printf("%s приглашаю победителей групповых этапов: %s\n", YAKUBOVICH, playersName);
        }
    }
}

