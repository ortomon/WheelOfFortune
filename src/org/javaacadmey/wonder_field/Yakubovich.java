package org.javaacadmey.wonder_field;

import org.javaacadmey.wonder_field.gamequestion.GameQuestion;
import org.javaacadmey.wonder_field.player.Player;

public class Yakubovich {
    public void startShow() {
        System.out.println("Якубович: Здравствуйте, уважаемые дамы и господа! Пятница! В эфире капитал-шоу «Поле чудес»!");
    }

    public void goodbye() {
        System.out.println("Якубович: Мы прощаемся с вами ровно на одну неделю! Здоровья вам, до встречи!");
    }

    public void invitePlayers(Player[] players, boolean isFinalRound) {
        String[] playerNames = new String[players.length];
        for (int i = 0; i < players.length; i++) {
            playerNames[i] = players[i].getName();
        }

        if (!isFinalRound) {
            System.out.println("Якубович: приглашаю тройку игроков: " + String.join(", ", playerNames));
        } else {
            System.out.println("Якубович: приглашаю победителей групповых этапов: " + String.join(", ", playerNames));
        }
    }

    public void askQuestion(GameQuestion gameQuestionText) {
        System.out.println("Якубович: Внимание вопрос! \n" + gameQuestionText.getQuestion());
    }

    public void celebrateWinner(Player player, boolean isFinalRound) {
        if (!isFinalRound) {
            System.out.println("Якубович: Молодец! " + player.getName() + " из " + player.getCity() + " проходит в финал!");
        } else {
            System.out.println("Якубович: И перед нами победитель Капитал шоу поле чудес! Это " + player.getName() + " из " + player.getCity());
        }
    }

    public void checkAnswer(char letter, String answer, String[] tableauLetters) {
        String message;
        if (answer.indexOf(letter) != -1) {
            message = "Якубович: Есть такая буква, откройте ее!";
        } else {
            message = "Якубович: Нет такой буквы! Следующий игрок, крутите барабан!";
        }
        printSeparator();
        System.out.println(message);
        printSeparator();
    }

    public void checkWord(String word, String correctAnswer) {
        String message;
        if (word.equalsIgnoreCase(correctAnswer)) {
            message = "Якубович: " + word + "! Абсолютно верно!";
        } else {
            message = "Якубович: Неверно! Следующий игрок!";
        }
        printSeparator();
        System.out.println(message);
        printSeparator();
    }

    private void printSeparator() {
        System.out.println("__________________________________");
    }
}

