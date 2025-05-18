package services;

import data.GesData;
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
}
