package com.UADE.model;

import com.UADE.enums.Sexo;

public class Criterio {
    private final Integer codigo;
    private Sexo sexo;
    private String condicionesPreexistentes;
    private Integer edadDesde;
    private Integer edadHasta;
    private String interpretacion;
    private Float referenciaInferior;
    private Float referenciaSuperior;
    private String unidadMedida;
    private Boolean reservado;

    public Criterio(Integer codigo, Sexo sexo, String condicionesPreexistentes, Integer edadDesde, Integer edadHasta, String interpretacion, Float referenciaInferior, Float referenciaSuperior, String unidadMedida, Boolean reservado) {
        this.codigo = codigo;
        this.sexo = sexo;
        this.condicionesPreexistentes = condicionesPreexistentes;
        this.edadDesde = edadDesde;
        this.edadHasta = edadHasta;
        this.interpretacion = interpretacion;
        this.referenciaInferior = referenciaInferior;
        this.referenciaSuperior = referenciaSuperior;
        this.unidadMedida = unidadMedida;
        this.reservado = reservado;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getCondicionesPreexistentes() {
        return condicionesPreexistentes;
    }

    public void setCondicionesPreexistentes(String condicionesPreexistentes) {
        this.condicionesPreexistentes = condicionesPreexistentes;
    }

    public Integer getEdadDesde() {
        return edadDesde;
    }

    public void setEdadDesde(Integer edadDesde) {
        this.edadDesde = edadDesde;
    }

    public Integer getEdadHasta() {
        return edadHasta;
    }

    public void setEdadHasta(Integer edadHasta) {
        this.edadHasta = edadHasta;
    }

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
