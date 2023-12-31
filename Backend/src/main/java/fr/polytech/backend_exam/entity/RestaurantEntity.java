package fr.polytech.backend_exam.entity;

import fr.polytech.backend_exam.enums.TagsEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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
            nullable = false
    )
    private String nom;

    @Column(
            name = "adresse",
            columnDefinition = "varchar(255)",
            nullable = false
    )
    private String adresse;

    @Column(
            name = "image",
            columnDefinition = "boolean default false",
            nullable = false
    )
    private boolean image = false;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "restaurant_tags")
    @Column(name = "tags", nullable = false)
    private List<TagsEnum> tags = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant")
    private List<EvaluationEntity> evaluations;

    @OneToOne(mappedBy = "restaurantEvaluationFinale")
    private EvaluationFinaleEntity evaluationFinale;

}
