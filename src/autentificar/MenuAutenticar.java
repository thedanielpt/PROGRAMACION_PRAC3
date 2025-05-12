package autentificar;

import models.Alumno;
import models.User;
import services.UsuarioServicio;
import ui.MenuAlumno;

import java.util.Scanner;

public class MenuAutenticar {
    public static User menAutentificar(){
        Scanner sc = new Scanner(System.in);
        String nombreUser = "";
        do {
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registro");
            System.out.println("3. Recuperar contraseña");
            System.out.println("0. Salir");
            String elec = sc.nextLine();

            switch (elec) {
                case "1":
                    nombreUser = AuathService.login();
                    User usuario = UsuarioServicio.buscar(nombreUser);

                    if (usuario instanceof Alumno) {
                        Alumno a = (Alumno) usuario;
                        MenuAlumno.menuUsuario(a);
                    }
                    System.out.println("Error login");
                    break;
                case "2":
                    AuathService.registro();
                    break;
                case "3":

                case "0":
                    nombreUser = "a";
                default:
                    System.out.println("Tienes que elegir una opción");
                    break;
            }
        }while (nombreUser!=null);
        return null;
    }
}