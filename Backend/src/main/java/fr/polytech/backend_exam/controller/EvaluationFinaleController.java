package fr.polytech.backend_exam.controller;

import fr.polytech.backend_exam.dto.request.EvaluationFinaleDtoCreate;
import fr.polytech.backend_exam.dto.response.EvaluationFinaleDto;
import fr.polytech.backend_exam.service.EvaluationFinaleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EvaluationFinaleController {

    private final EvaluationFinaleService evaluationFinaleService;

    @GetMapping("/evaluationsFinales")
    public @ResponseBody List<EvaluationFinaleDto> getEvaluationsFinales() {
        return evaluationFinaleService.getEvaluationsFinales().stream().map(
                evaluation -> EvaluationFinaleDto.convertEntitytoDto(evaluation)
        ).toList();
    }

    @GetMapping("/evaluationsFinales/{id}")
    public @ResponseBody EvaluationFinaleDto getEvaluation(@PathVariable Integer id) {
        return EvaluationFinaleDto.convertEntitytoDto(evaluationFinaleService.getEvaluationFinale(id));
    }

    @PostMapping("/evaluationsFinales")
    public @ResponseBody EvaluationFinaleDto addEvaluation(@Valid @RequestBody EvaluationFinaleDtoCreate evaluationFinaleDtoCreate) {
        return EvaluationFinaleDto.convertEntitytoDto(evaluationFinaleService.addEvaluationFinale(evaluationFinaleDtoCreate));
    }

}
