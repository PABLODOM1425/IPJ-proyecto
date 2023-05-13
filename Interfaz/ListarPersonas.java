package Tareas.Proyecto1.Interfaz;

import Tareas.Proyecto1.GestionPersonas;
import Tareas.Proyecto1.Persona;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListarPersonas extends JDialog {
    private JPanel ListarPersonas;
    private JScrollPane spListarPersonas;
    private JTable tbListarPersonas;
    private JButton btnCerrar;
    private JTextField txtFiltro;
    private JComboBox cbFiltro;
    private JButton btnFiltro;

    private GestionPersonas gestionPersonas;

    public ListarPersonas(GestionPersonas gestionPersonas) {
        this.gestionPersonas = new GestionPersonas();

        JFrame frame = new JFrame("ListarPersonas");
        frame.setContentPane(ListarPersonas);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setBounds(100, 100, 600, 600);

        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });


        btnFiltro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filtro = txtFiltro.getText();
                String filtroOpcion = cbFiltro.getSelectedItem().toString();
                crearTablaPersonas(filtro, filtroOpcion);

            }
        });

        crearTablaPersonas(null, null);
        frame.setVisible(true);
    }

    public void crearTablaPersonas(String filtro, String filtroOpcion) {

        ArrayList<Persona> personas = gestionPersonas.getListaPersonas();

        if (filtro != null) {
            personas = filtrarPersonas(personas, filtro, filtroOpcion);
        }

        DefaultTableModel tablaPersonas = new DefaultTableModel();
        String[] nombresColumnas = {"Id", "Nombre", "Apellido", "Departamento", "Cantidad de Hijos", "Fecha de Nacimiento"};
        tablaPersonas.setColumnIdentifiers(nombresColumnas);

        for(int i = 0; i < personas.size(); i++) {
            Persona persona = personas.get(i);
            Object[] filaPersona = new Object[]{
                    i + 1,
                    persona.getNombre(),
                    persona.getApellido(),
                    persona.getDptoResidencia(),
                    persona.getCantHijos(),
                    persona.getFechaNacimiento()
            };
            tbListarPersonas.setModel(tablaPersonas);
        }
    }

    private ArrayList<Persona> filtrarPersonas(ArrayList<Persona> arrPersona, String filtro, String filtroOpcion) {

        ArrayList<Persona> personasFiltradas = new ArrayList<>();

        for(Persona persona : arrPersona) {

            switch (filtroOpcion) {
                case "Nombre":
                    if (persona.getNombre().equals(filtro))
                        personasFiltradas.add(persona);
                    break;
                case "Apellido":
                    if (persona.getApellido().equals(filtro))
                        personasFiltradas.add(persona);

                    break;
                case "Departamento":
                    if (persona.getDptoResidencia().equals(filtro))
                        personasFiltradas.add(persona);

                    break;
                case "Cantidad de Hijos":
                    byte bFiltro = Byte.parseByte(filtro);
                    if (persona.getCantHijos() == bFiltro)
                        personasFiltradas.add(persona);

                    break;
                case "Fecha de Nacimiento":
                    if (persona.getFechaNacimiento().equals(filtro)) {
                        personasFiltradas.add(persona);
                        break;
                    }
            }
        }
        return personasFiltradas;
    }
}
