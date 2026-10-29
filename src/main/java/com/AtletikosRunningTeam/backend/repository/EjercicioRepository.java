package com.AtletikosRunningTeam.backend.repository;

import com.AtletikosRunningTeam.backend.model.Ejercicio;
import com.AtletikosRunningTeam.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EjercicioRepository extends JpaRepository<Ejercicio, Integer> {
    Optional<Ejercicio> findById(int id);
}
