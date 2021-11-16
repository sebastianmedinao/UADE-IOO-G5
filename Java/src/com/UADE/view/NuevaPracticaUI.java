package com.UADE.view;

import com.UADE.controller.PracticaController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class NuevaPracticaUI {
    private JPanel panel1;
    private JTextField txtNombre;
    private JTextField listaCriterios;
    private JTextField txtDemora;
    private JButton guardarPrácticaButton;
    private JButton agregarCriterioButton;
    private PracticaController practicasC;

    NuevaPracticaUI() throws Exception{
        JFrame frame = new JFrame("Nueva práctica");
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        practicasC = new PracticaController();

        /*guardarPrácticaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer cont = 0;
                Integer demora;
                JList criterios;
                Boolean codigoNuevaPractica = null;
                demora = Integer.valueOf(txtDemora.getText());
                criterios = list.valueOf(listaCriterios);

                for(Practica i : PracticaDAO){
                    cont++;
                }
                cont = PracticaDAO.size();
                try {


                    codigoNuevaPractica = practicasC.nuevaPractica(cont, txtNombre.getText(), demora, criterios );
                    //codigoNuevaSuc = practicasC.nuevaPractica();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                JOptionPane.showMessageDialog(null, "Se ha creado la sucursal " + codigoNuevaSuc, "Nueva sucursal creada", 1);

                if(codigoNuevaPractica == null){
                    JOptionPane.showMessageDialog(null,"Datos invàlidos.", "Error", JOptionPane.INFORMATION_MESSAGE);
                }else if (!codigoNuevaPractica) {
                    JOptionPane.showMessageDialog(null, "La practica ya existe.", "Error", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,"Se ha creado la práctica " + txtNombre.getText(),"Nuevo práctica creada", JOptionPane.INFORMATION_MESSAGE);

                    try {
                        practicasC.nuevaPractica(cont, txtNombre.getText(), demora, criterios);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    frame.dispose();

                    try {
                        new PracticasUI();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }


                try {
                    new MaestroSucursalesUI();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                frame.dispose();

            }
        }
        );*/

    }
}
