package com.UADE.view;

import com.UADE.base.Singleton;
import com.UADE.controller.PracticaController;
import com.UADE.dto.CriterioDTO;
import com.UADE.enums.Sexo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NuevoCriterioUI {
    private final PracticaController practicac;
    private JList<String> listCriterios;
    private JPanel panel1;
    private JComboBox<Sexo> comboSexo;
    private JTextField txtCondiciones;
    private JTextField txtEdadDesde;
    private JTextField txtEdadHasta;
    private JTextField txtReferenciaInferior;
    private JTextField txtReferenciaSuperior;
    private JTextField txtInterpretacion;
    private JTextField txtUnidad;
    private JCheckBox valorEsReservadosCheckBox;
    private JButton guardarButton;

    public NuevoCriterioUI(Integer codPractica) throws Exception {
        JFrame frame = new JFrame("Maestro de Sucursales");
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);


        practicac = Singleton.getInstance().practicaController;

        for (Sexo i : Sexo.values()) {
            comboSexo.addItem(i);
        }

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    practicac.nuevoCriterio(new CriterioDTO(null, codPractica, (Sexo) comboSexo.getSelectedItem(), txtCondiciones.getText(), Integer.valueOf(txtEdadDesde.getText()), Integer.valueOf(txtEdadHasta.getText()), txtInterpretacion.getText(), Float.valueOf(txtReferenciaInferior.getText()), Float.valueOf(txtReferenciaSuperior.getText()), txtUnidad.getText(), valorEsReservadosCheckBox.isSelected()));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                try {
                    new CriteriosUI(codPractica);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                frame.dispose();
            }
        });
    }
}
