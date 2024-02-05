package com.generation.gestionapp.controller;


import com.generation.gestionapp.model.Tarea;
import com.generation.gestionapp.service.TareaServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/tareas")
public class TareaRestController {

    private final TareaServiceImpl tareaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Tarea>> listarTareas() {
        List<Tarea> listaDeTareas = tareaService.obtenerListaTareas();
        return new ResponseEntity<>(listaDeTareas, HttpStatus.OK);
    }

    @PostMapping("/nueva")
    public ResponseEntity<Tarea> nuevaTarea(@RequestBody Tarea tareaParaGuardar) {
        Tarea nuevaTarea = tareaService.guardarTarea(tareaParaGuardar);
        return new ResponseEntity<>(nuevaTarea, HttpStatus.CREATED);
    }





}
