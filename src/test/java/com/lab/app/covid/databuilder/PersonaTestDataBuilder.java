package com.lab.app.covid.databuilder;


import com.lab.app.covid.dominio.model.Persona;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class PersonaTestDataBuilder {

    private static final String NOMBRE="Gemelo";
    private static final String APELLIDO="Moreno";
    private static final String IDENTIFICACION="0000000";
    private static final Date FECHA_NACIMIENTO=Date.from(LocalDate.parse("1998-06-13").atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

    private String nombre;
    private String apellido;
    private String identificacion;
    private Date fechaNacimiento;

    public PersonaTestDataBuilder() {
        this.nombre = NOMBRE;
        this.apellido = APELLIDO;
        this.identificacion = IDENTIFICACION;
        this.fechaNacimiento = FECHA_NACIMIENTO;
    }

    public PersonaTestDataBuilder(String nombre, String apellido, String identificacion, Date fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Persona build(){
        return new Persona(nombre, apellido, identificacion, fechaNacimiento);
    }
}

