package com.example.i20213tn110sdaextra2024.utils;

import jakarta.validation.ConstraintViolation;

import java.util.Set;

public class Utilidades {
    public static String obtenerMensajesDeError(Set<ConstraintViolation<?>> errores) {
        String mensajes = "";
        for (ConstraintViolation<?> error: errores) {
            mensajes += error.getMessage() + ',';
        }
        return mensajes.substring(0, mensajes.length() - 1);
    }
}
