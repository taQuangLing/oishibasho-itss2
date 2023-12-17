package dev.hikari.oishibasho.domain.special_rating.service;

import dev.hikari.oishibasho.app.exception.ApiException;
import dev.hikari.oishibasho.domain.food.entity.Food;
import dev.hikari.oishibasho.domain.food.repository.FoodRepository;
import dev.hikari.oishibasho.domain.special_rating.dto.response.SpecialRatingResponse;
import dev.hikari.oishibasho.domain.special_rating.entity.SpecialRating;
import dev.hikari.oishibasho.domain.special_rating.repository.SpecialRatingRepository;
import dev.hikari.oishibasho.infrastructure.utilies.MessageCode;
import org.springframework.stereotype.Service;

@Service
public class SpecialRatingService {
    private final SpecialRatingRepository specialRatingRepository;
    private final FoodRepository foodRepository;

    public SpecialRatingService(SpecialRatingRepository specialRatingRepository, FoodRepository foodRepository) {
        this.specialRatingRepository = specialRatingRepository;
        this.foodRepository = foodRepository;
    }

    public SpecialRatingResponse getSpecialRating(Integer id) {
        Food food = foodRepository.findById(id).orElse(null);
        if (food == null)throw new ApiException(MessageCode.ID_NOT_FOUND);

        SpecialRating specialRating = specialRatingRepository.findByFood(food).orElse(null);
        if (specialRating == null)throw new ApiException(MessageCode.FAIL);
        return SpecialRatingResponse.builder()
                .id(specialRating.getId())
                .star(specialRating.getStar())
                .video(specialRating.getVideo())
                .review(specialRating.getReview())
                .username(specialRating.getUser().getName())
                .build();
    }
}
