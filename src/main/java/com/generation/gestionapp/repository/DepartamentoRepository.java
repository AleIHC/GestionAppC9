package com.generation.gestionapp.repository;

import com.generation.gestionapp.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

    Departamento findByNombreDepartamento(String nombreDepartamento);
}
