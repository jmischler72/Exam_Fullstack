package fr.polytech.backend_exam.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.backend_exam.enums.TagsEnum;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
    @Max(value = 90)
    @Min(value = 2)
    @JsonProperty("nom")
    private String nom;

    @NotNull(message = "adresse may not be null")
    @Max(value = 255)
    @Min(value = 2)
    @JsonProperty("adresse")
    private String adresse;

    @JsonProperty("tags")
    private List<TagsEnum> tags;

}