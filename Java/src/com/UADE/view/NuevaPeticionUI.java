package com.UADE.view;

import com.UADE.controller.PeticionController;
import com.UADE.controller.PracticaController;
import com.UADE.dto.PracticaDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

public class NuevaPeticionUI {
    private JButton guardarButton;
    private JPanel panel1;
    private JComboBox comboBoxPacientes;
    private JTextField txtObraSocial;
    private JList<String> listPracticas;
    private JLabel JLabelObraSocial;
    private JComboBox<String> comboBoxPractica;
    private JButton agregarButton;
    private JComboBox comboBox1;

    private final PeticionController peticionc;
    private final PracticaController practicac;

    public NuevaPeticionUI() throws Exception {
        JFrame frame = new JFrame("Nueva petición");
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        listPracticas.setModel(listModel);

        peticionc = new PeticionController();
        practicac = new PracticaController();
        List<PracticaDTO> listadoPracticas = practicac.obtenerListaPracticas();

        for (PracticaDTO datprac : listadoPracticas) {
            comboBoxPractica.addItem(datprac.getCodigo() + " " + datprac.getNombre());
        }

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Iterator<String> it = listModel.elements().asIterator(); it.hasNext(); ) {
                    String i = it.next();

                    if (i.equals(comboBoxPractica.getSelectedItem().toString())) {
                        return;
                    }
                }

                listModel.addElement(comboBoxPractica.getSelectedItem().toString());
            }
        });
    }
}
