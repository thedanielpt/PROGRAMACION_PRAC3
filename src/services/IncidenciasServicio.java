package services;

import Excepciones.MensajeLargoException;
import data.GesData;
import models.Alumno;
import models.Bocatas;
import models.Incidencia;
import models.User;
import utils.Validaciones;

import java.io.*;
import java.time.LocalDate;

public class IncidenciasServicio {

    public static void leerIncidencias() throws IOException {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("src/persistencia/Incidencias.dat");
            ois = new ObjectInputStream(fis);
            Incidencia i;
            while (true) {
                i = (Incidencia) ois.readObject();
                GesData.incidencias.add(i);
            }
        } catch (FileNotFoundException e) {

        } catch (ClassNotFoundException e) {

        } catch (IOException e) {

        }finally {
            if (ois!=null){
                fis.close();
                ois.close();
            }
        }
    }

    public static void escribirIncidencias(){
        try {
            FileOutputStream fos = new FileOutputStream("src/persistencia/Incidencias.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Incidencia i: GesData.incidencias){
                oos.writeObject(i);
            }
            oos.flush();
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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
