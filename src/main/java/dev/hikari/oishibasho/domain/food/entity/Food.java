package dev.hikari.oishibasho.domain.food.entity;

import dev.hikari.oishibasho.domain.restaurant.entity.Restaurant;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "foods")
@Builder
@Data
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String name;

    @Column(columnDefinition = "text")
    private String description;

    private Integer price;

    @Column(length = 200)
    private String image;

    private Integer visitCount;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurantId;

    @Column(name = "period_id")
    private Integer periodId;

}