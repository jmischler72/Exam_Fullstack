package fr.polytech.backend_exam.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@Entity(name = "restaurants")
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantEntity {
    
    @Id
    @GeneratedValue()
    private Integer id;

    @Column(
        name = "nom",
        columnDefinition = "varchar(90)",
        nullable=false
    )
    private String nom;

    @Column(
        name = "adresse",
        columnDefinition = "varchar(255)",
        nullable=false
    )
    private String adresse;

    @OneToMany(mappedBy = "restaurant")
    private List<EvaluationEntity> evaluations;

    @OneToOne(mappedBy = "restaurantEvaluationFinale")
    private EvaluationFinaleEntity evaluationFinale;

}
