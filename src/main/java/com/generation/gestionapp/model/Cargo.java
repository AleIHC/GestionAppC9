package com.generation.gestionapp.model;

import jakarta.persistence.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cargos")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cargoId;

    @Column(name = "nombre")
    @Size(min = 2, max = 15)
    private String nombreCargo;

    @Column(name = "sueldo")
    @Min(value = 450000, message = "El sueldo del cargo debe ser mayor a 450.000")
    private Integer sueldoCargo;


    //Constructores
    public Cargo() {
    }

    public Cargo(String nombreCargo, Integer sueldoCargo) {
        this.nombreCargo = nombreCargo;
        this.sueldoCargo = sueldoCargo;
    }

    //Getter y Setter
    public long getCargoId() {
        return cargoId;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public Integer getSueldoCargo() {
        return sueldoCargo;
    }

    public void setSueldoCargo(Integer sueldoCargo) {
        this.sueldoCargo = sueldoCargo;
    }
}
