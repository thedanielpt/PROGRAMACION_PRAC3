package models;

import data.GesData;

/**
 *Clase de adminsitrador
 */

public class Admin extends User{

    /**
     * Constructor de Admin sin atributos
     */

    public Admin() {}

    /**
     * Constructor de Admin con atributos
     */

    public Admin(String usuario, String nombre, String correo, String password) {
        super(usuario, nombre, correo, password);
    }

    /**
     * Metodo de to string
     * @return devuelve la información el administrador
     */

    @Override
    public String toString() {
        return "Admin{" +
                "usuario='" + usuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
