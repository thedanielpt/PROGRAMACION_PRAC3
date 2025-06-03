package services;

import Excepciones.MensajeLargoException;
import data.GesData;
import models.Incidencia;
import utils.Validaciones;

import java.time.LocalDate;

public class IncidenciasServicio {

    public static void mostrarIncidencias(){
        for (Incidencia incidencia: GesData.incidencias) {
            System.out.println(incidencia);
        }
    }

    public static void insertarIncidencia(int id, String nombre, String descripcion, LocalDate fecha){
        GesData.incidencias.add(new Incidencia(nombre,id,descripcion,fecha));
    }

    public static void crearIncidencia() throws MensajeLargoException {

        int id = Validaciones.validarIdIncidencia();

        String nombre = Validaciones.validarNombreIncidencia();

        String descripcion = Validaciones.validarDescripcionIncidencia();

        insertarIncidencia(id, nombre, descripcion, LocalDate.now());
    }
}
