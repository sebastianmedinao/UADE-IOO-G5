package com.UADE.controller;

import com.UADE.dao.PeticionDAO;
import com.UADE.model.EstadoPeticion;
import com.UADE.model.Peticion;

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

    public Integer nuevaPeticion(String obraSocial, date fechaInicio, date fechaEstimadaEntrega, EstadoPeticion estadoPeticion) throws Exception {
        Peticion peticion = new Peticion(this.getNuevoCodigo(), obraSocial, fechaInicio, fechaEstimadaEntrega, estadoPeticion);
        peticiones.add(peticion);

        DAO.saveAll(peticiones);

        return peticion.getCodigo();
    }

    public DatosPeticionDTO obtenerDatosPeticion(Integer codigo) {
        DatosPeticionDTO petdto = null;

        for (Peticion i : this.peticiones) {
            if (codigo.intValue() == i.getCodigo().intValue()) {
                petdto = new DatosPeticionDTO(i.getCodigo(), i.getObraSocial(), i.getFechaInicio(), i.getFechaEstimadaEntrega(), i.getEstadoPeticion());
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


    public void actualizarPeticion(Integer codigo, String obraSocial, date fechaInicio, date fechaEstimadaEntrega, EstadoPeticion estadoPeticion) throws Exception {
        for (Peticion i : this.peticiones) {
            if (codigo.intValue() == i.getCodigo().intValue()) {
                i.setObraSocial(obraSocial);
                i.setFechaInicio(fechaInicio);
                i.setFechaEstimadaEntrega(fechaEstimadaEntrega);
                i.setEstadoPeticion(estadoPeticion);
                DAO.saveAll(peticiones);
                break;
            }
        }
    }
}