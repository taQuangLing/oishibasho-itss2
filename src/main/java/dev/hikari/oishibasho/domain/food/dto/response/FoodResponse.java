package dev.hikari.oishibasho.domain.food.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FoodResponse {
    private Integer id;
    private String name;
    private String address;
    private Integer price;
    private String image;
    private Double latitude;
    private Double longitude;
    private Integer visitCount;
}
