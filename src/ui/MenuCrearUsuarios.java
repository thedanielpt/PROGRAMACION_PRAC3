package ui;

import services.UsuarioServicio;
import utils.Validaciones;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuCrearUsuarios {
    /**
     * Este es un menu de crear usuario
     */

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
