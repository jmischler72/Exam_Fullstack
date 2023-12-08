package fr.polytech.backend_exam.controller;

import fr.polytech.backend_exam.dto.request.EvaluationDtoCreate;
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
                evaluation -> EvaluationDto.convertEntitytoDto(evaluation)
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

}
