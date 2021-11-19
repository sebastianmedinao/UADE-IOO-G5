package com.UADE.view;

import com.UADE.controller.PeticionController;
import com.UADE.dto.ListaPeticionesDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MaestroPeticionesUI {
    private JButton nuevaPeticiónButton;
    private JPanel panel1;
    private JButton modificarPeticiónButton;
    private JButton borrarPeticiónButton;
    private JList<String> listPeticiones;
    private JButton verPeticionButton;
    private PeticionController peticionc;

    public MaestroPeticionesUI(Integer codigo) throws Exception {
        JFrame frame = new JFrame("Maestro de Peticiones");
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        DefaultListModel<String> listModel = new DefaultListModel<>();


        listPeticiones.setModel(listModel);

        peticionc = new PeticionController();

        List<ListaPeticionesDTO> lista = peticionc.obtenerListaPeticiones();

        for (ListaPeticionesDTO i : lista)
            listModel.addElement(i.getCodigo() + " " + i.getFechaInicio() + " " + i.getCodPaciente());


        nuevaPeticiónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                try {
                    new NuevaPeticionUI();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        modificarPeticiónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String value = listPeticiones.getSelectedValue();
                Integer cod = Integer.valueOf(value.split(" ")[0]);

                try {
                    new ModificarPeticionUI(cod);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        borrarPeticiónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = listPeticiones.getSelectedValue();
                Integer cod = Integer.valueOf(value.split(" ")[0]);

                try {
                    if (peticionc.eliminarPeticion(cod) == false)
                    {JOptionPane.showMessageDialog(null, "No se puede borrar una petición en curso o finalizada.");
                    return;}

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
        verPeticionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = listPeticiones.getSelectedValue();
                Integer cod = Integer.valueOf(value.split(" ")[0]);

                try {
                    new PeticionesUI(cod);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}