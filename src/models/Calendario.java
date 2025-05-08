package models;

import java.time.LocalDate;

public class Calendario {
    protected int id;
    protected LocalDate fecha_inicio;
    protected LocalDate fecha_fin;
    protected String bocadillo_quincena_frios[];
    protected String bocadillo_quincena_calientes[];

    public Calendario(int id, LocalDate fecha_inicio, LocalDate fecha_fin, String[] bocadillo_quincena_frios, String[] bocadillo_quincena_calientes) {
        this.id = id;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.bocadillo_quincena_frios = bocadillo_quincena_frios;
        this.bocadillo_quincena_calientes = bocadillo_quincena_calientes;
    }

    public void mostrarInfo(){

        System.out.println("------------------------");
        System.out.println("id: "+id + "\nfecha-inicio: "+fecha_inicio+"\nfecha-fin: "+fecha_fin+"\nbocadillo quincena frios: ");
        for (int i = 0; i < bocadillo_quincena_frios.length; i++) {
            System.out.print(bocadillo_quincena_frios[i]+", ");
        }
        System.out.println("bocadillos calientes: ");
        for (int i = 0; i < bocadillo_quincena_calientes.length; i++) {
            System.out.print(bocadillo_quincena_calientes[i]+", ");
        }
    }

    public int getId() {
        return id;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public String[] getBocadillo_quincena_frios() {
        return bocadillo_quincena_frios;
    }

    public String[] getBocadillo_quincena_calientes() {
        return bocadillo_quincena_calientes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public void setBocadillo_quincena_frios(String[] bocadillo_quincena_frios) {
        this.bocadillo_quincena_frios = bocadillo_quincena_frios;
    }

    public void setBocadillo_quincena_calientes(String[] bocadillo_quincena_calientes) {
        this.bocadillo_quincena_calientes = bocadillo_quincena_calientes;
    }
}
