package com.pingwit.part_44.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Repository
public class TableReservationRepository {

    private String restaurantTableSchema;

    @PostConstruct
    private void init() throws IOException {
        List<String> restaurantTableSchemaLines = Files.readAllLines(Path.of("src/main/resources/part_44/restaurant.txt"));

        restaurantTableSchema = String.join("\n", restaurantTableSchemaLines);
    }

    public String getRestaurantTableSchema() {
        return restaurantTableSchema;
    }

    public String save(String restaurantTableSchema) {
        this.restaurantTableSchema = restaurantTableSchema;
        return getRestaurantTableSchema();
    }
}
