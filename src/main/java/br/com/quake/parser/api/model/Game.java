package br.com.quake.parser.api.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Game {
    private int totalKills;
    private List<String> players;
    private Map kills;

    public Game() {
    }

    public Game(int totalKills, List<String> players, Map<String, Integer> kills) {
        this.totalKills = totalKills;
        this.players = players;
        this.kills = kills;
    }
}
