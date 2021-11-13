package com.UADE.controller;

import com.UADE.dto.UsuarioDTO;
import com.UADE.model.Sucursal;
import com.UADE.dao.SucursalDAO;
import com.UADE.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class SucursalController {
    private List<Sucursal> sucursales = new ArrayList<Sucursal>();
    private final SucursalDAO DAO;

    public SucursalController() throws Exception {
        DAO = new SucursalDAO(Sucursal.class, "Sucursal.dao");

        sucursales = DAO.getAll();
    }

    public Integer nuevaSucursal(String direccion, String telefono) throws Exception {
        Sucursal sucursal = new Sucursal(direccion, telefono);
        sucursales.add(sucursal);

        DAO.saveAll(sucursales);

        return sucursal.getCodigo();
    }

    public void eliminarSucursal(Integer codigo) throws Exception {
        System.out.println(codigo);

        Sucursal sucABorrar = null;

        for (Sucursal i : this.sucursales) {
            if (codigo.intValue() == i.getCodigo().intValue()) {
                sucABorrar = i;
                break;
            }
        }

        // Faltan reglas de negocio

        sucursales.remove(sucABorrar);

        DAO.saveAll(sucursales);
    }

    public List<Integer> obtenerListaSucursales() {
        List<Integer> suclist = new ArrayList<Integer>();

        for (Sucursal i : sucursales) {
            suclist.add(i.getCodigo());
        }

        return suclist;
    }

}
