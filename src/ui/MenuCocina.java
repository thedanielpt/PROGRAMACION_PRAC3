package ui;

import Excepciones.MensajeLargoException;
import models.Cocina;
import services.IncidenciasServicio;
import services.PedidosServicio;

import java.util.Scanner;

public class MenuCocina {

    //COCINA

    /**
     * Este metodo muestra el menu de cocina
     */

    public static void menuCocina(Cocina cocinera) throws MensajeLargoException {
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        String elec = "";

        do {
            System.out.println("----MENU COCINA----");
            System.out.println("1. Modificar estado");
            System.out.println("2. Ver pedidos");
            System.out.println("3. Crear incidencia");
            System.out.println("4. Deslogueo");
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
                    IncidenciasServicio.crearIncidenciaCocina();
                    next = true;
                    break;
                case "4":
                    next = false;
                    break;
                default:
                    System.out.println("seleccona una opción");
                    next = true;
                    break;
            }
        }while (next);
    }

    /**
     * Metodo que utiliza el menu de cocina para modificarlo
     */
    public static void cocinaModificarestado(){
        PedidosServicio.cambiarEstadoAFinalizado();
    }

    /**
     * Metodo para que cocina vea los pedidos
     */
    public static void cocinaVerPedidos(){
        PedidosServicio.mostrarTodosPedidos();
    }
}
