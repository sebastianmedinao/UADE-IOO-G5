package com.UADE;

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
    private Enumeration rolSistema;

    public Usuario(String usuario, String password, String email,
                   String nombreCompleto, String domicilio, String dni,
                   Date fechaDeNacimiento, Enumeration rolSistema)
    {
        this.usuario = usuario;
        this.password = password;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
        this.domicilio = domicilio;
        this.dni = dni;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.rolSistema = rolSistema;
    }
}
