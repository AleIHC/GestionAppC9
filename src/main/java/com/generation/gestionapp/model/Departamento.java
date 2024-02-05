package com.generation.gestionapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departamentos")
@Data
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long departamentoId;

    @Size(min = 3, max = 50)
    private String nombreDepartamento;

    @JsonIgnore//Esto permite ingorar el atributo en el Json para evitar la recursión infinita
    @OneToMany(mappedBy = "departamentoEmpleado")// Indicamos de donde viene mapeada la relación
    private List<Empleado> empleadosDepartamento;
}
