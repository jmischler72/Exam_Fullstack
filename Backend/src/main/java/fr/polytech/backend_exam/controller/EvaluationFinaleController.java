package fr.polytech.backend_exam.controller;

import fr.polytech.backend_exam.dto.request.EvaluationFinaleDtoCreate;
import fr.polytech.backend_exam.dto.request.EvaluationFinaleDtoUpdate;
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
    public @ResponseBody EvaluationFinaleDto getEvaluationFinale(@PathVariable Integer id) {
        return EvaluationFinaleDto.convertEntitytoDto(evaluationFinaleService.getEvaluationFinale(id));
    }

    @PostMapping("/evaluationsFinales")
    public @ResponseBody EvaluationFinaleDto addEvaluationFinale(@Valid @RequestBody EvaluationFinaleDtoCreate evaluationFinaleDtoCreate) {
        return EvaluationFinaleDto.convertEntitytoDto(evaluationFinaleService.addEvaluationFinale(evaluationFinaleDtoCreate));
    }

    @PutMapping("/evaluationsFinales/{id}")
    public @ResponseBody EvaluationFinaleDto editEvaluationFinale(@PathVariable Integer id, @Valid @RequestBody EvaluationFinaleDtoUpdate evaluationFinaleDtoUpdate) {
        return EvaluationFinaleDto.convertEntitytoDto(evaluationFinaleService.editEvaluationFinale(id, evaluationFinaleDtoUpdate));
    }

    @DeleteMapping("/evaluationsFinales/{id}")
    public @ResponseBody String deleteEvaluationFinale(@PathVariable Integer id) {
        return this.evaluationFinaleService.deleteEvaluationFinale(id);
    }

}
