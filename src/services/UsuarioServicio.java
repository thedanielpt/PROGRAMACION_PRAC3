package services;

import data.GesData;
import models.Admin;
import models.Alumno;
import models.Cocina;
import models.User;
import utils.Validaciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class UsuarioServicio {

    /**
     * Muestra a todos los usuarios distribuidos entre alumno, cocina y administrador
     */
    public static void mostrarTodosUsers(){
        System.out.println("ALUMNOS");
        for (User usuario: GesData.usuarios) {
            if (usuario instanceof Alumno) {
                Alumno a = (Alumno) usuario;
                System.out.println(a.toString());
            }
        }

        System.out.println("\nCOCINA");

        for (User usuario: GesData.usuarios) {
            if (usuario instanceof Cocina) {
                Cocina c = (Cocina) usuario;
                System.out.println(c.toString());
            }
        }

        System.out.println("\nADMIN");

        for (User usuario: GesData.usuarios) {
            if (usuario instanceof Admin) {
                Admin a = (Admin) usuario;
                System.out.println(a.toString());
            }
        }
    }

    /**
     * Coje todos los usuarios
     * @return los devuelve en un ArrayList
     */

    public static ArrayList<User> obtenerTodos(){
        ArrayList<User> usuarios = new ArrayList<>();
        for (User usuario: GesData.usuarios) {
            usuarios.add(usuario);
        }
        return usuarios;
    }

    /**
     * Busca un usuario del parametro dado
     * @param usuario el usuario que se quiere buscar
     * @return si se encuentra el usuario lo devuelve, si no lo encuentra devuelve null
     */

    public static User buscar(String usuario){
        for (User usuarios: GesData.usuarios) {
            if (usuarios.getUsuario().equals(usuario)) {
                return usuarios;
            }
        }
        return null;
    }

    /**
     * Crea un usuario Alumno con alergias
     * @param usuario nombre de usuario unico
     * @param nombre nombre y apellidos del usuario
     * @param correo correo del usuario
     * @param password contraseña del usuario
     * @param alergico es alergico
     * @param alergias las alergias que tiene
     * @param curso el curso del usuario
     * @param pregunta la pregunta del usuario
     * @param respuesta la respuesta a la pregunta del usuario
     * @param num_expediente el numero de expediente
     * @param alta si esta de alta
     */

    public static void insertarUsuariosConAlergias(String usuario, String nombre, String correo, String password, boolean alergico, ArrayList<String> alergias, String curso, String pregunta, String respuesta, String num_expediente, boolean alta) {
        GesData.usuarios.add(new Alumno(usuario, nombre, correo, password, alergico,alergias, curso, pregunta, respuesta, num_expediente, alta));
    }

    /**
     * Crea un usuario Alumno sin alergias
     * @param usuario nombre de usuario unico
     * @param nombre nombre y apellidos del usuario
     * @param correo correo del usuario
     * @param password contraseña del usuario
     * @param alergico este valor esta a null
     * @param curso el curso del usuario
     * @param pregunta la pregunta del usuario
     * @param respuesta la respuesta a la pregunta del usuario
     * @param num_expediente el numero de expediente
     * @param alta si esta de alta
     */

    public static void insertarUsuariosSinAlergias(String usuario, String nombre, String correo, String password, boolean alergico, String curso, String pregunta, String respuesta, String num_expediente, boolean alta) {
        GesData.usuarios.add(new Alumno(usuario, nombre, correo, password, alergico, curso, pregunta, respuesta, num_expediente, alta));
    }

    /**
     * Este metodo coge la variable que le has dado y si encuentra al usuario lo elimina
     * @param eliminar usuario que se queire eliminar
     */

    public static void eliminar(String eliminar){
        for (User usuario: GesData.usuarios) {
            if (usuario.getUsuario().equals(eliminar)) {
                GesData.usuarios.remove(usuario);
                break;
            }
        }
    }

    /**
     * Crea un usuario de cocina
     *@param usuario nombre de usuario unico
     * @param nombre nombre y apellidos del usuario
     * @param correo correo del usuario
     * @param password contraseña del usuario
     * @return
     */

    public static void insertarCocina(String usuario, String nombre, String correo, String password){
        GesData.usuarios.add(new Cocina(usuario, nombre, correo, password));
    }

    /**
     * Crea un usuario de administrador
     *@param usuario nombre de usuario unico
     * @param nombre nombre y apellidos del usuario
     * @param correo correo del usuario
     * @param password contraseña del usuario
     * @return
     */

    public static void insertarAdmin(String usuario, String nombre, String correo, String password){
        GesData.usuarios.add(new Admin(usuario, nombre, correo, password));
    }

    public static void modificarAlergias(Alumno usuario){
        Scanner sc = new Scanner(System.in);
        boolean next = true;

        do {
            boolean alergicico  = Validaciones.tienesAlergias();

            System.out.println("Quieres cambiar los alergenos viejos: "+ usuario.isAlergico()+" por alergenos nuevos: "+alergicico+"?");

            if (Validaciones.validarEstasSeguro()) {
                if (alergicico) {
                    ArrayList<String> alergias = new ArrayList<>();
                    alergias = Validaciones.alergiasUsuario();
                    usuario.setAlergias(alergias);
                    GesData.usuarios.remove(usuario);
                } else {
                    usuario.setAlergico(alergicico);
                }
                next = false;
            } else {
                next=true;
            }
        }while (next);
    }

    public static void modificarCurso(Alumno usuario){
        Scanner sc = new Scanner(System.in);
        boolean next = true;

        do {
            String cursoNuevo  = Validaciones.cursoUsuario();

            System.out.println("Quieres cambiar el curso viejo: "+ usuario.getCurso()+" por el curso nuevo "+cursoNuevo+"?");

            if (Validaciones.validarEstasSeguro()) {
                usuario.setCurso(cursoNuevo);
                next = false;
            } else {
                next=true;
            }
        }while (next);
    }

    public static void modificarAlergico(Alumno usuario){
        Scanner sc = new Scanner(System.in);
        boolean next = true;

        do {
            boolean alergicico  = Validaciones.tienesAlergias();

            System.out.println("Quieres cambiar de alergico: "+ usuario.isAlergico()+" por alergico: "+alergicico+"?");

            if (Validaciones.validarEstasSeguro()) {
                if (alergicico) {
                    ArrayList<String> alergias = new ArrayList<>();
                    alergias = Validaciones.alergiasUsuario();
                    usuario.setAlergias(alergias);
                    GesData.usuarios.remove(usuario);
                    next = false;
                } else {
                    usuario.setAlergico(alergicico);
                }
            } else {
                next=true;
            }
        }while (next);
    }
}
