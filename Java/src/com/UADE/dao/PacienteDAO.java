package com.UADE.dao;

import com.UADE.model.Paciente;

public class PacienteDAO extends GenericDAO<Paciente> {

    public PacienteDAO(Class<Paciente> clase, String file) throws Exception {
        super(clase, file);
    }
}
