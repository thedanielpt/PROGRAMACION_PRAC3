package models;

import java.time.LocalDate;

public class User {
    private String usuario;
    private String nombre;
    private String correo;
    private String curso;
    private String password;
    private boolean alergico;
    private String[] alergias;
    private LocalDate fecha_nacimiento;
    private int rol;

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

    public User(String usuario, String nombre, String correo, String curso, String password, boolean alergico, String[] alergias, LocalDate fecha_nacimiento, int rol) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.correo = correo;
        this.curso = curso;
        this.password = password;
        this.alergico=alergico;
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

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCurso() {
        return curso;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAlergico() {
        return alergico;
    }

    public String[] getAlergias() {
        return alergias;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public int getRol() {
        return rol;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setAlergico(boolean alergico) {
        this.alergico = alergico;
    }

    public void setAlergias(String[] alergias) {
        this.alergias = alergias;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public boolean getAlergico() {
        return alergico;
    }
}
