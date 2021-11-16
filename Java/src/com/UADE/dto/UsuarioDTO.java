package com.UADE.dto;

import com.UADE.model.RolSistema;

import java.util.Date;

public class UsuarioDTO {
    private final String nombreUsuario;
    private final String email;
    private final String nombreCompleto;
    private final Integer dni;
    private final RolSistema rolSistema;
    private final String domicilio;
    private final Date fechaNacimiento;

    public UsuarioDTO(String nombreUsuario, String email, String nombreCompleto, Integer dni, RolSistema rolSistema, String domicilio, Date fechaNacimiento) {
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.rolSistema = rolSistema;
        this.domicilio = domicilio;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public Integer getDni() {
        return dni;
    }

    public RolSistema getRolSistema() {
        return rolSistema;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

}
