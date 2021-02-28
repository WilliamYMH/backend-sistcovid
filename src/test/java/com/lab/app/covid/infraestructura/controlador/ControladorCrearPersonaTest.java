package com.lab.app.covid.infraestructura.controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lab.app.covid.databuilder.PersonaTestDataBuilder;
import com.lab.app.covid.dominio.model.Persona;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class ControladorCrearPersonaTest {

    Persona persona;
    PersonaTestDataBuilder personaTestDataBuilder;
    ObjectMapper objectMapper;

    @Autowired
    private MockMvc mvc;

    @BeforeEach
    void setUp() throws Exception {
        personaTestDataBuilder = new PersonaTestDataBuilder();
        persona = personaTestDataBuilder.build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void crearPersona() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/api/persona")
                .content(objectMapper.writeValueAsString(persona))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(MockMvcRequestBuilders.get("/api/persona/{id}", 10))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value(persona.getNombre()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.apellido").value(persona.getApellido()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.identificacion").value(persona.getIdentificacion()));
    }

    @Test
    void crearPersonaMenorEdad() throws Exception {
        persona = new Persona();
        persona.setNombre("William");
        persona.setApellido("Moreno");
        persona.setIdentificacion("1234567");
        persona.setFechaNacimiento(LocalDateTime.parse("2020-06-13"));

        mvc.perform(MockMvcRequestBuilders.post("/api/persona")
                .content(objectMapper.writeValueAsString(persona))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

    @Test
    void crearPersonaRepetida() throws Exception {
        Long id=null;
        String nombre="Gemelo";
        String apellido="Moreno";
        String identificacion="123451";
        LocalDateTime fechaNacimiento=LocalDateTime.parse("1998-06-13");

        personaTestDataBuilder = new PersonaTestDataBuilder(id, nombre, apellido, identificacion, fechaNacimiento);
        persona = personaTestDataBuilder.build();
        mvc.perform(MockMvcRequestBuilders.post("/api/persona")
                .content(objectMapper.writeValueAsString(persona))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }


    @AfterEach
    void tearDown(){
    }

}

