package fr.polytech.backend_exam.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity(name = "evaluations_finales")
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationFinaleEntity {

    @Id
    @GeneratedValue()
    private Integer id;

    @Column(
            name = "decideur",
            columnDefinition = "varchar(90)",
            nullable = false
    )
    private String decideur;

    @Column(
            name = "noteFinale",
            columnDefinition = "integer",
            nullable = false
    )
    private Integer noteFinale;

    @Column(
            name = "qualites",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String qualites;

    @OneToOne(fetch = FetchType.LAZY)
    private RestaurantEntity restaurantEvaluationFinale;
}
