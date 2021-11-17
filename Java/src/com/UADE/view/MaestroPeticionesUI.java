package com.UADE.view;

import com.UADE.controller.PeticionController;
import com.UADE.dto.DatosPeticionDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.List;

public class MaestroPeticionesUI {
    private JButton nuevaPeticiónButton;
    private JPanel panel1;
    private JButton modificarPeticiónButton;
    private JButton borrarPeticiónButton;
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
        //listPeticiones.setModel(listModel);

        DefaultListModel<String> listModel = new DefaultListModel<String>();

        peticionc = new PeticionController();

       //List<DatosPeticionDTO> lista = peticionc.obtenerDatosPeticion();

        /*for (DatosPeticionDTO i : lista)
            listModel.addElement(i.getCodigo());*/

    }
}