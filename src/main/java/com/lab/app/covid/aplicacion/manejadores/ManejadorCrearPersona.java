package com.lab.app.covid.aplicacion.manejadores;

import com.lab.app.covid.dominio.model.Persona;
import com.lab.app.covid.dominio.service.persona.ServicioCrearPersona;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManejadorCrearPersona {

    private final ServicioCrearPersona servicioCrearPersona;

    public ManejadorCrearPersona(ServicioCrearPersona servicioCrearPersona) {
        this.servicioCrearPersona = servicioCrearPersona;
    }

    @Transactional
    public Long ejecutar(Persona persona) {
        return this.servicioCrearPersona.ejecutar(persona);
    }
}