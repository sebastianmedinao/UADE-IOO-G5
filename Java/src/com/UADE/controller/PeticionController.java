package com.UADE.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.UADE.dao.PeticionDAO;
import com.UADE.dto.DatosPeticionDTO;
import com.UADE.model.*;

public class PeticionController {
    private List<Peticion> peticiones = new ArrayList<Peticion>();
    private final PeticionDAO DAO;

    public PeticionController() throws Exception {
        DAO = new PeticionDAO(Peticion.class, "dao/Peticion.dao");
        peticiones = DAO.getAll();
    }


    private Integer getNuevoCodigo() {
        Peticion lastpet = peticiones.get(peticiones.size() - 1);
        return lastpet.getCodigo() + 1;
    }

    public Integer nuevaPeticion(String obraSocial, Date fechaInicio, Date fechaEstimadaEntrega, List<Practica> practicas, EstadoPeticion estadoPeticion, Paciente paciente, Sucursal sucursal, List<ResultadoPractica> resultadoPractica) throws Exception {
        Peticion peticion = new Peticion(this.getNuevoCodigo(), obraSocial, fechaInicio, practicas, fechaEstimadaEntrega, estadoPeticion, paciente, sucursal, resultadoPractica);
        peticiones.add(peticion);

        DAO.saveAll(peticiones);

        return peticion.getCodigo();
    }

    public DatosPeticionDTO obtenerDatosPeticion(Integer codigo) {
        DatosPeticionDTO petdto = null;

        for (Peticion i : this.peticiones) {
            if (codigo.intValue() == i.getCodigo().intValue()) {
                petdto = new DatosPeticionDTO(i.getCodigo(), i.getObraSocial(), i.getFechaInicio(), i.getFechaEstimadaEntrega(), i.getEstadoPeticion(),i.getPaciente(),i.getSucursal(),i.getPracticas(), i.getResultadosPracticas());
                break;
            }
        }

        return petdto;
    }

    public void eliminarPeticion(Integer codigo) throws Exception {
        Peticion petABorrar = null;

        for (Peticion i : this.peticiones) {
            if (codigo.intValue() == i.getCodigo().intValue()) {
                petABorrar = i;
                break;
            }
        }

        // TODO: Faltan reglas de negocio

        peticiones.remove(petABorrar);

        DAO.saveAll(peticiones);
    }


    public void actualizarPeticion(Integer codigo, String obraSocial, Date fechaInicio, Date fechaEstimadaEntrega, EstadoPeticion estadoPeticion, Paciente paciente, Sucursal sucursal, List<Practica> practicas, List<ResultadoPractica> resultadosPracticas) throws Exception {
        for (Peticion i : this.peticiones) {
            if (codigo.intValue() == i.getCodigo().intValue()) {
                i.setObraSocial(obraSocial);
                i.setFechaInicio(fechaInicio);
                i.setFechaEstimadaEntrega(fechaEstimadaEntrega);
                i.setEstadoPeticion(estadoPeticion);
                i.setPaciente(paciente);
                i.setSucursal(sucursal);
                i.setPracticas(practicas);
                i.setResultadosPracticas(resultadosPracticas);
                DAO.saveAll(peticiones);
                break;
            }
        }
    }
}
