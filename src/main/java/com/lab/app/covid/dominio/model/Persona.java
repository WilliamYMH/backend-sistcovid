package com.lab.app.covid.dominio.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lab.app.covid.dominio.exception.PersonaException;
import com.lab.app.covid.infraestructura.exception.ErrorResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Data
@NoArgsConstructor
public class Persona {
    private static final Integer EDAD_MENOR=18;
    private Long id;
    private String nombre;
    private String apellido;
    private String identificacion;

    private String fechaNacimiento;

    public Persona(Long id, String nombre, String apellido, String identificacion, String fechaNacimiento){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.fechaNacimiento = fechaNacimiento;
    }

    public void validarfechaNacimiento(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateConverter = LocalDate.parse(fechaNacimiento, formatter);
        Period edad = Period.between(dateConverter, LocalDate.now());
        if(edad.getYears()<18){
            throw new PersonaException("Error. La persona es menor de Edad");
        }
    }

    public LocalDate convertToLocalDateViaInstant() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateConverter = LocalDate.parse(fechaNacimiento, formatter);

        return dateConverter;
    }
}
