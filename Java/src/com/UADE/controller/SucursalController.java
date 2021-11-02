package com.UADE.controller;

import com.UADE.model.RolSistema;
import com.UADE.model.Sucursal;
import com.UADE.util.SucursalDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SucursalController {
    private List<Sucursal> sucursales = new ArrayList<Sucursal>(;
    private SucursalDAO DAO;

    public SucursalController() throws Exception {
        DAO = new SucursalDAO(Sucursal.class, "sucursal.txt");

        sucursales = DAO.getAll();
    }
}
