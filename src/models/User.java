package models;

import services.UsuarioServicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String usuario;
    private String nombre;
    private String correo;
    private String curso;
    private String password;
    private boolean alergico;
    private ArrayList alergias;
    private LocalDate fecha_nacimiento;
    private int rol;

    public User(){}

    public User(String usuario) {
        this.usuario = usuario;
    }

    public User(String usuario, String nombre, String curso, String correo, String password, boolean alergico, LocalDate fecha_nacimiento, int rol) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.curso = curso;
        this.correo = correo;
        this.password = password;
        this.alergico = alergico;
        this.fecha_nacimiento = fecha_nacimiento;
        this.rol = rol;
    }

    public User(String usuario, String nombre, String correo, String curso, String password, boolean alergico, ArrayList alergias, LocalDate fecha_nacimiento, int rol) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.correo = correo;
        this.curso = curso;
        this.password = password;
        this.alergico= alergico;
        this.alergias = alergias;
        this.fecha_nacimiento=fecha_nacimiento;
        this.rol=rol;
    }

    public void mostrarInfo() {

        if (alergico = true) {
            System.out.println("\n----------------");
            System.out.println("Nombre de user = " + usuario + "\nNombre del alumno = " + nombre + "\nCorreo electrónico = " + correo + "\nCurso = " + curso + "\nPassword = " + password + "\nAlergias = " + alergias + "\nFecha de nacimiento = " + fecha_nacimiento + "\nRol = " + rol);
            System.out.println("\n----------------");
        } else {
            System.out.println("\n----------------");
            System.out.println("Nombre de user = " + usuario + "\nNombre del alumno = " + nombre + "\nCorreo electrónico = " + correo + "\nCurso = " + curso + "\nPassword = " + password + "\n¿Eres alérgico? = " + alergico + "\nFecha de nacimiento = " + fecha_nacimiento + "\nRol = " + rol);
            System.out.println("\n----------------");
        }
    }

    public static void modificarUsuario(User usuario){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        String nombreNuevo;

        do {
            System.out.println("¿Que nombre de usuario quieres?");
            nombreNuevo = sc.nextLine();
            if (UsuarioServicio.buscar(nombreNuevo) != null) {
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

    public String getUsuario() {
        return usuario;
    }

    public int getRol() {
        return rol;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public ArrayList getAlergias() {
        return alergias;
    }

    public boolean isAlergico() {
        return alergico;
    }

    public String getPassword() {
        return password;
    }

    public String getCurso() {
        return curso;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAlergico(boolean alergico) {
        this.alergico = alergico;
    }

    public void setAlergias(ArrayList alergias) {
        this.alergias = alergias;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
}
