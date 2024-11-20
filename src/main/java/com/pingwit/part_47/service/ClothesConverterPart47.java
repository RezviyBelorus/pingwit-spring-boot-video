package com.pingwit.part_47.service;

import com.pingwit.part_46.dto.ClothesDto;
import com.pingwit.part_47.entity.ClothesPart47;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClothesConverterPart47 {

    public List<ClothesPart47> toEntity(List<ClothesDto> dtos) {
        return dtos.stream()
                .map(this::toEntity)
                .toList();
    }

    public ClothesPart47 toEntity(ClothesDto dto) {
        ClothesPart47 entity = new ClothesPart47();
        entity.setId(dto.getId());
        entity.setSize(dto.getSize());
        entity.setArticle(dto.getArticle());
        entity.setQuantity(dto.getQuantity());
        entity.setDescription(dto.getDescription());

        return entity;
    }

    public List<ClothesDto> toDto(List<ClothesPart47> entities) {
        return entities.stream()
                .map(this::toDto)
                .toList();
    }

    public ClothesDto toDto(ClothesPart47 entity) {
        ClothesDto dto = new ClothesDto();
        dto.setId(entity.getId());
        dto.setSize(entity.getSize());
        dto.setArticle(entity.getArticle());
        dto.setQuantity(entity.getQuantity());
        dto.setDescription(entity.getDescription());

        return dto;
    }
}
