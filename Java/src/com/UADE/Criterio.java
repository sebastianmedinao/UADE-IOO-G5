package com.UADE;


import java.util.ArrayList;
import java.util.List;

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

}
