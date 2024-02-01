package com.generation.gestionapp.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.ArrayList;

@Entity
@Table(name = "departamentos")
@Data
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long departamentoId;

    @Size(min = 3, max = 50)
    private String nombreDepartamento;

    @OneToMany(mappedBy = "departamentoEmpleado")// Indicamos de donde viene mapeada la relación
    private ArrayList<Empleado> empleadosDepartamento;
}
