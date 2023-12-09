package dev.hikari.oishibasho.domain.food.repository;

import dev.hikari.oishibasho.domain.food.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
    @Query(value = """
            select f.*, (0.8 * star_count.star + 0.2 * visit_count) as level_palatability
                from
                    foods f, restaurants, (
                        select f.id, case
                            when (sum(r.star) + sum(sr.star)) is null then 0
                            else  (sum(r.star) + sum(sr.star))
                        end
                        as star from
                        foods f full join ratings r
                        on f.id = r.food_id
                        full join special_ratings sr
                        on sr.food_id = f.id
                        group by f.id
                    ) star_count
                where
                    f.restaurant_id = restaurants.id
                    and f.id = star_count.id
                    and (:periodId is null or :periodId = f.period_id)
                    and (:priceFrom is null or :priceFrom <= price)
                    and (:priceTo is null or price <= :priceTo)
                    and (:address is null or address like :address)
                    order by level_palatability desc
            """, nativeQuery = true)
    List<Food> getFoodList(Integer periodId, Integer priceFrom, Integer priceTo, String address);
}
