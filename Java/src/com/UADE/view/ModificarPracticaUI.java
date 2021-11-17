package com.UADE.view;

import com.UADE.controller.PracticaController;
import com.UADE.dto.DatosPracticaDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ModificarPracticaUI {
    private JPanel panel1;
    private JTextField txtNombre;
    private JTextField listaCriterios;
    private JTextField txtDemora;
    private JButton agregarCriterioButton;
    private JButton guardarModificaciónButton;
    private PracticaController practicaC;
    private JList<String> listaPracticas;

    public ModificarPracticaUI(Integer cod) throws Exception{
        JFrame frame = new JFrame("Modificar prácticas");
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);




        DatosPracticaDTO practicaDTO = practicaC.obtenerDatosPractica(cod);

        txtNombre.setText(practicaDTO.getNombre());
        txtDemora.setText(practicaDTO.getTiempoEstimado().toString());
        //Ver lo de criterios, como modificarlos etc
        guardarModificaciónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //practicaC.actualizarPractica(cod, txtNombre.getText(), txtDemora.getText(), listaCriterios);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                frame.dispose();

                try {
                    new MaestroSucursalesUI();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });



    }
}
