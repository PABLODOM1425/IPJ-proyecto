package Tareas.Proyecto1.Interfaz;

import Tareas.Proyecto1.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public AgregarPersona(Persona refPersona) {
        JFrame frame = new JFrame("AgregarPersona");
        frame.setContentPane(AgregarPersona);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setBounds(100, 100, 400, 400);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuario(refPersona);
                frame.dispose();
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

    public void registrarUsuario(Persona refPersona) {
        int idPersona = refPersona.getListaPersonas().size() + 1;
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String departamento = txtDepto.getText();
        String stringFecNac = ftxtFechNac.getText();
        LocalDate fechaNacimiento = null;
        byte cantHijos = 0;


        if (nombre.isEmpty() || apellido.isEmpty() || departamento.isEmpty()){
            JOptionPane.showMessageDialog(null, "Los campos nombre, apellido y departamento no pueden estar vacios.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            fechaNacimiento = LocalDate.parse(stringFecNac, formatter);

        } catch (DateTimeParseException eDate) {
            JOptionPane.showMessageDialog(null, "Formato de fecha es invalido, debe ingresar su fecha de nacimiento como YYYY-MM-DD.", "Error", JOptionPane.ERROR_MESSAGE);
            ftxtFechNac.requestFocus();
        }

        try {
            String strCantHijos = txtCantHijos.getText();
            cantHijos = Byte.parseByte(strCantHijos);
        } catch(NumberFormatException eCantHijos) {
            JOptionPane.showMessageDialog(null, "La cantidad de hijos debe ser un número positivo", "Error", JOptionPane.ERROR_MESSAGE);
            txtCantHijos.requestFocus();
        }

        if (nombre.isEmpty() && apellido.isEmpty() && departamento.isEmpty() && fechaNacimiento != null && cantHijos != 0) {
            Persona persona = new Persona(idPersona, nombre, apellido, departamento, cantHijos, fechaNacimiento);

            refPersona.agregarPersona(persona);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo agregar la persona.", "Error", JOptionPane.ERROR_MESSAGE);
        }



    }
}

