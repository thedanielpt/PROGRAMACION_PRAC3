package ui;

import services.CalendariosServicio;

import java.util.Scanner;

public class MenuCambiarCalendarioDeLaSemana {

    //Probar

    /**
     * Gestion del menu de la semana
     */
    public static void MenuSemana(){
        Scanner sc = new Scanner(System.in);
        boolean next = true;

        int diaDeSemana = 0;

        do {
            System.out.println("A que día le quieres cambiar el calendario:");
            System.out.println("1. Lunes");
            System.out.println("2. Martes");
            System.out.println("3. miercoles");
            System.out.println("4. Jueves");
            System.out.println("5. Viernes");
            System.out.println("6. salir");

            String elec = sc.nextLine();

            switch (elec) {
                case "1":
                    CalendariosServicio.cambiarCalendarioPublico(diaDeSemana);
                    next = false;
                    break;
                case "2":
                    diaDeSemana += 1;
                    CalendariosServicio.cambiarCalendarioPublico(diaDeSemana);
                    next = false;
                    break;
                case "3":
                    CalendariosServicio.cambiarCalendarioPublico(diaDeSemana);
                    diaDeSemana += 2;
                    next = false;
                    break;
                case "4":
                    CalendariosServicio.cambiarCalendarioPublico(diaDeSemana);
                    diaDeSemana += 3;
                    next = false;
                    break;
                case "5":
                    CalendariosServicio.cambiarCalendarioPublico(diaDeSemana);
                    diaDeSemana += 4;
                    next = false;
                    break;
                case "6":
                    next = false;
                    break;
                default:
                    System.out.println("Tienes que seleccionar una opción");
                    next = true;
                    break;
            }
        }while (next);
    }

}
