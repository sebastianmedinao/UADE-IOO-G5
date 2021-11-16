package com.UADE.view;


import com.UADE.controller.PeticionController;
import com.UADE.controller.PracticaController;
import com.UADE.dto.DatosPracticaDTO;
import com.UADE.model.Practica;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class NuevaPeticionUI {

    private JButton guardarButton;
    private JPanel panel1;
    private JComboBox comboBoxPacientes;
    private JTextField txtObraSocial;
    private JList listPracticas;
    private JLabel JLabelObraSocial;
    private JComboBox comboBoxPractica;
    private JButton agregarButton;
    private PeticionController peticionc;
    private PracticaController practicac;


    public NuevaPeticionUI() throws Exception {
        JFrame frame = new JFrame("Nueva petición");
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        listPracticas.setModel(listModel);

        peticionc = new PeticionController();
        practicac = new PracticaController();
        List<DatosPracticaDTO> listadoPracticas = practicac.obtenerListaPracticas();

        for (DatosPracticaDTO datprac : listadoPracticas) {
            comboBoxPractica.addItem(datprac.getNombre());
        }

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer codigoNuevaPet = null;

                try {
                    //codigoNuevaPet = peticionc.nuevaPeticion(comboBoxPacientes.getSelectedItem(), txtObraSocial.getText());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                JOptionPane.showMessageDialog(null, "Se ha creado la petición " + codigoNuevaPet, "Nueva petición creada", 1);

                try {
                    new MaestroSucursalesUI();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                frame.dispose();

            }
        });
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.addElement((String) comboBoxPractica.getSelectedItem());
            }
        });
    }
}
