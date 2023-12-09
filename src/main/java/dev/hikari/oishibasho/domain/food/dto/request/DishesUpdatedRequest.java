package dev.hikari.oishibasho.domain.food.dto.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DishesUpdatedRequest {
    private Integer id;
    private Object data;
}
