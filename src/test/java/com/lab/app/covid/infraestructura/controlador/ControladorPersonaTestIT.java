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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class ControladorPersonaTestIT {

    Persona persona;
    PersonaTestDataBuilder personaTestDataBuilder;
    ObjectMapper objectMapper;

    @Autowired
    private MockMvc mvc;

    @BeforeEach
    void setUp(){
        personaTestDataBuilder = new PersonaTestDataBuilder();
        persona = personaTestDataBuilder.build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void listarPersonas() throws Exception {

    }

    @Test
    void crearPersona() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/api/persona/form")
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


    @AfterEach
    void tearDown(){
    }

}

