package fr.polytech.backend_exam.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationFinaleDtoCreate {

    @NotNull(message = "decideur may not be null")
    @JsonProperty("decideur")
    private String decideur;

    @NotNull(message = "noteFinale may not be null")
    @JsonProperty("noteFinale")
    private Integer noteFinale;

    @NotNull(message = "qualites may not be null")
    @JsonProperty("qualites")
    private String qualites;
}