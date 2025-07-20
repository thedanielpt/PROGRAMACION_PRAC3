package ui;

import models.Admin;
import models.Alumno;
import models.User;
import services.*;
import utils.Validaciones;

import java.util.Scanner;

/**
 * Clase donde esta el menu del Administrador
 */

public class MenuAdministrador {
    private static boolean usuarioEsta=true;

    //ADMIN

    /**
     *Metodo donde esta el menu Admin
     */
    public static void menuAdmin(Admin admin){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        String elec = "";

        do {
            System.out.println("Menu Principal");
            System.out.println("1. Gestionar usuarios:");
            System.out.println("2. Gestionar Bocadillos:");
            System.out.println("3. Pedir bocata");
            System.out.println("4. Gestionar Pedidos:");
            System.out.println("5. Gestionar Calendario");
            System.out.println("6  Incidencias");
            System.out.println("7. Salir");
            elec = sc.nextLine();
            if (!usuarioEsta) {
                next = false;
            } else {
                next = true;
            }
            switch (elec) {
                case "1":
                    adminGestionUsers(admin);
                    if (UsuarioServicio.buscarUsuarios(admin.getUsuario()) == null) {
                        System.out.println("Usuario administrador eliminado");
                        return;
                    }
                    next = true;
                    break;
                case "2":
                    adminGestionarBocadillos();
                    next = true;
                    break;
                case "3":
                    adminPedirBocata();
                    next = true;
                    break;
                case "4":
                    adminPedidos();
                    next = true;
                    break;
                case "5":
                    adminGestionarCalendario();
                    next = true;
                    break;
                case "6":
                    IncidenciasServicio.mostrarIncidencias();
                    next = true;
                    break;
                case "7":
                    usuarioEsta = false;
                    next = false;
                    break;
                default:
                    System.out.println("Tienes que seleccionar una opción");
                    next = true;
                    break;
            }

        } while (next);
    }

    /**
     * Menu de admin de gestion de usuarios
     */
    private static void adminGestionUsers(Admin admin){
        Scanner sc = new Scanner(System.in);
        String elec = "";
        boolean next = true;
        do {
            System.out.println("1. Listar usuarios");
            System.out.println("2. Añadir usuario");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Modificar usuario");
            System.out.println("5. Volver al menu princiapal");
            elec = sc.nextLine();

            switch (elec) {
                case "1":
                    UsuarioServicio.mostrarTodosUsers();
                    next = true;
                    break;
                case "2":
                    MenuCrearUsuarios.registroUsers();
                    next = true;
                    break;
                case "3":
                    UsuarioServicio.eliminar(Validaciones.pregunta_buscar(1));
                    if (UsuarioServicio.buscarUsuarios(admin.getUsuario()) == null) {
                        return;
                    } else {
                        next = true;
                    }
                    break;
                case "4":
                    MenuModificarUsuario.modificarUsuarios();
                    next = true;
                    break;
                case "5":
                    next = false;
                    break;
                default:
                    next = true;
                    break;
            }
        } while (next);
    }

    /**
     * Menu de admin para la gestion de bocadillos
     */
    private static void adminGestionarBocadillos(){
        Scanner sc = new Scanner(System.in);
        String elec = "";
        boolean next = true;

        do {
            System.out.println("1. Crear bocadillo");
            System.out.println("2. Eliminar bocadillo");
            System.out.println("3. Modificar bocadillo");
            System.out.println("4. Volver al menu princiapal");
            elec = sc.nextLine();

            switch (elec) {
                case "1":
                    BocatasServicio.registroBocatas();
                    next = true;
                    break;
                case "2":
                    BocatasServicio.eliminar(Validaciones.pregunta_buscar(2));
                    next = true;
                    break;
                case "3":
                    MenuModificarBocadillo.modificarBocata();
                    next = true;
                    break;
                case "4":
                    next = false;
                    break;
                default:
                    next = true;
                    break;
            }
        } while (next);
    }

    /**
     * Menu de admin para la realización de los pedidos con un Alumno
     */
    private static void adminPedirBocata(){
        Scanner sc = new Scanner(System.in);
        String elec = "";
        boolean next = true;
        Alumno a = null;

        do {
            System.out.println("1. Seleccionar usuario");
            System.out.println("2. Pedir bocadillo");
            System.out.println("3. Volver al menu princiapal");
            elec = sc.nextLine();

            switch (elec) {
                case "1":
                    a = elegirUsuario();
                    next = true;
                    break;
                case "2":
                    pedirBocadillo(a);
                    next = true;
                    break;
                case "3":
                    next = false;
                    break;
                default:
                    next = true;
                    break;
            }
        } while (next);
    }

    /**
     * Metodo para elegir un usuario
     * @return Usuario conseguido
     */

    private static Alumno elegirUsuario(){
        Alumno a = new Alumno();
        User user = new User();
        user = UsuarioServicio.buscarUsuarios(Validaciones.pregunta_buscar(1));
        if (user instanceof Alumno) {
            user = (Alumno) a;
            return a;
        } else {
            System.out.println("Solo se pueden Alumnos");
            return null;
        }
    }

    /**
     * Metodo para pedir bocadillo
     * @param a usuario recojido anteriormente
     */

    private static void pedirBocadillo(Alumno a){
        if (a != null) {
            PedidosServicio.pedirBocadillo(a);
        } else {
            System.out.println("Tienes que elegir primero un usuario");
            return;
        }
    }

    /**
     * Menu de admin para las consultas de los pedidos
     */
    private static void adminPedidos(){
        Scanner sc = new Scanner(System.in);
        String elec = "";
        boolean next = true;

        do {
            System.out.println("1. Listar calendarios");
            System.out.println("2. Mostrar pedidos de un usuario");
            System.out.println("3. Cambiar el estado de los pedidos");
            System.out.println("4. Eliminar pedido");
            System.out.println("5. Volver al menu princiapal");
            elec = sc.nextLine();

            switch (elec) {
                case "1":
                    CalendariosServicio.mostrarTodosCalendarios();
                    next = true;
                    break;
                case "2":
                    PedidosServicio.mostrarPedidosDeAlumno(UsuarioServicio.buscarUsuarios(Validaciones.pregunta_buscar(1)));
                    next = true;
                    break;
                case "3":
                    PedidosServicio.cambiarEstadoAFinalizado();
                    next = true;
                    break;
                case "4":
                    eliminarPeddido();
                    next = true;
                    break;
                case "5":
                    next = false;
                    break;
                default:
                    next = true;
                    break;
            }
            next = true;
        } while (next);
    }

    /**
     * Metodo para eliminar pedido
     */
    private static void eliminarPeddido(){
        String id_encontrado = Validaciones.pregunta_buscar(3);
        int id = Integer.parseInt(id_encontrado);
        PedidosServicio.eliminarPedido(id);
    }

    /**
     * Menu de admin para la gestion del calendario
     */

    private static void adminGestionarCalendario(){
        Scanner sc = new Scanner(System.in);
        String elec = "";
        boolean next = true;

        do {
            System.out.println("1. Modicficar Calendario");
            System.out.println("2. Crear calendario");
            System.out.println("3. Eliminar calendario");
            System.out.println("4. Calendario mostrado a alumnos");
            System.out.println("5. Volver al menu princiapal");
            elec = sc.nextLine();

            switch (elec) {
                case "1":
                    MenuModificarCalendario.modificarCalendario();
                    next = true;
                    break;
                case "2":
                    CalendariosServicio.crearCalendario();
                    next = true;
                    break;
                case "3":
                    CalendariosServicio.eliminarCalendario(CalendariosServicio.buscarCalendario(CalendariosServicio.preguntarIdCalendario()));
                    next = true;
                    break;
                case "4":
                    MenuCambiarCalendarioDeLaSemana.MenuSemana();
                    next = true;
                    break;
                case "5":
                    next = false;
                    break;
                default:
                    next = true;
                    break;
            }   
        } while (next);
    }
}
