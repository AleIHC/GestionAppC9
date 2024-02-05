package com.generation.gestionapp.controller;

import com.generation.gestionapp.dto.EmpleadoDTO;
import com.generation.gestionapp.dto.EmpleadoEditarDTO;
import com.generation.gestionapp.model.Empleado;
import com.generation.gestionapp.service.EmpleadoServiceImpl;
import com.generation.gestionapp.service.TareaServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/empleados")
public class EmpleadoRestController {

    private final TareaServiceImpl tareaService;
    private final EmpleadoServiceImpl empleadoService;

    //Obtener el empleado por id
    @GetMapping("/empleado/{id}")
    public ResponseEntity<Empleado> buscarEmpleadoPorId(@PathVariable Long id) {
        //En una variable empleado guardamos el empleado que trae el service al pasarle el id
        Empleado empleadoSeleccionado = empleadoService.buscarEmpleadoPorId(id);
        // Retornamos una nueva instancia response entity, en la que enviamos el objeto(empleado) mas el status de respuesta
        return new ResponseEntity<>(empleadoSeleccionado, HttpStatus.OK);
    }

    //Obtener lista de empleados
    @GetMapping("/lista")
    public ResponseEntity<List<Empleado>> buscarListaEmpleados() {

        List<Empleado> listaEmpleados = empleadoService.listarEmpleados();

        return new ResponseEntity<>(listaEmpleados, HttpStatus.OK);
    }

    //Guardar nuevo empleado
    @PostMapping("/nuevo")
    public ResponseEntity<EmpleadoDTO> guardarNuevoEmpleado(@RequestBody EmpleadoDTO empleadoParaGuardar) {
        EmpleadoDTO empleadoNuevo = empleadoService.guardarEmpleado(empleadoParaGuardar);
        return new ResponseEntity<>(empleadoNuevo, HttpStatus.CREATED);
    }

    //Borrar por id
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarEmpleadoPorId(@PathVariable Long id) {
        empleadoService.borrarEmpleadoPorId(id);
        return new ResponseEntity<>("El empleado fue despedido", HttpStatus.OK);
    }

    //Editar por id
    @PutMapping("/editar")
    public ResponseEntity<EmpleadoEditarDTO> editarEmpleadoPorId(@RequestBody EmpleadoEditarDTO empleadoParaEditar,
                                                        @RequestParam Long id) {

        EmpleadoEditarDTO empleadoEditado = empleadoService.editarEmpleadoPorId(empleadoParaEditar, id);

        return new ResponseEntity<>(empleadoEditado, HttpStatus.OK);
    }





}
