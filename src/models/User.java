package models;

import data.GesData;
import services.UsuarioServicio;
import utils.Validaciones;

import java.io.Serializable;
import java.util.Scanner;

public class User implements Serializable {
    protected String usuario;

    protected String nombre;

    protected String correo;

    protected String password;

    /**
     * Contstructor de la clase User, que sirve para crear Users sin atributos
     */

    public User(){}

    /**
     * Constructor de la clase Usuario, para crear Users con atributos
     * @param usuario
     * @param nombre
     * @param correo
     * @param password
     */

    public User(String usuario, String nombre, String correo, String password) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }

    /**
     * Muestra los datos de de la clase usuario
     * @return devuelve los valores de la clase usuarios
     */

    @Override
    public String toString() {
        return "User{" +
                "usuario='" + usuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    /**
     * Este metodo sirve para modificar el usuario que tenga el objeto usuario
     * @param usuario es el usuario al que queremos modificar el nombre
     */
    public static void modificarUsuario(User usuario){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        String nombreNuevo;

        do {
            System.out.println("¿Que nombre de usuario quieres?");
            nombreNuevo = sc.nextLine();
            if (UsuarioServicio.buscarUsuarios(nombreNuevo) != null) {
                System.out.println("Este nombre esta ya cogido por un usuario");
                next = true;
            } else {
                System.out.println("Quieres cambiar el nombre de "+usuario.getUsuario()+" a "+nombreNuevo);
                System.out.println("Di 'si' o 'no'");
                String elec = sc.nextLine();

                switch (elec) {
                    case "si":
                        usuario.setUsuario(nombreNuevo);
                        next = false;
                        break;
                    case "no":
                        next=true;
                        break;
                }
            }
        }while (next);
    }

    /**
     * Este metodo sirve para modificar el nombre y sus apellidos que tenga el objeto usuario
     * @param usuario coje el objeto que se va a utilizar
     */

    public static void modificarNombreUsuario(User usuario){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        String nombreNuevo;

        do {
            System.out.println("¿Que nombre y apellidos quieres?");
            nombreNuevo = sc.nextLine();

            System.out.println("Quieres cambiar el nombre de usuario de"+usuario.getNombre()+" a "+nombreNuevo);
            System.out.println("Di 'si' o 'no'");
            String elec = sc.nextLine();

            switch (elec) {
                case "si":
                    usuario.setNombre(nombreNuevo);
                    next = false;
                    break;
                case "no":
                    next=true;
                    break;
                }
        }while (next);
    }

    /**
     * Este metodo sirve para modificar el correo que tenga el objeto usuario
     * @param usuario coje el objeto que se va a utilizar
     */

    public static void modificarCorreo(User usuario){
        Scanner sc = new Scanner(System.in);
        boolean next = true;

        do {
            String correoNuevo  = Validaciones.validarGmail();

            System.out.println("Quieres cambiar el correo viejo: "+ usuario.getCorreo()+" por el correo nuevo "+correoNuevo+"?");
            System.out.println("Di 'si' o 'no'");
            String elec = sc.nextLine();

            switch (elec) {
                case "si":
                    usuario.setCorreo(correoNuevo);
                    next = false;
                    break;
                case "no":
                    next=true;
                    break;
            }
        }while (next);
    }

    /**
     * Este metodo sirve para modificar la contraseña que tenga el objeto usuario
     * @param usuario coje el objeto que se va a utilizar
     */

    public static void modificarContrasena(User usuario){
        Scanner sc = new Scanner(System.in);
        boolean next = true;

        do {
            String contrasenaNueva  = Validaciones.validarContrasena();

            System.out.println("Quieres cambiar la contraseña vieja: "+ usuario.getPassword()+" por la contraseña nueva "+contrasenaNueva+"?");
            System.out.println("Di 'si' o 'no'");
            String elec = sc.nextLine();

            switch (elec) {
                case "si":
                    usuario.setPassword(contrasenaNueva);
                    next = false;
                    break;
                case "no":
                    next=true;
                    break;
            }
        }while (next);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
