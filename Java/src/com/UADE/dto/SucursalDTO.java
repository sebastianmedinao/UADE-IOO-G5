package com.UADE.dto;

import java.util.ArrayList;
import java.util.List;

public class SucursalDTO {
    private final Integer codigo;
    private String direccion;
    private String telefono;
    private List<Integer> codUsuarios = new ArrayList<Integer>();
    private Integer codUsuarioRespTecnico = null;

    public SucursalDTO(Integer codigo, String direccion, String telefono, List<Integer> codUsuarios, Integer codUsuarioRespTecnico) {
        this.codigo = codigo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.codUsuarios = codUsuarios;
        this.codUsuarioRespTecnico = codUsuarioRespTecnico;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Integer> getCodUsuarios() {
        return codUsuarios;
    }

    public void setCodUsuarios(List<Integer> codUsuarios) {
        this.codUsuarios = codUsuarios;
    }

    public Integer getCodUsuarioRespTecnico() {
        return codUsuarioRespTecnico;
    }

    public void setCodUsuarioRespTecnico(Integer codUsuarioRespTecnico) {
        this.codUsuarioRespTecnico = codUsuarioRespTecnico;
    }
}
