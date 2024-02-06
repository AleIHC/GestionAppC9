package com.generation.gestionapp.service;

import com.generation.gestionapp.dto.EmpleadoDTO;
import com.generation.gestionapp.dto.EmpleadoEditarDTO;
import com.generation.gestionapp.dto.TareaDTO;
import com.generation.gestionapp.model.Departamento;
import com.generation.gestionapp.model.Empleado;
import com.generation.gestionapp.model.Tarea;
import com.generation.gestionapp.repository.DepartamentoRepository;
import com.generation.gestionapp.repository.EmpleadoRepository;
import com.generation.gestionapp.repository.TareaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    private DepartamentoRepository departamentoRepository;

    @Override
    public EmpleadoDTO guardarEmpleado(EmpleadoDTO empleadoParaGuardar) {
        //Boolean empleadoExiste = empleadoRepository.existsById(empleadoParaGuardar.getCorreoEmpleado());
        //Agrego validaciones antes de guardar al empleado
        Departamento departamentoEmpleado = departamentoRepository.
                findByNombreDepartamento(empleadoParaGuardar.getNombreDepartamento());


        if (empleadoParaGuardar.getNombreEmpleado() != null) {
            //Creamos una nueva instancia vacía del empleado
            Empleado empleadoNuevo = new Empleado();

            empleadoNuevo.setNombreEmpleado(empleadoParaGuardar.getNombreEmpleado());
            empleadoNuevo.setCorreoEmpleado(empleadoParaGuardar.getCorreoEmpleado());
            empleadoNuevo.setDireccionEmpleado(empleadoParaGuardar.getDireccionEmpleado());
            empleadoNuevo.setDepartamentoEmpleado(departamentoEmpleado);
            empleadoRepository.save(empleadoNuevo);
            return empleadoParaGuardar;
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

    public Empleado buscarEmpleadoPorCorreo(String correoEmpleado) {
        return empleadoRepository.buscarPorCorreo(correoEmpleado);
    }

    public Page<Empleado> bucarEmpleadosPorAnios(Integer anios, Integer numeroPagina, Integer tamanioPagina) {
        Pageable pageable = PageRequest.of(numeroPagina, tamanioPagina);
        Page<Empleado> paginaEmpleado = empleadoRepository.findByAniosAntiguedad(anios, pageable);
        return paginaEmpleado;
    }


    @Override
    public EmpleadoEditarDTO editarEmpleadoPorId(EmpleadoEditarDTO empleadoParaEditar, Long id) {
        Boolean empleadoExiste = empleadoRepository.existsById(id);

        Empleado empleadoSeleccionado = empleadoRepository.findById(id).get();

        if(empleadoExiste && empleadoParaEditar != null) {

            empleadoSeleccionado.setDireccionEmpleado(empleadoParaEditar.getDireccionEmpleado());
            empleadoSeleccionado.setNombreEmpleado(empleadoParaEditar.getNombreEmpleado());
            empleadoSeleccionado.setCorreoEmpleado(empleadoParaEditar.getCorreoEmpleado());
            empleadoSeleccionado.setAniosAntiguedad(empleadoParaEditar.getAniosAntiguedad());
            empleadoRepository.save(empleadoSeleccionado);

            return empleadoParaEditar;
        } else {
            return null;
        }
    }

    //Método para asignar tareas a empleados que recibe el Id de una tarea y el Id de un empleado para asignarle la tarea
    public EmpleadoDTO asignarTareaEmpleado(String nombreTarea, String nombreEmpleado) {

        //Buscamos en la lista de tareas por el id de la tarea indicada
        Tarea tareaParaAsignar = tareaRepository.findByNombreTarea(nombreTarea);
        Empleado empleadoSeleccionado = empleadoRepository.findByNombreEmpleado(nombreEmpleado);
        empleadoSeleccionado.getEmpleadoTareas().add(tareaParaAsignar);
        /***HASTA ACÁ SE ASIGNA LA TAREA***/


        //Construimos una nueva instancia de TareaDTO
        TareaDTO tareaSeleccionada = TareaDTO.builder()
                .nombreTarea(tareaParaAsignar.getNombreTarea())
                .build();
        List<TareaDTO> nombresTareas = new ArrayList<>();

        //Creamos el DTO que se va a enviar como respuesta
        EmpleadoDTO empleadoDTO = EmpleadoDTO.builder()
                .nombreEmpleado(empleadoSeleccionado.getNombreEmpleado())
                .correoEmpleado(empleadoSeleccionado.getCorreoEmpleado())
                .direccionEmpleado(empleadoSeleccionado.getDireccionEmpleado())
                .nombreDepartamento(empleadoSeleccionado.getDepartamentoEmpleado().getNombreDepartamento())
                .listaTareas(nombresTareas)
                .build();
        //Le aañadimos a la lista de TareasDTO del empleadoDTO, la nueva TareaDTO
        empleadoDTO.getListaTareas().add(tareaSeleccionada);

        /*
        Creamos un ArrayList de tareas
        ArrayList<Tarea> tareasEmpleado = new ArrayList<>();
        //Agregamos la tarea encontrada por id
        tareasEmpleado.add(tareaParaAsignar);
        //Le seteamos el ArrayList de tareas al empleado
        empleadoSeleccionado.setEmpleadoTareas(tareasEmpleado);
        */
        //Refactorizamos para seleccionar de una vez el ArrayList de tareas del usuario por sugerencia de Pao :3
        return empleadoDTO;
    }
}
