package data;

import models.*;
import services.UsuarioServicio;

import java.time.LocalDate;
import java.util.ArrayList;

public class GesData {

    /**
     * Array e usuarios
     */
    public static ArrayList<User> usuarios = new ArrayList<>();

    /**
     * Array de bocatas
     */
    public static ArrayList<Bocatas> bocatas = new ArrayList<>();

    /**
     * Array de pedidos
     */
    public static ArrayList<Pedidos> pedidos = new ArrayList<>();

    /**
     * Array de calendarios
     */
    public static ArrayList<Calendario> calendarios = new ArrayList<>();

    /**
     * Array de incidencias
     */
    public static ArrayList<Incidencia> incidencias = new ArrayList<>();


    /**
     * Metodo para cargar usuarios
     */
    public static void cargarUsuario(){
        ArrayList alergias = new ArrayList();
        alergias.add("Frutos secos");
        alergias.add("Polen");

        usuarios.add(new Alumno("Alumno", "Daniel Pamies Teruel", "danielpameisteruel@gmail.com", "Alumno_1",false, "1ºESO", "¿Eres mala persona?","No", "1ºESO_0001" ,false ));
        usuarios.add(new Alumno("Daniel", "Daniel Pamies Teruel", "danielpameisteruel@gmail.com", "Daniel_1",true ,alergias, "1ºESO", "¿Eres mala persona?" ,"SI", "1ºESO_0002", true));
        usuarios.add(new Alumno("LuciaM", "Lucía Martínez", "lucia.martinez@gmail.com", "Lucia_123",false , "1ºESO", "¿Eres mala persona?" ,"SI", "1ºESO_0003", true));
        usuarios.add(new Alumno("CarlosR", "Carlos Ruiz", "carlos.ruiz@gmail.com", "CarlosR_2024", false , "1ºESO", "¿Eres mala persona?" ,"SI", "1ºESO_0004", true));
        usuarios.add(new Alumno("AnaG", "Ana García", "ana.garcia@gmail.com", "AnaG_pass", false , "1ºESO", "¿Eres mala persona?" ,"SI", "1ºESO_0005", true));
        usuarios.add(new Cocina("María", "María la rápida", "marialarapida@gmail.com", "Maria_56"));
        usuarios.add(new Cocina("Cocina", "María la rápida", "marialarapida@gmail.com", "Cocina_1"));
        usuarios.add(new Cocina("Evaristo", "Evaristo el roñzas", "evaristoelroñas@gmail.com", "Evaristo_1"));
        usuarios.add(new Admin("Hugo", "Hugo el deportista", "hugodeporte@gmail.com", "Hugo_22"));
        usuarios.add(new Admin("Laura", "Laura la estudiosa", "lauraestudios@gmail.com", "Laura_55"));
        usuarios.add(new Admin("Admin", "Laura la estudiosa", "lauraestudios@gmail.com", "Admin_1"));
    }


    /**
     * metodo para caragr bocatas
     */
    public static void cargarBocatas(){
        ArrayList alergias = new ArrayList();
        alergias.add("Frutos secos");
        alergias.add("Polen");
        ArrayList<String> ingredientes = new ArrayList<>();
        ingredientes.add("Tortilla");
        ingredientes.add("Patatas");
        alergias.add("Gluten");

        //Bocatas

        bocatas.add(new Bocatas(0, "Bocadillo de tortilla", "Está hecho para la gente que quiere ser feliz" ,new ArrayList<>(ingredientes) , new ArrayList<>(alergias), 3.5, false));
        bocatas.add(new Bocatas(1, "Bocadillo de tortilla con jamón", "Perfecto para un almuerzo rápido",new ArrayList<>(ingredientes), new ArrayList<>(alergias),  4.0, true));
        bocatas.add(new Bocatas(2, "Bocadillo de tortilla con queso", "Ideal para los amantes del queso",new ArrayList<>(ingredientes), new ArrayList<>(alergias),  4.2, false));
        bocatas.add(new Bocatas(3, "Bocadillo de tortilla con atún", "Para los que prefieren el mar",new ArrayList<>(ingredientes), new ArrayList<>(alergias),  4.5, true));
        bocatas.add(new Bocatas(4, "Bocadillo de tortilla con pimiento", "Una opción más vegetal",new ArrayList<>(ingredientes), new ArrayList<>(alergias),  3.8, false));
        bocatas.add(new Bocatas(5, "Bocadillo de tortilla con tomate", "Fresco y delicioso",new ArrayList<>(ingredientes), new ArrayList<>(alergias),  4.0, true));
        bocatas.add(new Bocatas(6, "Bocadillo de tortilla con chistorra", "Para los amantes de los sabores fuertes",new ArrayList<>(ingredientes), new ArrayList<>(alergias),  5.0, false));
        bocatas.add(new Bocatas(7, "Bocadillo de tortilla con aguacate", "La combinación perfecta para los veganos",new ArrayList<>(ingredientes), new ArrayList<>(alergias),  4.3, true));
        bocatas.add(new Bocatas(8, "Bocadillo de tortilla con salchichón", "El clásico con un toque de sabor",new ArrayList<>(ingredientes), new ArrayList<>(alergias), 4.1, false));
        bocatas.add(new Bocatas(10, "Bocadillo de tortilla con espinacas",  "Una opción saludable y deliciosa",new ArrayList<>(ingredientes), new ArrayList<>(alergias), 4.0, true));
    }

    /**
     * metodo para cargar pedidos
     */
    public static void cargarPedidos(){
        //Pedidos

        pedidos.add(new Pedidos(0, "Hugo", 0, LocalDate.now(), "Pendiente"));
        pedidos.add(new Pedidos(1, "AnaG", 1, LocalDate.now(), "Finalizado"));
        pedidos.add(new Pedidos(2, "Hugo", 2, LocalDate.now(), "Finalizado"));
        pedidos.add(new Pedidos(3, "Hugo", 3, LocalDate.now(), "Pendiente"));
        pedidos.add(new Pedidos(4, "Hugo", 4, LocalDate.now(), "Pendiente"));
    }


    /**
     * metodo para cargar calendario
     */
    public static void cargarCalendario(){
        calendarios.add(new Calendario(0, bocatas.get(0), bocatas.get(1)));
        calendarios.add(new Calendario(1, bocatas.get(2), bocatas.get(3)));
    }
}
