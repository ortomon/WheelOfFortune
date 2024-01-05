package org.javaacadmey.wonder_field.player;

import org.javaacadmey.wonder_field.player.Player;

public class TestPlayers extends Player {
    private static Player[] initPlayers(String[] names, String[] locations) {
        Player[] players = new Player[names.length];
        for (int i = 0; i < names.length; i++) {
            players[i] = new Player(names[i], locations[i]);
        }
        return players;
    }

    public static Player[] initPlayers(int round) {
        if (round == 0) {
            String[] names = {"алина", "оксимирон", "бетмен"};
            String[] locations = {"мск", "спб", "готэм"};
            return initPlayers(names, locations);
        } else if (round == 1) {
            String[] names = {"даня", "миша", "максим"};
            String[] locations = {"омск", "лондон", "какашкасити"};
            return initPlayers(names, locations);
        } else {
            String[] names = {"мистер жопосранчик", "санечка", "снупдог"};
            String[] locations = {"париж", "вестерос", "эквестрия"};
            return initPlayers(names, locations);
        }
    }
}
