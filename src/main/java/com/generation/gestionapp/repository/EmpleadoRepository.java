package com.generation.gestionapp.repository;

import com.generation.gestionapp.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    //Hereda de JPARepository que aporta métodos para realizar CRUD y Paginación y orden


}
