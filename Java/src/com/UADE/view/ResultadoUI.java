package com.UADE.view;

import com.UADE.base.Singleton;
import com.UADE.controller.PeticionController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultadoUI {
    private JButton guardarButton;
    private JTextField txtResultadoNumerico;
    private JTextField txtResultadoLiteral;
    private JTextArea txtTranscripcion;

    private PeticionController petic;

    public ResultadoUI(Integer codigo) throws Exception {
        JFrame frame = new JFrame("Cargar resultado de la petición" + codigo);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        petic = Singleton.getInstance().peticionController;

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
}
