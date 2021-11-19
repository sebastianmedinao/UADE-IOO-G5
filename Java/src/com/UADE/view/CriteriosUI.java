package com.UADE.view;

import com.UADE.controller.PracticaController;
import com.UADE.dto.CriterioDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class CriteriosUI {
    private JList<String> listCriterios;
    private JPanel panel1;
    private JTable tablaCriterios;

    private PracticaController practicac;

    public CriteriosUI(Integer codPractica) throws Exception {
        JFrame frame = new JFrame("Maestro de Sucursales");
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Código","Sexo","Edad","Condiciones preexistentes", "Interpretación", "Rango de referencia", "Reservado"},0);
        tablaCriterios.setModel(tableModel);

        practicac = new PracticaController();

        List<CriterioDTO> lista = practicac.obtenerCriteriosPractica(codPractica);

        for (CriterioDTO i : lista) {
            tableModel.addRow(new Object[] { i.getCodigo(), i.getSexo().toString(), i.getEdadDesde() + "-" + i.getEdadHasta(), i.getCondicionesPreexistentes(), i.getInterpretacion(), i.getReferenciaInferior() + "-" + i.getReferenciaSuperior() + i.getUnidadMedida(), i.getReservado().toString() });
        }

    }
}

