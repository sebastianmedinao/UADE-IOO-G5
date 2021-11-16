package com.UADE.dto;

import com.UADE.model.*;

import javax.xml.transform.Result;
import java.util.Date;
import java.util.List;


public class DatosPeticionDTO {
    private final Integer codigo;
    private final String obraSocial;
    private final Date fechaInicio;
    private final Date fechaEstimadaEntrega;
    private final EstadoPeticion estadoPeticion;
    private final Paciente paciente;
    private final Sucursal sucursal;
    private final List<Practica> practicas;
    private final List<ResultadoPractica> resultadosPracticas;

    public DatosPeticionDTO(Integer codigo, String obraSocial, Date fechaInicio, Date fechaEstimadaEntrega, EstadoPeticion estadoPeticion, Paciente paciente, Sucursal sucursal, List<Practica> practicas, List<ResultadoPractica> resultadosPracticas) {
        this.codigo = codigo;
        this.obraSocial = obraSocial;
        this.fechaInicio = fechaInicio;
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
        this.estadoPeticion = estadoPeticion;
        this.paciente = paciente;
        this.sucursal = sucursal;
        this.practicas = practicas;
        this.resultadosPracticas = resultadosPracticas;
    }


    public Integer getCodigo() {
        return codigo;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaEstimadaEntrega() {
        return fechaEstimadaEntrega;
    }

    public EstadoPeticion getEstadoPeticion() { return estadoPeticion;}

    public Paciente getPaciente() { return paciente;}

    public Sucursal getSucursal() {return sucursal;}

    public List<Practica> getPracticas() {return practicas;}

    public List<ResultadoPractica> getResultadosPracticas() { return resultadosPracticas; }
}



