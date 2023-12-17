package dev.hikari.oishibasho.domain.rating.service;

import dev.hikari.oishibasho.app.exception.ApiException;
import dev.hikari.oishibasho.domain.food.entity.Food;
import dev.hikari.oishibasho.domain.food.repository.FoodRepository;
import dev.hikari.oishibasho.domain.rating.dto.response.RatingsResponse;
import dev.hikari.oishibasho.domain.rating.entity.Rating;
import dev.hikari.oishibasho.domain.rating.repository.RatingRepository;
import dev.hikari.oishibasho.infrastructure.utilies.MessageCode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;
    private final FoodRepository foodRepository;

    public RatingService(RatingRepository ratingRepository, FoodRepository foodRepository) {
        this.ratingRepository = ratingRepository;
        this.foodRepository = foodRepository;
    }

    public List<RatingsResponse> getListRating(Integer id) {
        Food food = foodRepository.findById(id).orElse(null);
        if (food == null)throw new ApiException(MessageCode.ID_NOT_FOUND);

        List<Rating> ratings = ratingRepository.findByFood(food);
        List<RatingsResponse> response = new ArrayList<>();
        for (Rating item : ratings){
            RatingsResponse rspItem = RatingsResponse.builder()
                    .id(item.getId())
                    .star(item.getStar())
                    .username(item.getUser().getName())
                    .review(item.getReview())
                    .build();
            response.add(rspItem);
        }
        return response;
    }
}
