package com.generation.gestionapp.model;

import jakarta.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Entity//Con la anotación entity, le decimos que representa una tabla
@Table(name = "empleados")//Con la anotación table, podemos especificar el nombre de esa tabla
public class Empleado {

    @Id//Indica que es la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Indica que se va a generar de manera autoincrementable
    private long empleadoId;

    @Column(name = "nombre_empleado")//Permite especificar el nombre de una columna
    @Size(min = 3, max = 15)//Validación para el ingreso del nombre
    private String nombreEmpleado;

    @Column(name = "direccion")
    @Size(min = 10, max = 50)
    private String direccionEmpleado;

    @Min(value = 1, message = "Tienes que indicar un número mayor a 1")
    @Max(value = 10, message = "Tienes que indicar un número menor a 10")
    private Integer aniosAntiguedad;

    @Email(message = "No se introdujo un correo válido")
    private String correoEmpleado;

    @ManyToOne//Indico que hay una relacion de Muchos a uno, desde el empleado
    @JoinColumn(name = "departamento")//Indicamos el nombre de la columna que lleva la llave foránea
    private Departamento departamentoEmpleado;

    @OneToOne
    @JoinColumn(name = "cargo")
    private Cargo cargoEmpleado;

    @ManyToMany(mappedBy = "tareaEmpleados")
    private ArrayList<Tarea> empleadoTareas;


    // Constructor vacío y constructor con sus atributos
    public Empleado() {
    }

    public Empleado(String nombreEmpleado, String direccionEmpleado, Integer aniosAntiguedad, String correoEmpleado, Departamento departamentoEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
        this.direccionEmpleado = direccionEmpleado;
        this.aniosAntiguedad = aniosAntiguedad;
        this.correoEmpleado = correoEmpleado;
        this.departamentoEmpleado = departamentoEmpleado;
    }

    //Getter y setter
    public long getEmpleadoId() {
        return empleadoId;
    }


    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getDireccionEmpleado() {
        return direccionEmpleado;
    }

    public void setDireccionEmpleado(String direccionEmpleado) {
        this.direccionEmpleado = direccionEmpleado;
    }

    public Integer getAniosAntiguedad() {
        return aniosAntiguedad;
    }

    public void setAniosAntiguedad(Integer aniosAntiguedad) {
        this.aniosAntiguedad = aniosAntiguedad;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public Departamento getDepartamentoEmpleado() {
        return departamentoEmpleado;
    }

    public void setDepartamentoEmpleado(Departamento departamentoEmpleado) {
        this.departamentoEmpleado = departamentoEmpleado;
    }

    public Cargo getCargoEmpleado() {
        return cargoEmpleado;
    }

    public void setCargoEmpleado(Cargo cargoEmpleado) {
        this.cargoEmpleado = cargoEmpleado;
    }

    public ArrayList<Tarea> getEmpleadoTareas() {
        return empleadoTareas;
    }

    public void setEmpleadoTareas(ArrayList<Tarea> empleadoTareas) {
        this.empleadoTareas = empleadoTareas;
    }
}
