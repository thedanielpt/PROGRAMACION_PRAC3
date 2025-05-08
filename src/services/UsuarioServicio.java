package services;

import data.GesData;
import models.Alumno;
import models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class UsuarioServicio {

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
    public void eliminar(String eliminar){
        for (User usuario: GesData.usuarios) {
            if (usuario.getUsuario().equals(eliminar)) {
                GesData.usuarios.remove(usuario);
                break;
            }
        }
        System.out.println("El usuario no ha siddo eliminado");
    }

    public static User insertarUsuariosConAlergias(String usuario, String nombre, String curso, String correo, String password, boolean alergico, ArrayList alergias, LocalDate año_nacimiento, int rol){
        GesData.usuarios.add(new User(usuario, nombre, curso, correo, password, alergico, alergias,año_nacimiento, rol));
        return null;
    }

    public static User insertarUsuariosSinAlergias(String usuario, String nombre, String curso, String correo, String password, boolean alergico, LocalDate año_nacimiento, int rol){
        GesData.usuarios.add(new User(usuario, nombre, curso, correo, password, alergico,año_nacimiento, rol));
        return null;
    }

    public static User modificarUsuarios(){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        User user = new User();
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
            System.out.println("6. Fecha de nacimiento");
            if (user.isAlergico()) {
                System.out.println("7. Alergico");
                System.out.println("8. Alergias");
            } else {
                System.out.println("7. Alergico");
            }
            String elec = sc.nextLine();

            if (user.isAlergico()){
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
                        Alumno.modificarCurso(user);
                        break;
                    case "4":
                        User.modificarCorreo(user);
                        break;
                    case "5":
                        User.modificarContrasena(user);
                        break;
                    case "6":
                        Alumno.modificarFechaNacimiento(user);
                        break;
                    case "7":
                        Alumno.modificarAlergico(user);
                        break;
                    case "8":
                        Alumno.modificarAlergias(user);
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
                        User.modificarCurso(user);
                        break;
                    case "4":
                        User.modificarCorreo(user);
                        break;
                    case "5":
                        User.modificarContrasena(user);
                        break;
                    case "6":
                        User.modificarFechaNacimiento(user);
                        break;
                    case "7":
                        User.modificarAlergico(user);
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
