package com.UADE.dto;

public class DatosSucursalDTO {
    private final Integer codigo;
    private final String direccion;
    private final String telefono;

    public DatosSucursalDTO(Integer codigo, String direccion, String telefono) {
        this.codigo = codigo;
        this.direccion = direccion;
        this.telefono = telefono;
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
}
