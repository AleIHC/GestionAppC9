package com.generation.gestionapp.controller;

import com.generation.gestionapp.model.Departamento;
import com.generation.gestionapp.service.DepartamentoServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/departamentos")
public class DepartamentoRestController {


    private final DepartamentoServiceImpl departamentoService;


    @PostMapping("/nuevo")
    public ResponseEntity<Departamento> guardarNuevoDepartamento(@RequestBody Departamento departamentoParaGuardar) {
        Departamento departamentoNuevo = departamentoService.guardarDepartamento(departamentoParaGuardar);
        return new ResponseEntity<>(departamentoNuevo, HttpStatus.CREATED);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Departamento>> buscarListaDepartamentos() {
        List<Departamento> listaDepartamentos = departamentoService.listarDepartamentos();
        return new ResponseEntity<>(listaDepartamentos, HttpStatus.OK);
    }

}
