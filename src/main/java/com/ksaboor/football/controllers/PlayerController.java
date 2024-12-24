package com.ksaboor.football.controllers;

import com.ksaboor.football.exceptions.NotFoundException;
import com.ksaboor.football.models.Player;
import com.ksaboor.football.services.FootballService;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/players")
@RestController
public class PlayerController {
    private final FootballService footballService;

    public PlayerController(FootballService footballService) {
        this.footballService = footballService;
    }

    @GetMapping
    public List<Player> listPlayers() {
        return footballService.listPlayers();
    }

    @GetMapping("/{id}")
    public Player readPlayer(@PathVariable String id) {
        return footballService.getPlayer(id);
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return footballService.addPlayer(player);
    }

    @PutMapping("/{id}")
    public void updatePlayer(@PathVariable String id,
                             @RequestBody Player player) {
        footballService.updatePlayer(player);
    }

    @DeleteMapping("/{id}")
    public String deletePlayer(@PathVariable String id) {
        return footballService.deletePlayer(id);
    }


    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Not Found")
    @ExceptionHandler(NotFoundException.class)
    public void notFoundHandler() {

    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Already exist")
    @ExceptionHandler(BadRequestException.class)
    public void alreadyExistsHandler() {

    }
}
