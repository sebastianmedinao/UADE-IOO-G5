package com.UADE.view;

import com.UADE.controller.PracticaController;
import com.UADE.dto.PracticaDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NuevaPracticaUI {
    private JPanel panel1;
    private JTextField txtNombre;
    private JTextField txtDemora;
    private JButton guardarPrácticaButton;
    private PracticaController practicasC;

    NuevaPracticaUI() throws Exception{
        JFrame frame = new JFrame("Nueva práctica");
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        practicasC = new PracticaController();

        guardarPrácticaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    practicasC.nuevaPractica(new PracticaDTO(null, txtNombre.getText(), Integer.valueOf(txtDemora.getText()), new ArrayList<>()));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                try {
                    new PracticasUI();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                frame.dispose();

            }
        });
    }
}
