package ui;

import Excepciones.MensajeLargoException;
import Excepciones.MenuUsuarioNoEncontrado;
import autentificar.AuathService;
import models.Admin;
import models.Alumno;
import models.Cocina;
import models.User;
import services.UsuarioServicio;
import utils.Validaciones;

import java.util.Scanner;

public class MenuAutenticar {

    /**
     * Menu principal para el login
     */
    public static void menAutentificar() throws MensajeLargoException, MenuUsuarioNoEncontrado{
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        do {
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Recuperar contraseña");
            System.out.println("0. Salir");
            String elec = sc.nextLine();

            switch (elec) {
                case "1":
                    login();
                    next = true;
                    break;
                case "2":
                    recuperarContrasena();
                    next = true;
                    break;
                case "0":
                    next = false;
                    break;
                default:
                    System.out.println("Tienes que elegir una opción");
                    break;
            }
        }while (next);
    }

    public static void login() throws MenuUsuarioNoEncontrado, MensajeLargoException {
        String nombreUser = "";
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
    }

    public static void recuperarContrasena(){
        User u = new User();

        u = UsuarioServicio.buscarUsuarios(Validaciones.recuperarContrasenaPreguntaUsuario());
        if (u instanceof Alumno){
            Alumno user = (Alumno) u;
            Validaciones.recuperacionContrasena(user);
        } else {
            System.out.println("Tu usuario no puede cambiar la contraseña aquí");
        }
    }
}