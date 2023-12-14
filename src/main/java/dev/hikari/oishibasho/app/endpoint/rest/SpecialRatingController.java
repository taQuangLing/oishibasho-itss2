package dev.hikari.oishibasho.app.endpoint.rest;

import dev.hikari.oishibasho.app.service.ResponseFactory;
import dev.hikari.oishibasho.domain.special_rating.dto.response.SpecialRatingResponse;
import dev.hikari.oishibasho.domain.special_rating.service.SpecialRatingService;
import dev.hikari.oishibasho.infrastructure.dto.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/special-ratings")
public class SpecialRatingController {
    private final SpecialRatingService specialRatingService;

    public SpecialRatingController(SpecialRatingService specialRatingService) {
        this.specialRatingService = specialRatingService;
    }

    @GetMapping("/{food_id}")
    public ResponseEntity<?> getSpecialRating(
            @PathVariable(name = "food_id") Integer id
    ){
        return ResponseFactory.response(specialRatingService.getSpecialRating(id));
    }
}
