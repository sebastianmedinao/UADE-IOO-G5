package com.UADE.model;

public class Criterio {
    private Sexo sexo;
    private String condicionesPreexistentes;
    private Integer edadDesde;
    private Integer edadHasta;
    private Valor valor;

    public Criterio(Sexo sexo, String condicionesPreexistentes, Integer edadDesde, Integer edadHasta)
    {
        setSexo(sexo);
        this.condicionesPreexistentes = condicionesPreexistentes;
        this.edadDesde = edadDesde;
        this.edadHasta = edadHasta;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexoB) {
        sexo = sexoB;
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

    public void setValor(Valor valorX) {
        valor = valorX;
    }
}
