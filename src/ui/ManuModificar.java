package ui;

import models.Admin;
import models.Alumno;
import models.Cocina;
import models.User;

import java.util.Scanner;

import static services.UsuarioServicio.buscar;

public class ManuModificar {
    public static User modificarUsuarios(){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        User user = new User();
        Alumno alumno = new Alumno();
        Cocina cocina = new Cocina();
        Admin adomin = new Admin();
        String usuario;

        System.out.println("Pon el nombre de usuario");

        usuario = sc.nextLine();

        while (next) {
            if (buscar(usuario).equals(usuario)) {
                user = buscar(usuario);
            } else {
                System.out.println("Pon el nombre de usuario");
                usuario = sc.nextLine();
            }
        }

        do {
            next = true;
            System.out.println("¿Que quieres modificar?");
            System.out.println("0. Salir");
            System.out.println("1. Usuario");
            System.out.println("2. Nombre");
            System.out.println("3. Curso");
            System.out.println("4. Correo");
            System.out.println("5. Contraseña");
            if ((alumno.isAlergico())) {
                System.out.println("6. Alergico");
                System.out.println("7. Alergias");
            } else {
                System.out.println("6. Alergico");
            }
            String elec = sc.nextLine();

            if (alumno.isAlergico()){
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
                        // Alumno.modificarCurso(user); Si modificas el curso, tambien modificas el expediente
                        break;
                    case "4":
                        User.modificarCorreo(user);
                        break;
                    case "5":
                        User.modificarContrasena(user);
                        break;
                    case "6":
                        break;
                    case "7":
                        // Alumno.modificarAlergico(user);
                        break;
                    case "8":
                        // Alumno.modificarAlergias(user);
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
                        //   Alumno.modificarCurso(user);
                        break;
                    case "4":
                        User.modificarCorreo(user);
                        break;
                    case "5":
                        User.modificarContrasena(user);
                        break;
                    case "6":
                        //  Alumno.modificarAlergico(user);
                        break;
                    default:
                        System.out.println("elige una opción");
                        break;
                }
            }
        }while (next);

        return null;
    }
}
