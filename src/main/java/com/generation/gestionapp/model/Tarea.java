package com.generation.gestionapp.model;

import jakarta.persistence.*;

import javax.validation.constraints.Size;
import java.util.ArrayList;

@Entity
@Table(name = "tareas")
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
    private ArrayList<Empleado> tareaEmpleados;

    //Constructores
    public Tarea() {
    }

    public Tarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public long getTareaId() {
        return tareaId;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public ArrayList<Empleado> getTareaEmpleados() {
        return tareaEmpleados;
    }

    public void setTareaEmpleados(ArrayList<Empleado> tareaEmpleados) {
        this.tareaEmpleados = tareaEmpleados;
    }
}
