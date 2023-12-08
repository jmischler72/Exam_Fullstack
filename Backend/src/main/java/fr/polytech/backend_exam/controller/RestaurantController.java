package fr.polytech.backend_exam.controller;

import fr.polytech.backend_exam.dto.request.RestaurantDtoCreate;
import fr.polytech.backend_exam.dto.request.RestaurantDtoUpdate;
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


    @PutMapping("/restaurants/{id}")
    public @ResponseBody RestaurantDto editRestaurant(@PathVariable Integer id, @Valid @RequestBody RestaurantDtoUpdate restaurantDtoUpdate) {
        return RestaurantDto.convertEntitytoDto(restaurantService.editRestaurant(id, restaurantDtoUpdate));
    }

    @DeleteMapping("/restaurants/{id}")
    public @ResponseBody String deleteRestaurant(@PathVariable Integer id) {
        return this.restaurantService.deleteRestaurant(id);
    }

//    @PutMapping("/acteurs/{id}/image")
//    public @ResponseBody MessageDto putImage(@PathVariable Integer id) {
//        return MessageDto.builder()
//                .code("GET_IMAGE_URL")
//                .message(this.acteurService.putImage(id))
//                .build();
//    }
//
//    @GetMapping("/acteurs/{id}/image")
//    public @ResponseBody MessageDto getImage(@PathVariable Integer id) {
//        return MessageDto.builder()
//                .code("GET_IMAGE_URL")
//                .message(this.acteurService.getImage(id))
//                .build();
//    }
}
