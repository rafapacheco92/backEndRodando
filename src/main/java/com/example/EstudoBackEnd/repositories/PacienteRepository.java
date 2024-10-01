package com.example.EstudoBackEnd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EstudoBackEnd.entities.PacienteEntity;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {

}
