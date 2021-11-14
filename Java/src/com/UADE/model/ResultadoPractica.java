package com.UADE.model;

public class ResultadoPractica {
    private Float resultadoNumerico;
    private String resultadoLiteral;
    private String transcripcion;
    private EstadoResultado estado;

    public ResultadoPractica(Float resultadoNumerico, String resultadoLiteral, String transcripcion, EstadoResultado estado)
    {
        this.resultadoNumerico = resultadoNumerico;
        this.resultadoLiteral = resultadoLiteral;
        this.transcripcion = transcripcion;
        this.estado = estado;
    }


    // Getters y Setters
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
