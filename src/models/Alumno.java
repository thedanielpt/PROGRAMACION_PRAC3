package models;

import data.GesData;
import services.UsuarioServicio;
import utils.Validaciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Alumno extends User{
    protected boolean alergico;

    protected ArrayList<String> alergias;

    protected String curso;

    protected String num_expediente;

    protected LocalDate Fecha_nacimiento;

    protected boolean alta;

    public Alumno(String usuario, String nombre, String correo, String password, boolean alergico, LocalDate fecha_nacimiento, ArrayList alergias, String curso, String num_expediente, boolean alta) {
        super(usuario, nombre, correo, password);
        this.alergico = alergico;
        Fecha_nacimiento = fecha_nacimiento;
        this.alergias = alergias;
        this.curso = curso;
        this.num_expediente = num_expediente;
        this.alta = alta;
    }

    public Alumno(String usuario, String nombre, String correo, String password, boolean alergico, LocalDate fecha_nacimiento, String curso, String num_expediente, boolean alta) {
        super(usuario, nombre, correo, password);
        this.alergico = alergico;
        Fecha_nacimiento = fecha_nacimiento;
        this.curso = curso;
        this.num_expediente = num_expediente;
        this.alta = alta;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "alergico=" + alergico +
                ", alergias=" + Arrays.toString(alergias) +
                ", curso='" + curso + '\'' +
                ", num_expediente='" + num_expediente + '\'' +
                ", usuario='" + usuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'';
    }

    public static void modificarCurso(Alumno usuario){
        Scanner sc = new Scanner(System.in);
        boolean next = true;

        do {
            String cursoNuevo  = Validaciones.cursoUsuario();

            System.out.println("Quieres cambiar el curso viejo: "+ usuario.getCurso()+" por el curso nuevo "+cursoNuevo+"?");
            System.out.println("Di 'si' o 'no'");
            String elec = sc.nextLine();

            switch (elec) {
                case "si":
                    usuario.setCurso(cursoNuevo);
                    next = false;
                    break;
                case "no":
                    next=true;
                    break;
            }
        }while (next);
    }

    public static void modificarAlergico(Alumno usuario){
        Scanner sc = new Scanner(System.in);
        boolean next = true;

        do {
            boolean alergicico  = Validaciones.tienesalergias();

            System.out.println("Quieres cambiar de alergico: "+ usuario.isAlergico()+" por alergico: "+alergicico+"?");
            System.out.println("Di 'si' o 'no'");
            String elec = sc.nextLine();

            switch (elec) {
                case "si":
                    if (alergicico) {
                        ArrayList<String> alergias = new ArrayList<>();
                        alergias = Validaciones.alergiasUsuario();
                        usuario.set(alergias);

                        UsuarioServicio.insertarUsuariosConAlergias(usuario.getUsuario(), usuario.getNombre(), usuario.getCurso(),
                                usuario.getCorreo(), usuario.getPassword(), usuario.isAlergico(), usuario.getAlergias(), usuario.getFecha_nacimiento() ,usuario.getRol());

                        GesData.usuarios.remove(usuario);
                    } else {
                        usuario.setAlergico(alergicico);
                    }
                    next = false;
                    break;
                case "no":
                    next=true;
                    break;
            }
        }while (next);
    }

    public static void modificarAlergias(Alumno usuario){
        Scanner sc = new Scanner(System.in);
        boolean next = true;

        do {
            boolean alergicico  = Validaciones.tienesalergias();

            System.out.println("Quieres cambiar los alergenos viejos: "+ usuario.isAlergico()+" por alergenos nuevos: "+alergicico+"?");
            System.out.println("Di 'si' o 'no'");
            String elec = sc.nextLine();

            switch (elec) {
                case "si":
                    if (alergicico) {
                        ArrayList<String> alergias = new ArrayList<>();
                        alergias = Validaciones.alergiasUsuario();
                        usuario.setAlergias(alergias);
                        GesData.usuarios.remove(usuario);
                    } else {
                        usuario.setAlergico(alergicico);
                    }
                    next = false;
                    break;
                case "no":
                    next=true;
                    break;
            }
        }while (next);
    }

    public boolean isAlergico() {
        return alergico;
    }

    public void setAlergico(boolean alergico) {
        this.alergico = alergico;
    }

    public String[] getAlergias() {
        return alergias;
    }

    public void setAlergias(ArrayList<String> alergias) {
        this.alergias = alergias;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNum_expediente() {
        return num_expediente;
    }

    public void setNum_expediente(String num_expediente) {
        this.num_expediente = num_expediente;
    }

    public LocalDate getFecha_nacimiento() {
        return Fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        Fecha_nacimiento = fecha_nacimiento;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }
}
