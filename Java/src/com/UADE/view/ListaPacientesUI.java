import com.UADE.controller.PacienteController;
import com.UADE.model.Paciente;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class ListaPacientesUI{
    private JList panel1;
    private PacienteController pacic;
    private JList<String> listaPacientes;
    private JPanel laminaDeLista, laminaDeTexto;
    private  JLabel rotulo;

    public ListaPacientesUI() throws Exception {
        JFrame frame = new JFrame("Pacientes");
        panel1.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.setContentPane(panel1);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listaPacientes.setModel(listModel);

        pacic = new PacienteController();

        List<Paciente> lista = pacic.obtenerListaPacientes();

        listaPacientes = new JList<String>((ListModel<String>) lista);

        listaPacientes.setVisibleRowCount(8);
        JScrollPane laminaDespazamiento = new JScrollPane(listaPacientes);

        laminaDeLista.add(laminaDespazamiento);

        laminaDeTexto = new JPanel();

        rotulo= new JLabel("Paciente seleccionado: ");
        laminaDeTexto.add(rotulo);

        frame.add(laminaDeLista, BorderLayout.NORTH);

        frame.add(laminaDeTexto, BorderLayout.SOUTH);




    }


}

