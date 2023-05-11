package Tareas.Proyecto1;

import java.time.LocalDate;
import java.util.ArrayList;

public class Persona {
    public int idPersona;
    public String nombre;
    public String apellido;
    public String dptoResidencia;
    public byte cantHijos;
    public LocalDate fechaNacimiento;

    //Constructors
    public Persona (){};
    public Persona (int idPersona, String nombre, String apellido, String dptoResidencia, byte cantHijos, LocalDate fechaNacimiento){
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dptoResidencia = dptoResidencia;
        this.cantHijos = cantHijos;
        this.fechaNacimiento = fechaNacimiento;
    }

    //Setters y Getters
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDptoResidencia() {
        return dptoResidencia;
    }

    public void setDptoResidencia(String dptoResidencia) {
        this.dptoResidencia = dptoResidencia;
    }

    public byte getCantHijos() {
        return cantHijos;
    }

    public void setCantHijos(byte cantHijos) {
        this.cantHijos = cantHijos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    private ArrayList<Persona> listaPersonas = new ArrayList<Persona>();

    //Metodos
    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void agregarPersona(Persona persona) {
        listaPersonas.add(persona);
    }
}

