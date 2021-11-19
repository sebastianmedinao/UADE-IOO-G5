package com.UADE.view;

import com.UADE.controller.PacienteController;
import com.UADE.model.Paciente;
import com.UADE.enums.Sexo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class NuevoPacienteUI {
    private JPanel panel1;
    private JTextField nroDni;
    private JTextField txtNombre;
    private JTextField txtDomicilio;
    private JTextField txtMail;
    private JTextField txtSexo;
    private JTextField txtEdad;
    private JButton guardarButton;
    private JRadioButton femeninoRadioButton;
    private JRadioButton masculinoRadioButton;
    private PacienteController pacientec;

    public NuevoPacienteUI() throws Exception{
        JFrame frame = new JFrame("Nuevo Paciente");
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        pacientec = new PacienteController();
        
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean codigoNuevoP = null;
                Integer dni = null;
                Integer edad;
                Sexo sexo = null;
                try {
                    dni = Integer.valueOf(nroDni.getText());
                    //Sexo sexo = Sexo.valueOf(txtSexo.getText());
                    if (femeninoRadioButton.isSelected()){
                        sexo = Sexo.FEMENINO;
                    }else if(masculinoRadioButton.isSelected()){
                        sexo = Sexo.MASCULINO;
                    } else{ //Chequear
                        JOptionPane.showMessageDialog(null,"Seleccione el sexo", "Error", JOptionPane.INFORMATION_MESSAGE);
                    }
                    edad = Integer.valueOf(txtEdad.getText());

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

               /*if (codigoNuevoP == null) {
                    JOptionPane.showMessageDialog(null,"Datos invàlidos.", "Error", JOptionPane.INFORMATION_MESSAGE);
                } else if (codigoNuevoP == false) {
                    JOptionPane.showMessageDialog(null,"El paciente ya esta registrado", "Error", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,"Se ha registrado el paciente " + txtNombre.getText(),"Nuevo usuario creado", JOptionPane.INFORMATION_MESSAGE);
                    
                    frame.dispose();

                    try {
                        new MaestroPacientesUI();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }*/



                frame.dispose();
            }
        });



    }
}
