package models;

import data.GesData;
import utils.Validaciones;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase de Alumno
 */
public class Alumno extends User{

    protected boolean alergico;

    protected ArrayList<String> alergias;

    protected String curso;

    protected String pregunta;

    protected String respuesta;

    protected String num_expediente;

    protected boolean alta;

    /**
     * Constructor sin ningun atributo
     */
    public Alumno (){}


    /**
     * Constructor del alumno con alergias
     * @param usuario usuario del alumno.
     * @param nombre nombre completo del alumno.
     * @param correo correo electrónico del alumno.
     * @param password contraseña del alumno.
     * @param alergico dice si es alergico o no
     * @param alergias alergias del usuario
     * @param curso matriculado del alumno.
     * @param pregunta pregunta de seguridad del alumno.
     * @param respuesta respuesta a la pregunta de seguridad.
     * @param num_expediente número de expediente del alumno.
     * @param alta si esta de alta o no.
     */
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

    /**
     * Constructor del alumno con alergias
     * @param usuario usuario del alumno.
     * @param nombre nombre completo del alumno.
     * @param correo correo electrónico del alumno.
     * @param password contraseña del alumno.
     * @param alergico dice si es alergico o no
     * @param curso matriculado del alumno.
     * @param pregunta pregunta de seguridad del alumno.
     * @param respuesta respuesta a la pregunta de seguridad.
     * @param num_expediente número de expediente del alumno.
     * @param alta si esta de alta o no.
     */
    public Alumno(String usuario, String nombre, String correo, String password, boolean alergico, String curso, String pregunta, String respuesta, String num_expediente, boolean alta) {
        super(usuario, nombre, correo, password);
        this.alergico = alergico;
        this.curso = curso;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.num_expediente = num_expediente;
        this.alta = alta;
    }


    /**
     * Metodo que muestra la información del Alumno
     * @return devuelve un string con la información el alumno
     */
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
