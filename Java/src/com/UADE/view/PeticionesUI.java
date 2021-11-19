package com.UADE.view;

import com.UADE.controller.PeticionController;
import com.UADE.controller.SucursalController;
import com.UADE.dto.PeticionDTO;
import com.UADE.dto.SucursalDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PeticionesUI {
    private JButton cargarResultadosButton;
    private JPanel panel1;
    private JList listPeticiones;
    private JButton volverAlListadoDeButton;

    public PeticionesUI(Integer codigo) throws Exception {
        JFrame frame = new JFrame("Peticiones del paciente");
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);


        cargarResultadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//cargar resultaods
            }
        });


        volverAlListadoDeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}


