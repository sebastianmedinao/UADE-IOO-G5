package com.UADE.view;

import com.UADE.controller.PeticionController;
import com.UADE.dto.ListaPeticionesDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MaestroPeticionesUI {
    private JButton nuevaPeticiónButton;
    private JPanel panel1;
    private JButton modificarPeticiónButton;
    private JButton borrarPeticiónButton;
    private JList<String> listPeticiones;
    private PeticionController peticionc;

    public MaestroPeticionesUI() throws Exception {
        JFrame frame = new JFrame("Maestro de Peticiones");
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        listPeticiones.setModel(listModel);

        //DefaultListModel<String> listModel = new DefaultListModel<String>();

        peticionc = new PeticionController();

        List<ListaPeticionesDTO> lista = peticionc.obtenerListaPeticiones();

        for (ListaPeticionesDTO i : lista)
            //listModel.addElement(i.getCodigo(), i.getFechaInicio(), i.getPaciente());



        nuevaPeticiónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                try {
                    new NuevaPeticionUI();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        modificarPeticiónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //MODIFICAR PETICIOn
            }
        });
        borrarPeticiónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BORRAR PETICIÓN

            }
        });
    }
}