package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Admin extends User{

    public Admin() {
    }

    public Admin(String usuario, String nombre, String correo, String password) {
        super(usuario, nombre, correo, password);
    }
}
