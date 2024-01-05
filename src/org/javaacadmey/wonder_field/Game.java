package org.javaacadmey.wonder_field;

import org.javaacadmey.wonder_field.components.Tableau;
import org.javaacadmey.wonder_field.components.Yakubovich;
import org.javaacadmey.wonder_field.components.gamequestion.GameQuestion;
import org.javaacadmey.wonder_field.components.gamequestion.components.Answer;
import org.javaacadmey.wonder_field.components.player.Player;
import org.javaacadmey.wonder_field.components.gamequestion.TestGameQuestion;
import org.javaacadmey.wonder_field.components.player.TestPlayers;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
    private Player[] players;

    public Game() {
        this.gameQuestions = new GameQuestion[NUMBER_ROUNDS];
        this.yakubovich = new Yakubovich();
        this.tableau = new Tableau();
        this.winners = new Player[NUMBER_GROUP_ROUNDS];
        this.players = new Player[NUMBER_PLAYERS];
        initGame();
    }

    public void start() {
        yakubovich.startShow();
        playGroupRounds();
        playFinalRound();
        yakubovich.endShow();
        scanner.close();
    }

    private void initGame() {
        System.out.println("Запуск игры \"Поле Чудес\" - подготовка к игре.");
//        System.out.println("Вам нужно ввести вопросы и ответы для игры.");
//        initGameQuestion();
        initTestGameQuestion();
        System.out.println("Иницализация закончена, игра начнется через 5 секунд");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print("\n".repeat(50));
    }

    private void initTestPlayers(int round) {
        players = TestPlayers.initPlayers(round);
    }

    private Player[] initPlayers() {
        for (int i = 0; i < players.length; i++) {
            Player player = new Player();
            System.out.println("Игрок №" + (i + 1) + " представьтесь: как вас зовут?");
            player.setName(scanner.nextLine());
            System.out.println("Из какого вы города?");
            player.setCity(scanner.nextLine());
            players[i] = player;
        }
        return players;
    }

    private String pullPlayersNames(Player[] players) {
        StringBuilder names = new StringBuilder();

        for (int i = 0; i < players.length; i++) {
            names.append(players[i].getName());
            if (i < players.length - 1) {
                names.append(", ");
            }
        }
        return names.toString();
    }

    private void initTestGameQuestion() {
        gameQuestions = TestGameQuestion.initGameQuestion();
    }

    private void initGameQuestion() {
        for (int i = 0; i < gameQuestions.length; i++) {
            System.out.println("Введите вопрос #" + (i + 1));
            String question = scanner.nextLine();

            System.out.println("Введите ответ на вопрос #" + (i + 1));
            Answer answer = new Answer(scanner.nextLine().toUpperCase());

            gameQuestions[i] = new GameQuestion(question, answer);
        }
    }

    private boolean checkTableau() {
        return tableau.containsUnknownLetters();
    }

    private boolean playerMove(GameQuestion gameQuestion, Player player,  boolean isFinalRound) {
        do {
            player.move();
            boolean correctGuess = yakubovich.checkPlayerAnswer(
                    player, gameQuestion.getAnswer(),
                    tableau, isFinalRound);

            if (correctGuess) {
                if (checkTableau()) {
                    tableau.displayTableau();
                } else {
                    return true;
                }
            } else {
                return false;
            }
        } while (true);
    }

    private GameQuestion getQuestionForRound(int round) {
        if (round != FINAL_ROUND_INDEX) {
            return gameQuestions[round];
        } else {
            return gameQuestions[FINAL_ROUND_INDEX];
        }
    }

    private void playRound(int round, Player[] players) {
        GameQuestion gameQuestion = getQuestionForRound(round);
        tableau.init(gameQuestion.getAnswer());
        yakubovich.invitePlayers(pullPlayersNames(players), round);
        yakubovich.askQuestion(gameQuestion);

        while (checkTableau()) {
            for (Player player : players) {
                boolean playerWins;

                if (round != FINAL_ROUND_INDEX) {
                    playerWins = playerMove(gameQuestion, player, false);
                    if (playerWins) {
                        winners[round] = player;
                        return;
                    }
                } else {
                    playerMove(gameQuestion, player, true);
                    return;
                }
            }
        }
    }

    private void playGroupRounds() {
        for (int round = 0; round < NUMBER_GROUP_ROUNDS; round++) {
            System.out.println("Групповой раунд " + (round + 1));
//            initPlayers();
            initTestPlayers(round);
            playRound(round, players);
            System.out.println("Групповой раунд закончен.");
        }
    }

    private void playFinalRound() {
        if (winners != null && winners.length > 0) {
            playRound(FINAL_ROUND_INDEX, winners);
        } else {
            System.out.println("Нет победителей групповых раундов.");
        }
    }

    public GameQuestion[] getGameQuestions() {
        return gameQuestions;
    }

    public Tableau getTableau() {
        return tableau;
    }

    public Yakubovich getYakubovich() {
        return yakubovich;
    }

    public Player[] getWinners() {
        return winners;
    }

    public Player[] getPlayers() {
        return players;
    }
}
