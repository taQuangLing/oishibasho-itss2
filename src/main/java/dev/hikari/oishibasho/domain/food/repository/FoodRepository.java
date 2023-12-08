package dev.hikari.oishibasho.domain.food.repository;

import dev.hikari.oishibasho.domain.food.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
    @Query(value = "select foods.* from foods, restaurants where foods.restaurant_id = restaurants.id " +
            "and (:periodId is null or :periodId = foods.period_id) " +
            "and (:priceFrom is null or :priceFrom <= price) " +
            "and (:priceTo is null or price <= :priceTo) " +
            "and (:address is null or address like :address)",
            nativeQuery = true
    )
    List<Food> getFoodList(Integer periodId, Integer priceFrom, Integer priceTo, String address);
}
