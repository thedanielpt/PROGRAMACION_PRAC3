package models;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * Clase del calendario
 */
public class Calendario {
    protected int id;
    protected Bocatas bocadillo_frio;
    protected Bocatas bocadillo_caliente;

    /**
     * Constructor sin atributos
     */
    public Calendario (){}

    /**
     * Constructor con atributos
     * @param id identificador del calendario
     * @param bocadillo_frio bocadillo frio
     * @param bocadillo_caliente bocadillo caliente
     */
    public Calendario(int id, Bocatas bocadillo_frio, Bocatas bocadillo_caliente) {
        this.id = id;
        this.bocadillo_frio = bocadillo_frio;
        this.bocadillo_caliente = bocadillo_caliente;
    }

    /**
     * Metodo que muestra la información del calendario
     * @return devuelve la infromación del calenario
     */
    @Override
    public String toString() {
        return "Calendario{" +
                "id=" + id +
                ", bocadillo_frio=" + bocadillo_frio +
                ", bocadillo_caliente=" + bocadillo_caliente +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bocatas getBocadillo_frio() {
        return bocadillo_frio;
    }

    public void setBocadillo_frio(Bocatas bocadillo_frio) {
        this.bocadillo_frio = bocadillo_frio;
    }

    public Bocatas getBocadillo_caliente() {
        return bocadillo_caliente;
    }

    public void setBocadillo_caliente(Bocatas bocadillo_caliente) {
        this.bocadillo_caliente = bocadillo_caliente;
    }
}
