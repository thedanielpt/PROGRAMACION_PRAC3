package data;

import models.*;
import services.UsuarioServicio;

import java.time.LocalDate;
import java.util.ArrayList;

public class GesData {

    public static ArrayList<User> usuarios = new ArrayList<>();
    public static ArrayList<Bocatas> bocatas = new ArrayList<>();
    public static ArrayList<Pedidos> pedidos = new ArrayList<>();
    public static ArrayList<Calendario> calendarios = new ArrayList<>();


    public static void cargarUsuaios(){
        ArrayList alergias = new ArrayList();
        alergias.add("Frutos secos");
        alergias.add("Polen");

        usuarios.add(new Alumno("Daniel", "Daniel Pamies Teruel", "danielpameisteruel@gmail.com", "Daniel_1",false, "1ºESO", "¿Eres mala persona?","No", "1ºESO_0001" ,false ));
        usuarios.add(new Alumno("Daniel", "Daniel Pamies Teruel", "danielpameisteruel@gmail.com", "Daniel_1",true ,alergias, "1ºESO", "¿Eres mala persona?" ,"SI", "1ºESO_0002", true));
        usuarios.add(new Alumno("LuciaM", "Lucía Martínez", "lucia.martinez@gmail.com", "Lucia_123",false , "1ºESO", "¿Eres mala persona?" ,"SI", "1ºESO_0003", true));
        usuarios.add(new Alumno("CarlosR", "Carlos Ruiz", "carlos.ruiz@gmail.com", "CarlosR_2024", false , "1ºESO", "¿Eres mala persona?" ,"SI", "1ºESO_0004", true));
        usuarios.add(new Alumno("AnaG", "Ana García", "ana.garcia@gmail.com", "AnaG_pass", false , "1ºESO", "¿Eres mala persona?" ,"SI", "1ºESO_0005", true));
        usuarios.add(new Cocina("María", "María la rápida", "marialarapida@gmail.com", "Maria_56"));
        usuarios.add(new Cocina("Evaristo", "Evaristo el roñzas", "evaristoelroñas@gmail.com", "Evaristo_1"));
        usuarios.add(new Admin("Hugo", "Hugo el deportista", "hugodeporte@gmail.com", "Hugo_22"));
        usuarios.add(new Admin("Laura", "Laura la estudiosa", "lauraestudios@gmail.com", "Laura_55"));
    }

    public static void cargarBocatas(){
        ArrayList<String> ingredientes = new ArrayList<>();
        ingredientes.add("Tortilla");
        ingredientes.add("Patatas");
        ArrayList<String> alergias =new ArrayList<>();
        alergias.add("Gluten");

        bocatas.add(new Bocatas(0, "Bocadillo de tortilla",  ingredientes, "Está hecho para la gente que quiere ser feliz", alergias, "Callosa", 3.5, false));
        bocatas.add(new Bocatas(1, "Bocadillo de tortilla con jamón", ingredientes,"Perfecto para un almuerzo rápido", alergias, "Alcoy", 4.0, true));
        bocatas.add(new Bocatas(2, "Bocadillo de tortilla con queso", ingredientes,"Ideal para los amantes del queso", alergias, "Elche", 4.2, false));
        bocatas.add(new Bocatas(3, "Bocadillo de tortilla con atún", ingredientes,"Para los que prefieren el mar", alergias, "Alicante", 4.5, true));
        bocatas.add(new Bocatas(4, "Bocadillo de tortilla con pimiento", ingredientes,"Una opción más vegetal", alergias, "Benidorm", 3.8, false));
        bocatas.add(new Bocatas(5, "Bocadillo de tortilla con tomate", ingredientes,"Fresco y delicioso", alergias, "Altea", 4.0, true));
        bocatas.add(new Bocatas(6, "Bocadillo de tortilla con chistorra", ingredientes,"Para los amantes de los sabores fuertes", alergias, "Castellón", 5.0, false));
        bocatas.add(new Bocatas(7, "Bocadillo de tortilla con aguacate", ingredientes,"La combinación perfecta para los veganos", alergias, "Orihuela", 4.3, true));
        bocatas.add(new Bocatas(8, "Bocadillo de tortilla con salchichón", ingredientes,"El clásico con un toque de sabor", alergias, "Elx", 4.1, false));
        bocatas.add(new Bocatas(9, "Bocadillo de tortilla con espinacas",  ingredientes,"Una opción saludable y deliciosa", alergias, "Torrevieja", 4.0, true));
    }

    //Metodo donde se instancia los pedidos

    public static void cargarPedidos(){
        pedidos.add(new Pedidos(0, "Daniel", 0, LocalDate.now(), "Pendiente"));
        pedidos.add(new Pedidos(1, "Maria", 1, LocalDate.now().minusDays(1), "Entregado"));
        pedidos.add(new Pedidos(2, "Ana", 2, LocalDate.now().plusDays(2), "En proceso"));
        pedidos.add(new Pedidos(3, "Hugo", 3, LocalDate.now(), "Cancelado"));
        pedidos.add(new Pedidos(4, "Laura", 4, LocalDate.now().minusDays(3), "Pendiente"));
    }

    public static void cargarCalendario(){
        String [] bocata_frio = {bocatas.get(0).getNombre(), bocatas.get(1).getNombre()};
        String [] bocata_caliente = {bocatas.get(2).getNombre(), bocatas.get(3).getNombre()};
        calendarios.add(new Calendario(0, LocalDate.of(2025, 03,6), LocalDate.of(2025, 03,8), bocata_caliente, bocata_frio));
        calendarios.add(new Calendario(1, LocalDate.of(2025, 03,7), LocalDate.of(2025, 03,9), bocata_caliente, bocata_frio));
        calendarios.add(new Calendario(2, LocalDate.of(2025, 03,8), LocalDate.of(2025, 03,10), bocata_caliente, bocata_frio));
        calendarios.add(new Calendario(3, LocalDate.of(2025, 03,9), LocalDate.of(2025, 03,11), bocata_caliente, bocata_frio));
        calendarios.add(new Calendario(4, LocalDate.of(2025, 03,10), LocalDate.of(2025, 03,12), bocata_caliente, bocata_frio));
    }
}
