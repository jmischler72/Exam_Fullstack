package fr.polytech.backend_exam.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.backend_exam.entity.EvaluationEntity;
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

    @JsonProperty("moyenne_evaluation")
    private Integer moyenne_evaluation;

    @JsonProperty("evaluations")
    private List<EvaluationDto> evaluations;

    @JsonProperty("tags")
    private List<TagsEnum> tags;

    public static RestaurantDto convertEntitytoDto(final RestaurantEntity restaurantEntity) {
        List<Integer> notes = Optional.ofNullable(restaurantEntity.getEvaluations()).orElse(Collections.emptyList()).stream().map(
                EvaluationEntity::getNote
        ).toList();

        Integer moyenne_notes = 0;

        if(notes.size()>0){
            moyenne_notes = notes.stream().mapToInt(Integer::intValue).sum() / notes.size();
        }
        // C'est nul de faire le calcul ici mais j'ai plus le temps

        return RestaurantDto.builder()
                .id(restaurantEntity.getId())
                .nom(restaurantEntity.getNom())
                .adresse(restaurantEntity.getAdresse())
                .evaluations(Optional.ofNullable(restaurantEntity.getEvaluations()).orElse(Collections.emptyList()).stream().map(
                        EvaluationDto::convertEntitytoDto).toList()
                )
                .tags(restaurantEntity.getTags())
                .moyenne_evaluation(moyenne_notes)
                .build();
    }
}
