package com.UADE.dto;

import com.UADE.model.*;

import java.util.Date;
import java.util.List;


public class ListaPeticionesDTO {
    private final Integer codigo;
    private final Date fechaInicio;
    private final Paciente paciente;

    public ListaPeticionesDTO(Integer codigo, Date fechaInicio, Paciente paciente) {
        this.codigo = codigo;
        this.fechaInicio = fechaInicio;
        this.paciente = paciente;
    }


    public Integer getCodigo() { return codigo; }
    public Date getFechaInicio() { return fechaInicio; }
    public Paciente getPaciente() { return paciente;}
}
