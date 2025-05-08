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

        usuarios.add(new Alumno("Daniel", "Daniel Pamies Teruel", "danielpameisteruel@gmail.com", "Daniel_1",false, LocalDate.of(2010, 5, 12), "1º ESO", "1213", false));
        usuarios.add(new Alumno("Daniel", "Daniel Pamies Teruel", "danielpameisteruel@gmail.com", "Daniel_1",true , LocalDate.of(2010, 5, 12), new String[]{"gluten", "lactosa"}, "1º ESO", "1213", true));
        usuarios.add(new Alumno("LuciaM", "Lucía Martínez", "lucia.martinez@gmail.com", "Lucia_123",true,LocalDate.of(2009, 9, 23), new String[]{"cacahuetes"}, "2º ESO", "1456", true));
        usuarios.add(new Alumno("CarlosR", "Carlos Ruiz", "carlos.ruiz@gmail.com", "CarlosR_2024", false,LocalDate.of(2011, 3, 15), null, "1º ESO", "1278", true));
        usuarios.add(new Alumno("AnaG", "Ana García", "ana.garcia@gmail.com", "AnaG_pass", true, LocalDate.of(2008, 12, 1), new String[]{"mariscos", "huevo"}, "3º ESO", "1679", false));
        usuarios.add(new Cocina("María", "María la rápida", "marialarapida@gmail.com", "Maria_56"));
        usuarios.add(new Cocina("Evaristo", "Evaristo el roñzas", "evaristoelroñas@gmail.com", "Evaristo_1"));
        usuarios.add(new Admin("Hugo", "Hugo el deportista", "hugodeporte@gmail.com", "Hugo_22"));
        usuarios.add(new Admin("Laura", "Laura la estudiosa", "lauraestudios@gmail.com", "Laura_55"));
    }

    public static void cargarBocatas(){
        String[] ingredientes = {"Tortilla, aceite"};
        String [] alergias = {"Gluten"};

        bocatas.add(new Bocatas(0, "Bocadillo de tortilla", "Está hecho para la gente que quiere ser feliz", ingredientes, alergias, "Callosa", 3.5, false));
        bocatas.add(new Bocatas(1, "Bocadillo de tortilla con jamón", "Perfecto para un almuerzo rápido", ingredientes, alergias, "Alcoy", 4.0, true));
        bocatas.add(new Bocatas(2, "Bocadillo de tortilla con queso", "Ideal para los amantes del queso", ingredientes, alergias, "Elche", 4.2, false));
        bocatas.add(new Bocatas(3, "Bocadillo de tortilla con atún", "Para los que prefieren el mar", ingredientes, alergias, "Alicante", 4.5, true));
        bocatas.add(new Bocatas(4, "Bocadillo de tortilla con pimiento", "Una opción más vegetal", ingredientes, alergias, "Benidorm", 3.8, false));
        bocatas.add(new Bocatas(5, "Bocadillo de tortilla con tomate", "Fresco y delicioso", ingredientes, alergias, "Altea", 4.0, true));
        bocatas.add(new Bocatas(6, "Bocadillo de tortilla con chistorra", "Para los amantes de los sabores fuertes", ingredientes, alergias, "Castellón", 5.0, false));
        bocatas.add(new Bocatas(7, "Bocadillo de tortilla con aguacate", "La combinación perfecta para los veganos", ingredientes, alergias, "Orihuela", 4.3, true));
        bocatas.add(new Bocatas(8, "Bocadillo de tortilla con salchichón", "El clásico con un toque de sabor", ingredientes, alergias, "Elx", 4.1, false));
        bocatas.add(new Bocatas(9, "Bocadillo de tortilla con espinacas", "Una opción saludable y deliciosa", ingredientes, alergias, "Torrevieja", 4.0, true));
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
    public static void eliminarUsuario(){
        eliminarUsuario();
    }
}
