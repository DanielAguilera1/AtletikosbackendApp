package com.AtletikosRunningTeam.backend.repository;

import com.AtletikosRunningTeam.backend.model.DetallePlanEjercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePlanEjercicioRepository extends JpaRepository<DetallePlanEjercicio, Integer> {}
