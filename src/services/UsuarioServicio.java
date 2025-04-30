package services;

import data.GesData;
import models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class UsuarioServicio {

    public static ArrayList<String> obtenerTodos(){
        ArrayList<String> usuarios = new ArrayList<>();
        for (User usuario: GesData.usuarios) {
            usuarios.add(usuario.getNombre());
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
            System.out.println("1. Nombre usuario");
            System.out.println("2. Nombre");
            System.out.println("3. Curso");
            System.out.println("4. Correo");
            System.out.println("5. Contraseña");
            System.out.println("6. Fecha de nacimiento");
            System.out.println("7. Rol");
            if (user.isAlergico()) {
                System.out.println("8. Alergico");
                System.out.println("9. Alergias");
            } else {
                System.out.println("8. Alergico");
            }
            String elec = sc.nextLine();

            if (user.isAlergico()){
                switch (elec) {
                    case "0":
                        next = false;
                        break;
                    case "1":

                        break;
                    case "2":

                        break;
                    case "3":

                        break;
                    case "4":

                        break;
                    case "5":

                        break;
                    case "6":

                        break;
                    case "7":

                        break;
                    case "8":

                        break;
                    case "9":

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

                        break;
                    case "2":

                        break;
                    case "3":

                        break;
                    case "4":

                        break;
                    case "5":

                        break;
                    case "6":

                        break;
                    case "7":

                        break;
                    case "8":

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
