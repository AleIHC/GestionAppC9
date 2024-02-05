package com.generation.gestionapp.service;

import com.generation.gestionapp.model.Departamento;

import java.util.List;

public interface DepartamentoService {

    List<Departamento> listarDepartamentos();

    Departamento guardarDepartamento(Departamento departamentoParaGuardar);

    void eliminarDepartamentoPorId(Long id);

    Departamento editarDepartamentoPorId(Departamento departamentoParaEditar, Long id);
}
