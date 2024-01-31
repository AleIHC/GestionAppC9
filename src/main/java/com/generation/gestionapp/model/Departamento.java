package com.generation.gestionapp.model;

import jakarta.persistence.*;

import javax.validation.constraints.Size;
import java.util.ArrayList;

@Entity
@Table(name = "departamentos")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long departamentoId;

    @Size(min = 3, max = 50)
    private String nombreDepartamento;

    @OneToMany(mappedBy = "departamentoEmpleado")// Indicamos de donde viene mapeada la relación
    private ArrayList<Empleado> empleadosDepartamento;

    //Constructores
    public Departamento() {
    }

    public Departamento(String nombreDepartamento, ArrayList<Empleado> empleadosDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
        this.empleadosDepartamento = empleadosDepartamento;
    }

    //Getter y Setter
    public long getDepartamentoId() {
        return departamentoId;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public ArrayList<Empleado> getEmpleadosDepartamento() {
        return empleadosDepartamento;
    }

    public void setEmpleadosDepartamento(ArrayList<Empleado> empleadosDepartamento) {
        this.empleadosDepartamento = empleadosDepartamento;
    }
}
