package com.lab.app.covid.infraestructura.persistencia.dao;
import com.lab.app.covid.infraestructura.persistencia.entidad.PersonaEntity;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends CrudRepository<PersonaEntity, Long>, PersonaCustomDao {
}