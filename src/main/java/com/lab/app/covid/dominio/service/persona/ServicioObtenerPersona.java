package com.lab.app.covid.dominio.service.persona;

import com.lab.app.covid.dominio.model.Persona;
import com.lab.app.covid.dominio.repositorio.RepositorioPersona;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioObtenerPersona {

    private final RepositorioPersona repositorioPersona;

    public ServicioObtenerPersona(RepositorioPersona repositorioPersona) {
        this.repositorioPersona = repositorioPersona;
    }

    public Persona ejecutar(Long idPersona) {
        return this.repositorioPersona.obtenerPersonaPorId(idPersona).orElse(null);
    }
}

