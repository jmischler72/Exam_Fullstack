package fr.polytech.backend_exam.repository;


import fr.polytech.backend_exam.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Integer> {


}
