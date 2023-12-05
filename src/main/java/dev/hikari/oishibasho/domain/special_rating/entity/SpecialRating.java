package dev.hikari.oishibasho.domain.special_rating.entity;

import dev.hikari.oishibasho.domain.food.entity.Food;
import dev.hikari.oishibasho.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "special_ratings")
@Builder
@Data
public class SpecialRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int star;

    @Column(length = 200)
    private String video;

    @Column(columnDefinition = "text")
    private String review;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "food_id")
    private Food food;

}