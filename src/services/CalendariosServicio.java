package services;

import data.GesData;
import models.Alumno;
import models.Bocatas;
import models.Calendario;
import utils.Validaciones;

import java.sql.SQLOutput;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CalendariosServicio {
    /**
     * Calendario que se muestra a los usuarios
     */
    private static int[] calendarioSemana = {0,1,0,1,0};


    /**
     * Coge todos los calendarios
     * @return devuelve los calendarios en un arrayList
     */
    public static ArrayList<Calendario> obtenerTodosLosCalendarios(){
        ArrayList<Calendario> calendarios = new ArrayList<>();
        for(Calendario calendario: GesData.calendarios) {
            calendarios.add(calendario);
        }
        return calendarios;
    }

    /**
     * Busca un calendario
     * @param id_calendario el id del calendario
     * @return devuelve el calendario, si se encuentra, y si no lo encuentra devuelve null
     */
    public static Calendario buscarCalendario(int id_calendario){
        for (Calendario calendario: GesData.calendarios) {
            if (calendario.getId() == id_calendario) {
                return calendario;
            }
        }
        return null;
    }

    /**
     * Instancia un objeto Calendario
     * @param id id del Calendario
     * @param bocadilloFrio Bocadillo frio
     * @param bocadilloCaliente Bocadillo caliente
     */
    public static void insertarCalendario(int id, Bocatas bocadilloFrio, Bocatas bocadilloCaliente){
        GesData.calendarios.add(new Calendario(id, bocadilloFrio, bocadilloCaliente));
    }

    /**
     * Muestra todos los calendarios que hay disponibles
     */

    public static void mostrarTodosCalendarios(){
        for (Calendario calendario: GesData.calendarios) {
            System.out.println(calendario.toString());
        }
    }

    public static void eliminarCalendario(Calendario eliminar){
        if (eliminar != null) {
            for(Calendario calendario: GesData.calendarios) {
                if (calendario.getId() == eliminar.getId()) {
                    GesData.calendarios.remove(calendario);
                    break;
                }
            }
        } else {
            System.out.println("Calendario no encontrado");
        }

    }

    /**
     * Modifica el bocata frio
     * @param calendario parametro de valor objeto Calendario
     */

    public static void modificarEnCalendarioBocataFrio(Calendario calendario){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        int elec = 2;

            try {
                do {
                    Bocatas bocata  = BocatasServicio.ElegirBocata(elec);
                    if (!bocata.isCaliente()) {
                        System.out.println("¿Quieres cambiar el bocadillo: \n"+ calendario.getBocadillo_frio()+"\n este otro bocadillo: \n"+bocata+"?");
                        if (Validaciones.validarEstasSeguro()) {
                            calendario.setBocadillo_frio(bocata);
                            return;
                        } else {
                            System.out.println("No se ha cambiado la descripción del bocata");
                            return;
                        }
                    } else {
                        System.out.println("El bocata tiene que ser frio");
                    }
                }while (next);
            }catch (NullPointerException e) {
                System.out.println("Bocadillo no encontrado");
            }
    }

    /**
     * Modifica el bocata caliente
     * @param calendario parametro de valor objeto Calendario
     */

    public static void modificarEnCalendarioBocataCaliente(Calendario calendario){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        int elec = 1;

        try {
            do {
                Bocatas bocata  = BocatasServicio.ElegirBocata(elec =1);
                if (bocata.isCaliente()) {
                    System.out.println("¿Quieres cambiar el bocadillo: \n"+ calendario.getBocadillo_caliente()+"\n por este otro bocadillo: \n"+bocata+"?");
                    if (Validaciones.validarEstasSeguro()) {
                        calendario.setBocadillo_caliente(bocata);
                        return;
                    } else {
                        System.out.println("No se ha cambiado la descripción del bocata");
                        return;
                    }
                } else {
                    System.out.println("El bocata tiene que ser caliente");
                }
            }while (next);
        }catch (NullPointerException e) {
            System.out.println("No se encontro el bocadillo");
        }
    }

    /**
     * Crea un Calendario
     */

    public static void crearCalendario(){

        int id = Validaciones.validarIdCalendario();

        Bocatas frio = BocatasServicio.ElegirBocata(1);

        Bocatas caliente = BocatasServicio.ElegirBocata(2);

        insertarCalendario(id, frio, caliente);
    }

    public static int preguntarIdCalendario(){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        String elec = "";

        System.out.println("¿Que calendario quieres elegir?");

        do {
            elec = sc.nextLine();
            if (Validaciones.soloNum(elec)) {
                return Integer.parseInt(elec);
            } else {
                System.out.println("Tiene que ser solo numeros");
            }
        }while (next);
        return 0;
    }

    /**
     * Cambia el calenario para que sea publico
     * @param dia dia elegido
     */
    public static void cambiarCalendarioPublico(int dia){
        Scanner sc = new Scanner(System.in);
        String elec = "";
        boolean next = true;
        Calendario nuevo = new Calendario();

        do {
            for (Calendario calendario: GesData.calendarios){
                System.out.println(calendario);
            }

            System.out.println("Elige el calendarrio que quieres cambiar");

            elec = sc.nextLine();
            try {
                if (Validaciones.soloNum(elec)){
                    int id = Integer.parseInt(elec);
                    nuevo = buscarCalendario(id);
                    int a = nuevo.getId();
                    calendarioSemana[dia] = a;
                    return;
                } else {
                    System.out.println("ID no encontrada");
                }
            }catch (NullPointerException e) {
                System.out.println("Calendario no encontrado");
            }
        }while (next);
    }

    /**
     * Metodo para insertar el numero del calendario del día
     * @return devuelve el numero del calendario del dia
     */

    public static int calendarioDeHoy(){
        LocalDate fecha = LocalDate.now();
        DayOfWeek diaSemana = fecha.getDayOfWeek();
        int numeroDeHoy = diaSemana.getValue() - 1;

        return calendarioSemana[numeroDeHoy];
    }

    /**
     * Dice el menu de hoy
     * @return devuelve el bocata que pediste
     */
    public static Bocatas menuHoy(Alumno a){
        Scanner sc = new Scanner(System.in);
        Bocatas bocataFrio = new Bocatas();
        Bocatas bocataCaliente = new Bocatas();
        Bocatas bocata = new Bocatas();
        boolean next = true;
        String elec = "";

        System.out.println("Estos son los dos bocadillos de hoy");
        int idCalendarioHoy = calendarioDeHoy();
        for (Calendario calendario: GesData.calendarios) {

            if (calendario.getId() == idCalendarioHoy) {
                bocataFrio = calendario.getBocadillo_frio();
                bocataCaliente = calendario.getBocadillo_caliente();

                System.out.println("1. ------BOCATA FRIO------");
                System.out.println("Nombre de bocata frio: "+ bocataFrio.getNombre());
                System.out.println();
                System.out.println("Descripción de bocatafrio: "+ bocataFrio.getDescrip());
                System.out.println();
                System.out.println("Alergenos:");
                System.out.println(bocataFrio.getAlergenos());
                System.out.println();

                System.out.println("2. ------BOCATA CALIENTE------");
                System.out.println("Nombre de bocata caliente: "+ bocataCaliente.getNombre());
                System.out.println();
                System.out.println("Descripción de bocata caliente: "+ bocataCaliente.getDescrip());
                System.out.println();
                System.out.println("Alergenos:");
                System.out.println(bocataCaliente.getAlergenos());
                break;
            }
        }
        do {
            System.out.println("Elige que bocata quieres con su nombre");
            System.out.println("Si no lo quieres pedir pon 'No quiero'");
            elec = sc.nextLine();
            switch (elec) {
                case "1":
                    if (BocatasServicio.comprobarAlergenosDeBocataAlumno(bocataFrio, a)) {
                        System.out.println("Alergeno peligroso encontrado");
                        return null;
                    } else {
                        return bocataFrio;
                    }
                case "2":
                    if (BocatasServicio.comprobarAlergenosDeBocataAlumno(bocataCaliente, a)) {
                        System.out.println("Alergeno peligroso encontrado");
                        return null;
                    } else {
                        return bocataCaliente;
                    }
                case "No quiero":
                    return null;
                default:
                    next = true;
                    System.out.println("No elegistes ningun bocata");
                    break;
            }
        }while (next);
        return null;
    }
}
