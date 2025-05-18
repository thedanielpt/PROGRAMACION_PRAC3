package services;

import data.GesData;
import models.Bocatas;
import models.Calendario;

import java.util.ArrayList;

public class CalendariosServicio {

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
}
