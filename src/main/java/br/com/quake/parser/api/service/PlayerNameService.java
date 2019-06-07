package br.com.quake.parser.api.service;

import org.springframework.stereotype.Service;

import static br.com.quake.parser.api.data.local.Constants.*;

@Service
public class PlayerNameService {

    public String getPlayerName(final String itemGameLog) {

        String playerName = "";

        if (itemGameLog.contains(CLIENT_USER_INFO)) {
            playerName = itemGameLog.substring(itemGameLog.indexOf(N_DELIMITER) + 2, itemGameLog.indexOf(T_DELIMITER));
        }

        return playerName;
    }

}
