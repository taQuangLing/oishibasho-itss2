package dev.hikari.oishibasho.domain.special_rating.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpecialRatingResponse {
    private Integer id;
    private String username;
    private String review;
    private String video;
    private Integer star;
}
