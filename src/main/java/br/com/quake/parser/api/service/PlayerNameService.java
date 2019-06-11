package br.com.quake.parser.api.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static br.com.quake.parser.api.data.local.Constants.*;

@Service
public class PlayerNameService {

    public List<String> getPlayersName(final List<String> listItemGame) {
        List<String> players = new ArrayList();
        for (String itemGame : listItemGame) {
            if (itemGame.contains(CLIENT_USER_INFO)) {
                String userName = itemGame.substring(itemGame.indexOf(N_DELIMITER) + 2, itemGame.indexOf(T_DELIMITER));
                if (!players.contains(userName)) {
                    players.add(userName);
                }
            }
        }
        return players;
    }

}
