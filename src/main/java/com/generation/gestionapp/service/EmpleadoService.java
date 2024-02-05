package com.generation.gestionapp.service;

import com.generation.gestionapp.dto.EmpleadoDTO;
import com.generation.gestionapp.dto.EmpleadoEditarDTO;
import com.generation.gestionapp.model.Empleado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmpleadoService {
    //En esta interfaz declaro los métodos solamente

    EmpleadoDTO guardarEmpleado(EmpleadoDTO empleadoParaGuardar);

    void borrarEmpleadoPorId(Long empleadoId);

    List<Empleado> listarEmpleados();

    EmpleadoEditarDTO editarEmpleadoPorId(EmpleadoEditarDTO empleadoParaEditar, Long id);

    Empleado buscarEmpleadoPorId(Long id);


}
