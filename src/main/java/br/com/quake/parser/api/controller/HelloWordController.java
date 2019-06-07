package br.com.quake.parser.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class HelloWordController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity quakeInfo() {
        return ResponseEntity.badRequest()
                .body("Year of birth cannot be in the future");
    }
}
