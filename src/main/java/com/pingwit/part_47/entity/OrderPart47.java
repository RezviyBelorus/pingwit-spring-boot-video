package com.pingwit.part_47.entity;

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
public class OrderPart47 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String address;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserPart47 user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "orders_clothes",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "clothes_id")
    )
    @Fetch(FetchMode.SUBSELECT)
//    @BatchSize(size = 3)
    private List<ClothesPart47> clothes = new ArrayList<>();
}
