package Tareas.Proyecto1.Interfaz;

public class Vehiculo {
    public int idVehiculo;
    public String nombre;

    //constructor vacío
    public Vehiculo(){
    }
    //constructor2
    public Vehiculo(int idVehiculo, String nombre){
        this.idVehiculo = idVehiculo;
        this.nombre = nombre;

    }
    //Getters y setters
    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String color;

}
