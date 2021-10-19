package com.UADE.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

public class Peticion {

    private Integer codigo;
    private String obraSocial;
    private Date fechaInicio;
    private Date fechaEstimadaEntrega;
    private EstadoPeticion estadoPeticion;
    private Paciente paciente;

    private static int numeradorCodigoPeticion = 0;
    private List<Practica> practicas = new ArrayList<Practica>();
    private List<ResultadoPractica> resultadosPracticas = new ArrayList<ResultadoPractica>();


    public Peticion(Integer codigo, String obraSocial, Date fechaInicio, List practicas, Date fechaEstimadaEntrega, EstadoPeticion estadoPeticion)
    {
        numeradorCodigoPeticion++;
        this.codigo = Integer.valueOf(numeradorCodigoPeticion);
        this.obraSocial = obraSocial;
        this.fechaInicio = fechaInicio;
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
        this.estadoPeticion = estadoPeticion;
    }


    // Getters y setters

    public Integer getCodigo() {
        return codigo;
    }

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
