package com.UADE.controller;

import com.UADE.dao.PeticionDAO;
import com.UADE.dao.ResultadoPracticaDAO;
import com.UADE.dto.ListaPeticionesDTO;
import com.UADE.dto.PeticionDTO;
import com.UADE.dto.ResultadoPracticaDTO;
import com.UADE.enums.EstadoPeticion;
import com.UADE.model.Peticion;
import com.UADE.model.ResultadoPractica;

import java.util.ArrayList;
import java.util.List;

public class PeticionController {
    private final PeticionDAO DAO_Peticion;
    private final ResultadoPracticaDAO DAO_ResultadoPractica;
    private List<Peticion> peticiones = new ArrayList<Peticion>();
    private List<ResultadoPractica> resultadosPracticas = new ArrayList<>();

    public PeticionController() throws Exception {
        DAO_Peticion = new PeticionDAO(Peticion.class, "dao/Peticion.dao");
        peticiones = DAO_Peticion.getAll();

        DAO_ResultadoPractica = new ResultadoPracticaDAO(ResultadoPractica.class, "dao/ResultadoPractica.dao");
        resultadosPracticas = DAO_ResultadoPractica.getAll();
    }

    private Integer getNuevoCodigoPeticion() {
        if (peticiones.size() > 0) {
            return peticiones.get(peticiones.size() - 1).getCodigo() + 1;
        } else {
            return 1;
        }
    }

    public Integer nuevaPeticion(PeticionDTO petdto) throws Exception {
        Peticion peticion = new Peticion(this.getNuevoCodigoPeticion(), petdto.getObraSocial(), petdto.getFechaInicio(), petdto.getFechaEstimadaEntrega(), petdto.getEstadoPeticion(), petdto.getCodPaciente(), petdto.getCodSucursal(), petdto.getCodPracticas(), petdto.getCodResultadosPracticas());
        peticiones.add(peticion);

        DAO_Peticion.saveAll(peticiones);

        return peticion.getCodigo();
    }

    public PeticionDTO obtenerDatosPeticion(Integer codigo) {
        PeticionDTO petdto = null;

        for (Peticion i : this.peticiones) {
            if (codigo.intValue() == i.getCodigo().intValue()) {
                petdto = new PeticionDTO(i.getCodigo(), i.getObraSocial(), i.getFechaInicio(), i.getFechaEstimadaEntrega(), i.getEstadoPeticion(), i.getCodPaciente(), i.getCodSucursal(), i.getCodPracticas(), i.getCodResultadosPracticas());
                break;
            }
        }

        return petdto;
    }

    public List<ResultadoPracticaDTO> obtenerResultadosPeticion(Integer codigo) {
        List<ResultadoPracticaDTO> rp = new ArrayList<>();

        for (Peticion i : this.peticiones) {
            if (codigo.intValue() == i.getCodigo().intValue()) {
                for (Integer j : i.getCodResultadosPracticas()) {
                    rp.add(this.obtenerResultadoPractica(j));
                }
            }
        }

        return rp;
    }

    public ResultadoPracticaDTO obtenerResultadoPractica(Integer codigo) {
        ResultadoPracticaDTO res = null;

        for (ResultadoPractica i : this.resultadosPracticas) {
            if (codigo.intValue() == i.getCodigo().intValue()) {
                res = new ResultadoPracticaDTO(i.getCodigo(), i.getResultadoNumerico(), i.getResultadoLiteral(), i.getResultadoLiteral(), i.getEstado());
                break;
            }
        }

        return res;
    }

    public boolean eliminarPeticion(Integer codigo) throws Exception {
        Peticion petABorrar = null;

        for (Peticion i : this.peticiones) {
            if (codigo.intValue() == i.getCodigo().intValue()) {
                if (i.getEstadoPeticion() == EstadoPeticion.INICIO) {
                    petABorrar = i;
                }
                break;
            }
        }

        // TODO: Faltan reglas de negocio
        if (petABorrar == null) {
            return false;
        } else {
            peticiones.remove(petABorrar);
            DAO_Peticion.saveAll(peticiones);
            return true;
        }
    }


    public void actualizarPeticion(PeticionDTO petdto) throws Exception {
        for (Peticion i : this.peticiones) {
            if (petdto.getCodigo().intValue() == i.getCodigo().intValue()) {
                i.setObraSocial(petdto.getObraSocial());
                i.setFechaInicio(petdto.getFechaInicio());
                i.setFechaEstimadaEntrega(petdto.getFechaEstimadaEntrega());
                i.setEstadoPeticion(petdto.getEstadoPeticion());
                i.setCodPaciente(petdto.getCodPaciente());
                i.setCodPracticas(petdto.getCodPracticas());
                i.setCodSucursal(petdto.getCodSucursal());
                i.setCodResultadosPracticas(petdto.getCodResultadosPracticas());
                DAO_Peticion.saveAll(peticiones);
                break;
            }
        }
    }

    public List<ListaPeticionesDTO> obtenerListaPeticiones() {
        List<ListaPeticionesDTO> petlist = new ArrayList<>();

        for (Peticion i : peticiones) {
            petlist.add(new ListaPeticionesDTO(i.getCodigo(), i.getFechaInicio(), i.getCodPaciente()));
        }

        return petlist;
    }

}
