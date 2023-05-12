package Tareas.Proyecto1.Interfaz;

public class Barco extends Vehiculo{
    public double eslora;
    public double manga;

    //constructor
    public Barco(){
    }

    //getters y setters
    public double getEslora() {
        return eslora;
    }

    public void setEslora(double eslora) {
        this.eslora = eslora;
    }

    public double getManga() {
        return manga;
    }

    public void setManga(double manga) {
        this.manga = manga;
    }
}
