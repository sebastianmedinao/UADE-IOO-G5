package com.UADE.model;

import java.util.ArrayList;
import java.util.List;

public class Practica {
    private final Integer codigo;
    private String nombre;
    private Integer tiempoEstimado;
    private List<Integer> codSubPracticas = new ArrayList<Integer>();

    public Practica(Integer codigo, String nombre, Integer tiempoEstimado, List<Integer> codSubPracticas)
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tiempoEstimado = tiempoEstimado;
        this.codSubPracticas = codSubPracticas;
    }

    public List<Integer> getCodSubPracticas() {
        return codSubPracticas;
    }

    public void setCodSubPracticas(List<Integer> codSubPracticas) {
        this.codSubPracticas = codSubPracticas;
    }

    public Integer getCodigo() {
        return codigo;
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
}
