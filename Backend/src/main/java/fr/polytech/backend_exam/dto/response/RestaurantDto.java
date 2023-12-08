package fr.polytech.backend_exam.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.backend_exam.entity.RestaurantEntity;
import fr.polytech.backend_exam.enums.TagsEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("adresse")
    private String adresse;

    @JsonProperty("evaluations")
    private List<EvaluationDto> evaluations;

    @JsonProperty("tags")
    private List<TagsEnum> tags;

    public static RestaurantDto convertEntitytoDto(final RestaurantEntity restaurantEntity) {
        return RestaurantDto.builder()
                .id(restaurantEntity.getId())
                .nom(restaurantEntity.getNom())
                .adresse(restaurantEntity.getAdresse())
                .evaluations(Optional.ofNullable(restaurantEntity.getEvaluations()).orElse(Collections.emptyList()).stream().map(
                        evaluationEntity -> EvaluationDto.convertEntitytoDto(evaluationEntity)).toList()
                )
                .tags(restaurantEntity.getTags())
                .build();
    }
}
