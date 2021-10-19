package com.UADE.model;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Paciente {
    private Integer codigo;
    private String dni;
    private String nombreCompleto;
    private String domicilio;
    private String email;
    private Enumeration sexo;
    private Integer edad;
    private static int numeradorCodigoPaciente = 0;

    private List<Peticion> peticiones = new ArrayList<Peticion>();

    public Paciente(Integer codigo, String dni, String nombreCompleto, String domicilio, String email, Enumeration sexo, Integer edad)
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
}
