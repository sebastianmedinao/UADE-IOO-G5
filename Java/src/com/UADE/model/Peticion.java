package com.UADE.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Peticion {
    private final Integer codigo;
    private String obraSocial;
    private Date fechaInicio;
    private Date fechaEstimadaEntrega;
    private EstadoPeticion estadoPeticion;
    private Paciente paciente;
    private Sucursal sucursal;
    private List<Practica> practicas;
    private List<ResultadoPractica> resultadosPracticas;

    public Peticion(Integer codigo, String obraSocial, Date fechaInicio, List<Practica> practicas, Date fechaEstimadaEntrega, EstadoPeticion estadoPeticion, Paciente paciente, Sucursal sucursal, List<ResultadoPractica> resultadosPracticas)
    {
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


    // Getters y Setters
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaEstimadaEntrega() {
        return fechaEstimadaEntrega;
    }

    public void setFechaEstimadaEntrega(Date fechaEstimadaEntrega) {
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
    }

    public EstadoPeticion getEstadoPeticion() {
        return estadoPeticion;
    }

    public void setEstadoPeticion(EstadoPeticion estadoPeticion) {
        this.estadoPeticion = estadoPeticion;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Paciente getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public List<Practica> getPracticas() {
        return practicas;
    }

    public void setPracticas(List<Practica> practicas) {
        this.practicas = practicas;
    }

    public List<ResultadoPractica> getResultadosPracticas() {
        return resultadosPracticas;
    }

    public void setResultadosPracticas(List<ResultadoPractica> resultadosPracticas) {
        this.resultadosPracticas = resultadosPracticas;
    }
}
