package com.UADE.model;

import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private static int numeradorCodigoPaciente = 0;
    private Integer codigo;
    private String dni;
    private String nombreCompleto;
    private String domicilio;
    private String email;
    private Sexo sexo;
    private Integer edad;
    private List<Peticion> peticiones = new ArrayList<Peticion>();

    public Paciente(Integer codigo, String dni, String nombreCompleto, String domicilio, String email, Sexo sexo, Integer edad)
    {
        numeradorCodigoPaciente++;
        this.codigo = Integer.valueOf(numeradorCodigoPaciente);
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.domicilio = domicilio;
        this.email = email;
        this.sexo = sexo;
        this.edad = edad;
    }


    // Getters y Setters
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public List<Peticion> getPeticiones() {
        return peticiones;
    }

    public void setPeticiones(List<Peticion> peticiones) {
        this.peticiones = peticiones;
    }
}
