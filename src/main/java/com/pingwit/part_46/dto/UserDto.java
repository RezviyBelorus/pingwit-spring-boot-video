package com.pingwit.part_46.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String name;
    private Integer age;
    private Double rating;
    private Double payment;
    private Boolean active;
    private String country;
    private String currency;
    private String bio;
    private AvatarDto avatar;
    private List<OrderDto> orders = new ArrayList<>();
}
