package com.UADE.dto;

import com.UADE.model.Usuario;

import java.util.List;

public class DatosSucursalDTO {
    private final Integer codigo;
    private final String direccion;
    private final String telefono;
    private final List<Usuario> usuarios;
    private final Usuario respTecnico;

    public DatosSucursalDTO(Integer codigo, String direccion, String telefono, List<Usuario> usuarios, Usuario respTecnico) {
        this.codigo = codigo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.usuarios = usuarios;
        this.respTecnico = respTecnico;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario getRespTecnico() {
        return respTecnico;
    }
}
