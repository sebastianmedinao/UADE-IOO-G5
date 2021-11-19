package com.UADE.view;

import com.UADE.controller.PracticaController;
import com.UADE.enums.RolSistema;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PracticasUI {
    private JList<String> listaPracticas;
    private JPanel panel1;
    private JButton crearNuevaPrácticaButton;
    private JButton modificarPrácticaExistenteButton;
    private JButton eliminarPracticaExistenteButton;
    private JButton volverAlMenúPrincipalButton;
    private JList list1;
    private PracticaController practicasC;


    PracticasUI() throws Exception{
        JFrame frame = new JFrame("Prácticas");
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        /*DefaultListModel<String> listModel = new DefaultListModel<String>();
        listaPracticas.setModel(listModel);


        practicasC = new PracticaController();
        List<DatosPracticaDTO> lista = practicasC.obtenerListaPracticas();

        String value = listaPracticas.getSelectedValue();
        Integer cod = Integer.valueOf(value.split(" ")[0]);

        for (DatosPracticaDTO i : lista)
            listModel.addElement(i.getCodigo() + " - " + i.getNombre());
*/
        // TODO: Ver tema listado de prácticas


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
                try {
                    new ModificarPracticaUI(Integer.parseInt(listaPracticas.getSelectedValue()));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        volverAlMenúPrincipalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new MenuUI("admin", RolSistema.ADMINISTRADOR);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

    }
}
