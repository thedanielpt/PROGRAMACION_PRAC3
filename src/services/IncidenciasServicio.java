package services;

import Excepciones.MensajeLargoException;
import data.GesData;
import models.Alumno;
import models.Incidencia;
import models.User;
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

    public static void crearIncidenciaAlumno(String usuario) throws MensajeLargoException {
        User a = new User();

        int id = Validaciones.validarIdIncidencia();

        String nombre = Validaciones.validarNombreIncidencia();


        if (nombre.equals("nocrear")) {
            return;
        } else if (nombre.equals("Sobre mi pedido") && UsuarioServicio.esAlmuno(usuario)) {
            a = UsuarioServicio.buscarUsuarios(usuario);
            Alumno alumno = (Alumno) a;
            if (!PedidosServicio.siAlumnoTienePedidos(alumno)) {
                System.out.println("No tienes ningun pedido");
                return;
            }
        }

        String descripcion = Validaciones.validarDescripcionIncidencia();

        insertarIncidencia(id, nombre, descripcion, LocalDate.now());
    }

    public static void crearIncidenciaCocina() throws MensajeLargoException {

        int id = Validaciones.validarIdIncidencia();

        String nombre = "Incidencia Cocina";

        String descripcion = Validaciones.validarDescripcionIncidencia();

        insertarIncidencia(id, nombre, descripcion, LocalDate.now());
    }
}
