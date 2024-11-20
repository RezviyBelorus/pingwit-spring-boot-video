package com.pingwit.part_46.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDto {
    private Long id;
    private String email;
    private String address;

    private List<ClothesDto> clothes = new ArrayList<>();
}
