package fr.polytech.backend_exam.controller;

import fr.polytech.backend_exam.dto.request.RestaurantDtoCreate;
import fr.polytech.backend_exam.dto.response.RestaurantDto;
import fr.polytech.backend_exam.service.RestaurantService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public @ResponseBody List<RestaurantDto> getRestaurants() {
        return restaurantService.getRestaurants().stream().map(
                restaurant -> RestaurantDto.convertEntitytoDto(restaurant)
        ).toList();
    }

    @GetMapping("/restaurants/{id}")
    public @ResponseBody RestaurantDto getRestaurant(@PathVariable Integer id) {
        return RestaurantDto.convertEntitytoDto(restaurantService.getRestaurant(id));
    }

    @PostMapping("/restaurants")
    public @ResponseBody RestaurantDto addRestaurant(@Valid @RequestBody RestaurantDtoCreate restaurantDtoCreate) {
        return RestaurantDto.convertEntitytoDto(restaurantService.addRestaurant(restaurantDtoCreate));
    }

}
