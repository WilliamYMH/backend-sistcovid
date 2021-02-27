package com.lab.app.covid.infraestructura.persistencia.repositorio;
import com.lab.app.covid.dominio.model.Persona;
import com.lab.app.covid.dominio.repositorio.RepositorioPersona;
import com.lab.app.covid.infraestructura.persistencia.builder.PersonaBuilder;
import com.lab.app.covid.infraestructura.persistencia.dao.PersonaDao;
import com.lab.app.covid.infraestructura.persistencia.entidad.PersonaEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioPersonaImpl implements RepositorioPersona {

    private final PersonaDao personaDao;

    public RepositorioPersonaImpl(PersonaDao personaDao) {
        this.personaDao = personaDao;
    }

    @Override
    public Long guardarPersona(Persona persona) {
        PersonaEntity personaEntity = PersonaBuilder.convertirAEntity(persona);
        personaDao.save(personaEntity);
        return personaEntity.getIdPersona();
    }

    @Override
    public Optional<Persona> obtenerPersonaPorId(Long id) {
        return personaDao.findById(id).map(PersonaBuilder::convertirADominio);
    }

    @Override
    public List<Persona> listarPersonas() {
        return PersonaBuilder.mapEntityIntoDominio(personaDao.findAll());
    }
}