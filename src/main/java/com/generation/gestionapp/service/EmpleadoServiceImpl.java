package com.generation.gestionapp.service;

import com.generation.gestionapp.model.Empleado;
import com.generation.gestionapp.model.Tarea;
import com.generation.gestionapp.repository.EmpleadoRepository;
import com.generation.gestionapp.repository.TareaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service//Anotacion service permite a Spring tomar este componente para inyectarlo luego donde lo necesitemos
@Transactional//Transactional indica que los métodos contenidos en esta clase son transaccionales
@AllArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

// @Autowired = Con esta anotación inyecto un componente dentro de esta clase
    private EmpleadoRepository empleadoRepository;
    private TareaRepository tareaRepository;

    @Override
    public Empleado guardarEmpleado(Empleado empleadoParaGuardar) {
        Boolean empleadoExiste = empleadoRepository.existsById(empleadoParaGuardar.getEmpleadoId());
        //Agrego validaciones antes de guardar al empleado
        if (!(empleadoExiste) && empleadoParaGuardar.getAniosAntiguedad() > 1) {
            return empleadoRepository.save(empleadoParaGuardar);
        } else {
            return null;
        }
    }

    @Override
    public void borrarEmpleadoPorId(Long id) {
        //Validamos que el empleado existe
        Boolean empleadoExiste = empleadoRepository.existsById(id);

        if (empleadoExiste) {
            empleadoRepository.deleteById(id);
        }
    }

    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado buscarEmpleadoPorId(Long id) {
        return empleadoRepository.findById(id).get();
    }


    @Override
    public Empleado editarEmpleadoPorId(Empleado empleadoParaEditar, Long id) {
        Boolean empleadoExiste = empleadoRepository.existsById(empleadoParaEditar.getEmpleadoId());

        Empleado empleadoSeleccionado = empleadoRepository.findById(id).get();

        if(empleadoExiste && empleadoParaEditar != null) {
            empleadoParaEditar.setEmpleadoId(empleadoSeleccionado.getEmpleadoId());
            return empleadoRepository.save(empleadoParaEditar);
        } else {
            return null;
        }
    }

    //Método para asignar tareas a empleados que recibe el Id de una tarea y el Id de un empleado para asignarle la tarea
    public void asignarTareaEmpleado(Long tareaId, Long empleadoId) {
        //Buscamos en la lista de tareas por el id de la tarea indicada
        Tarea tareaParaAsignar = tareaRepository.findById(tareaId).get();
        //Asignar la tarea al empleado
        Empleado empleadoSeleccionado = empleadoRepository.findById(empleadoId).get();

        /*
        Creamos un ArrayList de tareas
        ArrayList<Tarea> tareasEmpleado = new ArrayList<>();
        //Agregamos la tarea encontrada por id
        tareasEmpleado.add(tareaParaAsignar);
        //Le seteamos el ArrayList de tareas al empleado
        empleadoSeleccionado.setEmpleadoTareas(tareasEmpleado);
        */

        //Refactorizamos para seleccionar de una vez el ArrayList de tareas del usuario por sugerencia de Pao :3
        //empleadoSeleccionado.getEmpleadoTareas().add(tareaParaAsignar);
    }
}
