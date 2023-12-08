package fr.polytech.backend_exam.repository;


import fr.polytech.backend_exam.entity.EvaluationEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EvaluationRepository extends JpaRepository<EvaluationEntity, Integer> {


}
