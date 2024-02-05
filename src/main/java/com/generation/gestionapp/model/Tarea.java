package com.generation.gestionapp.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tareas")
@Data
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tareaId;

    @Size(min = 5, max = 50)
    private String nombreTarea;

    @ManyToMany
    @JoinTable(
            name = "tareas_empleados",//Empezamos definiendo el nombre de la tarea
            joinColumns = @JoinColumn(name = "tarea_id"),//Indicamos la columna que lleva la llave foránea de esta entidad
            inverseJoinColumns = @JoinColumn(name = "empleado_id")//Indicamos la columna que lleva la llave foránea de la otra entidad
    )
    private List<Empleado> tareaEmpleados;
}
