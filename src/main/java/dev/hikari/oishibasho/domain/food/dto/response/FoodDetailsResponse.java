package dev.hikari.oishibasho.domain.food.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FoodDetailsResponse {
    private Integer id;
    private String name;
    private String address;
    private Integer price;
    private String image;
    private String description;
    private String restaurantName;
}
