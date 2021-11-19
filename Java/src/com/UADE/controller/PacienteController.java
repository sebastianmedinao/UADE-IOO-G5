package com.UADE.controller;

import com.UADE.dao.PacienteDAO;
import com.UADE.dto.PacienteDTO;
import com.UADE.enums.Sexo;
import com.UADE.model.*;

import java.util.ArrayList;
import java.util.List;

public class PacienteController {
    private List<Paciente> pacientes = new ArrayList<Paciente>();
    private final PacienteDAO DAO_Paciente;

    public PacienteController() throws Exception {
        DAO_Paciente = new PacienteDAO(Paciente.class, "dao/Paciente.dao");
        pacientes = DAO_Paciente.getAll();
    }

    private Integer getNuevoCodigoPaciente() {
        if (pacientes.size() > 0) {
            return pacientes.get(pacientes.size() - 1).getCodigo() + 1;
        } else {
            return 1;
        }
    }

    public Integer nuevoPaciente(PacienteDTO pac) throws Exception {
        if (buscarPacientePorDNI(pac.getDni()) == null) {
            Paciente p = new Paciente(this.getNuevoCodigoPaciente(), pac.getDni(), pac.getNombreCompleto(), pac.getDomicilio(), pac.getEmail(), pac.getSexo(), pac.getEdad());
            this.pacientes.add(p);
            DAO_Paciente.saveAll(pacientes);
            return p.getCodigo();
        } else {
            return null;
        }
    }

    public Integer buscarPacientePorDNI(Integer dni) {
        for (Paciente i : this.pacientes) {
            if (dni.intValue() == i.getDni().intValue()) {
                return i.getCodigo();
            }
        }

        return null;
    }

    public PacienteDTO obtenerPaciente(Integer codigo) {
        PacienteDTO pac = null;

        for (Paciente i : this.pacientes) {
            if (codigo.intValue() == i.getCodigo().intValue()) {
                pac = new PacienteDTO(i.getCodigo(), i.getDni(), i.getEmail(), i.getDomicilio(), i.getEmail(), i.getSexo(), i.getEdad());
                break;
            }
        }

        return pac;
    }

    public List<PacienteDTO> obtenerListaPacientes() throws Exception {
        List<PacienteDTO> lista = new ArrayList<PacienteDTO>();

        for (Paciente i : pacientes) {
            lista.add(new PacienteDTO(i.getCodigo(), i.getDni(), i.getEmail(), i.getDomicilio(), i.getEmail(), i.getSexo(), i.getEdad()));
        }

        return lista;
    }

}