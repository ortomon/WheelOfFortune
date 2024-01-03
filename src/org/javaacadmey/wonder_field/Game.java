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

    public Game(Yakubovich yakubovich) {
        initGameQuestion();
        this.yakubovich = yakubovich;
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
























//    public void init() {
//        initGame();
//        initTableau();
//        yakubovich.startShow();
//    }

//    public void farewell() {
//        yakubovich.farewell();
//    }



    public void askQuestion(GameQuestion gameQuestionText) {
        yakubovich.askQuestion(gameQuestionText);
    }

    public void celebrateWinner(Player player, boolean isFinalRound) {
        yakubovich.celebrateWinner(player, isFinalRound);
    }

    public void checkAnswer(char letter, String answer, String[] tableauLetters) {
        yakubovich.checkAnswer(letter, answer, tableauLetters);
    }

    public void checkWord(String word, String correctAnswer) {
        yakubovich.checkWord(word, correctAnswer);
    }

//    public PlayerAnswer makeMove(Player player) throws Exception {
//        System.out.println("Ход игрока " + player.getName() + ", " + player.getCity());
//
//        char answerType = getPlayerAnswerType();
//        return processPlayerAnswer(player, answerType);
//    }

//    public void askQuestion() {
//        for (Question q : questions) {
//            System.out.println("Вопрос: " + q.getQuestion());
//            tableau.printLetters();
//        }
//    }

    // Запросить тип ответа у игрока ('б' - буква, 'с' - слово)
    private char getPlayerAnswerType() {
        char answerType;
        do {
            System.out.println("Если хотите букву, нажмите 'б' и Enter. Если хотите слово, нажмите 'с' и Enter.");
            String input = scanner.next().toLowerCase();
            if (input.length() == 1) {
                answerType = input.charAt(0);
                if (answerType == 'б' || answerType == 'с') {
                    return answerType;
                }
            }
            System.out.println("Некорректное значение, введите 'б' или 'с'.");
        } while (true);
    }


    // Обработать ответ игрока в зависимости от типа ('б' - буква, 'с' - слово)
//    private PlayerAnswer processPlayerAnswer(Player player, char answerType) throws Exception {
//        PlayerAnswer playerAnswer = new PlayerAnswer();
//        playerAnswer.setAnswerType(answerType);
//
//        switch (answerType) {
//            case 'б':
//                char letter = player.sayLetter();
//                playerAnswer.setAnswer(String.valueOf(letter));
//                break;
//            case 'с':
//                String word = player.sayWord();
//                playerAnswer.setAnswer(word);
//                break;
//        }
//
//        return playerAnswer;
//    }

//    public void initTableau() {
//        if (gameQuestions.length > 0) {
//            tableau = new Tableau(gameQuestions[0].getAnswer());
//        }
//    }
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