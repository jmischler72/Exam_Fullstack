package fr.polytech.backend_exam.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.backend_exam.enums.TagsEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDtoCreate {

    @NotNull(message = "nom may not be null")
    @JsonProperty("nom")
    private String nom;

    @NotNull(message = "adresse may not be null")
    @JsonProperty("adresse")
    private String adresse;

    @JsonProperty("tags")
    private List<TagsEnum> tags;

}