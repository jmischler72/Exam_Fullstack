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
public class ImageDto {

    @JsonProperty("url")
    private String url;

}
