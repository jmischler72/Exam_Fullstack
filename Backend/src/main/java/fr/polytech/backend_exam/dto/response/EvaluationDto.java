package fr.polytech.backend_exam.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.backend_exam.entity.EvaluationEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("evaluateur")
    private String evaluateur;

    @JsonProperty("note")
    private Integer note;

    @JsonProperty("dateCreation")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateCreation;

    @JsonProperty("dateUpdate")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateUpdate;

    @JsonProperty("images")
    private Set<String> images;

    public static EvaluationDto convertEntitytoDto(final EvaluationEntity evaluationEntity) {
        return EvaluationDto.builder()
                .id(evaluationEntity.getId())
                .evaluateur(evaluationEntity.getEvaluateur())
                .note(evaluationEntity.getNote())
                .dateCreation(evaluationEntity.getDateCreation())
                .dateUpdate(evaluationEntity.getDateUpdate())
                .images(evaluationEntity.getImages())
                .build();
    }
}