package com.UADE.dto;

import com.UADE.model.RolSistema;

import java.util.Date;

public class UsuarioDTO {
    private String nombreUsuario;
    private String email;
    private String nombreCompleto;
    private Integer dni;
    private RolSistema rolSistema;
    private String domicilio;
    private Date fechaNacimiento;

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

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public RolSistema getRolSistema() {
        return rolSistema;
    }

    public void setRolSistema(RolSistema rolSistema) {
        this.rolSistema = rolSistema;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
}
