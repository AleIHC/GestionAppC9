package com.generation.gestionapp.viewscontroller;

import com.generation.gestionapp.model.Empleado;
import com.generation.gestionapp.service.EmpleadoServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/empleados")//Con esto indicamos que es la ruta base para los métodos de este controlador
public class EmpleadoController {

    private final EmpleadoServiceImpl empleadoService;

    @GetMapping("/lista")
    public String mostrarListaEmpleados(Model model) {

        //LLamamos al service para que nos traiga una lista de empleados a través del repository y lo guardamos en una variable
        List<Empleado> listaEmpleados = empleadoService.listarEmpleados();

        //Al model para pasar a la vista le asignamos el valor de la variable
        model.addAttribute("empleados", listaEmpleados);
        return "lista";
    }

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardarNuevoEmpleado(@ModelAttribute Empleado nuevoEmpleado) {
        empleadoService.guardarEmpleado(nuevoEmpleado);
        return "redirect:/empleados/lista";
    }

    //Controlar para mostrar la vista del formulario de edición
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        //Se crea una variable que se llama empeladoAEditar y equivale al empleado que se busca por el id
        Empleado empleadoAEditar = empleadoService.buscarEmpleadoPorId(id);
        //A través del model, se lo pasamos a la vista
        model.addAttribute("empleado", empleadoAEditar);
        // Me muestra la vista de formulario
        return "formularioeditar";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarEmpleado(@PathVariable Long id, @ModelAttribute Empleado empleadoEditado) {
        empleadoService.editarEmpleadoPorId(empleadoEditado, id);
        return "redirect:/empleados/lista";
    }

    @PostMapping("/borrar/{id}")
    public String borrarEmpleado(@PathVariable Long id) {
        empleadoService.borrarEmpleadoPorId(id);
        return "redirect:/empleados/lista";
    }
}
