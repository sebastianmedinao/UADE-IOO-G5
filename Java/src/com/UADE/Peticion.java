package com.UADE;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

public class Peticion {

    private Integer codigo;
    private String obraSocial;
    private Date fechaInicio;
    private Date fechaEstimadaEntrega;
    private Enumeration estadoPeticion;
    private Paciente paciente;

    private static int numeradorCodigoPeticion = 0;
    private List<Practica> practicas = new ArrayList<Practica>();
    private List<ResultadoPractica> resultadosPracticas = new ArrayList<ResultadoPractica>();


    public Peticion(Integer codigo, String obraSocial, Date fechaInicio, List practicas, Date fechaEstimadaEntrega, Enumeration estadoPeticion)
    {
        numeradorCodigoPeticion++;
        this.codigo = Integer.valueOf(numeradorCodigoPeticion);
        this.obraSocial = obraSocial;
        this.fechaInicio = fechaInicio;
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
        this.estadoPeticion = estadoPeticion;
    }
}
