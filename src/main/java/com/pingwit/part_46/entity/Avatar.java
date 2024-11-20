package com.pingwit.part_46.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "avatars")
@Getter
@Setter
@ToString
public class Avatar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;

    @OneToOne(mappedBy = "avatar")
    private UserPart46 user;
}
