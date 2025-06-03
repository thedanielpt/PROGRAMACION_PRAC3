package ui;

import models.Bocatas;
import services.BocatasServicio;

import java.util.Scanner;

/**
 * Clase de del menu de bocadillos
 */

public class MenuModificarBocadillo {
    /**
     * Menu para modificar los atributos de los bocatas
     */

    public static void modificarBocata(){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        Bocatas bocata = new Bocatas();
        String bocatas;

        BocatasServicio.mostrarTodosBocatas();

        System.out.println("\nPon el nombre del bocata que quieras modificar");

        bocatas = sc.nextLine();

        bocata = BocatasServicio.buscarBocata(bocatas);

        if (bocata != null) {
            do {
                System.out.println("¿Que atributo quieres modificar?");
                System.out.println("1. Nombre");
                System.out.println("2. Descripción");
                System.out.println("3. Ingredientes");
                System.out.println("4. Alergenos");
                System.out.println("5. Precio");
                System.out.println("6. Caliente");
                System.out.println("7. Salir");

                String elec = sc.nextLine();

                switch (elec) {
                    case"1":
                        BocatasServicio.modificarNombreBocata(bocata);
                        break;
                    case"2":
                        BocatasServicio.modificarDescripcionBocata(bocata);
                        break;
                    case"3":
                        BocatasServicio.modificarIngredientesBocata(bocata);
                        break;
                    case"4":
                        BocatasServicio.modificarAlergenosBocata(bocata);
                        break;
                    case"5":
                        BocatasServicio.modificarPrecioBocata(bocata);
                        break;
                    case"6":
                        BocatasServicio.modificarCalienteBocata(bocata);
                        break;
                    case"7":
                        next = false;
                        break;
                    default:
                        System.out.println("Elige una opción");
                        break;
                }
            } while (next);
        } else {
            System.out.println("Bocata no encontrado");
        }
    }
}
