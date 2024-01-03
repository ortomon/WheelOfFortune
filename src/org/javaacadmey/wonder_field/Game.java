package org.javaacadmey.wonder_field;

import org.javaacadmey.wonder_field.gamequestion.components.Answer;
import org.javaacadmey.wonder_field.gamequestion.GameQuestion;
import org.javaacadmey.wonder_field.gamequestion.components.Question;
import org.javaacadmey.wonder_field.player.PlayerAnswer;
import org.javaacadmey.wonder_field.player.Player;

import java.util.Scanner;

public class Game {
    public static final int NUMBER_PLAYERS = 3;
    public static final int NUMBER_ROUNDS = 4;
    public static final int NUMBER_GROUP_ROUNDS = 3;
    public static final int FINAL_ROUND_INDEX = 3;
    public static final Scanner scanner = new Scanner(System.in);

    private GameQuestion[] gameQuestions;
    private Tableau tableau;
    private Yakubovich yakubovich;
    private Player[] winners;

    public Game(Yakubovich yakubovich) {
        initGameQuestion();
        this.yakubovich = yakubovich;
    }

    private boolean checkTableau() {
        return tableau.containsUnknownLetters();
    }

    public Player[] initPlayers() {
        Player[] players = new Player[NUMBER_PLAYERS];
        for (int i = 0; i < players.length; i++) {
            Player player = new Player();
            System.out.println("Игрок №" + i + " представьтесь: как вас зовут?");
            player.setName(scanner.nextLine());
            System.out.println("Из какого вы города?");
            player.setCity(scanner.nextLine());
            players[i] = player;
        }
        return players;
    }

    private String[] pullPlayersNames() {
        Player[] players = initPlayers();
        String[] names = new String[NUMBER_PLAYERS];
        for (int i = 0; i < NUMBER_PLAYERS; i++) {
            names[i] = players[i].getName();
        }
        return names;
    }

    // Инициализация вопросов и ответов (реализация с уже созданными вопросами и ответами)
    public void initGameQuestion() {
        gameQuestions = new GameQuestion[]{
                new GameQuestion("Как меня зовут?", new Answer("Алина")),
                new GameQuestion("Какого цвета небо?", new Answer("Голубое")),
                new GameQuestion("Что носят все?", new Answer("Трусы")),
                new GameQuestion("Какое дерево украшают на новый год?", new Answer("Ёлка"))
        };

        System.out.println("Иницализация закончена, игра начнется через 5 секунд");
    }

    public GameQuestion[] getGameQuestions() {
        return gameQuestions;
    }

    private boolean playerMove(GameQuestion gameQuestion, Player player) {
        player.move();

    }
}

/**    // инициализация игры
 public void initGame() {
 System.out.println("Запуск игры \"Поле Чудес\" - подготовка к игре.");
 System.out.println("Вам нужно ввести вопросы и ответы для игры.");
 initQuestionsAndAnswers();
 System.out.println("Иницализация закончена, игра начнется через 5 секунд");

 // пауза 5 секунд
 try {
 TimeUnit.SECONDS.sleep(5);
 } catch (InterruptedException e) {
 e.printStackTrace();
 }

 // Очистка консоли
 System.out.printf("\n".repeat(50));
 }

 // Инициализация вопросов и ответов
 private void initQuestionsAndAnswers() {
 gameQuestions = new GameQuestion[NUMBER_ROUNDS];

 for (int i = 0; i < NUMBER_ROUNDS; i++) {
 GameQuestion gameQuestion = new GameQuestion();

 System.out.println("Введите вопрос #" + (i + 1));
 gameQuestion.setQuestion(scanner.nextLine());

 System.out.println("Введите ответ на вопрос #" + (i + 1));
 gameQuestion.setAnswer(scanner.nextLine().toLowerCase());

 questions[i] = gameQuestion;
 }
 }
 */