package com.UADE.model;

import java.util.Date;

public class Usuario {
    private String nombreUsuario;
    private String password;
    private String email;
    private String nombreCompleto;
    private String domicilio;
    private Integer dni;
    private Date fechaDeNacimiento;
    private RolSistema rolSistema;

    public Usuario(String nombreUsuario, String password, String email,
                   String nombreCompleto, String domicilio, Integer dni,
                   Date fechaDeNacimiento, RolSistema rolSistema) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
        this.domicilio = domicilio;
        this.dni = dni;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.rolSistema = rolSistema;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public RolSistema getRolSistema() {
        return rolSistema;
    }

    public void setRolSistema(RolSistema rolSistema) {
        this.rolSistema = rolSistema;
    }
}

