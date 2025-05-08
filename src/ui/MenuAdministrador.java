package ui;

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
            System.out.println("     Cambiar un curso entero");
            System.out.println("     Eliminar un curso entero");
            System.out.println("2. Gestionar Bocadillos:");
            System.out.println("     Listar bocadillos disponibles");
            System.out.println("     Ver curiosidades de un bocadillo");
            System.out.println("     Crear bocadillo");
            System.out.println("     Eliminar bocadillo");
            System.out.println("     Modificar bocadillo");
            System.out.println("     Realizar Pedido:");
            System.out.println("3. Pedir bocata");
            System.out.println("     Seleccionar usuario");
            System.out.println("     Eligir Bocadillo");
            System.out.println("     Confirmar pedido");
            System.out.println("4. Consultar Pedidos:");
            System.out.println("     Mostrar pedidos de un usuario");
            System.out.println("     Marcar pedidos como retirado");
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
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Modificar usuario");
            System.out.println("3. Cambiar un curso entero");
            System.out.println("5. Eliminar un curso entero");
            System.out.println("6. Volver al menu princiapal");
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
                    next = true;
                    break;
                case "5":
                    next = true;
                    break;
                case "6":
                    next = false;
                    break;
                default:
                    next = true;
                    break;
            }
        } while (next);
    }

    //Menu de admin para la gestion de bocadillos

    public static void adminGestionarBocadillos(){
        Scanner sc = new Scanner(System.in);
        String elec = "";
        boolean next = true;

        do {
            System.out.println("1. Listar bocadillos disponibles");
            System.out.println("2. Ver curiosidades de un bocadillo");
            System.out.println("3. Crear bocadillo");
            System.out.println("4. Eliminar bocadillo");
            System.out.println("5. Modificar bocadillo");
            System.out.println("6. Volver al menu princiapal");
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
                    next = true;
                    break;
                case "5":
                    next = true;
                    break;
                case "6":
                    next = false;
                    break;
                default:
                    next = true;
                    break;
            }
        } while (next);
    }

    /**
     * Metodo para la realización de los pedidos
     */

    public static void adminPedirBocata(){
        Scanner sc = new Scanner(System.in);
        String elec = "";
        boolean next = true;

        do {
            System.out.println("1. Seleccionar usuario");
            System.out.println("2. Pedir bocadillo bocadillo");
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

    public static void adminConsultarPedidos(){
        Scanner sc = new Scanner(System.in);
        String elec = "";
        boolean next = true;

        do {
            System.out.println("1. Gestion usuarios");
            System.out.println("2. Gestion bocatas");
            System.out.println("3. Gestion calendario");
            System.out.println("4. gestion pedidos");
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
}
