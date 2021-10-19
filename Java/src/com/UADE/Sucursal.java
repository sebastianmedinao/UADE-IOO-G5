package com.UADE;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {
    private Integer codigo;
    private String direccion;
    private String telefono;

    private static int numeradorCodigoSucursal = 0;

    private List<Usuario> usuarios = new ArrayList<Usuario>();

    public Sucursal(Integer codigo, String direccion, String telefono)
    {
        numeradorCodigoSucursal++;
        this.codigo = Integer.valueOf(numeradorCodigoSucursal);
        this.direccion = direccion;
        this.telefono = telefono;
    }
}
