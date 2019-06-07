package br.com.quake.parser.api.service;

import br.com.quake.parser.api.data.local.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameNameService {

    @Autowired
    private PlayerNameService playerNameService;

    private Integer quantidadeJogos = 0;


    public String getGameName(String itemGameLog) {

        if (isInitGame(itemGameLog)) {
            quantidadeJogos++;
        }


        String player = playerNameService.getPlayerName(itemGameLog);
        System.out.println(Constants.GAME_NUMBER + quantidadeJogos + " ---- " + player);


        return Constants.GAME_NUMBER + quantidadeJogos;
    }


    private boolean isInitGame(String itemGameLog) {
        return itemGameLog.contains(Constants.INIT_GAME);
    }

}
