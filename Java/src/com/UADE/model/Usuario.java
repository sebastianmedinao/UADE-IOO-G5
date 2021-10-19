package com.UADE.model;

import java.util.Date;
import java.util.Enumeration;

public class Usuario {

    private String usuario;
    private String password;
    private String email;
    private String nombreCompleto;
    private String domicilio;
    private String dni;
    private Date fechaDeNacimiento;
    private RolSistema rolSistema;

    public Usuario(String usuario, String password, String email,
                   String nombreCompleto, String domicilio, String dni,
                   Date fechaDeNacimiento, RolSistema rolSistema) {
        this.usuario = usuario;
        this.password = password;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
        this.domicilio = domicilio;
        this.dni = dni;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.rolSistema = rolSistema;
    }


    //Getters y Setters

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
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

