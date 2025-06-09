package models;

import java.io.Serializable;
import java.time.LocalDate;

public class Incidencia implements Serializable {

    protected int id;

    protected String nombre;

    protected String descripcion;

    protected LocalDate fecha;

    public Incidencia(String nombre, int id, String descripcion, LocalDate fecha) {
        this.nombre = nombre;
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Incidencia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha=" + fecha +
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
