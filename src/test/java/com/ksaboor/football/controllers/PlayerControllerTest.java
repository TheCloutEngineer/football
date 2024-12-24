package com.ksaboor.football.controllers;

import com.ksaboor.football.services.FootballService;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(value = PlayerController.class)
class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private final FootballService footballService;

    PlayerControllerTest(FootballService footballService) {
        this.footballService = footballService;
    }


}