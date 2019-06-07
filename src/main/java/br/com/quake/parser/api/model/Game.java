package br.com.quake.parser.api.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Game {
    private int totalKills;
    private List<String> players;
    private Map kills;
}
