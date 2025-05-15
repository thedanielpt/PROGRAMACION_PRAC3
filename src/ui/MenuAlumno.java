package ui;

import models.Alumno;
import utils.Validaciones;

import java.time.LocalDateTime;
import java.util.Scanner;

public class MenuAlumno {

    //ALUMNO

    /**
     * Metodo donde esta el menu de Usuario
     */

    public static void menuUsuario(Alumno alumno){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        String elec = "";

        do {
            System.out.println("----MENU USUARIO----");
            System.out.println("----8:00 - 10:30----");
            System.out.println("Hora"+LocalDateTime.now());
            System.out.println("1. Pedir bocata");
            System.out.println("2. Cancelar pedido");
            System.out.println("3. Historial de pedidos");
            System.out.println("4. Deslogueo");
            elec = sc.nextLine();
            next = true;

            switch (elec) {
                case "1":
                    usuarioPedirBocata();
                    next = true;
                    break;
                case "2":
                    usuarioCancelarBocata();
                    next = true;
                    break;
                case "3":
                    usuarioHistorialPedidos();
                    next = true;
                    break;
                case "4":

                    next = true;
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
        if (Validaciones.validarHora()) {
            MenuBocatas.menuPedirBocata();
        } else {
            System.out.println("Fuera de horario");
        }
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
