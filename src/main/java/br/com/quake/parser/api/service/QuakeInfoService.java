package br.com.quake.parser.api.service;

import br.com.quake.parser.api.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class QuakeInfoService {

    @Autowired
    private ReadLogService readLogService;

    @Autowired
    private GameService gameNameService;

    @Autowired
    private PlayerNameService playerNameService;

    @Autowired
    private KillInfoService killInfoService;

    public Map<String, Game> getGameInfo() {
        final List<String> listGamesLogs = readLogService.getGamesLog();
        final Map<String, List> gameMatches = gameNameService.getGames(listGamesLogs);
        Map<String, Game> games = new HashMap<>();

        for (Map.Entry<String, List> match : gameMatches.entrySet()) {
            games.put(match.getKey(), this.setUpGameInformations(match.getValue()));
        }

        return games;
    }


    public Game getGameInfoById(int id) {
        return getGameInfo().get("game_" + id);
    }


    public Game setUpGameInformations(final List<String> gameMatches) {
        List<String> players = playerNameService.getPlayersName(gameMatches);

        Map<String, Integer> kills = killInfoService.getKills(players, gameMatches);

        return new Game(
                killInfoService.getTotalOfKills(),
                players,
                kills
        );
    }
}
