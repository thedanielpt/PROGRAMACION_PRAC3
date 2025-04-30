package menus;

import java.util.Scanner;

public class Menu {

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
            System.out.println("2. Gestionar Bocadillos:");
            System.out.println("     Listar bocadillos disponibles");
            System.out.println("     Ver curiosidades de un bocadillo");
            System.out.println("3. Realizar Pedido:");
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
                    adminRealizarPedido();
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
            System.out.println("2. Volver al menu princiapal");
            elec = sc.nextLine();

            switch (elec) {
                case "1":
                    next = true;
                    break;
                case "2":
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
     * Metodo para la realización de los pedidos
     */

    public static void adminRealizarPedido(){
        Scanner sc = new Scanner(System.in);
        String elec = "";
        boolean next = true;

        do {
            System.out.println("1. Seleccionar usuario");
            System.out.println("2. Elegir bocadillo");
            System.out.println("3. Confirmar pedido");
            System.out.println("4. Volver al menu princiapal");
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
        } while (next);
    }

    public static void adminConsultarPedidos(){
        Scanner sc = new Scanner(System.in);
        String elec = "";
        boolean next = true;

        do {
            System.out.println("1. Mostrar pedidos de un usuario");
            System.out.println("2. Marcar pedidos como retirado");
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

    //USUARIO

    /**
     * Metodo donde esta el menu de Usuario
     */

    public static void menuUsuario(){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        String elec = "";

        do {
            System.out.println("----MENU USUARIO----");
            System.out.println("1. Pedir bocata");
            System.out.println("2. Horario bocata");
            System.out.println("3. Cancelar pedido");
            System.out.println("4. Historial de pedidos");
            System.out.println("5. Deslogueo");
            elec = sc.nextLine();
            next = true;

            switch (elec) {
                case "1":
                    usuarioPedirBocata();
                    next = true;
                    break;
                case "2":
                    usuarioHorarioBocata();
                    next = true;
                    break;
                case "3":
                    usuarioCancelarBocata();
                    next = true;
                    break;
                case "4":
                    usuarioHistorialPedidos();
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
        }while (next);
    }

    /**
     * Metodo para pedir un bocata
     */
    public static void usuarioPedirBocata(){
        //TODO: usuario pide bocata
    }

    /**
     * Metodo para ver el horario de los bocatas
     */
    public static void usuarioHorarioBocata(){
        //TODO: usuario mira horario
    }

    /**
     * Metodo para cancelar el bocata
     */
    public static void usuarioCancelarBocata(){
        //TODO: usuario cancela bocata
    }

    /**
     * Metodo para ver el historial de pedidos
     */
    public static void usuarioHistorialPedidos(){
        //TODO: usuario mira su historial de pedidos
    }

    //COCINA

    /**
     * Este metodo muestra el menu de cocina
     */

    public static void menuCocina(){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        String elec = "";

        System.out.println("----MENU COCINA----");
        System.out.println("1. Modificar estado");
        System.out.println("2. Ver pedidos");
        System.out.println("3. Deslogueo");
        elec = sc.nextLine();

        switch (elec) {
            case "1":
                cocinaModificarestado();
                next = true;
                break;
            case "2":
                cocinaVerPedidos();
                next = true;
                break;
            case "3":
                next = false;
                break;
            default:
                System.out.println("seleccona una opción");
                next = true;
                break;
        }
    }

    public static void cocinaModificarestado(){
        //TODO: cocina podra modificar el estado de los pedidos
    }

    public static void cocinaVerPedidos(){
        //TODO: cocina podra mirar los pedidos
    }

}
