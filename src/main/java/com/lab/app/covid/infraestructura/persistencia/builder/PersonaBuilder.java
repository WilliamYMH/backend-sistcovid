package com.lab.app.covid.infraestructura.persistencia.builder;

import com.lab.app.covid.dominio.model.Persona;
import com.lab.app.covid.infraestructura.persistencia.entidad.PersonaEntity;

import java.util.ArrayList;
import java.util.List;

public final class PersonaBuilder {

    private PersonaBuilder() {
    }

    public static Persona convertirADominio(PersonaEntity personaEntity){
        Persona persona = null;
        if (personaEntity != null) {
            persona = new Persona(personaEntity.getIdPersona(),personaEntity.getNombre(), personaEntity.getApellido(), personaEntity.getIdentificacion(), personaEntity.getFechaNacimiento().toString());
        }
        return persona;
    }

    public static PersonaEntity convertirAEntity(Persona persona) {
        PersonaEntity personaEntity = new PersonaEntity();
        personaEntity.setNombre(persona.getNombre());
        personaEntity.setApellido(persona.getApellido());
        personaEntity.setIdentificacion(persona.getIdentificacion());
        personaEntity.setFechaNacimiento(persona.convertToLocalDateViaInstant());
        personaEntity.setIdPersona(persona.getId());
        return personaEntity;
    }

    public static List<Persona> mapEntityIntoDominio(Iterable<PersonaEntity> entities) {
        List<Persona> personas = new ArrayList<>();
        entities.forEach(e -> personas.add(convertirADominio(e)));

        return personas;
    }
}