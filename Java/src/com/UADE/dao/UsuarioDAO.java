package com.UADE.dao;

import com.UADE.model.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario> {

    public UsuarioDAO(Class<Usuario> clase, String file) throws Exception {
        super(clase, file);
    }
}
