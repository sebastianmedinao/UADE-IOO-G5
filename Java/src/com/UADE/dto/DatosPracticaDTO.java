package com.UADE.dto;

import com.UADE.model.*;

import java.util.List;

public class DatosPracticaDTO {
    private final Integer codigo;
    private final String nombre;
    private final Integer tiempoEstimado;
    private final List<Criterio> criterios;

    public DatosPeticionDTO(Integer codigo, String nombre, Integer tiempoEstimado, List<Criterio> criterios) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tiempoEstimado = tiempoEstimado;
        this.criterios = criterios;
    }


    public Integer getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getTiempoEstimado() { return tiempoEstimado; }

    public List<Criterio> getCriterios() { return criterios; }

}
