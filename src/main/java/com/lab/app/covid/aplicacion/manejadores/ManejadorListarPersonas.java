package com.lab.app.covid.aplicacion.manejadores;

import com.lab.app.covid.dominio.model.Persona;
import com.lab.app.covid.dominio.service.persona.ServicioListarPersonas;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ManejadorListarPersonas {

    private final ServicioListarPersonas servicioListarPersonas;

    public ManejadorListarPersonas(ServicioListarPersonas servicioListarPersonas) {
        this.servicioListarPersonas = servicioListarPersonas;
    }

    @Transactional
    public List<Persona> ejecutar() {
        return this.servicioListarPersonas.ejecutar();
    }
}