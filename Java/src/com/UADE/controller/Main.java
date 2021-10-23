package com.UADE.controller;

import com.UADE.model.Usuario;
import com.UADE.model.RolSistema;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        UsuarioController usuarioController = new UsuarioController();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date datex = dateFormat.parse("15/09/1996");

        usuarioController.nuevoUsuario("admin", "1234", "uade@uade.edu.ar", "administrador", "lima 1", 10444322, datex, RolSistema.ADMINISTRADOR);
    }
}
