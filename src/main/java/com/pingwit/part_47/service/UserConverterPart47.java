package com.pingwit.part_47.service;

import com.pingwit.part_46.dto.AvatarDto;
import com.pingwit.part_46.dto.OrderDto;
import com.pingwit.part_46.dto.UserDto;
import com.pingwit.part_47.entity.AvatarPart47;
import com.pingwit.part_47.entity.OrderPart47;
import com.pingwit.part_47.entity.UserPart47;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserConverterPart47 {

    private final OrderConverterPart47 orderConverter;

    public UserDto toDto(UserPart47 entity) {
        UserDto dto = new UserDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setRating(entity.getRating());
        dto.setPayment(entity.getPayment());
        dto.setActive(entity.getActive());
        dto.setCountry(entity.getCountry());
        dto.setCurrency(entity.getCurrency());
        dto.setBio(entity.getBio());

        if (entity.getAvatar() != null) {
            AvatarDto avatarDto = new AvatarDto();
            avatarDto.setId(entity.getAvatar().getId());
            avatarDto.setUrl(entity.getAvatar().getUrl());

            dto.setAvatar(avatarDto);
        }

        List<OrderDto> ordersDto = orderConverter.toDto(entity.getOrders());
        dto.setOrders(ordersDto);

        return dto;
    }

    public UserPart47 toEntity(UserDto dto) {
        UserPart47 entity = new UserPart47();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setRating(dto.getRating());
        entity.setPayment(dto.getPayment());
        entity.setActive(dto.getActive());
        entity.setCountry(dto.getCountry());
        entity.setCurrency(dto.getCurrency());
        entity.setBio(dto.getBio());

        if (dto.getAvatar() != null) {
            AvatarPart47 avatar = new AvatarPart47();
            avatar.setUrl(dto.getAvatar().getUrl());
            entity.setAvatar(avatar);
        }

        List<OrderPart47> orders = orderConverter.toEntity(dto.getOrders());
        entity.setOrders(orders);

        return entity;
    }
}
