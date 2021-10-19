package com.UADE.model;

import java.util.ArrayList;
import java.util.List;

public class Practica {
    private Integer codigo;
    private String nombre;
    private Integer tiempoEstimado;


    private static int numeradorCodigoPractica = 0;
    private List<Criterio> criterios = new ArrayList<Criterio>();


    public Practica(Integer codigo, String nombre, Integer tiempoEstimado)
    {
        numeradorCodigoPractica++;
        this.codigo = Integer.valueOf(numeradorCodigoPractica);
        this.nombre = nombre;
        this.tiempoEstimado = tiempoEstimado;
    }
}
