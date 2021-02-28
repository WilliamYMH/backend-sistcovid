package com.lab.app.covid.infraestructura.controlador;

import com.lab.app.covid.aplicacion.manejadores.ManejadorCrearPersona;
import com.lab.app.covid.dominio.model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController()
@RequestMapping("/api/persona")
public class ControladorCrearPersona {

    ManejadorCrearPersona manejadorCrearPersona;

    public ControladorCrearPersona(ManejadorCrearPersona manejadorCrearPersona) {
        this.manejadorCrearPersona = manejadorCrearPersona;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public Long crearPersona(@RequestBody Persona persona) {
        return manejadorCrearPersona.ejecutar(persona);
    }

}

