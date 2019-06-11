package br.com.quake.parser.api.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static br.com.quake.parser.api.data.local.Constants.*;

@Service
public class GameService {


    public Map getGames(List<String> listGameLog) {
        Map games = new HashMap<String, List>();
        List gameData = new ArrayList<String>();

        boolean initGame = false;
        int gameMatch = 0;

        for (String itemGameLog : listGameLog) {


            if (!initGame && itemGameLog.contains(INIT_GAME)) {
                initGame = true;
            }

            if (initGame && itemGameLog.contains(END_GAME)) {
                initGame = false;
                games.put(GAME + gameMatch, new ArrayList<>(gameData));
                gameData.clear();
                gameMatch++;
            }

            gameData.add(itemGameLog);
        }

        return games;
    }
}
