package com.lab.app.covid.infraestructura.controlador;
import com.lab.app.covid.aplicacion.manejadores.ManejadorObtenerPersona;
import com.lab.app.covid.dominio.model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController()
@RequestMapping("/api/persona")
public class ControladorObtenerPersona {

    Persona persona;
    ManejadorObtenerPersona manejadorObtenerPersona;

    public ControladorObtenerPersona(ManejadorObtenerPersona manejadorObtenerPersona) {
        this.manejadorObtenerPersona = manejadorObtenerPersona;
    }

    @GetMapping(path = "/{idPersona}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Persona> obtenerPersona(@PathVariable("idPersona") String idPersona) {
        persona = manejadorObtenerPersona.ejecutar(Long.parseLong(idPersona) );
        return ResponseEntity.ok(persona);
    }

}