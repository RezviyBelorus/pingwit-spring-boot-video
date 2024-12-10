package com.pingwit.part_52.controller;

import com.pingwit.part_52.dto.FlowerDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/flowers")
@Validated
public class FlowerController {

    private static final List<FlowerDTO> FLOWERS = new ArrayList<>();

    @GetMapping
    public List<FlowerDTO> getAllFlowers() {
        return FLOWERS;
    }

    @PostMapping
    public FlowerDTO addFlower(@Valid @RequestBody FlowerDTO flowerDTO) {
        FLOWERS.add(flowerDTO);
        return flowerDTO;
    }

    @GetMapping("/{name}")
    public ResponseEntity<FlowerDTO> getFlowerByName(@PathVariable @Size(min = 3, message = "Slishkom malo bukov") String name) {
        return FLOWERS.stream()
                .filter(flower -> flower.getName().equalsIgnoreCase(name))
                .map(ResponseEntity::ok)
                .findFirst()
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{name}")
    public ResponseEntity<String> updateFlower(@PathVariable String name, @RequestBody FlowerDTO flowerDTO) {
        return FLOWERS.stream()
                .filter(flower -> flower.getName().equalsIgnoreCase(name))
                .findFirst()
                .map(flower -> update(flowerDTO, flower))
                .map(flower -> "Flower has been updated: " + flower.getName())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flower with name " + name + " has not been found"));
    }

    private FlowerDTO update(FlowerDTO dto, FlowerDTO entity) {
        entity.setName(dto.getName());
        entity.setType(dto.getType());
        entity.setPrice(dto.getPrice());
        entity.setQuantity(dto.getQuantity());

        return entity;
    }
}
