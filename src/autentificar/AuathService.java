package autentificar;

import data.GesData;
import models.Admin;
import models.Alumno;
import models.Cocina;
import models.User;
import services.UsuarioServicio;
import utils.Validaciones;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class AuathService {
    public static String login(){
        Scanner sc = new Scanner(System.in);
        String nameL = "";
        String contraL = "";
        GesData.cargarUsuaios();

        if (Validaciones.captcha()){
            System.out.println("Escribe tu nombre de usuario");
            for (int i = 0; i < 4; i++) {
                nameL = sc.nextLine();
                for (User usuario : GesData.usuarios) {
                    if (nameL.equals(usuario.getUsuario())) {
                        for (int j = 0; j < 4; j++) {
                            System.out.println("Escribe tu contraseña");
                            contraL = sc.nextLine();
                            if (contraL.equals(usuario.getPassword())) {
                                return usuario.getNombre();
                            } else {
                                System.out.println("Contraseña no encontrada");
                            }
                            if (j == 3) {
                                System.out.println("Demasiados intentos");
                                return null;
                            }
                        }
                    }
                }
                System.out.println("Usuario no encontrado");
                if (i == 3){
                    System.out.println("Demasiados intentos");
                    return null;
                }
            }
        } else {
            System.out.println("Se cancelo el login");
            return null;
        }
        return null;
    }

    public static void registro(){
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

                        boolean alergico = Validaciones.tienesalergias();

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
