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

    //Getters y Setters

    public String getInterpretacion() {
        return interpretacion;
    }

    public void setInterpretacion(String interpretacion) {
        this.interpretacion = interpretacion;
    }

    public Float getReferenciaInferior() {
        return referenciaInferior;
    }

    public void setReferenciaInferior(Float referenciaInferior) {
        this.referenciaInferior = referenciaInferior;
    }

    public Float getReferenciaSuperior() {
        return referenciaSuperior;
    }

    public void setReferenciaSuperior(Float referenciaSuperior) {
        this.referenciaSuperior = referenciaSuperior;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Boolean getReservado() {
        return reservado;
    }

    public void setReservado(Boolean reservado) {
        this.reservado = reservado;
    }
}
