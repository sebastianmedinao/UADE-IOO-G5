package com.UADE.view;

import com.UADE.controller.SucursalController;
import com.UADE.dto.DatosSucursalDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
                    codigoNuevaSuc = sucursalc.nuevaSucursal(txtDireccion.getText(), txtTelefono.getText());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                JOptionPane.showMessageDialog(null,"Se ha creado la sucursal " + codigoNuevaSuc,"Nueva sucursal creada",1);

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
