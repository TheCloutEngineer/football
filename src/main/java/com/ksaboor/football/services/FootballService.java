package com.ksaboor.football.services;

import com.ksaboor.football.exceptions.AlreadyExistsException;
import com.ksaboor.football.exceptions.NotFoundException;
import com.ksaboor.football.models.Player;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FootballService {
    Map<String, Player> players = Map.ofEntries(
            Map.entry("1884823", new Player("1884823", 5, "Ivana ANDRES", "Defender", LocalDate.of(1994, 02, 04))),
            Map.entry("325636", new Player("325636", 11, "Alexia PUTELLA", "Midfielder", LocalDate.of(1994, 02, 04
            ))));

    public List<Player> listPlayers() {
        return new ArrayList<>(players.values());
    }

    public Player getPlayer(String id) {
        Player player = players.get(id);
        if (player == null) {
            throw new NotFoundException("Player not found");
        }
        return player;
    }

    public Player addPlayer(Player player) {
        if (players.containsKey(player.id())) {
            throw new AlreadyExistsException("The Player already exists");
        } else {
            players.put(player.id(), player);
            return player;
        }
    }

    public Player updatePlayer(Player player) {
        if (!players.containsKey(player.id())) {
            throw new NotFoundException("This player does not exist");
        } else {
            players.put(player.id(), player);
            return player;
        }
    }

    public String deletePlayer(String id) {
        if (players.containsKey(id)) {
            players.remove(id);
            return "Success Player deleted";
        }
        return "Player does not exist";
    }
}
