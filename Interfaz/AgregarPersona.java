package Tareas.Proyecto1.Interfaz;

import Tareas.Proyecto1.GestionPersonas;
import Tareas.Proyecto1.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class AgregarPersona extends JDialog {
    private JPanel AgregarPersona;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDepto;
    private JTextField txtCantHijos;
    private JFormattedTextField ftxtFechNac;
    private JButton btnAgregar;
    private JButton btnCancelar;
    private GestionPersonas gestionPersonas;

    private boolean errorAgregar;

    public AgregarPersona(GestionPersonas gestionPersonas) {
        this.gestionPersonas = new GestionPersonas();

        JFrame frame = new JFrame("AgregarPersona");
        frame.setContentPane(AgregarPersona);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setBounds(100, 100, 400, 400);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarPersona();

                 if (!errorAgregar) {
                     JOptionPane.showMessageDialog(null, "Persona registrada");
                     frame.dispose();
                 }
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }

    public void registrarPersona() {
        errorAgregar = false;

        int idPersona = gestionPersonas.getListaPersonas().size() + 1;
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String departamento = txtDepto.getText();
        String stringCantHijos = txtCantHijos.getText();
        String stringFecNac = ftxtFechNac.getText();

        if (nombre.isEmpty() || apellido.isEmpty() || departamento.isEmpty() || stringFecNac.isEmpty() || stringCantHijos.isEmpty()){
            JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacios.", "Error", JOptionPane.ERROR_MESSAGE);
            errorAgregar = true;
            return;
        }

        try {
            byte cantHijos = Byte.parseByte(stringCantHijos);
            LocalDate fechaNacimiento = LocalDate.parse(stringFecNac);

            Persona persona = new Persona(idPersona, nombre, apellido, departamento, cantHijos, fechaNacimiento);
            gestionPersonas.agregarPersona(persona);

        } catch (DateTimeParseException eDate) {
            JOptionPane.showMessageDialog(null, "Formato de fecha es invalido, debe ingresar su fecha de nacimiento como AAAA-MM-DD.", "Error", JOptionPane.ERROR_MESSAGE);
            errorAgregar = true;
        } catch(NumberFormatException eCantHijos) {
            JOptionPane.showMessageDialog(null, "La cantidad de hijos debe ser un número positivo", "Error", JOptionPane.ERROR_MESSAGE);
            errorAgregar = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar la persona", "Error", JOptionPane.ERROR_MESSAGE);
            errorAgregar = true;
        }
    }
}

