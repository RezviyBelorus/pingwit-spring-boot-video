package com.pingwit.part_49.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pingwit.part_49.dto.JokeDto;
import com.pingwit.part_49.service.JokeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/joke")
@RequiredArgsConstructor
public class JokeController {

    private final JokeService jokeService;

    @GetMapping
    public JokeDto getJoke() throws JsonProcessingException {
        return jokeService.getJoke();
    }
}
