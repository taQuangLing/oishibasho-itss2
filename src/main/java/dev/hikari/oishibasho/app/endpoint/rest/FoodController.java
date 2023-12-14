package dev.hikari.oishibasho.app.endpoint.rest;

import dev.hikari.oishibasho.app.service.ResponseFactory;
import dev.hikari.oishibasho.domain.food.dto.request.DishesUpdatedRequest;
import dev.hikari.oishibasho.domain.food.dto.response.FoodResponse;
import dev.hikari.oishibasho.domain.food.service.FoodService;
import dev.hikari.oishibasho.infrastructure.dto.response.BaseResponse;
import dev.hikari.oishibasho.infrastructure.dto.response.ResponseList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/foods")
public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("")
    public ResponseEntity<ResponseList<FoodResponse>> getListFood(
            @RequestParam(name = "period_id", required = false) Integer periodId,
            @RequestParam(name = "price_from", required = false) Integer priceFrom,
            @RequestParam(name = "price_to", required = false) Integer priceTo,
            @RequestParam(name = "address", required = false) String address,
            @RequestParam(name = "latitude", required = false) Double latitude,
            @RequestParam(name = "longitude", required = false) Double longitude
    ){
        List<FoodResponse> rsp = foodService.getListFood(
                periodId, priceFrom, priceTo, address, latitude, longitude);
        return ResponseFactory.response(rsp);
    }
    @PutMapping("/{id}/change")
    public ResponseEntity<BaseResponse> changeDishes(
            @PathVariable("id") Integer id,
            @RequestBody DishesUpdatedRequest request
    ){
        request.setId(id);
        return ResponseFactory.response(foodService.changeDishes(request));
    }

    @PutMapping("/{id}/details")
    public ResponseEntity<?> dishDetailsAction(
            @PathVariable("id") Integer id,
            @RequestBody DishesUpdatedRequest request
    ){
        request.setId(id);
        return ResponseFactory.response(foodService.dishDetailsAction(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDishDetails(@PathVariable("id") Integer id){
        return ResponseFactory.response(foodService.getDishDetails(id));
    }


}
