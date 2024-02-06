package com.generation.gestionapp.repository;

import com.generation.gestionapp.dto.EmpleadoDTO;
import com.generation.gestionapp.model.Empleado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    //Hereda de JPARepository que aporta métodos para realizar CRUD y Paginación y orden

    //Empleado findByCorreoEmpleado(String correoEmpleado);
    Empleado findByNombreEmpleado(String nombreEmpleado);

    //JPQL es un lenguaje que permite hacer consultas directamente con las entidades
    @Query("SELECT e FROM Empleado e WHERE e.correoEmpleado = :correo")
    public Empleado buscarPorCorreo(@Param("correo") String correoEmpleado);

    //Paginación
    Page<Empleado> findByAniosAntiguedad(Integer anios, Pageable pageable);
}
