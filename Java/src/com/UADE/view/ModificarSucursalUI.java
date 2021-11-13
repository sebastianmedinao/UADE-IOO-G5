package com.UADE.view;

import com.UADE.controller.SucursalController;
import com.UADE.dto.DatosSucursalDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificarSucursalUI {
    private JButton guardarButton;
    private JPanel panel1;
    private JTextField txtDirecion;
    private JTextField txtTelefono;
    private SucursalController sucursalc;

    public ModificarSucursalUI(Integer codigo) throws Exception {
        JFrame frame = new JFrame("Modificar sucursal " + codigo);
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        sucursalc = new SucursalController();

        DatosSucursalDTO sucdto = sucursalc.obtenerDatosSucursal(codigo);

        txtDirecion.setText(sucdto.getDireccion());
        txtTelefono.setText(sucdto.getTelefono());
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sucursalc.actualizarSucursal(codigo, txtDirecion.getText(), txtTelefono.getText());
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
