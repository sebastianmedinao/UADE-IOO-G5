package com.UADE.view;

import com.UADE.controller.PeticionController;
import com.UADE.controller.PracticaController;
import com.UADE.dto.ListaPeticionesDTO;
import com.UADE.dto.ListaPracticasDTO;
import com.UADE.dto.PracticaDTO;
import com.UADE.enums.RolSistema;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PracticasUI {
    private JList<String> listaPracticas;
    private JPanel panel1;
    private JButton crearNuevaPrácticaButton;
    private JButton modificarPrácticaExistenteButton;
    private JButton eliminarPracticaButton;
    private JButton volverAlMenúPrincipalButton;
    private JList listPracticas;
    private PracticaController practicasC;


    PracticasUI() throws Exception{
        JFrame frame = new JFrame("Prácticas");
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        DefaultListModel<String> listModel = new DefaultListModel<>();


        listPracticas.setModel(listModel);

        practicasC = new PracticaController();

        List<ListaPracticasDTO> lista = practicasC.obtenerListaPracticasSimplificada();

        for (ListaPracticasDTO i : lista)
            listModel.addElement(i.getCodigo() + " " + i.getNombre());

        crearNuevaPrácticaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new NuevaPracticaUI();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        modificarPrácticaExistenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = String.valueOf(listPracticas.getSelectedValue());
                Integer cod = Integer.valueOf(value.split(" ")[0]);
                try {
                    new ModificarPracticaUI(cod);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

    }
}
