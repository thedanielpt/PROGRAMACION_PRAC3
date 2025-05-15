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

    public static ArrayList<User> obtenerTodos(){
        ArrayList<User> usuarios = new ArrayList<>();
        for (User usuario: GesData.usuarios) {
            usuarios.add(usuario);
        }
        return usuarios;
    }

    public static User buscar(String usuario){
        for (User usuarios: GesData.usuarios) {
            if (usuarios.getUsuario().equals(usuario)) {
                return usuarios;
            }
        }
        return null;
    }

    public static void insertarUsuariosConAlergias(String usuario, String nombre, String correo, String password, boolean alergico, ArrayList<String> alergias, String curso, String pregunta, String respuesta, String num_expediente, boolean alta) {
        GesData.usuarios.add(new Alumno(usuario, nombre, correo, password, alergico,alergias, curso, pregunta, respuesta, num_expediente, alta));
    }

    public static void insertarUsuariosSinAlergias(String usuario, String nombre, String correo, String password, boolean alergico, String curso, String pregunta, String respuesta, String num_expediente, boolean alta) {
        GesData.usuarios.add(new Alumno(usuario, nombre, correo, password, alergico, curso, pregunta, respuesta, num_expediente, alta));
    }

    public static void eliminar(String eliminar){
        for (User usuario: GesData.usuarios) {
            if (usuario.getUsuario().equals(eliminar)) {
                GesData.usuarios.remove(usuario);
                break;
            }
        }
    }

    public static Cocina insertarCocina(String usuario, String nombre, String correo, String password){
        GesData.usuarios.add(new Cocina(usuario, nombre, correo, password));
        return null;
    }

    public static Admin insertarAdmin(String usuario, String nombre, String correo, String password){
        GesData.usuarios.add(new Admin(usuario, nombre, correo, password));
        return null;
    }



    public static void registroUsers(){
        Scanner sc = new Scanner(System.in);
        boolean next = true;

        do {
            System.out.println("¿Que tipo de usuario quieres crear?");

            System.out.println("--TIPOS DE USUARIO--");
            System.out.println("1.----- ADMIN ------");
            System.out.println("2.----- COCINA -----");
            System.out.println("3.----- ALUMNO -----");
            System.out.println("4.----- SAlIR ------");

            String elec = sc.nextLine();

            switch (elec) {
                case "1":
                    try {
                        String usuario = Validaciones.validarUsuario();

                        String nombre = Validaciones.nombreApellidos();

                        String correo = Validaciones.validarGmail();

                        String password = Validaciones.validarContrasena();

                        UsuarioServicio.insertarAdmin(usuario,nombre,correo,password);
                        next = false;
                        break;
                    } catch (Exception e) {
                        System.out.println("Error a la hora de crear un usuario admin");
                        break;
                    }

                case "2":
                    try {
                        String usuario = Validaciones.validarUsuario();

                        String nombre = Validaciones.nombreApellidos();

                        String correo = Validaciones.validarGmail();

                        String password = Validaciones.validarContrasena();

                        UsuarioServicio.insertarCocina(usuario,nombre,correo,password);
                        next = false;
                        break;
                    } catch (Exception e) {
                        System.out.println("Error a la hora de crear un usuario cocina");
                        break;
                    }

                case "3":
                    try {
                        String usuario = Validaciones.validarUsuario();

                        String nombre = Validaciones.nombreApellidos();

                        String correo = Validaciones.validarGmail();

                        String password = Validaciones.validarContrasena();

                        String curso = Validaciones.cursoUsuario();

                        boolean alergico = Validaciones.tienesAlergias();

                        String pregunta = Validaciones.validarPregunta();

                        System.out.println(pregunta+" Responde a la pregunta");

                        String resultado = sc.nextLine();

                        String num_expediente = Validaciones.validar_expediente(curso);

                        boolean alta = Validaciones.validar_alta();

                        if (alergico) {
                            ArrayList alergias = Validaciones.alergiasUsuario();
                            UsuarioServicio.insertarUsuariosConAlergias(usuario,nombre,correo,password, alergico,alergias, curso, pregunta, resultado, num_expediente, alta);
                            next = false;
                        } else {
                            UsuarioServicio.insertarUsuariosSinAlergias(usuario,nombre,correo,password, alergico, curso, pregunta, resultado, num_expediente, alta);
                            next = false;
                        }
                    } catch (Exception e) {
                        System.out.println("Error a la hora de crear un usuario Alumno");
                    }
                    break;
                case "4":
                    next = false;
                    break;
                default:
                    System.out.println("Elige una opcion");
                    break;
            }
        }while (next);
    }
}
