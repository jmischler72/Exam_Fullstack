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
public class EvaluationDtoCreate {

    @NotNull(message = "evaluateur may not be null")
    @JsonProperty("evaluateur")
    private String evaluateur;

    @NotNull(message = "commentaire may not be null")
    @JsonProperty("commentaire")
    private String commentaire;

    @NotNull(message = "note may not be null")
    @JsonProperty("note")
    private Integer note;
}