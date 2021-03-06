package com.lab.app.covid.dominio.service.persona;

import com.lab.app.covid.dominio.exception.PersonaException;
import com.lab.app.covid.dominio.model.Persona;
import com.lab.app.covid.dominio.repositorio.RepositorioPersona;
import org.springframework.stereotype.Component;

@Component
public class ServicioCrearPersona {

    private final RepositorioPersona repositorioPersona;

    public ServicioCrearPersona(RepositorioPersona repositorioPersona) {
        this.repositorioPersona = repositorioPersona;
    }

    public Long ejecutar(Persona persona) {

        persona.validarfechaNacimiento();
        Persona p = this.repositorioPersona.obtenerPersonaPorIdentificacion(persona.getIdentificacion()).orElse(null);
        if(p!=null){
            throw new PersonaException("Error. Ya se encuentra una persona registrada con la misma identificacion");
        }
        return this.repositorioPersona.guardarPersona(persona);
    }
}