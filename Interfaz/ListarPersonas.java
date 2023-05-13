package Tareas.Proyecto1.Interfaz;

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


    public ListarPersonas(Persona refPersona) {

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
                crearTablaPersonas(refPersona, filtro, filtroOpcion);

            }
        });

        crearTablaPersonas(refPersona, null, null);
        frame.setVisible(true);
    }

    public void crearTablaPersonas(Persona refPersona, String filtro, String filtroOpcion) {

        ArrayList<Persona> arrPersonas = refPersona.getListaPersonas();
        ArrayList<Persona> personasFiltradas = new ArrayList<>();
        Object[][] personas;

        if (filtro != null && filtroOpcion != null) {
            switch(filtroOpcion){

                case "Nombre":
                    for (int i = 0; i < arrPersonas.size(); i++) {
                        Persona persona = arrPersonas.get(i);
                        if (persona.getNombre().equals(filtro)) {
                            personasFiltradas.add(persona);
                        }
                    }
                    break;
                case "Apellido":
                    for (int i = 0; i < arrPersonas.size(); i++) {
                        Persona persona = arrPersonas.get(i);
                        if (persona.getApellido().equals(filtro)) {
                            personasFiltradas.add(persona);
                        }
                    }
                    break;
                case "Departamento":
                    for (int i = 0; i < arrPersonas.size(); i++) {
                        Persona persona = arrPersonas.get(i);
                        if (persona.getDptoResidencia().equals(filtro)) {
                            personasFiltradas.add(persona);
                        }
                    }
                    break;
                case "Cantidad de Hijos":
                    byte bFiltro =  Byte.parseByte(filtro);
                    for (int i = 0; i < arrPersonas.size(); i++) {
                        Persona persona = arrPersonas.get(i);
                        if (persona.getCantHijos() == bFiltro) {
                            personasFiltradas.add(persona);
                        }
                    }
                    break;
                case "Fecha de Nacimiento":
                    for (int i = 0; i < arrPersonas.size(); i++) {
                        Persona persona = arrPersonas.get(i);
                        if (persona.getFechaNacimiento().equals(filtro)) {
                            personasFiltradas.add(persona);
                        }
                    }
                    break;
            }
            personas = crearFilasPersonas(personasFiltradas);
        } else {
            personas = crearFilasPersonas(arrPersonas);
        }

        tbListarPersonas.setModel(new DefaultTableModel(personas, new String[]{"Id","Nombre", "Apellido", "Departamento", "Cantidad de Hijos", "Fecha de Nacimiento"})
        );

    }

    private Object[][] crearFilasPersonas(ArrayList<Persona> arrPersonas) {
        Object[][] personas = new Object[arrPersonas.size()][6];
        for (int i = 0; i < arrPersonas.size(); i++) {
            Persona persona = arrPersonas.get(i);
            personas[i][0] = i + 1; // ID
            personas[i][1] = persona.getNombre();
            personas[i][2] = persona.getApellido();
            personas[i][3] = persona.getDptoResidencia();
            personas[i][4] = persona.getCantHijos();
            personas[i][5] = persona.getFechaNacimiento();
        }

        return personas;
    }
}
