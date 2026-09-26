package com.AtletikosRunningTeam.backend.repository;

import com.AtletikosRunningTeam.backend.model.PlanEntrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanEntrenamientoRepository extends JpaRepository<PlanEntrenamiento, Integer> {
}
