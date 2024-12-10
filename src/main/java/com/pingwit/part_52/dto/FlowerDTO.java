package com.pingwit.part_52.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FlowerDTO {
    @NotBlank(message = "Flower must not be empty")
    private String name;

    @NotBlank(message = "Flower type must not be empty")
    private String type;

    @NotNull(message = "Price must not be null")
    @Min(value = 0, message = "Price cannot be negative")
    //@Positive
    private Double price;

    @NotNull(message = "Quantity must not be null")
    @Min(value = 0, message = "Quantity cannot be negative")
    private Integer quantity;
}
