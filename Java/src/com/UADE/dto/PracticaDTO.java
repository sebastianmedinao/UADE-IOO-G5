package com.UADE.dto;

import com.UADE.model.*;

import java.util.ArrayList;
import java.util.List;

public class PracticaDTO {
    private final Integer codigo;
    private String nombre;
    private Integer tiempoEstimado;
    private List<Integer> codCriterios = new ArrayList<Integer>();
    private List<Integer> codSubPracticas = new ArrayList<Integer>();

    public PracticaDTO(Integer codigo, String nombre, Integer tiempoEstimado, List<Integer> codCriterios, List<Integer> codSubPracticas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tiempoEstimado = tiempoEstimado;
        this.codCriterios = codCriterios;
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

    public List<Integer> getCodCriterios() {
        return codCriterios;
    }

    public void setCodCriterios(List<Integer> codCriterios) {
        this.codCriterios = codCriterios;
    }

    public List<Integer> getCodSubPracticas() {
        return codSubPracticas;
    }

    public void setCodSubPracticas(List<Integer> codSubPracticas) {
        this.codSubPracticas = codSubPracticas;
    }
}
