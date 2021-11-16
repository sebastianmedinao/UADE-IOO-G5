package com.UADE.controller;

import com.UADE.dto.DatosSucursalDTO;
import com.UADE.dto.UsuarioDTO;
import com.UADE.model.RolSistema;
import com.UADE.model.Sucursal;
import com.UADE.model.Usuario;
import com.UADE.dao.UsuarioDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsuarioController {
    private List<Usuario> usuarios = new ArrayList<Usuario>();
    private final UsuarioDAO DAO;

    public UsuarioController() throws Exception {
        DAO = new UsuarioDAO(Usuario.class, "dao/Usuario.dao");

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

    public Boolean actualizarUsuario(String nombreUsuario, String password, String email, String nombreCompleto, String domicilio, Integer dni, Date fechaDeNacimiento, RolSistema rolSistema) throws Exception {
        Usuario u = null;

        for (Usuario i : this.usuarios) {
            if (nombreUsuario.compareToIgnoreCase(i.getNombreUsuario()) == 0) {
                u = i;
                break;
            }
        }

        if (u != null) {
            if (password.length() > 0) { // Solo guardo la clave si fue escrita una nueva
                u.setPassword(password);
            }

            u.setEmail(email);
            u.setNombreCompleto(nombreCompleto);
            u.setDomicilio(domicilio);
            u.setDni(dni);
            u.setFechaDeNacimiento(fechaDeNacimiento);
            u.setRolSistema(rolSistema);

            DAO.saveAll(usuarios);

            return true;
        } else {
            return false;
        }
    }

    public UsuarioDTO buscarUsuarioPorNombreUsuario(String nombreUsuario) {
        UsuarioDTO udto = null;

        for (Usuario i : this.usuarios) {
            if (nombreUsuario.compareToIgnoreCase(i.getNombreUsuario()) == 0) {
                udto = new UsuarioDTO(i.getNombreUsuario(), i.getEmail(), i.getNombreCompleto(), i.getDni(), i.getRolSistema(), i.getDomicilio(), i.getFechaDeNacimiento());
                break;
            }
        }

        return udto;
    }

    public UsuarioDTO buscarUsuarioPorDNI(Integer dni) {
        UsuarioDTO udto = null;

        for (Usuario i : this.usuarios) {
            if (dni.intValue() == i.getDni().intValue()) {
                udto = new UsuarioDTO(i.getNombreUsuario(), i.getEmail(), i.getNombreCompleto(), i.getDni(), i.getRolSistema(), i.getDomicilio(), i.getFechaDeNacimiento());
                break;
            }
        }

        return udto;
    }

    public UsuarioDTO buscarUsuarioPorCredenciales(String nombreUsuario, String clave) {
        UsuarioDTO udto = null;

        for (Usuario i : this.usuarios) {
            if (nombreUsuario.compareToIgnoreCase(i.getNombreUsuario()) == 0 && clave.compareToIgnoreCase(i.getPassword()) == 0) {
                udto = new UsuarioDTO(i.getNombreUsuario(), i.getEmail(), i.getNombreCompleto(), i.getDni(), i.getRolSistema(), i.getDomicilio(), i.getFechaDeNacimiento());
                break;
            }
        }

        return udto;
    }

    public List<UsuarioDTO> obtenerListaUsuarios() {
        List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();

        for (Usuario i : usuarios) {
            lista.add(new UsuarioDTO(i.getNombreUsuario(), i.getEmail(), i.getNombreCompleto(), i.getDni(), i.getRolSistema(), i.getDomicilio(), i.getFechaDeNacimiento()));
        }

        return lista;
    }

    public void borrarUsuario(String nombreUsuario) throws Exception {
        System.out.println(nombreUsuario);
        for (Usuario i : this.usuarios) {
            if (nombreUsuario.compareToIgnoreCase(i.getNombreUsuario()) == 0) {
                this.usuarios.remove(i);
                DAO.saveAll(usuarios);
                break;
            }
        }
    }
}

