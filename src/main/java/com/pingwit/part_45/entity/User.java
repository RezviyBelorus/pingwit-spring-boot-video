package com.pingwit.part_45.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private Double rating;
    private Double payment;
    private Boolean active;
    private String country;
    private String currency;
    private String bio;

//    private List<Order> orders = new ArrayList<>();
}
