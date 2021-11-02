package com.UADE.model;

import java.util.ArrayList;
import java.util.List;

public class Practica {
    private static int numeradorCodigoPractica = 0;
    private Integer codigo;
    private String nombre;
    private Integer tiempoEstimado;
    private List<Criterio> criterios = new ArrayList<Criterio>();

    public Practica(Integer codigo, String nombre, Integer tiempoEstimado)
    {
        numeradorCodigoPractica++;
        this.codigo = Integer.valueOf(numeradorCodigoPractica);
        this.nombre = nombre;
        this.tiempoEstimado = tiempoEstimado;
    }


    // Getters y Setters
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(Integer tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public List<Criterio> getCriterios() {
        return criterios;
    }

    public void setCriterios(List<Criterio> criterios) {
        this.criterios = criterios;
    }
}
