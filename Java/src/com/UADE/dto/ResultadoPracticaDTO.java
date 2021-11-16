package com.UADE.dto;

import com.UADE.model.EstadoResultado;
import com.UADE.model.*;


import java.util.ArrayList;
import java.util.List;


//private Float resultadoNumerico;
//    private String resultadoLiteral;
//    private String transcripcion;
//    private EstadoResultado estado;

public class ResultadoPracticaDTO {
    private final Float resultadoNumerico;
    private final String resultadoLiteral;
    private final String transcription;
    private final EstadoResultado estado;

    public ResultadoPracticaDTO(Float resultadoNumerico, String resultadoLiteral, String transcription, EstadoResultado estado) {
        this.resultadoNumerico = resultadoNumerico;
        this.resultadoLiteral = resultadoLiteral;
        this.transcription = transcription;
        this.estado = estado;
    }

    public Float getResultadoNumerico() {
        return resultadoNumerico;
    }

    public String getResultadoLiteral() {
        return resultadoLiteral;
    }

    public String getTranscription() {
        return transcription;
    }

    public EstadoResultado getEstado() { return estado;}

}
