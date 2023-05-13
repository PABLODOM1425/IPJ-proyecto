package Tareas.Proyecto1.Interfaz;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarVehiculo {
    private JLabel LbnTitulo;
    private JLabel LbnLongitud;
    private JLabel cantidadDePasajerosLabel;
    private JPanel PanelAgregarVehiculo;
    private JTextField textLongitud;
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
    private JTable tablaDatos;
    private JLabel menuAvionLabel;
    private JTextField textNombre;
    private JTextField textColor;



    /*public class Tabla{
        DefaultTableModel dtm= new DefaultTableModel();

        public Tabla(){
            //initComponents();
            String[] titulo=new String[]{"Id","Nombre", "Color", "Tipo"} ;
            dtm.setColumnIdentifiers(titulo);
            tablaDatos.setModel(dtm);

        }
        public void agregar(){
            dtm.addRow(new Object[]{
                    textNombre.getX(),
                    textColor.getText(),
                    (String)CmbVehiculos.getSelectedItem(),
                    textLongitud.getText(),
                    textPasajeros.getText(),
                    TxtEslora.getText(),
                    TxtManga.getText()
            });

        }

    }

*/

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


        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}

