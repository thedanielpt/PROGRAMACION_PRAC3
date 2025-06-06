package services;

import data.GesData;
import models.*;
import utils.Validaciones;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsuarioServicio {

    //Hecho en clase
    public static ArrayList<User> obtenerUsuario (){
        List<User> lista=new ArrayList<>();
        FileInputStream fis=null;
        ObjectInputStream ois = null;

        try {
            fis=new FileInputStream("src/persistencia/Usuario.dat");
            ois = new ObjectInputStream(fis);
            User u = new User();
            while (true) {
                u=(User) ois.readObject();
                lista.add(u);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ois!=null){ois.close();}
                if (fis!=null){ois.close();}
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void volcarListas(){
        try {
            FileOutputStream fos = new FileOutputStream("src/persistencia/Usuario.txt",true);//Para que tenga pueda tener mas de un usuario
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (User u : GesData.usuarios) {
                oos.writeObject(u);
            }
            fos.close();
            oos.close();
            //Vacia por si acaso el tunel
            oos.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Muestra a todos los usuarios distribuidos entre alumno, cocina y administrador
     */
    public static void mostrarTodosUsers(){
        System.out.println("ALUMNOS");
        for (User usuario: GesData.usuarios) {
            if (usuario instanceof Alumno) {
                Alumno a = (Alumno) usuario;
                System.out.println(a.toString());
            }
        }

        System.out.println("\nCOCINA");

        for (User usuario: GesData.usuarios) {
            if (usuario instanceof Cocina) {
                Cocina c = (Cocina) usuario;
                System.out.println(c.toString());
            }
        }

        System.out.println("\nADMIN");

        for (User usuario: GesData.usuarios) {
            if (usuario instanceof Admin) {
                Admin a = (Admin) usuario;
                System.out.println(a.toString());
            }
        }
    }

    /**
     * Coje todos los usuarios
     * @return los devuelve en un ArrayList
     */

    public static ArrayList<User> obtenerTodosLosUsuarios(){
        ArrayList<User> usuarios = new ArrayList<>();
        for (User usuario: GesData.usuarios) {
            usuarios.add(usuario);
        }
        return usuarios;
    }

    /**
     * Busca un usuario del parametro dado
     * @param usuario el usuario que se quiere buscar
     * @return si se encuentra el usuario lo devuelve, si no lo encuentra devuelve null
     */

    public static User buscarUsuarios(String usuario){
        try {
            for (User usuarios: GesData.usuarios) {
                if (usuarios.getUsuario().equals(usuario)) {
                    return usuarios;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Error en  la busqueda del usuario");
        }
        return null;
    }

    /**
     * Crea un usuario Alumno con alergias
     * @param usuario nombre de usuario unico
     * @param nombre nombre y apellidos del usuario
     * @param correo correo del usuario
     * @param password contraseña del usuario
     * @param alergico es alergico
     * @param alergias las alergias que tiene
     * @param curso el curso del usuario
     * @param pregunta la pregunta del usuario
     * @param respuesta la respuesta a la pregunta del usuario
     * @param num_expediente el numero de expediente
     * @param alta si esta de alta
     */

    public static void insertarUsuariosConAlergias(String usuario, String nombre, String correo, String password, boolean alergico, ArrayList<String> alergias, String curso, String pregunta, String respuesta, String num_expediente, boolean alta) {
        GesData.usuarios.add(new Alumno(usuario, nombre, correo, password, alergico,alergias, curso, pregunta, respuesta, num_expediente, alta));
    }

    /**
     * Crea un usuario Alumno sin alergias
     * @param usuario nombre de usuario unico
     * @param nombre nombre y apellidos del usuario
     * @param correo correo del usuario
     * @param password contraseña del usuario
     * @param alergico este valor esta a null
     * @param curso el curso del usuario
     * @param pregunta la pregunta del usuario
     * @param respuesta la respuesta a la pregunta del usuario
     * @param num_expediente el numero de expediente
     * @param alta si esta de alta
     */

    public static void insertarUsuariosSinAlergias(String usuario, String nombre, String correo, String password, boolean alergico, String curso, String pregunta, String respuesta, String num_expediente, boolean alta) {
        GesData.usuarios.add(new Alumno(usuario, nombre, correo, password, alergico, curso, pregunta, respuesta, num_expediente, alta));
    }

    /**
     * Este metodo coge la variable que le has dado y si encuentra al usuario lo elimina
     * @param eliminar usuario que se queire eliminar
     */

    public static void eliminar(String eliminar){
        for (User usuario: GesData.usuarios) {
            if (usuario.getUsuario().equals(eliminar)) {
                //Si hay solo un administrador no lo elimina
                if (usuario instanceof Admin && contarAdministradores() < 2 &&
                usuario.getUsuario().equals(eliminar)) {
                    System.out.println("No se puede eliminar al administrador");
                    return;
                }
                GesData.usuarios.remove(usuario);
                break;
            }
        }
    }

    public static int contarAdministradores(){
        int cuenta = 0;
        for (User usuario: GesData.usuarios){
            if (usuario instanceof Admin) {
                ++cuenta;
            }
        }
        return cuenta;
    }

    /**
     * Crea un usuario de cocina
     *@param usuario nombre de usuario unico
     * @param nombre nombre y apellidos del usuario
     * @param correo correo del usuario
     * @param password contraseña del usuario
     * @return
     */

    public static void insertarCocina(String usuario, String nombre, String correo, String password){
        GesData.usuarios.add(new Cocina(usuario, nombre, correo, password));
    }

    /**
     * Crea un usuario de administrador
     *@param usuario nombre de usuario unico
     * @param nombre nombre y apellidos del usuario
     * @param correo correo del usuario
     * @param password contraseña del usuario
     * @return
     */

    public static void insertarAdmin(String usuario, String nombre, String correo, String password){
        GesData.usuarios.add(new Admin(usuario, nombre, correo, password));
    }

    /**
     * Modifica las alergias del usuario
     * @param usuario le das el ususario para que coja las alergias de ese usuario
     */

    public static void modificarAlergias(Alumno usuario){
        Scanner sc = new Scanner(System.in);
        boolean next = true;

        do {
            boolean alergicico  = Validaciones.tienesAlergias();

            System.out.println("Quieres cambiar los alergenos viejos: "+ usuario.isAlergico()+" por alergenos nuevos: "+alergicico+"?");

            if (Validaciones.validarEstasSeguro()) {
                if (alergicico) {
                    ArrayList<String> alergias = new ArrayList<>();
                    alergias = Validaciones.alergiasUsuario();
                    usuario.setAlergias(alergias);
                    GesData.usuarios.remove(usuario);
                } else {
                    usuario.setAlergico(alergicico);
                }
                next = false;
            } else {
                next=true;
            }
        }while (next);
    }

    /**
     * Modifica el curso de usuario
     * @param usuario le das el ususario para que coja el curso de ese usuario
     */

    public static void modificarCurso(Alumno usuario){
        Scanner sc = new Scanner(System.in);
        boolean next = true;

        do {
            String cursoNuevo  = Validaciones.cursoUsuario();

            System.out.println("Quieres cambiar el curso viejo: "+ usuario.getCurso()+" por el curso nuevo "+cursoNuevo+"?");

            if (Validaciones.validarEstasSeguro()) {
                usuario.setCurso(cursoNuevo);
                next = false;
            } else {
                next=true;
            }
        }while (next);
    }

    /**
     * Modifica el estado de alergico
     * @param usuario le das el ususario para que coja el estado de alergico
     */

    public static void modificarAlergico(Alumno usuario){
        Scanner sc = new Scanner(System.in);
        boolean next = true;

        do {
            boolean alergico  = Validaciones.tienesAlergias();

            System.out.println("Quieres cambiar de alergico: "+ usuario.isAlergico()+" por alergico: "+alergico+"?");

            if (Validaciones.validarEstasSeguro()) {
                if (alergico) {
                    ArrayList<String> alergias = new ArrayList<>();
                    alergias = Validaciones.alergiasUsuario();
                    usuario.setAlergias(alergias);
                    GesData.usuarios.remove(usuario);
                    next = false;
                } else {
                    usuario.setAlergico(alergico);
                }
            } else {
                next=true;
            }
        }while (next);
    }

    public static boolean esAlmuno(String usuario){
        User a = new User();
        for (Pedidos pedidos: GesData.pedidos){
            if (pedidos.getId_usuario().equals(usuario)){
                return true;
            }
        }
        return false;
    }
}