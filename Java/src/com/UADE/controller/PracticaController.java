package com.UADE.controller;

import java.util.ArrayList;
import java.util.List;

import com.UADE.dao.CriterioDAO;
import com.UADE.dao.PracticaDAO;
import com.UADE.dto.CriterioDTO;
import com.UADE.dto.ListaPracticasDTO;
import com.UADE.dto.PracticaDTO;
import com.UADE.model.*;

public class PracticaController {
    private List<Practica> practicas;
    private final PracticaDAO DAO_Practica;

    private List<Criterio> criterios;
    private final CriterioDAO DAO_Criterio;

    public PracticaController() throws Exception {
        DAO_Practica = new PracticaDAO(Practica.class, "dao/Practica.dao");
        practicas = DAO_Practica.getAll();

        DAO_Criterio = new CriterioDAO(Criterio.class, "dao/Criterio.dao");
        criterios = DAO_Criterio.getAll();
    }

    private Integer getNuevoCodigoPractica() {
        if (practicas.size() > 0) {
            return practicas.get(practicas.size() - 1).getCodigo() + 1;
        } else {
            return 1;
        }
    }

    public Integer nuevaPractica(PracticaDTO pracdto) throws Exception {
        Practica practica = new Practica(this.getNuevoCodigoPractica(), pracdto.getNombre(), pracdto.getTiempoEstimado(), pracdto.getCodCriterios(), pracdto.getCodSubPracticas());
        practicas.add(practica);

        DAO_Practica.saveAll(practicas);

        return practica.getCodigo();
    }

    public PracticaDTO obtenerDatosPractica(Integer codigo) {
        PracticaDTO practdto = null;

        for (Practica i : this.practicas) {
            if (codigo.intValue() == i.getCodigo().intValue()) {
                practdto = new PracticaDTO(i.getCodigo(), i.getNombre(), i.getTiempoEstimado(), i.getCodCriterios(), i.getCodSubPracticas());
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

        DAO_Practica.saveAll(practicas);
    }

    public void actualizarPractica(PracticaDTO pracdto) throws Exception {
        for (Practica i : this.practicas) {
            if (pracdto.getCodigo().intValue() == i.getCodigo().intValue()) {
                i.setNombre(pracdto.getNombre());
                i.setTiempoEstimado(pracdto.getTiempoEstimado());
                i.setCodCriterios(pracdto.getCodCriterios());
                i.setCodSubPracticas(pracdto.getCodSubPracticas());
                DAO_Practica.saveAll(practicas);
                break;
            }
        }
    }

    public List<PracticaDTO> obtenerListaPracticas() {
        List<PracticaDTO> listaPracticas = new ArrayList<>();

        for (Practica i : this.practicas) {
            listaPracticas.add(new PracticaDTO(i.getCodigo(),i.getNombre(),i.getTiempoEstimado(), i.getCodCriterios(), i.getCodSubPracticas()));
        }

        return listaPracticas;
    }

    public List<ListaPracticasDTO> obtenerListaPracticasSimplificada() {
        List<ListaPracticasDTO> listaPracticas = new ArrayList<>();

        for (Practica i : this.practicas) {
            listaPracticas.add(new ListaPracticasDTO(i.getCodigo(),i.getNombre()));
        }

        return listaPracticas;
    }

    public CriterioDTO obtenerCriterio(Integer codCriterio) {
        CriterioDTO cdto = null;

        for (Criterio i : this.criterios) {
            if (i.getCodigo().intValue() == codCriterio.intValue()) {
                cdto = new CriterioDTO(i.getCodigo(), i.getSexo(), i.getCondicionesPreexistentes(), i.getEdadDesde(), i.getEdadHasta(), i.getInterpretacion(), i.getReferenciaInferior(), i.getReferenciaSuperior(), i.getUnidadMedida(), i.getReservado());
                break;
            }
        }

        return cdto;
    }

    public List<CriterioDTO> obtenerCriteriosPractica(Integer codPractica) {
        List<CriterioDTO> listdto = new ArrayList<>();

        for (Practica i : this.practicas) {
            if (codPractica.intValue() == i.getCodigo().intValue()) {
                for (Integer j : i.getCodCriterios()) {
                    listdto.add(this.obtenerCriterio(j));
                }
            }
        }

        return listdto;
    }

}
