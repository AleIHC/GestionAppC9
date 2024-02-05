package com.generation.gestionapp.service;

import com.generation.gestionapp.model.Cargo;

import java.util.List;

public interface CargoService {

    List<Cargo> listarCargos();

    Cargo guardarCargo(Cargo cargoParaGuardar);

    void eliminarCargoPorId(Long id);

    Cargo editarCargoPorId(Cargo cargoParaEditar, Long id);
}
