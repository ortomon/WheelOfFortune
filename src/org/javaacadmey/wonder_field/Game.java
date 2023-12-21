package org.javaacadmey.wonder_field;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
    public static final int NUMBER_PLAYERS = 3;
    public static final int TOTAL_ROUNDS = 4;
    public static final int GROUP_ROUNDS = 3;
    public static final int FINAL_ROUND_INDEX = 3;
    public static final Scanner scanner = new Scanner(System.in);

    private String[] questions;
    public String[] answers;
    public Tableau tableau;

    // инициализация игры
    public void init() {
        System.out.println("Запуск игры \"Поле Чудес\" - подготовка к игре. Вам нужно ввести вопросы и ответы для игры.");

        initializeQuestionsAndAnswers();

        System.out.println("Иницализация закончена, игра начнется через 5 секунд");

        // пауза 5 секунд
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Очистка консоли
        for (int i = 0; i < 50; ++i) {
            System.out.println();
        }
    }

    // Инициализация вопросов и ответов
    private void initializeQuestionsAndAnswers() {
        questions = new String[TOTAL_ROUNDS];
        answers = new String[TOTAL_ROUNDS];

        for (int i = 0; i < TOTAL_ROUNDS; i++) {
            System.out.println("Введите вопрос #" + (i + 1));
            questions[i] = scanner.nextLine();

            System.out.println("Введите ответ на вопрос #" + (i + 1));
            answers[i] = scanner.nextLine();
        }
    }
}

