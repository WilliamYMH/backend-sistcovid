package com.lab.app.covid.aplicacion.manejadores;

import com.lab.app.covid.dominio.model.Persona;
import com.lab.app.covid.dominio.service.persona.ServicioActualizarPersona;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManejadorActualizarPersona {

    private final ServicioActualizarPersona servicioActualizarPersona;

    public ManejadorActualizarPersona(ServicioActualizarPersona servicioActualizarPersona) {
        this.servicioActualizarPersona = servicioActualizarPersona;
    }

    @Transactional
    public void ejecutar(Persona persona) {
        this.servicioActualizarPersona.ejecutar(persona);
    }
}

