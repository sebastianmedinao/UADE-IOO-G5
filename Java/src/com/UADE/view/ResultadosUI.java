package com.UADE.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultadosUI {
    private JButton cargarNuevoResultadoButton;
    private JButton consultarResultadoButton;
    private JList list1;
    private JPanel JPResultados;

    public ResultadosUI() throws Exception{
        JFrame frame = new JFrame("Resultados");
        JPResultados.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(JPResultados);
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);




        cargarNuevoResultadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new NuevoResultadoUI();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    }
