package com.lab.app.covid.dominio.exception;

public class PersonaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PersonaException(String msj) {
        super(msj);
    }
}

