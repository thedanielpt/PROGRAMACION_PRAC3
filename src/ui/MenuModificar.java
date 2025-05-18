package ui;

import models.*;
import services.BocatasServicio;
import services.UsuarioServicio;
import utils.Validaciones;

import java.util.Scanner;

public class MenuModificar {

    /**
     * Menu para modificar los atributos de usuario
     */
    public static void modificarUsuarios(){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        User user = new User();
        String usuario;

        UsuarioServicio.mostrarTodosUsers();

        System.out.println("\nPon el nombre del usuario que quieras modificar");

        usuario = sc.nextLine();

        user = UsuarioServicio.buscarUsuarios(usuario);

        if (UsuarioServicio.buscarUsuarios(usuario) != null && user instanceof Alumno) {
            Alumno a = (Alumno) user;
            do {
                next = true;
                System.out.println("¿Que quieres modificar?");
                System.out.println("0. Salir");
                System.out.println("1. Usuario");
                System.out.println("2. Nombre");
                System.out.println("3. Curso");
                System.out.println("--AVISO: Si modificas el curso modificas el num_expediente");
                System.out.println("4. Correo");
                System.out.println("5. Contraseña");
                if ((a.isAlergico())) {
                    System.out.println("6. Alergico");
                    System.out.println("7. Alergias");
                } else {
                    System.out.println("6. Alergico");
                }
                String elec = sc.nextLine();

                if (a.isAlergico()){
                    switch (elec) {
                        case "0":
                            next = false;
                            break;
                        case "1":
                            User.modificarUsuario(user);
                            break;
                        case "2":
                            User.modificarNombreUsuario(user);
                            break;
                        case "3":
                            UsuarioServicio.modificarCurso(a);
                            Validaciones.validar_expediente(a.getCurso());
                            break;
                        case "4":
                            User.modificarCorreo(user);
                            break;
                        case "5":
                            User.modificarContrasena(user);
                            break;
                        case "6":
                            UsuarioServicio.modificarAlergico(a);
                            break;
                        case "7":
                            UsuarioServicio.modificarAlergias(a);
                            break;
                        default:
                            System.out.println("elige una opción");
                            break;
                    }
                } else {
                    switch (elec) {
                        case "0":
                            next = false;
                            break;
                        case "1":
                            User.modificarUsuario(user);
                            break;
                        case "2":
                            User.modificarNombreUsuario(user);
                            break;
                        case "3":
                            UsuarioServicio.modificarCurso(a);
                            break;
                        case "4":
                            User.modificarCorreo(user);
                            break;
                        case "5":
                            User.modificarContrasena(user);
                            break;
                        case "6":
                            UsuarioServicio.modificarAlergico(a);
                            break;
                        default:
                            System.out.println("elige una opción");
                            break;
                    }
                }
            }while (next);
        }
    }

    /**
     * Menu para modificar los atributos de los bocatas
     */

    public static void modificarBocata(){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        Bocatas bocata = new Bocatas();
        String bocatas;

        BocatasServicio.mostrarTodosBocatas();

        System.out.println("\nPon el nombre del bocata que quieras modificar");

        bocatas = sc.nextLine();

        bocata = BocatasServicio.buscarBocata(bocatas);

        if (bocata != null) {
            do {
                System.out.println("¿Que atributo quieres modificar?");
                System.out.println("1. Nombre");
                System.out.println("2. Descripción");
                System.out.println("3. Ingredientes");
                System.out.println("4. Alergenos");
                System.out.println("5. Precio");
                System.out.println("6. Caliente");
                System.out.println("7. Salir");

                String elec = sc.nextLine();

                switch (elec) {
                    case"1":
                        BocatasServicio.modificarNombreBocata(bocata);
                        break;
                    case"2":
                        BocatasServicio.modificarDescripcionBocata(bocata);
                        break;
                    case"3":
                        BocatasServicio.modificarIngredientesBocata(bocata);
                        break;
                    case"4":
                        BocatasServicio.modificarAlergenosBocata(bocata);
                        break;
                    case"5":
                        BocatasServicio.modificarPrecioBocata(bocata);
                        break;
                    case"6":
                        BocatasServicio.modificarCalienteBocata(bocata);
                        break;
                    case"7":
                        next = false;
                        break;
                    default:
                        System.out.println("Elige una opción");
                        break;
                }

            } while (next);
        } else {
            System.out.println("Bocata no encontrado");
        }
    }
}
