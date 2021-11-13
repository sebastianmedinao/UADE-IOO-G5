package com.UADE.view;

import com.UADE.controller.SucursalController;
import com.UADE.dto.DatosSucursalDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MaestroSucursalesUI {
    private DefaultListModel listModel = new DefaultListModel();
    private JList listSucursales;
    private JPanel panel1;
    private JButton nuevaSucursalButton;
    private JButton modificarSucursalButton;
    private JButton borrarSucursalButton;
    private SucursalController sucursalc;

    public MaestroSucursalesUI() throws Exception {
        JFrame frame = new JFrame("Maestro de Sucursales");
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        listSucursales.setModel(listModel);

        sucursalc = new SucursalController();

        List<DatosSucursalDTO> lista = sucursalc.obtenerListaSucursales();

        for (DatosSucursalDTO i : lista)
            listModel.addElement(i.getCodigo() + " - " + i.getDireccion());

        nuevaSucursalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                try {
                    new NuevaSucursalUI();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });

        borrarSucursalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = (String) listSucursales.getSelectedValue();
                Integer cod = Integer.valueOf(value.split(" ")[0]);

                try {
                    sucursalc.eliminarSucursal(cod);
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
        modificarSucursalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = (String) listSucursales.getSelectedValue();
                Integer cod = Integer.valueOf(value.split(" ")[0]);

                try {
                    new ModificarSucursalUI(cod);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                frame.dispose();
            }
        });
    }
}
