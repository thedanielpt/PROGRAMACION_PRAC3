package ui;

import Excepciones.MensajeLargoException;
import models.Alumno;
import services.IncidenciasServicio;
import services.PedidosServicio;
import utils.Validaciones;

import java.util.Scanner;

public class MenuAlumno {

    //ALUMNO

    /**
     * Metodo donde esta el menu de Usuario
     */

    public static void menuUsuario(Alumno alumno) throws MensajeLargoException {
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        String elec = "";

        do {
            System.out.println("----MENU USUARIO----");
            System.out.println("Horario para pedir: 8:00 - 10:30");
            System.out.println("1. Pedir bocata");
            System.out.println("2. Cancelar pedido");
            System.out.println("3. Historial de pedidos");
            System.out.println("4. Hacer una incidencia");
            System.out.println("5. Deslogueo");
            elec = sc.nextLine();
            next = true;

            switch (elec) {
                case "1":
                    usuarioPedirBocata(alumno);
                    next = true;
                    break;
                case "2":
                    usuarioCancelarPedido(alumno);
                    next = true;
                    break;
                case "3":
                    usuarioHistorialPedidos(alumno);
                    next = true;
                    break;
                case "4":
                    IncidenciasServicio.crearIncidenciaAlumno(alumno.getUsuario());
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
    public static void usuarioPedirBocata(Alumno alumno){
        if (Validaciones.validarHora()) {
            PedidosServicio.pedirBocadillo(alumno);
        } else {
            System.out.println("Fuera de horario");
        }
    }

    /**
     * Metodo para cancelar el bocata
     */
    public static void usuarioCancelarPedido(Alumno alumno){
        PedidosServicio.cancelarPedido(alumno);
    }

    /**
     * Metodo para ver el historial de pedidos
     */
    public static void usuarioHistorialPedidos(Alumno alumno){
        PedidosServicio.mostrarPedidosDeAlumno(alumno);
    }
}
