package com.UADE.model;

public class Valor {
    private String interpretacion;
    private Float referenciaInferior;
    private Float referenciaSuperior;
    private String unidadMedida;
    private Boolean reservado;

    public Valor(String interpretacion, Float referenciaInferior, Float referenciaSuperior,
                 String unidadMedida, Boolean reservado)
    {
        this.interpretacion = interpretacion;
        this.referenciaInferior = referenciaInferior;
        this.referenciaSuperior = referenciaSuperior;
        this.unidadMedida = unidadMedida;
        this.reservado = reservado;
    }
}
