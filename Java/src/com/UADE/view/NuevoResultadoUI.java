package com.UADE.view;

import com.UADE.controller.PeticionController;
import com.UADE.controller.SucursalController;
import com.UADE.dto.PeticionDTO;
import com.UADE.dto.SucursalDTO;
import com.UADE.model.Peticion;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class NuevoResultadoUI {
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField2;
    private JTextField textField3;
    private JTextArea textArea1;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JPanel Panel1;
    private PeticionController peticionc;

    public NuevoResultadoUI() throws Exception{
        JFrame frame = new JFrame("Resultados");
        Panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(Panel1);
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        peticionc = new PeticionController();

        //PeticionDTO petdo = peticionc.obtenerDatosPeticion();




    }
}
