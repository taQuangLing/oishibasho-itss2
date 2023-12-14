package dev.hikari.oishibasho.domain.rating.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RatingsResponse {
    private Integer id;
    private String username;
    private String review;
    private Integer star;
}
