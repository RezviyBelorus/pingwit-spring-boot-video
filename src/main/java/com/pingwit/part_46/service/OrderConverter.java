package com.pingwit.part_46.service;

import com.pingwit.part_46.dto.ClothesDto;
import com.pingwit.part_46.dto.OrderDto;
import com.pingwit.part_46.entity.Clothes;
import com.pingwit.part_46.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderConverter {

    private final ClothesConverter clothesConverter;

    public List<OrderDto> toDto(List<Order> orders) {
        return orders.stream()
                .map(this::toDto)
                .toList();
    }

    public OrderDto toDto(Order order) {
        OrderDto dto = new OrderDto();
        dto.setId(order.getId());
        dto.setAddress(order.getAddress());
        dto.setEmail(order.getEmail());

        List<ClothesDto> clothes = clothesConverter.toDto(order.getClothes());
        dto.setClothes(clothes);

        return dto;
    }

    public List<Order> toEntity(List<OrderDto> ordersDto) {
        return ordersDto.stream()
                .map(this::toEntity)
                .toList();
    }

    public Order toEntity(OrderDto dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setAddress(dto.getAddress());
        order.setEmail(dto.getEmail());

        List<Clothes> clothes = clothesConverter.toEntity(dto.getClothes());
        order.setClothes(clothes);

        return order;
    }
}
