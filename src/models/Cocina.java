package models;

import java.time.LocalDate;

/**
 * Clase de cocina
 */
public class Cocina extends User{

    /**
     * Constructor e cocina
     * @param usuario usuario de cocina
     * @param nombre nombre completo de cocina
     * @param correo correo de cocina
     * @param password contraseña de cocina
     */
    public Cocina(String usuario, String nombre, String correo, String password) {
        super(usuario, nombre, correo, password);
    }

    /**
     * Devuelve la infromación del objeto cocina
     * @return devuelve la informacion de cocina
     */
    @Override
    public String toString() {
        return "Cocina{" +
                "usuario='" + usuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
