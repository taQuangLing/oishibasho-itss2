package dev.hikari.oishibasho.domain.special_rating.repository;

import dev.hikari.oishibasho.domain.food.entity.Food;
import dev.hikari.oishibasho.domain.special_rating.entity.SpecialRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecialRatingRepository extends JpaRepository<SpecialRating, Integer> {
    Optional<SpecialRating> findByFood(Food food);
}
