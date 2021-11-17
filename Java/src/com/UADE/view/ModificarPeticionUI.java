package com.UADE.view;

import com.UADE.controller.PeticionController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificarPeticionUI {
    private JButton guardarButton;
    private JPanel panel1;
    private JComboBox comboBoxPaciente;
    private JTextField txtObraSocial;
    private JList listPracticas;
    private JButton agregarPracticaButton;
    private JButton eliminarPracticaButton;
    private PeticionController peticionc;


    public ModificarPeticionUI(Integer codigo) throws Exception {
        JFrame frame = new JFrame("Modificar petición" + codigo);
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        agregarPracticaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //agregar practica
            }
        });
        eliminarPracticaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //eliminar practica
            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    try {
                        /*peticionc.actualizarPeticion();*/
                        // agregar prácticas y borrar las seleccionadas --> ver como hacer
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    frame.dispose();

                    try {
                        new MaestroPeticionesUI();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
            }
        });
    }
}