package services;

import data.GesData;
import models.Admin;
import models.Alumno;
import models.Cocina;
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

    public static void insertarUsuariosConAlergias(String usuario, String nombre, String correo, String password, boolean alergico, ArrayList<String> alergias, String curso, String pregunta, String respuesta, String num_expediente, boolean alta) {
        GesData.usuarios.add(new Alumno(usuario, nombre, correo, password, alergico,alergias, curso, pregunta, respuesta, num_expediente, alta));
    }

    public static void insertarUsuariosSinAlergias(String usuario, String nombre, String correo, String password, boolean alergico, String curso, String pregunta, String respuesta, String num_expediente, boolean alta) {
        GesData.usuarios.add(new Alumno(usuario, nombre, correo, password, alergico, curso, pregunta, respuesta, num_expediente, alta));
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

    public static Cocina insertarCocina(String usuario, String nombre, String correo, String password){
        GesData.usuarios.add(new Cocina(usuario, nombre, correo, password));
        return null;
    }

    public static Admin insertarAdmin(String usuario, String nombre, String correo, String password){
        GesData.usuarios.add(new Admin(usuario, nombre, correo, password));
        return null;
    }

    //Modificar esta en la clase MenuModificar
}
