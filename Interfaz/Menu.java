package Tareas.Proyecto1.Interfaz;

import Tareas.Proyecto1.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JDialog {

    private JButton agregarPersonasButton;
    private JButton listarPersonasButton;
    private JPanel menu;
    private JButton agregarVehiculonButton;
    private Persona personas = new Persona();
    private Vehiculo vehiculo = new Vehiculo();

    //vehiculo
    private AgregarVehiculo agregarVehiculo = new AgregarVehiculo();

    public Menu(JFrame parent)  {
        super(parent);
        setTitle("Menu");
        setContentPane(menu);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 400);

        agregarPersonasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarPersona agregarPersona = new AgregarPersona(personas);
            }
        });

        listarPersonasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListarPersonas listarPersonas = new ListarPersonas(personas);
            }
        });


        setVisible(true);
        //cargar menu auto
        agregarVehiculonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarVehiculo agregarVehiculo = new AgregarVehiculo();

            }
        });
    }

    public static void main(String[] args) {
        Menu menu = new Menu(null);

    }

}
