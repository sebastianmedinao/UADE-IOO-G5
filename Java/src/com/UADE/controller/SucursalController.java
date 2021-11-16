package com.UADE.controller;

import com.UADE.dao.UsuarioDAO;
import com.UADE.dto.DatosSucursalDTO;
import com.UADE.dto.UsuarioDTO;
import com.UADE.model.Sucursal;
import com.UADE.dao.SucursalDAO;
import com.UADE.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class SucursalController {
    private List<Sucursal> sucursales = new ArrayList<Sucursal>();
    private final SucursalDAO DAO;

    private List<Usuario> usuarios = new ArrayList<Usuario>();
    private final UsuarioDAO DAO_Usuarios;

    public SucursalController() throws Exception {
        DAO = new SucursalDAO(Sucursal.class, "dao/Sucursal.dao");
        sucursales = DAO.getAll();

        DAO_Usuarios = new UsuarioDAO(Usuario.class, "dao/Usuario.dao");
        usuarios = DAO_Usuarios.getAll();
    }

    private Integer getNuevoCodigo() {
        if (sucursales.size() > 0) {
            Sucursal lastsuc = sucursales.get(sucursales.size() - 1);
            return lastsuc.getCodigo() + 1;
        } else {
            return 1;
        }
    }

    public Integer nuevaSucursal(String direccion, String telefono) throws Exception {
        Sucursal sucursal = new Sucursal(this.getNuevoCodigo(), direccion, telefono);
        sucursales.add(sucursal);

        DAO.saveAll(sucursales);

        return sucursal.getCodigo();
    }

    public DatosSucursalDTO obtenerDatosSucursal(Integer codigo) {
        DatosSucursalDTO sucdto = null;

        for (Sucursal i : this.sucursales) {
            if (codigo.intValue() == i.getCodigo().intValue()) {
                sucdto = new DatosSucursalDTO(i.getCodigo(), i.getDireccion(), i.getTelefono(), i.getUsuarios(), i.getRespTecnico());
                break;
            }
        }

        return sucdto;
    }

    public void eliminarSucursal(Integer codigo) throws Exception {
        Sucursal sucABorrar = null;

        for (Sucursal i : this.sucursales) {
            if (codigo.intValue() == i.getCodigo().intValue()) {
                sucABorrar = i;
                break;
            }
        }

        // TODO: Faltan reglas de negocio

        sucursales.remove(sucABorrar);

        DAO.saveAll(sucursales);
    }

    public void actualizarSucursal(Integer codigo, String direccion, String telefono) throws Exception {
        for (Sucursal i : this.sucursales) {
            if (codigo.intValue() == i.getCodigo().intValue()) {
                i.setDireccion(direccion);
                i.setTelefono(telefono);
                DAO.saveAll(sucursales);
                break;
            }
        }
    }

    public List<DatosSucursalDTO> obtenerListaSucursales() {
        List<DatosSucursalDTO> suclist = new ArrayList<DatosSucursalDTO>();

        for (Sucursal i : sucursales) {
            suclist.add(new DatosSucursalDTO(i.getCodigo(), i.getDireccion(), i.getTelefono(), i.getUsuarios(), i.getRespTecnico()));
        }

        return suclist;
    }

    public void agregarUsuarioASucursal(Integer codigo, String nombreUsuario, Boolean respTecnico) throws Exception {
        Usuario u = null;

        for (Usuario i : this.usuarios) {
            if (nombreUsuario.compareToIgnoreCase(i.getNombreUsuario()) == 0) {
                u = i;
                break;
            }
        }

        for (Sucursal i : this.sucursales) {
            if (codigo.intValue() == i.getCodigo().intValue()) {

                i.addUsuario(u);

                if (respTecnico) {
                    i.setRespTecnico(u);
                }

                break;
            }
        }

        DAO.saveAll(sucursales);
    }

    public void retirarUsuarioDeSucursal(Integer codigo, String nombreUsuario) throws Exception {
        Usuario u = null;

        for (Usuario i : this.usuarios) {
            if (nombreUsuario.compareToIgnoreCase(i.getNombreUsuario()) == 0) {
                u = i;
                break;
            }
        }

        System.out.print("USUARIO ");
        System.out.println(u.getNombreUsuario());


        for (Sucursal i : this.sucursales) {
            System.out.print("SUCURSAL BUSCADA ");
            System.out.println(codigo.intValue());
            System.out.print("SUCURSAL I ");
            System.out.println(i.getCodigo());
            if (codigo.intValue() == i.getCodigo().intValue()) {

                System.out.print("REMOVE USUARIO");

                i.removeUsuario(u);

                if (i.getRespTecnico() == u) {
                    i.setRespTecnico(null);
                }

                break;
            }
        }

        DAO.saveAll(sucursales);
    }

    public List<UsuarioDTO> obtenerUsuariosSucursal(Integer codigo) {
        List<UsuarioDTO> us = new ArrayList<>();

        for (Usuario i : this.usuarios) {
            us.add(new UsuarioDTO(i.getNombreUsuario(), i.getEmail(), i.getNombreCompleto(), i.getDni(), i.getRolSistema(), i.getDomicilio(), i.getFechaDeNacimiento()));
        }

        return us;
    }
}
