package com.lab.app.covid.databuilder;


import com.lab.app.covid.dominio.model.Persona;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class PersonaTestDataBuilder {
    private static final Long ID=null;
    private static final String NOMBRE="Gemelo";
    private static final String APELLIDO="Moreno";
    private static final String IDENTIFICACION="0000000";
    private static final String FECHA_NACIMIENTO="1998-06-13";

    private Long id;
    private String nombre;
    private String apellido;
    private String identificacion;
    private String fechaNacimiento;

    public PersonaTestDataBuilder() {
        this.id=ID;
        this.nombre = NOMBRE;
        this.apellido = APELLIDO;
        this.identificacion = IDENTIFICACION;
        this.fechaNacimiento = FECHA_NACIMIENTO;
    }

    public PersonaTestDataBuilder(Long id, String nombre, String apellido, String identificacion, String fechaNacimiento) {
        this.id=id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Persona build() {
        return new Persona(id, nombre, apellido, identificacion, fechaNacimiento);
    }
}

