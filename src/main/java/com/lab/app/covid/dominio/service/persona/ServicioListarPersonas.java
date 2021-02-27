package com.lab.app.covid.dominio.service.persona;

import com.lab.app.covid.dominio.model.Persona;
import com.lab.app.covid.dominio.repositorio.RepositorioPersona;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioListarPersonas {

    private final RepositorioPersona repositorioPersona;

    public ServicioListarPersonas(RepositorioPersona repositorioPersona) {
        this.repositorioPersona = repositorioPersona;
    }

    public List<Persona> ejecutar() {
        return this.repositorioPersona.listarPersonas();
    }
}