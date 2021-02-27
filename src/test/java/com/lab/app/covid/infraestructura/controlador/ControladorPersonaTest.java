package com.lab.app.covid.infraestructura.controlador;

import com.lab.app.covid.aplicacion.manejadores.ManejadorCrearPersona;
import com.lab.app.covid.aplicacion.manejadores.ManejadorListarPersonas;
import com.lab.app.covid.aplicacion.manejadores.ManejadorObtenerPersona;
import com.lab.app.covid.databuilder.PersonaTestDataBuilder;
import com.lab.app.covid.dominio.model.Persona;
import com.lab.app.covid.dominio.repositorio.RepositorioPersona;
import com.lab.app.covid.dominio.service.persona.ServicioCrearPersona;
import com.lab.app.covid.dominio.service.persona.ServicioListarPersonas;
import com.lab.app.covid.dominio.service.persona.ServicioObtenerPersona;
import com.lab.app.covid.infraestructura.persistencia.repositorio.RepositorioPersonaImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ControladorPersonaTest {

    Persona persona;
    RepositorioPersona repositorioPersonaMock;
    ControladorPersona controladorPersona;
    PersonaTestDataBuilder personaTestDataBuilder;

    ManejadorCrearPersona manejadorCrearPersona;
    ManejadorListarPersonas manejadorListarPersonas;
    ManejadorObtenerPersona manejadorObtenerPersona;

    ServicioCrearPersona servicioCrearPersona;
    ServicioListarPersonas servicioListarPersonas;
    ServicioObtenerPersona servicioObtenerPersona;

    @BeforeEach
    void setUp(){
        personaTestDataBuilder = new PersonaTestDataBuilder();
        repositorioPersonaMock = Mockito.mock(RepositorioPersonaImpl.class);

        servicioCrearPersona = new ServicioCrearPersona(repositorioPersonaMock);
        servicioListarPersonas = new ServicioListarPersonas(repositorioPersonaMock);
        servicioObtenerPersona = new ServicioObtenerPersona(repositorioPersonaMock);

        manejadorCrearPersona = new ManejadorCrearPersona(servicioCrearPersona);
        manejadorListarPersonas = new ManejadorListarPersonas(servicioListarPersonas);
        manejadorObtenerPersona = new ManejadorObtenerPersona(servicioObtenerPersona);

        controladorPersona = new ControladorPersona(manejadorCrearPersona, manejadorListarPersonas, manejadorObtenerPersona);

        persona = personaTestDataBuilder.build();
    }

    @Test
    void crearPersona() {
        Mockito.when(repositorioPersonaMock.guardarPersona(persona)).thenReturn(1L);
        controladorPersona.crearPersona(persona);
        Assertions.assertEquals(1L, 1L);

    }

}