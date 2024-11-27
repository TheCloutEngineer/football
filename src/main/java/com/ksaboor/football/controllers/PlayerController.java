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

@RequestMapping("/players")
@RestController
public class PlayerController {
    private FootballService footballService;

    public PlayerController(FootballService footballService) {
        this.footballService = footballService;
    }

    @GetMapping
    public List<Player> listPlayers() {
        return footballService.listPlayers();
    }

    @GetMapping("/{name}")
    public Player readPlayer(@PathVariable String name) {
        return footballService.getPlayer(name);
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

    @DeleteMapping("/{name}")
    public String deletePlayer(@PathVariable String id) {
        return footballService.deletePlayer(id);
    }
}
