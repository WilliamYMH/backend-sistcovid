package com.lab.app.covid.infraestructura.persistencia.dao;
import com.lab.app.covid.dominio.model.Persona;
import com.lab.app.covid.infraestructura.persistencia.entidad.PersonaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonaDao extends CrudRepository<PersonaEntity, Long>, PersonaCustomDao {

    Optional<PersonaEntity> findByIdentificacion(String identificacion);
}