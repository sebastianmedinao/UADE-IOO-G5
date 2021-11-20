package com.UADE.dao;

import com.UADE.model.Criterio;

public class CriterioDAO extends GenericDAO<Criterio> {
    public CriterioDAO() throws Exception {
        super(Criterio.class, "dao/Criterio.dao");
    }
}
