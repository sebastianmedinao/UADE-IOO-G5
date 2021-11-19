package com.UADE.view;

import com.UADE.controller.PeticionController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class InformesUI {
    private JPanel panel1;
    private JList<String> listaPeticiones;
    private PeticionController peticionController;


    public InformesUI(){
        JFrame frame = new JFrame("Informes");
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

    }
}
