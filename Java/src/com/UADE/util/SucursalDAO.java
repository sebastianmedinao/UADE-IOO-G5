package com.UADE.util;

import com.UADE.model.Sucursal;

public class SucursalDAO extends GenericDAO<Sucursal> {

    public SucursalDAO(Class<Sucursal> clase, String file) throws Exception {
        super(clase, file);
    }
}
