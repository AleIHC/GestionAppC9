package com.generation.gestionapp.repository;

import com.generation.gestionapp.model.Empleado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    //Hereda de JPARepository que aporta métodos para realizar CRUD y Paginación y orden


}
