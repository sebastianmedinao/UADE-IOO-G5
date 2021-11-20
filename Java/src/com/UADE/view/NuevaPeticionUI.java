package com.UADE.view;

import com.UADE.base.Singleton;
import com.UADE.controller.PacienteController;
import com.UADE.controller.PeticionController;
import com.UADE.controller.PracticaController;
import com.UADE.dto.PacienteDTO;
import com.UADE.dto.PeticionDTO;
import com.UADE.dto.PracticaDTO;
import com.UADE.enums.EstadoPeticion;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class NuevaPeticionUI {
    private final PeticionController peticionc;
    private final PracticaController practicac;
    private final PacienteController pacientec;
    private JButton guardarButton;
    private JPanel panel1;
    private JComboBox<String> comboBoxPacientes;
    private JTextField txtObraSocial;
    private JList<String> listPracticas;
    private JLabel JLabelObraSocial;
    private JComboBox<String> comboBoxPractica;
    private JButton agregarButton;

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

        peticionc = Singleton.getInstance().peticionController;
        practicac = Singleton.getInstance().practicaController;
        pacientec = Singleton.getInstance().pacienteController;

        List<PracticaDTO> listadoPracticas = practicac.obtenerListaPracticas();

        for (PracticaDTO datprac : listadoPracticas) {
            comboBoxPractica.addItem(datprac.getCodigo() + " " + datprac.getNombre());
        }

        List<PacienteDTO> pacientes = pacientec.obtenerListaPacientes();

        for (PacienteDTO pac : pacientes) {
            comboBoxPacientes.addItem(pac.getCodigo() + " " + pac.getNombreCompleto());
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
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = (String) comboBoxPacientes.getSelectedItem();
                Integer codP = Integer.valueOf(value.split(" ")[0]);

                List<Integer> listpract = new ArrayList<>();

                for (Iterator<String> it = listModel.elements().asIterator(); it.hasNext(); ) {
                    String i = it.next();
                    listpract.add(Integer.valueOf(i.split(" ")[0]));
                }

                try {
                    peticionc.nuevaPeticion(new PeticionDTO(null, txtObraSocial.getText(), new Date(), EstadoPeticion.INICIO, codP, Singleton.getInstance().codigoSucursal, listpract, new ArrayList<>()));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                frame.dispose();

                try {
                    new MaestroPeticionesUI(null);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
