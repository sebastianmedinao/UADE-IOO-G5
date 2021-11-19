package com.UADE.view;

import com.UADE.enums.RolSistema;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUI {
    private JPanel panel1;
    private JLabel lblBienvenido;
    private JButton practicasButton;
    private JButton peticionesButton;
    private JButton sucursalesButton;
    private JButton usuariosButton;
    private JButton maestroDePacientesButton;
    private JButton resultadosButton;
    private JButton informesButton;
    private String usuario;

    public MenuUI(String usuario, RolSistema rol) {
        JFrame frame = new JFrame("Menu principal");
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        lblBienvenido.setText("Bienvenido, " + usuario);

        if (rol != RolSistema.ADMINISTRADOR) {
            practicasButton.setVisible(false);
            usuariosButton.setVisible(false);
            sucursalesButton.setVisible(false);
        }

        sucursalesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new MaestroSucursalesUI();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        usuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new MaestroUsuariosUI();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        maestroDePacientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new MaestroPacientesUI();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        practicasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new PracticasUI();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        informesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new InformesUI();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

    }
}
