package ui;

import Excepciones.MensajeLargoException;
import Excepciones.MenuUsuarioNoEncontrado;
import autentificar.AuathService;
import models.Admin;
import models.Alumno;
import models.Cocina;
import models.User;
import services.UsuarioServicio;

import java.util.Scanner;

public class MenuAutenticar {

    /**
     * Menu principal para el login
     */
    public static void menAutentificar() throws MensajeLargoException, MenuUsuarioNoEncontrado{
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        String nombreUser = "";
        do {
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Recuperar contraseña");
            System.out.println("0. Salir");
            String elec = sc.nextLine();

            switch (elec) {
                case "1":
                    nombreUser = AuathService.login();
                    User usuario = UsuarioServicio.buscarUsuarios(nombreUser);
                    if (usuario instanceof Alumno) {
                        Alumno a = (Alumno) usuario;
                        MenuAlumno.menuUsuario(a);
                    } else if (usuario instanceof Cocina) {
                        Cocina c = (Cocina) usuario;
                        MenuCocina.menuCocina(c);
                    } else if (usuario instanceof Admin) {
                        Admin a = (Admin) usuario;
                        MenuAdministrador.menuAdmin(a);
                    } else {
                        throw new MenuUsuarioNoEncontrado("Error a la hora de buscar el menu del usuaio elegido");
                    }
                    break;
                case "2":
                    //hacer lo de recuperar contraseña
                case "0":
                    next = false;
                    break;
                default:
                    System.out.println("Tienes que elegir una opción");
                    break;
            }
        }while (next);
    }
}