package com.lab.app.covid.dominio.service.persona;

import com.lab.app.covid.dominio.exception.PersonaException;
import com.lab.app.covid.dominio.model.Persona;
import com.lab.app.covid.dominio.repositorio.RepositorioPersona;
import org.springframework.stereotype.Component;

@Component
public class ServicioActualizarPersona {

    private final RepositorioPersona repositorioPersona;

    public ServicioActualizarPersona(RepositorioPersona repositorioPersona) {
        this.repositorioPersona = repositorioPersona;
    }

    public void ejecutar(Persona persona) {

        persona.validarfechaNacimiento();
        Persona p = this.repositorioPersona.obtenerPersonaPorIdentificacion(persona.getIdentificacion()).orElse(null);
        if(p.getId() != persona.getId() && p!=null){
            throw new PersonaException("Error. Ya se encuentra una persona registrada con la misma identificacion");
        }

        this.repositorioPersona.actualizarPersona(persona);
    }
}

