package dev.hikari.oishibasho.domain.rating.repository;

import dev.hikari.oishibasho.domain.food.entity.Food;
import dev.hikari.oishibasho.domain.rating.dto.response.RatingsResponse;
import dev.hikari.oishibasho.domain.rating.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
    List<Rating> findByFood(Food food);
}
