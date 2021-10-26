package com.UADE.view;

import com.UADE.controller.UsuarioController;
import com.UADE.model.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestUI {
    private JPanel InicioTest;
    private JLabel lblTest;
    private JButton button1;
    private UsuarioController usercontroller;

    public TestUI() {
        JFrame root = new JFrame("Test Title");
        root.setContentPane(InicioTest);
        root.setLocationRelativeTo(null);
        root.setSize(400, 400);
        root.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        root.setVisible(true);

        usercontroller = new UsuarioController();

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario usu = usercontroller.buscarUsuarioPorDNI(10444322);
                lblTest.setText(usu.getNombreUsuario());
            }
        });
    }
}
