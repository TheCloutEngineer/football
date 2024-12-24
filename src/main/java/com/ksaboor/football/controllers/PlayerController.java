package com.ksaboor.football.controllers;

import com.ksaboor.football.models.Player;
import com.ksaboor.football.services.FootballService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(PlayerController.BASE_PATH)
public class PlayerController {

    public static final String BASE_PATH = "/players";
    private final FootballService footballService;

    public PlayerController(FootballService footballService) {
        this.footballService = footballService;
    }

    @GetMapping
    public List<Player> listPlayers() {
        return footballService.listPlayers();
    }

    @GetMapping("/{playerId}")
    public Player getPlayerById(@PathVariable final String playerId) {
        return footballService.getPlayer(playerId);
    }

    @PostMapping
    public Player createPlayer(@RequestBody final Player player) {
        return footballService.addPlayer(player);
    }

    @PutMapping("/{playerId}")
    public Player updatePlayer(@PathVariable final String playerId,
                               @RequestBody final Player player) {
        return footballService.updatePlayer(player);
    }

    @DeleteMapping("/{playerId}")
    public String deletePlayer(@PathVariable final String playerId) {
        return footballService.deletePlayer(playerId);
    }
}