package com.UADE.view;

import com.UADE.controller.PracticaController;
import com.UADE.dto.DatosPracticaDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ModificarPracticaUI {
    private JPanel panel1;
    private JTextField txtNombre;
    private JTextField listaCriterios;
    private JTextField txtDemora;
    private JButton agregarCriterioButton;
    private JButton guardarModificaciónButton;
    private PracticaController practicaC;
    private JList<String> listaPracticas;

    public ModificarPracticaUI() throws Exception{
        JFrame frame = new JFrame("Modificar prácticas");
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        listaPracticas.setModel(listModel);


        practicaC = new PracticaController();
        //List<DatosPracticaDTO> lista = practicaC.obtenerListaPracticas();

        //for (DatosPracticaDTO i : lista)
          //  listModel.addElement(i.getCodigo() + " - " + i.getNombre());

        String value = listaPracticas.getSelectedValue();
        Integer cod = Integer.valueOf(value.split(" ")[0]);

        DatosPracticaDTO practicaDTO = practicaC.obtenerDatosPractica(cod);

        txtNombre.setText(practicaDTO.getNombre());


        txtDemora.setText(practicaDTO.getTiempoEstimado().toString());




    }
}
