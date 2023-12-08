package fr.polytech.backend_exam.service;

import fr.polytech.backend_exam.dto.request.RestaurantDtoCreate;
import fr.polytech.backend_exam.dto.request.RestaurantDtoUpdate;
import fr.polytech.backend_exam.entity.EvaluationEntity;
import fr.polytech.backend_exam.entity.RestaurantEntity;
import fr.polytech.backend_exam.exception.ResourceNotFoundException;
import fr.polytech.backend_exam.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public List<RestaurantEntity> getRestaurants() {
        return restaurantRepository.findAll();
    }

    public RestaurantEntity getRestaurant(Integer id) {
        return restaurantRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("L'ID du restaurant est introuvable")
        );
    }

    public RestaurantEntity addRestaurant(RestaurantDtoCreate restaurantDtoCreate) {
        final RestaurantEntity restaurantEntity = RestaurantEntity.builder()
                .nom(restaurantDtoCreate.getNom())
                .adresse(restaurantDtoCreate.getAdresse())
                .tags(restaurantDtoCreate.getTags())
                .build();

        restaurantRepository.save(restaurantEntity);
        return restaurantEntity;
    }

    public RestaurantEntity editRestaurant(Integer id, RestaurantDtoUpdate restaurantDtoUpdate) {
        final RestaurantEntity restaurant = this.getRestaurant(id);

        if(restaurantDtoUpdate.getNom() != null) restaurant.setNom(restaurantDtoUpdate.getNom());
        if(restaurantDtoUpdate.getTags() != null) restaurant.setTags(restaurantDtoUpdate.getTags());
        if(restaurantDtoUpdate.getAdresse() != null) restaurant.setAdresse(restaurantDtoUpdate.getAdresse());

        restaurantRepository.save(restaurant);

        return restaurant;
    }

    public String deleteRestaurant(Integer id) {
        RestaurantEntity restaurant = this.getRestaurant(id);
        for(EvaluationEntity evaluation : restaurant.getEvaluations()) {
            restaurant.getEvaluations().remove(evaluation);
        }
        this.restaurantRepository.delete(restaurant);
        return "Le restaurant " + id +" vient d'être supprimé";
    }
}
