package com.UADE.view;

import com.UADE.controller.PacienteController;
import com.UADE.controller.SucursalController;
import com.UADE.controller.UsuarioController;
import com.UADE.dao.PacienteDAO;
import com.UADE.dto.PacienteDTO;
import com.UADE.dto.SucursalDTO;
import com.UADE.dto.UsuarioDTO;
import com.UADE.model.Paciente;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MaestroPacientesUI {

    private JList<String> listPacientes;
    private JPanel panel1;
    private JButton listaPacientesButton;
    private JButton nuevoPacienteButton;
    private JButton modificarPacienteButton;
    private JButton borrarPacienteButton;
    private JButton consultarPeticionesDelPacienteButton;
    private PacienteController pacic;

    public MaestroPacientesUI() throws Exception {
        JFrame frame = new JFrame("Maestro de Pacientes");
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        listPacientes.setModel(listModel);
        pacic = new PacienteController();

        List<PacienteDTO> lista = pacic.obtenerListaPacientes();

        for (PacienteDTO i : lista)
            listModel.addElement(i.getCodigo() + " " + i.getDni() + "_" + i.getNombreCompleto());

        nuevoPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                try {
                    new NuevoPacienteUI();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        modificarPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                String value = listPacientes.getSelectedValue();
                Integer cod = Integer.valueOf(value.split(" ")[0]);

                try {
                    new ModificarPacienteUI(cod);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        borrarPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = listPacientes.getSelectedValue();
                Integer cod = Integer.valueOf(value.split(" ")[0]);
//LIMITACIONES DE BORRAR PACIENTE


                try {
                    //falta controller borrar paciente
                    //pacic.pac(cod);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                frame.dispose();

                try {
                    new MaestroPacientesUI();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        consultarPeticionesDelPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = listPacientes.getSelectedValue();
                Integer cod = Integer.valueOf(value.split(" ")[0]);

                try {
                    new MaestroPeticionesUI(cod);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

}

