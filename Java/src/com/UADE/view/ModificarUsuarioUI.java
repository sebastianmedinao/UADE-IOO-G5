package com.UADE.view;

import com.UADE.controller.SucursalController;
import com.UADE.controller.UsuarioController;
import com.UADE.dto.DatosSucursalDTO;
import com.UADE.dto.UsuarioDTO;
import com.UADE.model.RolSistema;
import com.UADE.model.Usuario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ModificarUsuarioUI {
    private JPanel panel1;
    private JTextField txtUsuario;
    private JTextField txtClave;
    private JTextField txtNombre;
    private JTextField txtDNI;
    private JTextField txtEmail;
    private JTextField txtDomicilio;
    private JTextField txtNacimiento;
    private JComboBox<RolSistema> comboRol;
    private JComboBox<Integer> comboSucursal;
    private JCheckBox responsableTecnicoCheckBox;
    private JButton guardarButton;

    private final UsuarioController usuc;
    private final SucursalController succ;

    private Integer oldSucursal = null;

    public ModificarUsuarioUI(String nomUsu) throws Exception {

        JFrame frame = new JFrame("Modificar usuario");
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        for (RolSistema rol : RolSistema.values()) {
            comboRol.addItem(rol);
        }

        usuc = new UsuarioController();
        succ = new SucursalController();

        UsuarioDTO usermod = usuc.buscarUsuarioPorNombreUsuario(nomUsu);

        txtUsuario.setText(usermod.getNombreUsuario());
        txtDNI.setText(String.valueOf(usermod.getDni()));
        txtDomicilio.setText(usermod.getDomicilio());
        txtEmail.setText(usermod.getEmail());
        txtNacimiento.setText(new SimpleDateFormat("dd/MM/yyyy").format(usermod.getFechaNacimiento()));
        txtNombre.setText(usermod.getNombreCompleto());
        txtClave.setText("");

        List<DatosSucursalDTO> listasuc = succ.obtenerListaSucursales();

        for (DatosSucursalDTO suc : listasuc) {
            comboSucursal.addItem(suc.getCodigo());

            if (oldSucursal == null) {
                for (UsuarioDTO user : suc.getUsuarios()) {
                    if (user.getNombreUsuario().equals(usermod.getNombreUsuario())) {
                        oldSucursal = suc.getCodigo();
                        break;
                    }
                }
            }
        }

        if (oldSucursal == null) {
            JOptionPane.showMessageDialog(null,"Error interno - sucursal invalida", "Error", JOptionPane.INFORMATION_MESSAGE);
        } else {
            comboSucursal.setSelectedItem(oldSucursal);
        }

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Date datenac = null;
                try {
                    datenac = new SimpleDateFormat("dd/MM/yyyy").parse(txtNacimiento.getText());
                } catch (ParseException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"El formato de fecha de nacimiento no es correcto. Utilice dd/mm/aaaa", "Error", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                Boolean result = null;
                try {
                    result = usuc.actualizarUsuario(txtUsuario.getText(), txtClave.getText(), txtEmail.getText(), txtNombre.getText(), txtDomicilio.getText(), Integer.valueOf(txtDNI.getText()), datenac, (RolSistema) comboRol.getSelectedItem());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                if (result == null) {
                    JOptionPane.showMessageDialog(null,"Datos invàlidos.", "Error", JOptionPane.INFORMATION_MESSAGE);
                } else if (!result) {
                    JOptionPane.showMessageDialog(null,"Ha ocurrido un error.", "Error", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,"Se ha actualizado el usuario " + txtUsuario.getText(),"Usuario modificado", JOptionPane.INFORMATION_MESSAGE);

                    if (comboSucursal.getSelectedItem() != oldSucursal) {
                        try {
                            succ.retirarUsuarioDeSucursal(oldSucursal, txtUsuario.getText());
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                        try {
                            succ.agregarUsuarioASucursal((Integer) comboSucursal.getSelectedItem(), txtUsuario.getText(), responsableTecnicoCheckBox.isSelected());
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }

                    frame.dispose();

                    try {
                        new MaestroUsuariosUI();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
}
