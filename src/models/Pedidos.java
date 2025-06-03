package models;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Clase del objeto pedidos
 */

public class Pedidos implements Serializable {

    protected int id_pedido;
    protected String id_usuario;
    protected int id_bocadillo;
    protected LocalDate fecha;
    protected String estado;

    /**
     *Constructor de pedidos
     * @param id_pedido identificador de pedidos
     * @param id_usuario identificador del usuario
     * @param id_bocadillo identificador de bocadillos
     * @param fecha fecha del pedido
     * @param estado estado del pedido
     */

    public Pedidos(int id_pedido, String id_usuario, int id_bocadillo, LocalDate fecha, String estado) {
        this.id_pedido = id_pedido;
        this.id_usuario = id_usuario;
        this.id_bocadillo = id_bocadillo;
        this.fecha = fecha;
        this.estado = estado;
    }

    /**
     * to string de pedidos
     * @return devuelve un string con todda la información del objeto pedido
     */

    @Override
    public String toString() {
        return "Pedidos{" +
                "id_pedido=" + id_pedido +
                ", id_usuario=" + id_usuario +
                ", id_bocadillo=" + id_bocadillo +
                ", fecha=" + fecha +
                ", estado='" + estado + '\'' +
                '}';
    }

    /**
     * Comprueba los alergenos el usuario con los del bocata
     * @param a objeto alumno
     * @param b objeto bocata
     * @return verdad si encuentra un alergeno peligroso para el usuario, false si no lo encuentra
     */

    public static boolean comprobarAlergenosBocatasYAlumno(Alumno a, Bocatas b){
        boolean alerta = false;

        for (int i = 0; i < a.getAlergias().size(); i++) {
            for (int j = 0; j < b.getAlergenos().size(); j++) {
                if (b.getAlergenos().equals(a.getAlergias())){
                    return true;
                }
            }
        }
        return false;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public int getId_bocadillo() {
        return id_bocadillo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public void setId_bocadillo(int id_bocadillo) {
        this.id_bocadillo = id_bocadillo;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }
}
