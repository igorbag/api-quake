package br.com.quake.parser.api.controller;

import br.com.quake.parser.api.model.Game;
import br.com.quake.parser.api.service.QuakeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/game")
public class QuakeInfoController {

    @Autowired
    private QuakeInfoService quakeInfoService;

    @RequestMapping(method = RequestMethod.GET)
    public Map<String, Game> getGameInfo() {
        return quakeInfoService.getGameInfo();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Game quakeInfoById(@PathVariable Integer id) {
        return quakeInfoService.getGameInfoById(id);
    }
}
