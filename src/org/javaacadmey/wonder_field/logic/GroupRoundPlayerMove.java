package org.javaacadmey.wonder_field.logic;

import org.javaacadmey.wonder_field.components.Drum;
import org.javaacadmey.wonder_field.components.SymbolChecker;
import org.javaacadmey.wonder_field.components.Tableau;
import org.javaacadmey.wonder_field.components.gamequestion.GameQuestion;
import org.javaacadmey.wonder_field.components.gift.type.BoxWithMoney;
import org.javaacadmey.wonder_field.components.player.Player;
import org.javaacadmey.wonder_field.components.player.answer.TypeAnswer;
import org.javaacadmey.wonder_field.components.yakubovich.Yakubovich;

public class GroupRoundPlayerMove {
    private static final Drum drum = new Drum();

    public static boolean playerMove(GameQuestion gameQuestion, Player player, boolean isFinalRound, Tableau tableau) {
        int countMove = 1;

        while (true) {
            String sector = player.spinDrum(drum);
            Yakubovich.saySector(sector);

            if (sector.equals(Drum.SECTOR_SKIPPING_MOVE)) {
                return false;
            }

            playerMove(player);

            boolean correctGuess = Yakubovich.checkPlayerAnswer(player, gameQuestion.getAnswer(), tableau);

            if (!correctGuess) {
                return false;
            } else {
                if (countMove % 3 == 0) {
                    giveBoxWithMoney(player);
                }

                playerGetsPoints(player, sector);
                countMove++;

                if (!playerContinuesMove(player, isFinalRound, tableau)) {
                    return true;
                }
            }
        }
    }

    private static void playerMove(Player player) {
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

    private static void giveBoxWithMoney(Player player) {
        Yakubovich.sayBoxesWithMoney();
        System.out.println("Нажмиите '1' и enter, если хотите шкатулку слева или '2' и enter - если справа.");
        BoxWithMoney[] boxesWithMoney = BoxWithMoney.initForGame();

        while (true) {
            int command = player.chooseBoxWithMoney();

            switch (command) {
                case 1:
                    Yakubovich.sayHowManyMoneyInBox(boxesWithMoney[0]);
                    player.takeGift(boxesWithMoney[0]);
                    return;
                case 2:
                    Yakubovich.sayHowManyMoneyInBox(boxesWithMoney[1]);
                    player.takeGift(boxesWithMoney[1]);
                    return;
                default:
                    System.out.println("Некорректное значение, введите 1 или 2.");
            }
        }
    }

    private static void playerGetsPoints(Player player, String sector) {
        try {
            int pointsDrum = Integer.parseInt(sector);
            player.setPoints(pointsDrum);
        } catch (NumberFormatException e) {
            player.setPoints(player.getPoints() * 2);
        }
    }

    private static boolean playerContinuesMove(Player player, boolean isFinalRound, Tableau tableau) {
        if (checkTableau(tableau)) {
            tableau.displayTableau();
            return true;
        } else {
            Yakubovich.sayIfPlayerWins(player, isFinalRound);
            return false;
        }
    }

    private static boolean checkTableau(Tableau tableau) {
        return tableau.containsUnknownLetters();
    }
}
