package com.lab.app.covid.infraestructura.controlador;

import com.lab.app.covid.aplicacion.manejadores.ManejadorActualizarPersona;
import com.lab.app.covid.dominio.model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController()
@RequestMapping("/api/persona")
public class ControladorActualizarPersona {

    ManejadorActualizarPersona manejadorActualizarPersona;

    public ControladorActualizarPersona( ManejadorActualizarPersona manejadorActualizarPersona) {
        this.manejadorActualizarPersona = manejadorActualizarPersona;
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public void actualizarPersona(@RequestBody Persona persona) {
         manejadorActualizarPersona.ejecutar(persona);
    }
}