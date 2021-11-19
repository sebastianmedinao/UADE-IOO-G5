package com.UADE.dto;

import com.UADE.enums.EstadoPeticion;
import com.UADE.model.*;

import java.util.Date;
import java.util.List;


public class PeticionDTO {
    private final Integer codigo;
    private String obraSocial;
    private Date fechaInicio;
    private Date fechaEstimadaEntrega;
    private EstadoPeticion estadoPeticion;
    private Integer codPaciente;
    private Integer codSucursal;
    private List<Integer> codPracticas;
    private List<Integer> codResultadosPracticas;

    public PeticionDTO(Integer codigo, String obraSocial, Date fechaInicio, Date fechaEstimadaEntrega, EstadoPeticion estadoPeticion, Integer codPaciente, Integer codSucursal, List<Integer> codPracticas, List<Integer> codResultadosPracticas) {
        this.codigo = codigo;
        this.obraSocial = obraSocial;
        this.fechaInicio = fechaInicio;
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
        this.estadoPeticion = estadoPeticion;
        this.codPaciente = codPaciente;
        this.codSucursal = codSucursal;
        this.codPracticas = codPracticas;
        this.codResultadosPracticas = codResultadosPracticas;
    }

    public Integer getCodigo() {
        return codigo;
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

    public Integer getCodPaciente() {
        return codPaciente;
    }

    public void setCodPaciente(Integer codPaciente) {
        this.codPaciente = codPaciente;
    }

    public Integer getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(Integer codSucursal) {
        this.codSucursal = codSucursal;
    }

    public List<Integer> getCodPracticas() {
        return codPracticas;
    }

    public void setCodPracticas(List<Integer> codPracticas) {
        this.codPracticas = codPracticas;
    }

    public List<Integer> getCodResultadosPracticas() {
        return codResultadosPracticas;
    }

    public void setCodResultadosPracticas(List<Integer> codResultadosPracticas) {
        this.codResultadosPracticas = codResultadosPracticas;
    }
}



