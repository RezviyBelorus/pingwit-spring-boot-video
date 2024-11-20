package com.pingwit.part_46.service;

import com.pingwit.part_46.dto.ClothesDto;
import com.pingwit.part_46.entity.Clothes;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClothesConverter {

    public List<Clothes> toEntity(List<ClothesDto> dtos) {
        return dtos.stream()
                .map(this::toEntity)
                .toList();
    }

    public Clothes toEntity(ClothesDto dto) {
        Clothes entity = new Clothes();
        entity.setId(dto.getId());
        entity.setSize(dto.getSize());
        entity.setArticle(dto.getArticle());
        entity.setQuantity(dto.getQuantity());
        entity.setDescription(dto.getDescription());

        return entity;
    }

    public List<ClothesDto> toDto(List<Clothes> entities) {
        return entities.stream()
                .map(this::toDto)
                .toList();
    }

    public ClothesDto toDto(Clothes entity) {
        ClothesDto dto = new ClothesDto();
        dto.setId(entity.getId());
        dto.setSize(entity.getSize());
        dto.setArticle(entity.getArticle());
        dto.setQuantity(entity.getQuantity());
        dto.setDescription(entity.getDescription());

        return dto;
    }
}
