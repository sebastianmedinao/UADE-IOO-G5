package com.UADE.dao;

import com.UADE.model.Valor;

public class ValorDAO extends GenericDAO<Valor> {

    public ValorDAO(Class<Valor> clase, String file) throws Exception {
        super(clase, file);
    }
}
