package com.UADE.view;

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
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        cargarResultadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = String.valueOf(listPeticiones.getSelectedValue());
                Integer cod = Integer.valueOf(value.split(" ")[0]);
                try {
                    new ResultadoUI(cod);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });


        volverAlListadoDeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new MaestroPeticionesUI(null);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}


