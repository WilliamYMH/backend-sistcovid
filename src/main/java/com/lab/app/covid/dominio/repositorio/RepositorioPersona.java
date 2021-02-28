package com.lab.app.covid.dominio.repositorio;

import com.lab.app.covid.dominio.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioPersona {

    Long guardarPersona(Persona persona);
    void actualizarPersona(Persona persona);
    Optional<Persona> obtenerPersonaPorId(Long id);
    Optional<Persona> obtenerPersonaPorIdentificacion(String identificacion);
    List<Persona> listarPersonas();
}