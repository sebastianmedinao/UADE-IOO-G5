package com.UADE.controller;

import com.UADE.dao.PacienteDAO;
import com.UADE.dao.UsuarioDAO;
import com.UADE.dto.UsuarioDTO;
import com.UADE.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PacienteController {
    private List<Paciente> pacientes = new ArrayList<Paciente>();
    private final PacienteDAO DAO;

    public PacienteController() throws Exception {
        DAO = new PacienteDAO(Paciente.class, "dao/Paciente.dao");

        pacientes = DAO.getAll();

        this.nuevoPaciente(1,43571048, "Paciente Prueba", "Independencia 123", "uade@uade.edu.ar", Sexo.FEMENINO, 20);
    }

    private Integer getNuevoCodigo() {
        Paciente lastpa = pacientes.get(pacientes.size() - 1);
        return lastpa.getCodigo() + 1;
    }

    public Boolean nuevoPaciente(Integer codigo, Integer dni, String nombreCompleto, String domicilio, String email, Sexo sexo, Integer edad) throws Exception {
        if (buscarPacientePorDNI(dni) == true) {
            Paciente p = new Paciente(this.getNuevoCodigo(), dni, nombreCompleto, domicilio, email, sexo, edad);
            this.pacientes.add(p);
            DAO.save(p);
            return true;
        } else {
            return false;
        }
    }


    public boolean buscarPacientePorDNI(Integer dni) {
        PacienteDAO pdao = null;

        for (Paciente i : this.pacientes) {
            if (dni.intValue() == i.getDni().intValue()) {
                //pdao = new PacienteDAO(i.getCodigo(), i.getDni(), i.getEmail(), i.getDomicilio(), i.getEmail(), i.getSexo(), i.getEdad());
                return false;
            }
        }

        return true;
    }


    public List<Paciente> obtenerListaPacientes() throws Exception {
        List<Paciente> lista = new ArrayList<Paciente>();

        for (Paciente i : pacientes) {
            lista.add(new Paciente(i.getCodigo(), i.getDni(), i.getEmail(), i.getDomicilio(), i.getEmail(), i.getSexo(), i.getEdad()));
        }

        return lista;
    }

}