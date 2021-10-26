package com.UADE.controller;

import com.UADE.model.RolSistema;
import com.UADE.view.TestUI;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        UsuarioController usuarioController = new UsuarioController();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date datex = dateFormat.parse("15/09/1996");

        usuarioController.nuevoUsuario("admin", "1234", "uade@uade.edu.ar", "administrador", "lima 1", 10444322, datex, RolSistema.ADMINISTRADOR);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    createAndShowGUI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void createAndShowGUI() throws Exception {
        new TestUI();
    }
}
