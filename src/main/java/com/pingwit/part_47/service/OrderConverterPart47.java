package com.pingwit.part_47.service;

import com.pingwit.part_46.dto.ClothesDto;
import com.pingwit.part_46.dto.OrderDto;
import com.pingwit.part_47.entity.ClothesPart47;
import com.pingwit.part_47.entity.OrderPart47;
import com.pingwit.part_47.service.ClothesConverterPart47;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderConverterPart47 {

    private final ClothesConverterPart47 clothesConverter;

    public List<OrderDto> toDto(List<OrderPart47> orders) {
        return orders.stream()
                .map(this::toDto)
                .toList();
    }

    public OrderDto toDto(OrderPart47 order) {
        OrderDto dto = new OrderDto();
        dto.setId(order.getId());
        dto.setAddress(order.getAddress());
        dto.setEmail(order.getEmail());

        List<ClothesDto> clothes = clothesConverter.toDto(order.getClothes());
        dto.setClothes(clothes);

        return dto;
    }

    public List<OrderPart47> toEntity(List<OrderDto> ordersDto) {
        return ordersDto.stream()
                .map(this::toEntity)
                .toList();
    }

    public OrderPart47 toEntity(OrderDto dto) {
        OrderPart47 order = new OrderPart47();
        order.setId(dto.getId());
        order.setAddress(dto.getAddress());
        order.setEmail(dto.getEmail());

        List<ClothesPart47> clothes = clothesConverter.toEntity(dto.getClothes());
        order.setClothes(clothes);

        return order;
    }
}
