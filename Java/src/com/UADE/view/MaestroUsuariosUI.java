package com.UADE.view;

import com.UADE.controller.UsuarioController;
import com.UADE.dto.DatosSucursalDTO;
import com.UADE.dto.UsuarioDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MaestroUsuariosUI {
    private JList<String> listUsuarios;
    private JPanel panel1;
    private JButton nuevoUsuarioButton;
    private JButton modificarUsuarioButton;
    private JButton borrarUsuarioButton;
    private UsuarioController usuc;

    public MaestroUsuariosUI() throws Exception {
        JFrame frame = new JFrame("Maestro de Usuarios");
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listUsuarios.setModel(listModel);

        usuc = new UsuarioController();

        List<UsuarioDTO> lista = usuc.obtenerListaUsuarios();

        for (UsuarioDTO i : lista)
            listModel.addElement(i.getNombreUsuario());

        nuevoUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                try {
                    new NuevoUsuarioUI();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
