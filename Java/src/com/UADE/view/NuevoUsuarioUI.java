package com.UADE.view;

import com.UADE.controller.UsuarioController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class NuevoUsuarioUI {
    private JButton guardarButton;
    private JPanel panel1;
    private JTextField txtUsuario;
    private JTextField txtNombre;
    private JTextField txtClave;
    private JTextField txtDNI;
    private JTextField txtEmail;
    private JTextField txtDomicilio;
    private JComboBox<String> comboRol;
    private JTextField txtNacimiento;

    private UsuarioController usuc;

    public NuevoUsuarioUI() throws Exception {
        JFrame frame = new JFrame("Nuevo usuario");
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        comboRol.addItem("ADMINISTRADOR");
        comboRol.addItem("LABORATORISTA");
        comboRol.addItem("RECEPCION");

        usuc = new UsuarioController();

    }
}
