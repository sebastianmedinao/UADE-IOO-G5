package com.UADE.model;

public class Criterio {
    private Enum sexo;
    private String condicionesPreexistentes;
    private Integer edadDesde;
    private Integer edadHasta;
    private Valor valor;

    public Criterio(Enum sexo, String condicionesPreexistentes, Integer edadDesde, Integer edadHasta)
    {
        this.sexo = sexo;
        this.condicionesPreexistentes = condicionesPreexistentes;
        this.edadDesde = edadDesde;
        this.edadHasta = edadHasta;
    }

    public Enum getSexo() {
        return sexo;
    }

    public void setSexo(Enum sexo) {
        this.sexo = sexo;
    }

    public String getCondicionesPreexistentes() {
        return condicionesPreexistentes;
    }

    public void setCondicionesPreexistentes(String condicionesPreexistentes) {
        this.condicionesPreexistentes = condicionesPreexistentes;
    }



    // Getters y Setters
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

    public Valor getValor() {
        return valor;
    }

    public void setValor(Valor valor) {
        this.valor = valor;
    }
}
