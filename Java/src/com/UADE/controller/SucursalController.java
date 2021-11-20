package com.UADE.controller;

import com.UADE.dao.SucursalDAO;
import com.UADE.dao.UsuarioDAO;
import com.UADE.dto.SucursalDTO;
import com.UADE.dto.UsuarioDTO;
import com.UADE.model.Sucursal;
import com.UADE.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class SucursalController {
    private final SucursalDAO DAO_Sucursal;
    private final List<Sucursal> sucursales;

    public SucursalController() throws Exception {
        DAO_Sucursal = new SucursalDAO();
        sucursales = DAO_Sucursal.getAll();
    }

    private Integer getNuevoCodigoSucursal() {
        if (sucursales.size() > 0) {
            return sucursales.get(sucursales.size() - 1).getCodigo() + 1;
        } else {
            return 1;
        }
    }

    public Integer nuevaSucursal(SucursalDTO sucdto) throws Exception {
        Sucursal sucursal = new Sucursal(this.getNuevoCodigoSucursal(), sucdto.getDireccion(), sucdto.getTelefono(), sucdto.getCodUsuarios(), sucdto.getCodUsuarioRespTecnico());
        sucursales.add(sucursal);

        DAO_Sucursal.saveAll(sucursales);

        return sucursal.getCodigo();
    }

    public SucursalDTO obtenerDatosSucursal(Integer codigo) {
        SucursalDTO sucdto = null;

        for (Sucursal i : this.sucursales) {
            if (codigo.intValue() == i.getCodigo().intValue()) {
                sucdto = new SucursalDTO(i.getCodigo(), i.getDireccion(), i.getTelefono(), i.getCodUsuarios(), i.getCodUsuarioRespTecnico());
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

        DAO_Sucursal.saveAll(sucursales);
    }

    public void actualizarSucursal(SucursalDTO sucdto) throws Exception {
        for (Sucursal i : this.sucursales) {
            if (sucdto.getCodigo().intValue() == i.getCodigo().intValue()) {
                i.setDireccion(sucdto.getDireccion());
                i.setTelefono(sucdto.getTelefono());
                DAO_Sucursal.saveAll(sucursales);
                break;
            }
        }
    }

    public List<SucursalDTO> obtenerListaSucursales() {
        List<SucursalDTO> suclist = new ArrayList<SucursalDTO>();

        for (Sucursal i : sucursales) {
            suclist.add(new SucursalDTO(i.getCodigo(), i.getDireccion(), i.getTelefono(), i.getCodUsuarios(), i.getCodUsuarioRespTecnico()));
        }

        return suclist;
    }

    public void agregarUsuarioASucursal(Integer codigoSucursal, Integer codigoUsuario, Boolean respTecnico) throws Exception {
        for (Sucursal i : this.sucursales) {
            if (codigoSucursal.intValue() == i.getCodigo().intValue()) {

                List<Integer> usuarios = i.getCodUsuarios();

                if (!usuarios.contains(codigoUsuario)) {
                    usuarios.add(codigoUsuario);
                }

                i.setCodUsuarios(usuarios);

                if (respTecnico) {
                    i.setCodUsuarioRespTecnico(codigoUsuario);
                }

                break;
            }
        }

        DAO_Sucursal.saveAll(sucursales);
    }

    public void retirarUsuarioDeSucursal(Integer codigoSucursal, Integer codigoUsuario) throws Exception {
        for (Sucursal i : this.sucursales) {
            if (codigoSucursal.intValue() == i.getCodigo().intValue()) {

                List<Integer> uss = i.getCodUsuarios();

                uss.remove(codigoUsuario);

                i.setCodUsuarios(uss);

                if (i.getCodUsuarioRespTecnico().intValue() == codigoUsuario.intValue()) {
                    i.setCodUsuarioRespTecnico(null);
                }

                break;
            }
        }

        DAO_Sucursal.saveAll(sucursales);
    }

    public List<UsuarioDTO> obtenerUsuariosSucursal(Integer codigo) throws Exception {
        UsuarioDAO DAO_Usuario = new UsuarioDAO();
        List<Usuario> usuarios = DAO_Usuario.getAll();

        List<UsuarioDTO> us = new ArrayList<>();

        for (Sucursal i : this.sucursales) {
            if (codigo.intValue() == i.getCodigo().intValue()) {
                for (Integer j : i.getCodUsuarios()) {
                    for (Usuario k : usuarios) {
                        if (j.intValue() == k.getCodigo().intValue()) {
                            us.add(new UsuarioDTO(k.getCodigo(), k.getNombreUsuario(), k.getPassword(), k.getEmail(), k.getNombreCompleto(), k.getDomicilio(), k.getDni(), k.getFechaDeNacimiento(), k.getRolSistema()));
                        }
                    }
                }
                break;
            }
        }

        return us;
    }
}
