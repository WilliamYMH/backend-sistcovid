package com.lab.app.covid.infraestructura.controlador;

import com.lab.app.covid.aplicacion.manejadores.ManejadorCrearPersona;
import com.lab.app.covid.aplicacion.manejadores.ManejadorListarPersonas;
import com.lab.app.covid.aplicacion.manejadores.ManejadorObtenerPersona;
import com.lab.app.covid.dominio.model.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/persona")
public class ControladorPersona {

    Persona persona;
    ManejadorCrearPersona manejadorCrearPersona;
    ManejadorListarPersonas manejadorListarPersonas;
    ManejadorObtenerPersona manejadorObtenerPersona;

    public ControladorPersona(ManejadorCrearPersona manejadorCrearPersona, ManejadorListarPersonas manejadorListarPersonas, ManejadorObtenerPersona manejadorObtenerPersona) {
        this.manejadorCrearPersona = manejadorCrearPersona;
        this.manejadorListarPersonas = manejadorListarPersonas;
        this.manejadorObtenerPersona = manejadorObtenerPersona;
    }

    @GetMapping()
    public List<Persona> listarPersonas() {
        return manejadorListarPersonas.ejecutar();
    }

    @GetMapping(path = "/{idPersona}")
    public ResponseEntity<Persona> obtenerPersona(@PathVariable("idPersona") String idPersona) {
        persona = manejadorObtenerPersona.ejecutar(Long.parseLong(idPersona) );
        return ResponseEntity.ok(persona);
    }

    @PostMapping()
    public Long crearPersona(@RequestBody Persona persona) {
        return manejadorCrearPersona.ejecutar(persona);
    }
}