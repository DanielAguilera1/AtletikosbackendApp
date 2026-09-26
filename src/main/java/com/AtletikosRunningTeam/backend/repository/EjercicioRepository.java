package com.AtletikosRunningTeam.backend.repository;

import com.AtletikosRunningTeam.backend.model.Ejercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EjercicioRepository extends JpaRepository<Ejercicio, Integer> {
}
