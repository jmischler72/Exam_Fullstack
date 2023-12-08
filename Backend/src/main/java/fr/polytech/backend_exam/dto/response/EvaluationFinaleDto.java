package fr.polytech.backend_exam.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.backend_exam.entity.EvaluationFinaleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationFinaleDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("decideur")
    private String decideur;

    @JsonProperty("noteFinale")
    private Integer noteFinale;

    @JsonProperty("qualites")
    private String qualites;

    public static EvaluationFinaleDto convertEntitytoDto(final EvaluationFinaleEntity evaluationFinaleEntity) {
        return EvaluationFinaleDto.builder()
                .id(evaluationFinaleEntity.getId())
                .decideur(evaluationFinaleEntity.getDecideur())
                .noteFinale(evaluationFinaleEntity.getNoteFinale())
                .qualites(evaluationFinaleEntity.getQualites())
                .build();
    }
}
