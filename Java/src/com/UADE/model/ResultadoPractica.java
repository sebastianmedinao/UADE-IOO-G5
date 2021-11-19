package com.UADE.model;

import com.UADE.enums.EstadoResultado;

public class ResultadoPractica {
    private final Integer codigo;
    private Float resultadoNumerico;
    private String resultadoLiteral;
    private String transcripcion;
    private EstadoResultado estado;

    public ResultadoPractica(Integer codigo, Float resultadoNumerico, String resultadoLiteral, String transcripcion, EstadoResultado estado)
    {
        this.codigo = codigo;
        this.resultadoNumerico = resultadoNumerico;
        this.resultadoLiteral = resultadoLiteral;
        this.transcripcion = transcripcion;
        this.estado = estado;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Float getResultadoNumerico() {
        return resultadoNumerico;
    }

    public void setResultadoNumerico(Float resultadoNumerico) {
        this.resultadoNumerico = resultadoNumerico;
    }

    public String getResultadoLiteral() {
        return resultadoLiteral;
    }

    public void setResultadoLiteral(String resultadoLiteral) {
        this.resultadoLiteral = resultadoLiteral;
    }

    public String getTranscripcion() {
        return transcripcion;
    }

    public void setTranscripcion(String transcripcion) {
        this.transcripcion = transcripcion;
    }

    public EstadoResultado getEstado() {
        return estado;
    }

    public void setEstado(EstadoResultado estado) {
        this.estado = estado;
    }
}
