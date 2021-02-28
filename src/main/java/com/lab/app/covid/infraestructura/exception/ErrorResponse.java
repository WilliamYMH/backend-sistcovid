package com.lab.app.covid.infraestructura.exception;

public class ErrorResponse extends RuntimeException{

    private final String excepcion;
    private final String mensajeError;

    public ErrorResponse(String excepcion, String mensajeError) {
        this.excepcion = excepcion;
        this.mensajeError = mensajeError;
    }

    public String getExcepcion() {
        return excepcion;
    }

    public String getMensajeError() {
        return mensajeError;
    }
}
