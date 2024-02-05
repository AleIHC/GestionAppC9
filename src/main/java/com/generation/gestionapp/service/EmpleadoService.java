package com.generation.gestionapp.service;

import com.generation.gestionapp.model.Empleado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmpleadoService {
    //En esta interfaz declaro los métodos solamente

    Empleado guardarEmpleado(Empleado empleadoParaGuardar);

    void borrarEmpleadoPorId(Long empleadoId);

    List<Empleado> listarEmpleados();

    Empleado editarEmpleadoPorId(Empleado empleadoParaEditar, Long id);

    Empleado buscarEmpleadoPorId(Long id);


}
