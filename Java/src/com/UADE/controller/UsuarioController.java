package com.UADE.controller;

import com.UADE.model.RolSistema;
import com.UADE.model.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsuarioController {
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    public UsuarioController() {
        //
    }

    public Boolean nuevoUsuario(String nombreUsuario, String password, String email, String nombreCompleto, String domicilio, Integer dni, Date fechaDeNacimiento, RolSistema rolSistema) {
        if (buscarUsuarioPorNombreUsuario(nombreUsuario) == null && buscarUsuarioPorDNI(dni) == null) {
            Usuario u = new Usuario(nombreUsuario, password, email, nombreCompleto, domicilio, dni, fechaDeNacimiento, rolSistema);
            this.usuarios.add(u);
            return true;
        } else {
            return false;
        }
    }

    private Usuario buscarUsuarioPorNombreUsuario(String nombreUsuario) {
        Usuario u = null;

        for (Usuario i : this.usuarios) {
            if (nombreUsuario.compareToIgnoreCase(i.getNombreUsuario()) == 0) {
                u = i;
                break;
            }
        }

        return u;
    }

    private Usuario buscarUsuarioPorDNI(Integer dni) {
        Usuario u = null;

        for (Usuario i : this.usuarios) {
            if (dni.intValue() == i.getDni().intValue()) {
                u = i;
                break;
            }
        }

        return u;
    }

    private Boolean login(String usuario, String password) {
        return false;
    }
}

