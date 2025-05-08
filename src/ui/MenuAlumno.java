package ui;

import java.util.Scanner;

public class MenuAlumno {

    //ALUMNO

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
}
