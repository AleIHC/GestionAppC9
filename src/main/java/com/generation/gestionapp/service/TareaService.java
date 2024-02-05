package com.generation.gestionapp.service;

import com.generation.gestionapp.model.Tarea;

import java.util.List;

public interface TareaService {

    List<Tarea> obtenerListaTareas();

    Tarea guardarTarea(Tarea tareaParaGuardar);

    void eliminarTareaPorId(Long id);

    Tarea editarTareaPorId(Tarea tareaParaEditar, Long id);



}
