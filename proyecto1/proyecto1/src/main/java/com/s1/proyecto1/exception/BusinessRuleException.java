package com.s1.proyecto1.exception;

public class BusinessRuleException extends RuntimeException {
    public BusinessRuleException(String mensaje){
        super(mensaje);
    }
}
