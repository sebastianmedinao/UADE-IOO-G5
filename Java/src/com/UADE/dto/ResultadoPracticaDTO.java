package com.UADE.dto;

import com.UADE.enums.EstadoResultado;


//private Float resultadoNumerico;
//    private String resultadoLiteral;
//    private String transcripcion;
//    private EstadoResultado estado;

public class ResultadoPracticaDTO {
    private final Integer codigo;
    private Float resultadoNumerico;
    private String resultadoLiteral;
    private String transcription;
    private EstadoResultado estado;

    public ResultadoPracticaDTO(Integer codigo, Float resultadoNumerico, String resultadoLiteral, String transcription, EstadoResultado estado) {
        this.codigo = codigo;
        this.resultadoNumerico = resultadoNumerico;
        this.resultadoLiteral = resultadoLiteral;
        this.transcription = transcription;
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

    public String getTranscription() {
        return transcription;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }

    public EstadoResultado getEstado() {
        return estado;
    }

    public void setEstado(EstadoResultado estado) {
        this.estado = estado;
    }
}
