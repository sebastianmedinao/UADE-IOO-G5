package com.UADE.controller;

import com.UADE.model.RolSistema;
import com.UADE.model.Usuario;
import com.UADE.util.GenericDAO;
import com.UADE.util.UsuarioDAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsuarioController {
    private List<Usuario> usuarios = new ArrayList<Usuario>();
    private UsuarioDAO DAO;

    public UsuarioController() throws Exception {
        DAO = new UsuarioDAO(Usuario.class, "usuario.txt");

        usuarios = DAO.getAll();

        this.nuevoUsuario("admin", "1234", "uade@uade.edu.ar", "administrador", "lima 1", 10444322, new Date(), RolSistema.ADMINISTRADOR);
    }

    public Boolean nuevoUsuario(String nombreUsuario, String password, String email, String nombreCompleto, String domicilio, Integer dni, Date fechaDeNacimiento, RolSistema rolSistema) throws Exception {
        if (buscarUsuarioPorNombreUsuario(nombreUsuario) == null && buscarUsuarioPorDNI(dni) == null) {
            Usuario u = new Usuario(nombreUsuario, password, email, nombreCompleto, domicilio, dni, fechaDeNacimiento, rolSistema);
            this.usuarios.add(u);
            DAO.save(u);
            return true;
        } else {
            return false;
        }
    }

    public Usuario buscarUsuarioPorNombreUsuario(String nombreUsuario) {
        Usuario u = null;

        for (Usuario i : this.usuarios) {
            if (nombreUsuario.compareToIgnoreCase(i.getNombreUsuario()) == 0) {
                u = i;
                break;
            }
        }

        return u;
    }

    public Usuario buscarUsuarioPorDNI(Integer dni) {
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

