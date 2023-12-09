package dev.hikari.oishibasho.domain.food.service;

import dev.hikari.oishibasho.domain.food.dto.request.DishesUpdatedRequest;
import dev.hikari.oishibasho.domain.food.dto.response.FoodResponse;
import dev.hikari.oishibasho.domain.food.entity.Food;
import dev.hikari.oishibasho.domain.food.repository.FoodRepository;
import dev.hikari.oishibasho.infrastructure.exception.ApiException;
import dev.hikari.oishibasho.infrastructure.exception.GlobalControllerExceptionHandler;
import dev.hikari.oishibasho.infrastructure.utilies.MessageCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService {
    private static final int GAP = 2;
    private final FoodRepository foodRepository;
    private static final Logger LOGGER = LogManager.getLogger(GlobalControllerExceptionHandler.class);
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<FoodResponse> getListFood(Integer periodId, Integer priceFrom, Integer priceTo, String address, Double latitude, Double longitude) {
        if (address != null){
            address = '%' + address + '%';
        }

        List<Food> foods = foodRepository.getFoodList(periodId, priceFrom, priceTo, address);
        List<FoodResponse> response = new ArrayList<>();

        for (Food item : foods){
            if (latitude != null && longitude != null){
                double longitudeFood = item.getRestaurant().getLongitude();
                double latitudeFood = item.getRestaurant().getLatitude();

                if (    (longitude - GAP > longitudeFood || longitude + GAP < longitudeFood) &&
                        (latitude - GAP < latitudeFood || latitude + GAP < latitudeFood)
                )continue;
            }
            FoodResponse rspItem = FoodResponse.builder()
                    .id(item.getId())
                    .price(item.getPrice())
                    .image(item.getImage())
                    .name(item.getName())
                    .visitCount(item.getVisitCount())
                    .address(item.getRestaurant().getAddress())
                    .longitude(item.getRestaurant().getLongitude())
                    .latitude(item.getRestaurant().getLatitude())
                    .build();
            response.add(rspItem);
        }
        return response;
    }

    public MessageCode changeDishes(DishesUpdatedRequest request) {
        Food food = foodRepository.findById(request.getId()).orElse(null);
        if (food != null){
            food.setVisitCount(food.getVisitCount() + 1);
            try {
                foodRepository.save(food);
                return MessageCode.SUCCESS;
            }catch (Exception e){
                LOGGER.warn(e);
                throw new ApiException(MessageCode.ERROR);
            }
        }else{
            throw new ApiException(MessageCode.FAIL);
        }
    }
}
