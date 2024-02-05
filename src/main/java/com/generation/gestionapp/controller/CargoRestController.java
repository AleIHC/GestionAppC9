package com.generation.gestionapp.controller;

import com.generation.gestionapp.model.Cargo;
import com.generation.gestionapp.service.CargoServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cargos")
public class CargoRestController {

    private final CargoServiceImpl cargoService;

    @GetMapping("/lista")
    public ResponseEntity<List<Cargo>> buscarListaCargos() {
        List<Cargo> listaCargos = cargoService.listarCargos();
        return new ResponseEntity<>(listaCargos, HttpStatus.OK);
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Cargo> guardarNuevoCargo(@RequestBody Cargo cargoParaGuardar) {
        Cargo nuevoCargo = cargoService.guardarCargo(cargoParaGuardar);
        return new ResponseEntity<>(nuevoCargo, HttpStatus.CREATED);
    }

}
