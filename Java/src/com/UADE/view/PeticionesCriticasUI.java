package com.UADE.view;

import com.UADE.base.Singleton;
import com.UADE.controller.PacienteController;
import com.UADE.controller.PeticionController;
import com.UADE.controller.PracticaController;
import com.UADE.dto.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PeticionesCriticasUI {
    private final PeticionController peticionc;
    private final PacienteController pacientec;
    private final PracticaController practicac;
    private JPanel panel1;
    private JList<Integer> listPeticiones;
    private JButton verPeticionButton;
    private JList<String> listaPeticiones;
    private PeticionController peticionController;

    public PeticionesCriticasUI() throws Exception {
        JFrame frame = new JFrame("Peticiones con valores criticos");
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        DefaultListModel<Integer> listModel = new DefaultListModel<>();
        listPeticiones.setModel(listModel);

        peticionc = Singleton.getInstance().peticionController;
        pacientec = Singleton.getInstance().pacienteController;
        practicac = Singleton.getInstance().practicaController;

        List<PeticionDTO> lista = peticionc.obtenerListaPeticiones();

        for (PeticionDTO i : lista) {
            PacienteDTO pac = pacientec.obtenerPaciente(i.getCodPaciente());
            List<ResultadoPracticaDTO> resultados = peticionc.obtenerResultadosPeticion(i.getCodigo());
            boolean critico = false;

            for (ResultadoPracticaDTO r : resultados) {
                PracticaDTO prac = practicac.obtenerDatosPractica(r.getCodPractica());
                List<CriterioDTO> criterios = practicac.obtenerCriteriosPractica(r.getCodPractica());
                CriterioDTO auxcrit = null;

                for (CriterioDTO c : criterios) {
                    if (pac.getEdad() >= c.getEdadDesde() && pac.getEdad() <= c.getEdadHasta() && c.getSexo() == pac.getSexo()) {
                        auxcrit = c;
                    }
                }

                if (auxcrit != null) {
                    if (r.getResultadoNumerico() < auxcrit.getReferenciaInferior() || r.getResultadoNumerico() > auxcrit.getReferenciaSuperior()) {
                        critico = true;
                    }
                }
            }

            if (critico)
                listModel.addElement(i.getCodigo());
        }

        verPeticionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new PeticionesUI(listPeticiones.getSelectedValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
