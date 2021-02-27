package com.lab.app.covid.dominio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Persona {

    private String nombre;
    private String apellido;
    private String identificacion;
    private Date  fechaNacimiento;
}
