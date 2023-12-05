package dev.hikari.oishibasho.domain.rating.entity;

import dev.hikari.oishibasho.domain.food.entity.Food;
import dev.hikari.oishibasho.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "ratings")
@Builder
@Data
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer star;

    @Column(columnDefinition = "text")
    private String review;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

}