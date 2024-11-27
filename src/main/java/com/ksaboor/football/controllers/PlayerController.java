package com.ksaboor.football.controllers;

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
    public List<String> listPlayers() {
        return List.of("Jalen Hurts", "Saquon Barkley");
    }

    @GetMapping("/{name}")
    public String readPlayer(@PathVariable String name) {
        return name;
    }

    @PostMapping
    public String createPlayer(@RequestBody String name) {
        return "Player " + name + " created";
    }

    @DeleteMapping("/{name}")
    public String deletePlayer(@PathVariable String name) {
        return "Player " + name + " deleted";
    }

    @PutMapping("/{name}")
    public String updatePlayer(@PathVariable String name, @RequestBody String newName) {
        return "Player " + name + " updated to " + newName;
    }
}
