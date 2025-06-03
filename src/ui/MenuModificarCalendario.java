package ui;

import models.Calendario;
import services.CalendariosServicio;

import java.util.Scanner;

public class MenuModificarCalendario {

    /**
     * Menu para modificar el calendario
     */
    public static void modificarCalendario(){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        Calendario calendario = new Calendario();
        String string_calendarios;

        CalendariosServicio.mostrarTodosCalendarios();

        System.out.println("Pon el id del Calendario para seleccionarlo");

        string_calendarios = sc.nextLine();

        try{
            int num_calendarios = Integer.parseInt(string_calendarios);
            calendario = CalendariosServicio.buscarCalendario(num_calendarios);

            if (calendario!=null) {
                do {
                    System.out.println("¿Que atributo quieres modificar?");
                    System.out.println("1. Bocadillo frio");
                    System.out.println("2. Bocadillo caliente");
                    System.out.println("3. Salir");

                    String elec = sc.nextLine();

                    switch (elec) {
                        case "1":
                            CalendariosServicio.modificarEnCalendarioBocataFrio(calendario);
                            next = true;
                            break;
                        case "2":
                            CalendariosServicio.modificarEnCalendarioBocataCaliente(calendario);
                            next = true;
                            break;
                        case "3":
                            next = false;
                            break;
                        default:
                            next = true;
                            break;
                    }

                }while (next);
            }
        }catch (NumberFormatException e) {
            System.out.println("No has puesto solo el numero");
        }
    }
}
