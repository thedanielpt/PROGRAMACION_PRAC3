package models;

import java.time.LocalDate;

public class Cocina extends User{

    public Cocina (){}

    public Cocina(String usuario, String nombre, String correo, String password) {
        super(usuario, nombre, correo, password);
    }

    public static void cambiarEstadoBocata(){

    }

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
