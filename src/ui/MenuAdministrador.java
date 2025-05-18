package ui;

import autentificar.AuathService;
import models.Alumno;
import models.User;
import services.BocatasServicio;
import services.PedidosServicio;
import services.UsuarioServicio;
import utils.Validaciones;

import java.util.Scanner;

public class MenuAdministrador {
    //ADMIN

    /**
     *Metodo donde esta el menu Admin
     */
    public static void menuAdmin(){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        String elec = "";

        do {
            System.out.println("Menu Principal\n");
            System.out.println("1. Gestionar usuarios:");
            System.out.println("     Listar usuarios");
            System.out.println("     Añadir usuario");
            System.out.println("     Eliminar usuario");
            System.out.println("     Eliminar un curso entero");
            System.out.println("2. Gestionar Bocadillos:");
            System.out.println("     Listar bocadillos disponibles");
            System.out.println("     Crear bocadillo");
            System.out.println("     Eliminar bocadillo");
            System.out.println("     Modificar bocadillo");
            System.out.println("3. Pedir bocata");
            System.out.println("     Seleccionar usuario");
            System.out.println("     Pedir bocadillo");
            System.out.println("4. Consultar Pedidos:");
            System.out.println("     Mostrar pedidos de un usuario");
            System.out.println("     Cambiar el estado de los pedidos");
            System.out.println("5. Gestion Calendario");
            System.out.println("     Listar calendario");
            System.out.println("     Modicficar Calendario");
            System.out.println("     Crear calendario");
            System.out.println("     Eliminar calendario");
            System.out.println("5. Salir");
            elec = sc.nextLine();
            next = true;

            switch (elec) {
                case "1":
                    adminGestionUsers();
                    next = true;
                    break;
                case "2":
                    adminGestionarBocadillos();
                    next = true;
                    break;
                case "3":
                    adminPedirBocata();
                    next = true;
                    break;
                case "4":
                    adminConsultarPedidos();
                    next = true;
                    break;
                case "5":
                    next = false;
                    break;
                default:
                    System.out.println("Tienes que seleccionar una opción");
                    next = true;
                    break;
            }

        } while (next);
    }

    /**
     * Menu de admin de gestion de usuarios
     */
    public static void adminGestionUsers(){
        Scanner sc = new Scanner(System.in);
        String elec = "";
        boolean next = true;
        do {
            System.out.println("1. Listar usuarios");
            System.out.println("2. Añadir usuario");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Modificar usuario");
            System.out.println("5. Volver al menu princiapal");
            elec = sc.nextLine();

            switch (elec) {
                case "1":
                    UsuarioServicio.mostrarTodosUsers();
                    next = true;
                    break;
                case "2":
                    MenuCrearUsuarios.registroUsers();
                    next = true;
                    break;
                case "3":
                    UsuarioServicio.eliminar(Validaciones.pregunta_buscar());
                    next = true;
                    break;
                case "4":
                    MenuModificar.modificarUsuarios();
                    next = true;
                    break;
                case "5":
                    next = false;
                    break;
                default:
                    next = true;
                    break;
            }
        } while (next);
    }

    /**
     * Menu de admin para la gestion de bocadillos
     */
    public static void adminGestionarBocadillos(){
        Scanner sc = new Scanner(System.in);
        String elec = "";
        boolean next = true;

        do {
            System.out.println("1. Listar bocadillos disponibles");//Priemro se tiene que hacer admin_calendario
            System.out.println("2. Crear bocadillo");
            System.out.println("3. Eliminar bocadillo");
            System.out.println("4. Modificar bocadillo");
            System.out.println("5. Volver al menu princiapal");
            elec = sc.nextLine();

            switch (elec) {
                case "1":

                    next = true;
                    break;
                case "2":
                    BocatasServicio.registroBocatas();
                    next = true;
                    break;
                case "3":
                    BocatasServicio.eliminar(Validaciones.pregunta_buscar());
                    next = true;
                    break;
                case "4":
                    MenuModificar.modificarBocata();
                    next = true;
                    break;
                case "5":
                    next = false;
                    break;
                default:
                    next = true;
                    break;
            }
        } while (next);
    }

    /**
     * Menu de admin para la realización de los pedidos con un Alumno
     */
    public static void adminPedirBocata(){
        Scanner sc = new Scanner(System.in);
        String elec = "";
        boolean next = true;
        Alumno a = new Alumno();

        do {
            System.out.println("1. Seleccionar usuario");
            System.out.println("2. Pedir bocadillo");
            System.out.println("3. Volver al menu princiapal");
            elec = sc.nextLine();

            switch (elec) {
                case "1":
                    next = true;
                    break;
                case "2":
                    next = true;
                    break;
                case "3":
                    next = false;
                    break;
                default:
                    next = true;
                    break;
            }
        } while (next);
    }

    /**
     * Menu de admin para las consultas de los pedidos
     */
    public static void adminConsultarPedidos(){
        Scanner sc = new Scanner(System.in);
        String elec = "";
        boolean next = true;

        do {
            System.out.println("1. Listar calendarios");
            System.out.println("1. Mostrar pedidos de un usuario");
            System.out.println("2. Cambiar el estado de los pedidos");
            System.out.println("3. Volver al menu princiapal");
            elec = sc.nextLine();

            switch (elec) {
                case "1":

                    next = true;
                    break;
                case "2":

                    next = true;
                    break;
                case "3":
                    next = false;
                    break;
                default:
                    next = true;
                    break;
            }
            next = true;
        } while (next);
    }

    /**
     * Menu de admin para la gestion del calendario
     */
    public static void adminGestionarCalendario(){
        Scanner sc = new Scanner(System.in);
        String elec = "";
        boolean next = true;

        do {
            System.out.println("1. Modicficar Calendario");
            System.out.println("2. Crear calendario");
            System.out.println("3. Eliminar calendario");
            elec = sc.nextLine();

            switch (elec) {
                case "1":

                    next = true;
                    break;
                case "2":

                    next = true;
                    break;
                case "3":

                    next = true;
                    break;
                case "4":
                    next = false;
                    break;
                default:
                    next = true;
                    break;
            }
            next = true;
        } while (next);

    }
}
