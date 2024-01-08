package org.javaacadmey.wonder_field;

import org.javaacadmey.wonder_field.components.*;
import org.javaacadmey.wonder_field.components.gamequestion.GameQuestion;
import org.javaacadmey.wonder_field.components.gamequestion.components.Answer;
import org.javaacadmey.wonder_field.components.gift.type.BoxWithMoney;
import org.javaacadmey.wonder_field.components.gift.Gift;
import org.javaacadmey.wonder_field.components.gift.PointGifts;
import org.javaacadmey.wonder_field.components.gift.SuperGifts;
import org.javaacadmey.wonder_field.components.player.Player;
import org.javaacadmey.wonder_field.components.gamequestion.TestGameQuestion;
import org.javaacadmey.wonder_field.components.SymbolChecker;
import org.javaacadmey.wonder_field.components.player.TestPlayers;
import org.javaacadmey.wonder_field.components.player.answer.TypeAnswer;
import org.javaacadmey.wonder_field.components.yakubovich.Yakubovich;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public static final int NUMBER_PLAYERS = 3;
    public static final int NUMBER_ROUNDS = 5;
    public static final int NUMBER_GROUP_ROUNDS = 3;
    public static final int FINAL_ROUND_INDEX = 3;
    public static final int SUPER_GAME_ROUND_INDEX = 4;
    private static final int NUMBER_BOXES_WITH_MONEY = 2;
    public static final Scanner scanner = new Scanner(System.in);

    private GameQuestion[] gameQuestions;
    private Tableau tableau;
    private Yakubovich yakubovich;
    private Drum drum;
    private Player[] groupRoundsWinners;
    private Player[] players;
    private Player winner;
    private BoxWithMoney[] boxesWithMoney;

    public Game() {
        this.gameQuestions = new GameQuestion[NUMBER_ROUNDS];
        this.groupRoundsWinners = new Player[NUMBER_GROUP_ROUNDS];
        this.players = new Player[NUMBER_PLAYERS];
        this.boxesWithMoney = new BoxWithMoney[NUMBER_BOXES_WITH_MONEY];
        this.yakubovich = new Yakubovich();
        this.tableau = new Tableau();
        this.drum = new Drum();
        initGame();
    }

    public void start() {
        yakubovich.startShow();
        playGroupRounds();
        playFinalRound();
        winnerChooseGift();
        offerPlaySuperGame();
        yakubovich.endShow();
        scanner.close();
    }

    private void initBoxesWithMoney() {
        Random random = new Random();

        int randomIndex = random.nextInt(0, NUMBER_BOXES_WITH_MONEY);
        int step = 1000;
        int minValue = 1000;
        int randomValueGreaterZero = minValue + step * random.nextInt(0, 100);

        boxesWithMoney[randomIndex] = new BoxWithMoney(0);
        boxesWithMoney[NUMBER_BOXES_WITH_MONEY - 1 - randomIndex] = new BoxWithMoney(randomValueGreaterZero);
    }

    private void initGame() {
        System.out.println("Запуск игры \"Поле Чудес\" - подготовка к игре.");
//        System.out.println("Вам нужно ввести вопросы и ответы для игры.");
//        initGameQuestion();
        initTestGameQuestion();
        System.out.println("Иницализация закончена, игра начнется через 5 секунд");

//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.print("\n".repeat(50));
    }

    private void initTestPlayers(int round) {
        players = TestPlayers.initPlayers(round);
    }

    private Player[] initPlayers() {
        for (int i = 0; i < NUMBER_PLAYERS; i++) {
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

        for (int i = 0; i < NUMBER_PLAYERS; i++) {
            names.append(players[i].getName());
            if (i < NUMBER_PLAYERS - 1) {
                names.append(", ");
            }
        }
        return names.toString();
    }

    private void initTestGameQuestion() {
        gameQuestions = TestGameQuestion.initGameQuestion();
    }

    private void initGameQuestion() {
        for (int i = 0; i < FINAL_ROUND_INDEX; i++) {
            System.out.println("Введите вопрос #" + (i + 1));
            String question = scanner.nextLine();

            System.out.println("Введите ответ на вопрос #" + (i + 1));
            Answer answer = new Answer(scanner.nextLine().toUpperCase());

            gameQuestions[i] = new GameQuestion(question, answer);
        }

        System.out.println("Введите вопрос для супер игры:");
        String question = scanner.nextLine();

        System.out.println("Введите ответ на вопрос супер игры:");
        Answer answer = new Answer(scanner.nextLine().toUpperCase());

        gameQuestions[SUPER_GAME_ROUND_INDEX] = new GameQuestion(question, answer);
    }

    private boolean checkTableau() {
        return tableau.containsUnknownLetters();
    }

    private void playerMove(Player player) {
        System.out.printf("Ход игрока %s, город %s\n", player.getName(), player.getCity());

        while (true) {
            System.out.println("Если хотите букву нажмите 'б' и enter, если хотите слово нажмите 'c' и enter");
            String command = Game.scanner.nextLine().toLowerCase();

            if (SymbolChecker.symbolIsCyrillic(command.charAt(0))) {
                switch (command) {
                    case "б":
                        player.move(TypeAnswer.LETTER);
                        return;
                    case "с":
                        player.move(TypeAnswer.WORD);
                        return;
                    default:
                        System.out.println("Некорректное значение, введите 'б' или 'с'.");
                }
            }
        }
    }

    private boolean playerMove(GameQuestion gameQuestion, Player player, boolean isFinalRound) {
        int countMove = 1;

        while (true) {
            String sector = player.spinDrum(drum);
            yakubovich.saySector(sector);

            if (sector.equals(Drum.SECTOR_SKIPPING_MOVE)) {
                return false;
            }

            playerMove(player);

            boolean correctGuess = yakubovich.checkPlayerAnswer(player, gameQuestion.getAnswer(), tableau);

            if (!correctGuess) {
                return false;
            } else {
                if (countMove % 3 == 0) {
                    giveBoxWithMoney(player);
                }

                playerGetsPoints(player, sector);
                countMove++;

                if (!playerContinuesMove(player, isFinalRound)) {
                    return true;
                }
            }
        }
    }

    private void giveBoxWithMoney(Player player) {
        yakubovich.sayBoxesWithMoney();
        System.out.println("Нажмиите '1' и enter, если хотите шкатулку слева или '2' и enter - если справа.");
        initBoxesWithMoney();

        while (true) {
            int command = player.chooseBoxWithMoney();

            switch (command) {
                case 1:
                    yakubovich.sayHowManyMoneyInBox(boxesWithMoney[0]);
                    player.takeGift(boxesWithMoney[0]);
                    return;
                case 2:
                    yakubovich.sayHowManyMoneyInBox(boxesWithMoney[1]);
                    player.takeGift(boxesWithMoney[1]);
                    return;
                default:
                    System.out.println("Некорректное значение, введите 1 или 2.");
            }
        }
    }

    private void playerGetsPoints(Player player, String sector) {
        try {
            int pointsDrum = Integer.parseInt(sector);
            player.setPoints(pointsDrum);
        } catch (NumberFormatException e) {
            player.setPoints(player.getPoints() * 2);
        }
    }

    private boolean playerContinuesMove(Player player, boolean isFinalRound) {
        if (checkTableau()) {
            tableau.displayTableau();
            return true;
        } else {
            yakubovich.sayIfPlayerWins(player, isFinalRound);
            return false;
        }
    }

    private GameQuestion getQuestionForRound(int round) {
        return gameQuestions[round];
    }

    private void playRound(int round, Player[] players) {
        GameQuestion gameQuestion = getQuestionForRound(round);
        tableau.init(gameQuestion.getAnswer());
        yakubovich.invitePlayers(pullPlayersNames(players), round);
        yakubovich.askQuestion(gameQuestion);

        while (checkTableau()) {
            for (Player player : players) {
                yakubovich.saySpinDrum(player);
                boolean playerWins;

                if (round != FINAL_ROUND_INDEX) {
                    playerWins = playerMove(gameQuestion, player, false);
                    if (playerWins) {
                        groupRoundsWinners[round] = player;
                        return;
                    }
                } else {
                    playerWins = playerMove(gameQuestion, player, true);
                    if (playerWins) {
                        winner = player;
                        return;
                    }
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
        if (groupRoundsWinners != null && groupRoundsWinners.length > 0) {
            playRound(FINAL_ROUND_INDEX, groupRoundsWinners);
        } else {
            System.out.println("Нет победителей групповых раундов.");
        }
    }

    private void winnerChooseGift() {
        while (winner.getPoints() >= PointGifts.cheapestPointGift()) {
            System.out.println("Напишите выбранный подарок из каталога:");
            String choose = scanner.nextLine().toLowerCase();
            PointGifts choosePointGift = PointGifts.getByGiftName(choose);

            if (choosePointGift == null) {
                System.out.println("Такого подарка нет, выберите подарок из каталога и напишите его название еще раз:");
            } else {
                if (winner.getPoints() >= choosePointGift.getPointGift().getCost()) {
                    winner.takeGift(choosePointGift.getPointGift());
                    winner.setPoints(-choosePointGift.getPointGift().getCost());

                    if (winner.getPoints() >= PointGifts.cheapestPointGift()) {
                        System.out.println("У вас осталось " + winner.getPoints() + " баллов. Выберите еще один подарок!");
                    } else {
                        System.out.println("Пользуйтесь своими подарками на здоровье!");
                        return;
                    }
                } else {
                    System.out.println("У вас не хватает баллов, выберите что-нибудь другое.");
                }
            }
        }
    }

    private void offerPlaySuperGame() {
        System.out.println("Хотите сыграть в супер игру?");
        Gift superGift = SuperGifts.getRandomSuperGift().getGift();
        boolean playSuperGame = true;

        while (playSuperGame) {
            String command = Game.scanner.nextLine().toLowerCase();

            switch (command) {
                case "да":
                    boolean isVictory = playSuperGame();

                    if (isVictory) {
                        winner.takeGift(superGift);
                    }

                    printWinnerGiftInfo();
                    return;
                case "нет":
                    System.out.println("якубови: а секреный подарок был " + superGift);
                    printWinnerGiftInfo();
                    return;
                default:
                    System.out.println("Некорректное значение, введите 'да' или 'нет'");
            }
            playSuperGame = false;
        }
    }

    private boolean playSuperGame() {
        GameQuestion superGameQuestion = getQuestionForRound(SUPER_GAME_ROUND_INDEX);

        if (winner != null) {
            return SuperGame.play(superGameQuestion, winner, yakubovich, tableau);
        } else {
            System.out.println("Нет победителя.");
        }
        return false;
    }

    private void printWinnerGiftInfo() {
        System.out.print("игрок уходит с такими вещам: ");
        winner.printGifts();
    }
}
