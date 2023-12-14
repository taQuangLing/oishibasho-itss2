package dev.hikari.oishibasho.app.endpoint.rest;


import dev.hikari.oishibasho.app.service.ResponseFactory;
import dev.hikari.oishibasho.domain.rating.dto.response.RatingsResponse;
import dev.hikari.oishibasho.domain.rating.service.RatingService;
import dev.hikari.oishibasho.infrastructure.dto.response.ResponseList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/ratings")
public class RatingController {
    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("/{food_id}")
    public ResponseEntity<ResponseList<RatingsResponse>> getListRating(
            @PathVariable("food_id") Integer id
    ){
        return ResponseFactory.response(ratingService.getListRating(id));
    }
}
