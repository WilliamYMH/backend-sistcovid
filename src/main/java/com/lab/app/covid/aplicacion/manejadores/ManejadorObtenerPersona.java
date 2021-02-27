package com.lab.app.covid.aplicacion.manejadores;

import com.lab.app.covid.dominio.model.Persona;
import com.lab.app.covid.dominio.service.persona.ServicioObtenerPersona;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManejadorObtenerPersona {

    private final ServicioObtenerPersona servicioObtenerPersona;

    public ManejadorObtenerPersona(ServicioObtenerPersona servicioObtenerPersona) {
        this.servicioObtenerPersona = servicioObtenerPersona;
    }

    @Transactional
    public Persona ejecutar(Long idPersona) {
        return this.servicioObtenerPersona.ejecutar(idPersona);
    }
}

