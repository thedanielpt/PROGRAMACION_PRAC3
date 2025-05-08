package ui;

import java.util.Scanner;

public class MenuCocina {

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
