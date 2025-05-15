package models;

import java.util.ArrayList;
import java.util.Arrays;

public class Bocatas {
    protected int id;
    protected String nombre;
    protected String descrip;
    protected ArrayList<String> ingredientes;
    protected ArrayList<String> alergenos;
    protected double precio;
    protected boolean caliente;

    public Bocatas(int id, String nombre, String descrip, ArrayList<String> ingredientes, ArrayList<String> alergenos, double precio, boolean caliente) {
        this.id = id;
        this.nombre = nombre;
        this.descrip = descrip;
        this.ingredientes = ingredientes;
        this.alergenos = alergenos;
        this.precio = precio;
        this.caliente = caliente;
    }

    public void mostrarAlergenos(String nombre, String[] alergenos) {
        System.out.println("El " + nombre + " tiene estos alergenos:");
        for (int i = 0; i < alergenos.length; i++) {
            System.out.println(alergenos[i]);
        }
    }

    public void mostrarIngredientes(String nombre, String[] ingredientes) {
        System.out.println("El " + nombre + " tiene estos ingredientes:");
        for (int i = 0; i < ingredientes.length; i++) {
            System.out.println(ingredientes[i]);
        }
    }

    @Override
    public String toString() {
        return "Bocatas{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descrip='" + descrip + '\'' +
                ", ingredientes=" + ingredientes +
                ", alergenos=" + alergenos +
                ", precio=" + precio +
                ", caliente=" + caliente +
                '}';
    }

    public static ArrayList<String> menuBocatas(){
        ArrayList<String> bocatas = new ArrayList<>();


        return bocatas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public ArrayList<String> getAlergenos() {
        return alergenos;
    }

    public void setAlergenos(ArrayList<String> alergenos) {
        this.alergenos = alergenos;
    }

    public boolean isCaliente() {
        return caliente;
    }

    public void setCaliente(boolean caliente) {
        this.caliente = caliente;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

