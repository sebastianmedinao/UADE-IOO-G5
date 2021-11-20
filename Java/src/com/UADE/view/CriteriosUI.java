package com.UADE.view;

import com.UADE.base.Singleton;
import com.UADE.controller.PracticaController;
import com.UADE.dto.CriterioDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CriteriosUI {
    private final PracticaController practicac;
    private JList<String> listCriterios;
    private JPanel panel1;
    private JTable tablaCriterios;
    private JButton agregarCriterioButton;
    private JButton borrarCriterioButton;

    public CriteriosUI(Integer codPractica) throws Exception {
        JFrame frame = new JFrame("Criterios de practica " + codPractica);
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Código", "Sexo", "Edad", "Condiciones preexistentes", "Interpretación", "Rango de referencia", "Reservado"});
        tablaCriterios.setModel(tableModel);

        practicac = Singleton.getInstance().practicaController;

        List<CriterioDTO> lista = practicac.obtenerCriteriosPractica(codPractica);

        for (CriterioDTO i : lista) {
            tableModel.addRow(new Object[]{i.getCodigo(), i.getSexo().toString(), i.getEdadDesde() + "-" + i.getEdadHasta(), i.getCondicionesPreexistentes(), i.getInterpretacion(), i.getReferenciaInferior() + "-" + i.getReferenciaSuperior() + i.getUnidadMedida(), i.getReservado().toString()});
        }

        agregarCriterioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new NuevoCriterioUI(codPractica);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                frame.dispose();
            }
        });
        borrarCriterioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    practicac.eliminarCriterio((Integer) tablaCriterios.getValueAt(tablaCriterios.getSelectedRow(), 0));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                frame.dispose();

                try {
                    new CriteriosUI(codPractica);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}

