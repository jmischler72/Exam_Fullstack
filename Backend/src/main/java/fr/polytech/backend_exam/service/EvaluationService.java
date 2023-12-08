package fr.polytech.backend_exam.service;

import fr.polytech.backend_exam.dto.request.EvaluationDtoCreate;
import fr.polytech.backend_exam.dto.request.EvaluationDtoUpdate;
import fr.polytech.backend_exam.entity.EvaluationEntity;
import fr.polytech.backend_exam.exception.ResourceNotFoundException;
import fr.polytech.backend_exam.repository.EvaluationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class EvaluationService {
    private final EvaluationRepository evaluationRepository;

    public List<EvaluationEntity> getEvaluations() {
        return evaluationRepository.findAll();
    }

    public EvaluationEntity getEvaluation(Integer id) {
        return evaluationRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("L'ID de l'évaluation est introuvable")
        );
    }

    public EvaluationEntity addEvaluation(EvaluationDtoCreate evaluationDtoCreate) {
        final EvaluationEntity evaluationEntity = EvaluationEntity.builder()
                .evaluateur(evaluationDtoCreate.getEvaluateur())
                .commentaire(evaluationDtoCreate.getCommentaire())
                .note(evaluationDtoCreate.getNote())
                .dateCreation(LocalDate.now())
                .dateUpdate(LocalDate.now())
                .build();

        evaluationRepository.save(evaluationEntity);
        return evaluationEntity;
    }

    public EvaluationEntity editEvaluation(Integer id, EvaluationDtoUpdate evaluationDtoUpdate) {
        final EvaluationEntity evaluation = this.getEvaluation(id);

        if(evaluationDtoUpdate.getCommentaire() != null) evaluation.setCommentaire(evaluationDtoUpdate.getCommentaire());
        if(evaluationDtoUpdate.getEvaluateur() != null) evaluation.setCommentaire(evaluationDtoUpdate.getEvaluateur());
        if(evaluationDtoUpdate.getNote() != null) evaluation.setNote(evaluationDtoUpdate.getNote());

        evaluationRepository.save(evaluation);

        return evaluation;
    }

    public String deleteEvaluation(Integer id) {
        EvaluationEntity evaluation = this.getEvaluation(id);

        this.evaluationRepository.delete(evaluation);
        return "L'évaluation " + id +" vient d'être supprimé";
    }
}
