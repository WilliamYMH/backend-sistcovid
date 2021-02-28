package com.lab.app.covid.infraestructura.persistencia.entidad;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "persona")
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Long idPersona;

    private String nombre;

    private String apellido;

    private String identificacion;

    @Column(name="fecha_nacimiento")
    //@JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaNacimiento;
}
