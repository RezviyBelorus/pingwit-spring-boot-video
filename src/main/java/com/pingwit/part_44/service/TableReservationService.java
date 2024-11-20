package com.pingwit.part_44.service;

import com.pingwit.part_44.repository.TableReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TableReservationService {

    private static final String TABLE_EMPTY_TEMPLATE = " $T%d  ";
    private static final String TABLE_RESERVED_TEMPLATE = "||R%d||";

    private final TableReservationRepository repository;

    public String getTableRestaurantSchema() {
        return repository.getRestaurantTableSchema();
    }

    public String reserveTable(int tableNumber) {
        String restaurantTableSchema = repository.getRestaurantTableSchema();

        String emptyTableInfo = String.format(TABLE_EMPTY_TEMPLATE, tableNumber);
        String reservedTableInfo = String.format(TABLE_RESERVED_TEMPLATE, tableNumber);

        if (restaurantTableSchema.contains(reservedTableInfo)) {
            return "This table is already reserved, please choose another one\n" + restaurantTableSchema;
        }

        restaurantTableSchema = restaurantTableSchema.replace(emptyTableInfo, reservedTableInfo);

        return repository.save(restaurantTableSchema);
    }

    public String cancelReservation(int tableNumber) {
        String restaurantTableSchema = repository.getRestaurantTableSchema();

        String emptyTableInfo = String.format(TABLE_EMPTY_TEMPLATE, tableNumber);
        String reservedTableInfo = String.format(TABLE_RESERVED_TEMPLATE, tableNumber);

        if (restaurantTableSchema.contains(emptyTableInfo)) {
            return "Table is already free to reserve\n" + restaurantTableSchema;
        }

        restaurantTableSchema = restaurantTableSchema.replace(reservedTableInfo, emptyTableInfo);

        return repository.save(restaurantTableSchema);
    }
}
