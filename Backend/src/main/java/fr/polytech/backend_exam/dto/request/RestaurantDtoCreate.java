package fr.polytech.backend_exam.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDtoCreate {

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("adresse")
    private String adresse;

}