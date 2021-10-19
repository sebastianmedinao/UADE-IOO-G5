package com.UADE.model;

import java.util.Enumeration;

public class ResultadoPractica {

    private Float resultadoNumerico;
    private String resultadoLiteral;
    private String transcripcion;
    private Enumeration estado;

    public ResultadoPractica(Float resultadoNumerico, String resultadoLiteral, String transcripcion, Enumeration estado)
    {
        this.resultadoNumerico = resultadoNumerico;
        this.resultadoLiteral = resultadoLiteral;
        this.transcripcion = transcripcion;
        this.estado = estado;
    }
}
