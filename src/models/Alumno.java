package models;

import data.GesData;
import utils.Validaciones;

import java.util.ArrayList;
import java.util.Scanner;

public class Alumno extends User{
    protected boolean alergico;

    protected ArrayList<String> alergias;

    protected String curso;

    protected String pregunta;

    protected String respuesta;

    protected String num_expediente;

    protected boolean alta;

    public Alumno (){}

    public Alumno(String usuario, String nombre, String correo, String password, boolean alergico, ArrayList<String> alergias, String curso, String pregunta, String respuesta, String num_expediente, boolean alta) {
        super(usuario, nombre, correo, password);
        this.alergico = alergico;
        this.alergias = alergias;
        this.curso = curso;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.num_expediente = num_expediente;
        this.alta = alta;
    }

    public Alumno(String usuario, String nombre, String correo, String password, boolean alergico, String curso, String pregunta, String respuesta, String num_expediente, boolean alta) {
        super(usuario, nombre, correo, password);
        this.alergico = alergico;
        this.curso = curso;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.num_expediente = num_expediente;
        this.alta = alta;
    }



    @Override
    public String toString() {
        return "Alumno{" +
                ", usuario='" + usuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                ", curso='" + curso + '\'' +
                ", alergico=" + alergico +
                ", alergias=" + alergias +
                ", pregunta='" + pregunta + '\'' +
                ", respuesta='" + respuesta + '\'' +
                ", num_expediente='" + num_expediente + '\'' +
                ", alta=" + alta +
                '}';
    }

    public boolean isAlergico() {
        return alergico;
    }

    public void setAlergico(boolean alergico) {
        this.alergico = alergico;
    }

    public ArrayList<String> getAlergias() {
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

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getNum_expediente() {
        return num_expediente;
    }

    public void setNum_expediente(String num_expediente) {
        this.num_expediente = num_expediente;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }
}
