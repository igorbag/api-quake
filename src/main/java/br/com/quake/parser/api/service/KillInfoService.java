package br.com.quake.parser.api.service;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static br.com.quake.parser.api.data.local.Constants.*;

@Service
public class KillInfoService {
    private Map<String, Integer> kills;
    private int worldKillsCount;
    private int userKillsCount;

    public Map getKills(final List<String> players, final List<String> lines) {
        if (init(players)) return Collections.emptyMap();
        reset(players);
        this.getEachKillsInTheGame(players, lines);
        return kills;
    }

    private boolean init(List<String> players) {
        if (players.isEmpty()) {
            return true;
        }
        kills = new HashMap<>();
        worldKillsCount = 0;
        userKillsCount = 0;
        return false;
    }

    private void reset(List<String> players) {
        for (String player : players) {
            kills.put(player, 0);
        }
    }


    private void getEachKillsInTheGame(List<String> players, List<String> lines) {
        for (String line : lines) {
            if (line.contains(KILL_PATTERN)) {

                String targetPlayer = extractTargetName(line);

                userLoop:
                for (String player : players) {

                    if (setUpKillHimself(targetPlayer, player)) continue;

                    if (setUpWorldKill(line, targetPlayer)) break userLoop;

                    if (setUpWorldKillIncrease(targetPlayer)) break userLoop;

                    if (setUpKillOtherPlayer(line, targetPlayer, player)) break userLoop;
                }
            }
        }
    }

    private boolean setUpKillOtherPlayer(String line, String targetPlayer, String player) {
        boolean retorno = false;
        if (line.contains(player + KILLED_PATTERN)) {
            setKilledPlayer(player);
            subtractKill(targetPlayer);
            userKillsCount++;
            retorno = true;
        }
        return retorno;
    }

    private boolean setUpWorldKillIncrease(String targetPlayer) {
        boolean retorno = false;
        if (targetPlayer.equals(WORLD)) {
            worldKillsCount++;
            retorno = true;
        }
        return retorno;
    }

    private boolean setUpWorldKill(String line, String targetPlayer) {
        boolean retorno = false;
        if (line.contains(WORLD + KILLED_PATTERN)) {
            subtractKill(targetPlayer);
            retorno = true;
        }
        return retorno;
    }

    private boolean setUpKillHimself(String targetPlayer, String player) {
        boolean retorno = false;
        if (player.equals(targetPlayer)) {
            retorno = true;
        }
        return retorno;
    }

    public int getTotalOfKills() {
        return userKillsCount + worldKillsCount;
    }

    private void subtractKill(final String targetName) {
        Integer targetCount = kills.get(targetName);
        targetCount--;
        kills.put(targetName, targetCount);
    }

    private void setKilledPlayer(final String user) {
        Integer killCount = kills.get(user);
        killCount++;
        kills.put(user, killCount);
    }

    private String extractTargetName(final String line) {
        return line.substring(line.lastIndexOf(KILLED_PATTERN) + KILLED_PATTERN.length(), line.indexOf(BY_DELIMITER)).trim();
    }
}
