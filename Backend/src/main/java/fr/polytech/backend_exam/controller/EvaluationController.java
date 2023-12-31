package fr.polytech.backend_exam.controller;

import fr.polytech.backend_exam.dto.request.EvaluationDtoCreate;
import fr.polytech.backend_exam.dto.request.EvaluationDtoUpdate;
import fr.polytech.backend_exam.dto.response.EvaluationDto;
import fr.polytech.backend_exam.service.EvaluationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EvaluationController {

    private final EvaluationService evaluationService;

    @GetMapping("/evaluations")
    public @ResponseBody List<EvaluationDto> getEvaluations() {
        return evaluationService.getEvaluations().stream().map(
                EvaluationDto::convertEntitytoDto
        ).toList();
    }

    @GetMapping("/evaluations/{id}")
    public @ResponseBody EvaluationDto getEvaluation(@PathVariable Integer id) {
        return EvaluationDto.convertEntitytoDto(evaluationService.getEvaluation(id));
    }

    @PostMapping("/evaluations")
    public @ResponseBody EvaluationDto addEvaluation(@Valid @RequestBody EvaluationDtoCreate evaluationDtoCreate) {
        return EvaluationDto.convertEntitytoDto(evaluationService.addEvaluation(evaluationDtoCreate));
    }

    @PutMapping("/evaluations/{id}")
    public @ResponseBody EvaluationDto editEvaluation(@PathVariable Integer id, @Valid @RequestBody EvaluationDtoUpdate evaluationDtoUpdate) {
        return EvaluationDto.convertEntitytoDto(evaluationService.editEvaluation(id, evaluationDtoUpdate));
    }

    @DeleteMapping("/evaluations/{id}")
    public @ResponseBody String deleteEvaluation(@PathVariable Integer id) {
        return this.evaluationService.deleteEvaluation(id);
    }

    @GetMapping("/evaluations/{id}/get_image_url")
    public @ResponseBody List<String> getRestaurantGetImageUrl(@PathVariable Integer id) {
        return this.evaluationService.getEvaluationGetImageUrls(id);
    }

    @GetMapping("/evaluations/{id}/put_image_url")
    public @ResponseBody String getRestaurantPutImageUrl(@PathVariable Integer id) {
        return this.evaluationService.getEvaluationPutImageUrl(id);
    }

}
