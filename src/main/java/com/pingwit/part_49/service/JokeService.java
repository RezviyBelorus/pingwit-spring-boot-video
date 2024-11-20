package com.pingwit.part_49.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pingwit.part_49.dto.JokeDto;
import com.pingwit.part_49.property.JokeProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class JokeService {
    private static final String JOKE_URL = "https://official-joke-api.appspot.com/random_joke";

    private final JokeProperties jokeProperties;
    private final RestClient restClient;
    private final ObjectMapper objectMapper;

    @Value("${api.jokes.url}")
    private String jokeUrl;

    public JokeDto getJoke() throws JsonProcessingException {
        int randomJokeServerIndex = getRandomJokeServerIndex();
        String url = jokeProperties.servers().get(randomJokeServerIndex).url();

        String response = restClient.get()
                .uri(url)
                .retrieve()
                .body(String.class);


        String joke = getJokeFromServerResponse(randomJokeServerIndex, response);
        String serverName = jokeProperties.servers().get(randomJokeServerIndex).name();

        return new JokeDto(serverName, joke);
    }

    private int getRandomJokeServerIndex() {
        Random random = new Random();
        return random.nextInt(jokeProperties.servers().size());
    }

    private String getJokeFromServerResponse(int randomJokeServerIndex, String response) throws JsonProcessingException {
        JsonNode responseTree = objectMapper.readTree(response);

        if (randomJokeServerIndex == 0) {
            JsonNode setup = responseTree.get("setup");
            JsonNode punchline = responseTree.get("punchline");
            return setup.textValue() + " " + punchline.textValue();
        }

        if (randomJokeServerIndex == 1) {
            return responseTree.get("value").asText();
        }

        if (randomJokeServerIndex == 2) {
            JsonNode setup = responseTree.get("setup");
            JsonNode delivery = responseTree.get("delivery");
            return setup.textValue() + " " + delivery.textValue();
        }

        throw new IllegalArgumentException("Incorrect joke server index");
    }

}
