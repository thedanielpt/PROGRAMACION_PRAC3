package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Clase de bocatas
 */
public class Bocatas implements Serializable {

    /**
     * Iva de los bocatas
     */
    public static final double iva = 0.21;

    protected int id;
    protected String nombre;
    protected String descrip;
    protected ArrayList<String> ingredientes;
    protected ArrayList<String> alergenos;
    protected double precio;
    protected boolean caliente;

    /**
     * Constructor sin atributos de bocatas
     */
    public Bocatas(){}

    /**
     * Constructor con atributos de bocatas
     * @param id identificador del bocadillo
     * @param nombre nombre del bocadillo
     * @param descrip descripcion del bocadillo
     * @param ingredientes ingredientes del bocata
     * @param alergenos alergenos del bocadillo
     * @param precio  precio el bocata
     * @param caliente si esta caliente es true
     */
    public Bocatas(int id, String nombre, String descrip, ArrayList<String> ingredientes, ArrayList<String> alergenos, double precio, boolean caliente) {
        this.id = id;
        this.nombre = nombre;
        this.descrip = descrip;
        this.ingredientes = ingredientes;
        this.alergenos = alergenos;
        this.precio = precio;
        this.caliente = caliente;
    }

    /**
     * Metodo para mostrar todos los atributos del bocata
     * @return devuelve la infromaciónd del bcoata en string
     */
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

