package data;

import models.User;
import models.Bocatas;
import models.Calendario;
import models.Pedidos;
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

        usuarios.add(new User("Daniel", "Daniel Pamies Teruel", "1º ESO", "danielpameisteruel@gmail.com", "Daniel_1", false, LocalDate.of(2006, 3, 29), 2));
        usuarios.add(new User("Javi", "Javi solemne malo", "2ºESO", "javisolemnemalo2gmail.com", "Javi_123", true, alergias ,LocalDate.of(2000, 05, 23), 1));
        usuarios.add(new User("Lucia", "Lucia buena mala", "2ºESO", "luciabuenamala@gmail.com", "Lucia_12", false, LocalDate.of(2006,12,29), 0));
        usuarios.add(new User("Carlos", "Carlos el grande", "2ºESO", "carlosgrande@gmail.com", "Carlos_34", true, alergias , LocalDate.of(2005, 3, 15), 0));
        usuarios.add(new User("Ana", "Ana la sabia", "3ºESO", "analasabia@gmail.com", "Ana_45", false, LocalDate.of(2007, 7, 25), 0));
        usuarios.add(new User("Pedro", "Pedro el valiente", "4ºESO", "pedrovaliente@gmail.com", "Pedro_78", true, alergias,LocalDate.of(2006, 11, 10), 0));
        usuarios.add(new User("María", "María la rápida", "2ºESO", "marialarapida@gmail.com", "Maria_56", false, LocalDate.of(2006, 5, 3), 0));
        usuarios.add(new User("Evaristo", "Evaristo el roñzas", "2ºESO", "evaristoelroñas@gmail.com", "Evaristo_1", false, LocalDate.of(1980, 05, 17), 0));
        usuarios.add(new User("Hugo", "Hugo el deportista", "4ºBach", "hugodeporte@gmail.com", "Hugo_22", false, LocalDate.of(2004, 6, 17), 0));
        usuarios.add(new User("Laura", "Laura la estudiosa", "2ºESO", "lauraestudios@gmail.com", "Laura_55", false, LocalDate.of(2007, 10, 11), 0));
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
