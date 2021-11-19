package com.UADE.view;

import com.UADE.controller.SucursalController;
import com.UADE.dto.SucursalDTO;
import com.UADE.model.Sucursal;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NuevaSucursalUI {
    private JPanel panel1;
    private JButton guardarButton;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private SucursalController sucursalc;

    public NuevaSucursalUI() throws Exception {
        JFrame frame = new JFrame("Nueva sucursal");
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        sucursalc = new SucursalController();

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer codigoNuevaSuc = null;

                try {
                    codigoNuevaSuc = sucursalc.nuevaSucursal(new SucursalDTO(null, txtDireccion.getText(), txtTelefono.getText(), new ArrayList<>(), null));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                JOptionPane.showMessageDialog(null,"Se ha creado la sucursal " + codigoNuevaSuc,"Nueva sucursal creada", JOptionPane.INFORMATION_MESSAGE);

                try {
                    new MaestroSucursalesUI();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                frame.dispose();
            }
        });
    }
}
