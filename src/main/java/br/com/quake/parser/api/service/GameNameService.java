package br.com.quake.parser.api.service;

import br.com.quake.parser.api.data.local.Constants;
import br.com.quake.parser.api.model.Game;
import org.springframework.stereotype.Service;

@Service
public class GameNameService {

    private Integer quantidadeJogos = 0;


    public void setUpGameName(String itemGameLog) {

        final Game game = new Game();
        if (isInitGame(itemGameLog)) {
            quantidadeJogos++;
            game.setGame(Constants.GAME_NUMBER + quantidadeJogos);
        }
    }

    private boolean isInitGame(String itemGameLog) {
        return itemGameLog.contains(Constants.INIT_GAME);
    }

}
