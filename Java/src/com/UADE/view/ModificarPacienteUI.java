package com.UADE.view;

import com.UADE.controller.PacienteController;
import com.UADE.model.Sexo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificarPacienteUI {

    private JPanel panel1;
    private JTextField nroDni;
    private JTextField txtNombre;
    private JTextField txtDomicilio;
    private JTextField txtMail;
    private JTextField txtEdad;
    private JRadioButton femeninoRadioButton;
    private JRadioButton masculinoRadioButton;
    private JButton actualizarButton;
    private PacienteController pacientec;

    public ModificarPacienteUI() throws Exception{
        JFrame frame = new JFrame("Modificar paciente");
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        pacientec = new PacienteController();

        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean codigoPaciente = null;
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
                    // TODO: Hacer que efectivamente actalice el paciente

                    if(pacientec.buscarPacientePorDNI(Integer.valueOf(nroDni.getText()))){

                        edad = Integer.valueOf(txtEdad.getText());

                        Integer codigo = pacientec.obtenerListaPacientes().size();

                        codigoPaciente = pacientec.nuevoPaciente(codigo+1, dni , txtNombre.getText(), txtDomicilio.getText(), txtMail.getText(), sexo, edad);

                    }
                    else{
                        JOptionPane.showMessageDialog(null,"No existe un paciente con DNI numero " + nroDni.getText(),"Error", JOptionPane.INFORMATION_MESSAGE);
                    }


                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                if (codigoPaciente == null) {
                    JOptionPane.showMessageDialog(null,"Datos invàlidos.", "Error", JOptionPane.INFORMATION_MESSAGE);
                } else if (codigoPaciente == false) {
                    JOptionPane.showMessageDialog(null,"El paciente ya esta registrado", "Error", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,"Se ha actualizado el paciente " + txtNombre.getText(),"Usuario actualizado", JOptionPane.INFORMATION_MESSAGE);

                    frame.dispose();

                    try {
                        new MaestroPacientesUI();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }



                frame.dispose();
            }
        });





    }
}
