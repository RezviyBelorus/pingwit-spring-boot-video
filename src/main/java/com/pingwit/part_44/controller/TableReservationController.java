package com.pingwit.part_44.controller;

import com.pingwit.part_44.service.TableReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservation/table")
@RequiredArgsConstructor
public class TableReservationController {

    private final TableReservationService tableReservationService;

    @GetMapping
    public String getTableRestaurantSchema() {
        return tableReservationService.getTableRestaurantSchema();
    }

    @PutMapping("/{tableNumber}")
    public String reserveTable(@PathVariable int tableNumber) {
        return tableReservationService.reserveTable(tableNumber);
    }

    @PutMapping("/cancel/{tableNumber}")
    public String cancelReservation(@PathVariable int tableNumber) {
        return tableReservationService.cancelReservation(tableNumber);
    }
}
