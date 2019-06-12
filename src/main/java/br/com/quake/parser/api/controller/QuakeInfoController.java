package br.com.quake.parser.api.controller;

import br.com.quake.parser.api.model.Game;
import br.com.quake.parser.api.service.QuakeInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Api(value = "Game", description = "Controller responsável por expor informacoes das partidas do quake")
@RequestMapping("/game")
public class QuakeInfoController {

    @Autowired
    private QuakeInfoService quakeInfoService;

    @ApiOperation(value = "Responsavel por buscar todos as partidas do quake 3")
    @ApiResponses(value = @ApiResponse(code = 200, message = "Retornando todos os resultados", response = Game.class))
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Map<String, Game>> getGameInfo() {
        return ResponseEntity.ok(quakeInfoService.getGameInfo());
    }

    @ApiOperation(value = "Responsavel por buscar o jogo por id")
    @ApiResponses(value = @ApiResponse(code = 200, message = "Retornando somente somente um único registro", response = Game.class))
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Game> quakeInfoById(@PathVariable Integer id) {
        return ResponseEntity.ok(quakeInfoService.getGameInfoById(id));
    }
}
