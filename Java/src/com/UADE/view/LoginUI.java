package com.UADE.view;

import com.UADE.controller.UsuarioController;
import com.UADE.dto.UsuarioDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI {
    private JPanel panel1;
    private JTextField txtUsuario;
    private JTextField txtClave;
    private JButton ingresarButton;
    private UsuarioController usercontroller;

    public LoginUI() throws Exception {
        JFrame frame = new JFrame("Ingresar a Sistema Laboratorio");
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        usercontroller = new UsuarioController();

        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioDTO usuarioencontrado = usercontroller.buscarUsuarioPorCredenciales(txtUsuario.getText(), txtClave.getText());

                if (usuarioencontrado == null) {
                    JOptionPane.showMessageDialog(null,"Las credenciales no coinciden con un usuario existente.","Error",1);
                } else {
                    new MenuUI(usuarioencontrado.getNombreUsuario(), usuarioencontrado.getRolSistema());
                    frame.dispose();
                }
            }
        });
    }
}
