package com.lab.app.covid.infraestructura.controlador;

import com.lab.app.covid.aplicacion.manejadores.ManejadorListarPersonas;
import com.lab.app.covid.dominio.model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController()
@RequestMapping("/api/persona")
public class ControladorListarPersonas {

    ManejadorListarPersonas manejadorListarPersonas;

    public ControladorListarPersonas(ManejadorListarPersonas manejadorListarPersonas) {
        this.manejadorListarPersonas = manejadorListarPersonas;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<Persona> listarPersonas() {
        return manejadorListarPersonas.ejecutar();
    }

}