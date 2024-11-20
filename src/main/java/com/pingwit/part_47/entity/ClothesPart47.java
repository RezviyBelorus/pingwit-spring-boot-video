package com.pingwit.part_47.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clothes")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ClothesPart47 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String article;
    private String size;
    private Integer quantity;
    private String description;

    @ManyToMany(mappedBy = "clothes")
    private List<OrderPart47> orders = new ArrayList<>();
}
