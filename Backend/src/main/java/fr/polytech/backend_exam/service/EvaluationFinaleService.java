package fr.polytech.backend_exam.service;

import fr.polytech.backend_exam.dto.request.EvaluationFinaleDtoCreate;
import fr.polytech.backend_exam.dto.request.EvaluationFinaleDtoUpdate;
import fr.polytech.backend_exam.entity.EvaluationFinaleEntity;
import fr.polytech.backend_exam.exception.ResourceNotFoundException;
import fr.polytech.backend_exam.repository.EvaluationFinaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EvaluationFinaleService {
    private final EvaluationFinaleRepository evaluationFinaleRepository;

    public List<EvaluationFinaleEntity> getEvaluationsFinales() {
        return evaluationFinaleRepository.findAll();
    }

    public EvaluationFinaleEntity getEvaluationFinale(Integer id) {
        return evaluationFinaleRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("L'ID de l'évaluation finale est introuvable")
        );
    }

    public EvaluationFinaleEntity addEvaluationFinale(EvaluationFinaleDtoCreate evaluationFinaleDtoCreate) {
        final EvaluationFinaleEntity evaluationFinaleEntity = EvaluationFinaleEntity.builder()
                .decideur(evaluationFinaleDtoCreate.getDecideur())
                .noteFinale(evaluationFinaleDtoCreate.getNoteFinale())
                .qualites(evaluationFinaleDtoCreate.getQualites())
                .build();

        evaluationFinaleRepository.save(evaluationFinaleEntity);
        return evaluationFinaleEntity;
    }

    public EvaluationFinaleEntity editEvaluationFinale(Integer id, EvaluationFinaleDtoUpdate evaluationFinaleDtoUpdate) {
        final EvaluationFinaleEntity evaluationFinale = this.getEvaluationFinale(id);

        if(evaluationFinaleDtoUpdate.getNoteFinale() != null) evaluationFinale.setNoteFinale(evaluationFinaleDtoUpdate.getNoteFinale());
        if(evaluationFinaleDtoUpdate.getDecideur() != null) evaluationFinale.setDecideur(evaluationFinaleDtoUpdate.getDecideur());
        if(evaluationFinaleDtoUpdate.getQualites() != null) evaluationFinale.setQualites(evaluationFinaleDtoUpdate.getQualites());

        evaluationFinaleRepository.save(evaluationFinale);

        return evaluationFinale;
    }

    public String deleteEvaluationFinale(Integer id) {
        EvaluationFinaleEntity evaluation = this.getEvaluationFinale(id);

        this.evaluationFinaleRepository.delete(evaluation);
        return "L'évaluation finale " + id +" vient d'être supprimé";
    }
}
