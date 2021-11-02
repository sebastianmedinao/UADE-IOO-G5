package com.UADE.util;

import com.UADE.model.Peticion;

public class PeticionDAO extends GenericDAO<Peticion> {

    public PeticionDAO(Class<Peticion> clase, String file) throws Exception {
        super(clase, file);
    }
}