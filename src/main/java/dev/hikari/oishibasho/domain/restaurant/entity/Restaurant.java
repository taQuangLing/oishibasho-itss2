package dev.hikari.oishibasho.domain.restaurant.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "restaurants")
@Builder
@Data
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String address;

    @Column(columnDefinition = "text")
    private String description;

    private Double latitude;

    private Double longitude;

}