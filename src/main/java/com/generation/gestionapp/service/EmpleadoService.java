package com.generation.gestionapp.service;

import com.generation.gestionapp.model.Empleado;

public interface EmpleadoService {
    //En esta interfaz declaro los métodos solamente

    Empleado guardarEmpleado(Empleado empleadoParaGuardar);

    void borrarEmpleadoPorId(Long empleadoId);
}
