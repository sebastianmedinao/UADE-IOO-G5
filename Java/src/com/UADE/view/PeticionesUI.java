package com.UADE.view;

import com.UADE.base.Singleton;
import com.UADE.controller.PacienteController;
import com.UADE.controller.PeticionController;
import com.UADE.controller.PracticaController;
import com.UADE.dto.PacienteDTO;
import com.UADE.dto.PeticionDTO;
import com.UADE.dto.PracticaDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PeticionesUI {
    private final PacienteController pacientec;
    private final PeticionController peticionc;
    private final PracticaController practicac;
    private JButton cargarResultadosButton;
    private JPanel panel1;
    private JList<String> listPracticas;
    private JTable tableResultados;
    private JLabel lblPaciente;
    private JLabel lblFechaInicio;
    private JLabel lblFechaEntrega;
    private JLabel lblObraSocial;
    private JLabel lblEstado;
    private JButton enviarResultadosButton;

    public PeticionesUI(Integer codigoPeticion) throws Exception {
        JFrame frame = new JFrame("Detalle de la petición " + codigoPeticion);
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listPracticas.setModel(listModel);
        DefaultTableModel tableModel = new DefaultTableModel();
        tableResultados.setModel(tableModel);

        pacientec = Singleton.getInstance().pacienteController;
        peticionc = Singleton.getInstance().peticionController;
        practicac = Singleton.getInstance().practicaController;

        PeticionDTO petic = peticionc.obtenerDatosPeticion(codigoPeticion);
        PacienteDTO pac = pacientec.obtenerPaciente(petic.getCodPaciente());

        lblPaciente.setText(pac.getCodigo() + " " + pac.getNombreCompleto());
        lblObraSocial.setText(petic.getObraSocial());
        lblFechaInicio.setText(petic.getFechaInicio().toString());
        lblFechaEntrega.setText("TODO");
        lblEstado.setText(petic.getEstadoPeticion().toString());

        for (Integer i : petic.getCodPracticas()) {
            PracticaDTO pracdto = practicac.obtenerDatosPractica(i);

            listModel.addElement(i + " " + pracdto.getNombre());
        }

        cargarResultadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = String.valueOf(listPracticas.getSelectedValue());
                Integer cod = Integer.valueOf(value.split(" ")[0]);

                try {
                    new ResultadoUI(cod);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });
        cargarResultadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}


