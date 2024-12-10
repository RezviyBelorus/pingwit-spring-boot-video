package com.pingwit.part_51.controller;

import com.pingwit.part_51.dto.CarSharingDto;
import com.pingwit.part_51.exception.CarSharingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/car/sharing")
public class CarSharingController {

    private static final Map<Long, String> CARS = Map.of(
            1L, "Toyota Corolla",
            2L, "Honda Civic",
            3L, "Ford Focus",
            4L, "Chevrolet Malibu",
            5L, "BMW 3 Series",
            6L, "Audi A4",
            7L, "Mercedes-Benz C-Class",
            8L, "Volkswagen Passat",
            9L, "Hyundai Elantra",
            10L, "Nissan Altima"
    );

    @GetMapping("/{id}")
    public CarSharingDto book(@PathVariable Long id) {
        String car = CARS.get(id);

        if (car == null) {
            throw new CarSharingException("We don't have that car available.");
        }

        return new CarSharingDto(id, car);
    }

}
