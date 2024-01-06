package org.javaacadmey.wonder_field.components;

import org.javaacadmey.wonder_field.Game;
import org.javaacadmey.wonder_field.components.gamequestion.GameQuestion;
import org.javaacadmey.wonder_field.components.gamequestion.components.Answer;
import org.javaacadmey.wonder_field.components.player.Player;
import org.javaacadmey.wonder_field.components.player.answer.PlayerAnswer;
import org.javaacadmey.wonder_field.components.player.answer.TypeAnswer;

public class Yakubovich {
    private static final String SEPARATOR = "__________________________________";

    public boolean checkPlayerAnswer(Player player, Answer correctAnswer, Tableau tableau) {
        PlayerAnswer playerAnswer = player.getPlayerAnswer();
        String playerAnswerText = player.getPlayerAnswer().getText();

        if (playerAnswer.getTypeAnswer() == TypeAnswer.LETTER) {
            if (checkPlayerAnswer(playerAnswerText.charAt(0), correctAnswer)) {
                tableau.openLetter(playerAnswerText.charAt(0));
                System.out.println("Якубович: Есть такая буква, откройте ее!");
                return true;
            } else {
                System.out.println("Якубович: Нет такой буквы! Следующий игрок, крутите барабан!");
                System.out.println(SEPARATOR);
                return false;
            }
        } else {
            if (checkPlayerAnswer(playerAnswerText, correctAnswer)) {
                tableau.openWord();
                System.out.println("Якубович: " + playerAnswer.getText() + "! Абсолютно верно!");
                return true;
            } else {
                System.out.println("Якубович: Неверно! Следующий игрок!");
                System.out.println(SEPARATOR);
                return false;
            }
        }
    }

    public void saySector(String sector) {
        try {
            int pointsDrumSector = Integer.parseInt(sector);
            System.out.printf("Якубович: %d очков на барабане!\n", pointsDrumSector);
        } catch (NumberFormatException e) {
            System.out.printf("Якубович: %s ", sector);
            if (sector.equals(Drum.SECTOR_DOUBLING)) {
                System.out.println("Заработанные игроком очки удваиваются, если он назовёт верную букву.");
            } else {
                System.out.println("Игрок пропускает ход.");
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
            System.out.print("Якубович: И перед нами победитель Капитал шоу поле чудес! ");
            System.out.println("Это " + playerName + " из " + playerCity);
            System.out.printf("У него %d очков.\n", player.getPoints());
        } else {
            System.out.println("Якубович: Молодец! " + playerName+ " из " + playerCity + " проходит в финал!");
        }
    }

    public void askQuestion(GameQuestion gameQuestion) {
        System.out.println("Якубович: Внимание вопрос! \n" + gameQuestion.getText());
    }

    public void saySpinDrum(Player player) {
        System.out.printf("Якубович: %s, крутите барабан!\n", player.getName());
    }

    public void startShow() {
        System.out.println(
                "Якубович: Здравствуйте, уважаемые дамы и господа! " +
                "Пятница! В эфире капитал-шоу «Поле чудес»!");
    }

    public void endShow() {
        System.out.println("Якубович: Мы прощаемся с вами ровно на одну неделю! Здоровья вам, до встречи!");
    }

    public void invitePlayers(String playersName, int numberOfRound) {
        if (numberOfRound != Game.FINAL_ROUND_INDEX) {
            System.out.printf("Якубович: приглашаю %d тройку игроков: %s\n", numberOfRound + 1,  playersName);
        } else {
            System.out.printf("Якубович: приглашаю победителей групповых этапов: %s\n", playersName);
        }
    }
}

