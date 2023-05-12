package Tareas.Proyecto1.Interfaz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarVehiculo {
    private JLabel LbnTitulo;
    private JLabel LbnLongitud;
    private JLabel cantidadDePasajerosLabel;
    private JPanel PanelAgregarVehiculo;
    private JTextField textField1;
    private JTextField textPasajeros;
    private JButton agregarButton;
    private JButton cancelarButton;
    private JButton listarButton;
    private JLabel LblLongitud;
    private JLabel LblManga;
    private JTextField TxtEslora;
    private JLabel LblMenuAvion;
    private JLabel LblEslora;
    private JLabel LblMenuBarco;
    private JTextField TxtManga;
    private JComboBox CmbVehiculos;




    private static void init(JComboBox CmbVehiculos) {

        CmbVehiculos.addItem("Avion");
        CmbVehiculos.addItem("Barco");
    }

    public AgregarVehiculo() {
        JFrame frame = new JFrame("Menu Vehículos");
        frame.setContentPane(PanelAgregarVehiculo);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setBounds(100, 100, 400, 400);
        frame.setVisible(true);
        CmbVehiculos.addItem("");
        CmbVehiculos.addItem("Avion");
        CmbVehiculos.addItem("Barco");

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }

        });
      /*  listarButton.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent e) {
                public void actionPerformed(ActionEvent e){
                    ListarVehiculo ListarVehiculo = new ListarVehiculo();

                }
                ;
            }
*/
        /*public void VisibleText() {
            String SelectCombo = (String) CmbVehiculos.getSelectedItem();
            if (SelectCombo.equals("Avion")) {
                System.out.println("Entro a avion");
                agregarButton.enable();
*/
            }
        }

