package com.UADE.controller;

import java.util.Date;
import java.util.List;

import com.UADE.dao.PracticaDAO;
import com.UADE.dto.DatosPracticaDTO;
import com.UADE.model.*;

public class PracticaController {
    private List<Practica> practicas;
    private final PracticaDAO DAO;

    public PracticaController() throws Exception {
        DAO = new PracticaDAO(Practica.class, "dao/Practica.dao");
        practicas = DAO.getAll();
    }

    private Integer getNuevoCodigo() {
        Practica lastpract = practicas.get(practicas.size() - 1);
        return lastpract.getCodigo() + 1;
    }

    //private Integer codigo;
    //    private String nombre;
    //    private Integer tiempoEstimado;
    //    private List<Criterio> criterios = new ArrayList<Criterio>();

    public Integer nuevaPractica(Integer codigo, String nombre, Integer tiempoEstimado, List<Criterio> criterios) throws Exception {
        Practica practica = new Practica(codigo, nombre, tiempoEstimado, criterios);
        practicas.add(practica);

        DAO.saveAll(practicas);

        return practica.getCodigo();
    }


    public DatosPracticaDTO obtenerDatosPractica(Integer codigo) {
        DatosPracticaDTO practdto = null;

        for (Practica i : this.practicas) {
            if (codigo.intValue() == i.getCodigo().intValue()) {
                practdto = new DatosPracticaDTO()(i.getCodigo(), i.getNombre(), i.getTiempoEstimado(), i.getCriterios());
                break;
            }
        }

        return practdto;
    }

    public void eliminarPractica(Integer codigo) throws Exception {
        Practica practABorrar = null;

        for (Practica i : this.practicas) {
            if (codigo.intValue() == i.getCodigo().intValue()) {
                practABorrar = i;
                break;
            }
        }

        // TODO: Faltan reglas de negocio

        practicas.remove(practABorrar);

        DAO.saveAll(practicas);
    }

    public void actualizarPractica(Integer codigo, String nombre, Integer tiempoEstimado, List<Criterio> criterios) throws Exception {
        for (Practica i : this.practicas) {
            if (codigo.intValue() == i.getCodigo().intValue()) {
                i.setNombre(nombre);
                i.setTiempoEstimado(tiempoEstimado);
                i.setCriterios(criterios);
                DAO.saveAll(practicas);
                break;
            }
        }
    }

}