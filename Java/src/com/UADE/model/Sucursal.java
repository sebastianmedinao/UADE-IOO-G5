package com.UADE.model;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {
    private final Integer codigo;
    private String direccion;
    private String telefono;
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    public Sucursal(Integer codigo, String direccion, String telefono)
    {
        this.codigo = codigo;
        this.direccion = direccion;
        this.telefono = telefono;
    }


    // Getters y Setters
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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
