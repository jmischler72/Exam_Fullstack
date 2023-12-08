package fr.polytech.backend_exam.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
            name = "dateCreation",
            columnDefinition = "date",
            nullable = false
    )
    private LocalDate dateCreation;

    @Column(
            name = "dateUpdate",
            columnDefinition = "date"
    )
    private LocalDate dateUpdate;


    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "images",
            joinColumns = @JoinColumn(name = "image_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"image_id"}))
    private Set<String> images = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private RestaurantEntity restaurant;
}
