package com.UADE.dto;

import com.UADE.model.*;

import java.util.Date;
import java.util.List;


public class ListaPeticionesDTO {
    private final Integer codigo;
    private Date fechaInicio;
    private Integer codPaciente;

    public ListaPeticionesDTO(Integer codigo, Date fechaInicio, Integer codPaciente) {
        this.codigo = codigo;
        this.fechaInicio = fechaInicio;
        this.codPaciente = codPaciente;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Integer getCodPaciente() {
        return codPaciente;
    }

    public void setCodPaciente(Integer codPaciente) {
        this.codPaciente = codPaciente;
    }
}
