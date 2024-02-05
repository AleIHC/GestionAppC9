package com.generation.gestionapp.dto;

import lombok.Data;

@Data
public class EmpleadoDTO {

    //Indico los atributos que considero necesarios para el nuevo objeto que se va a guardar
    private String nombreEmpleado;
    private String direccionEmpleado;
    private String correoEmpleado;
    private String nombreDepartamento;

}
