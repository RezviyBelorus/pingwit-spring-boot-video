package com.pingwit.part_46.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String address;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserPart46 user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "orders_clothes",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "clothes_id")
    )
    @Fetch(FetchMode.SUBSELECT)
//    @BatchSize(size = 10)
    private List<Clothes> clothes = new ArrayList<>();
}
