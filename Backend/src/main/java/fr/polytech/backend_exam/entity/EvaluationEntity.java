package fr.polytech.backend_exam.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@Entity(name = "evaluations")
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationEntity {

    @Id
    @GeneratedValue()
    private Integer id;

    @Column(
            name = "evaluateur",
            columnDefinition = "varchar(50)",
            nullable = false
    )
    private String evaluateur;

    @Column(
            name = "commentaire",
            columnDefinition = "varchar(255)",
            nullable = false
    )
    private String commentaire;

    @Column(
            name = "note",
            columnDefinition = "integer",
            nullable = false
    )
    private Integer note;

    @Column(
            name = "date_creation",
            columnDefinition = "date",
            nullable = false
    )
    private LocalDate dateCreation;

    @Column(
            name = "date_update",
            columnDefinition = "date"
    )
    private LocalDate dateUpdate;


    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "evaluation_images")
    @Column(name = "images")
    private List<String> images = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private RestaurantEntity restaurant;
}
