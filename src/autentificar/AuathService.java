package autentificar;

import data.GesData;
import models.Admin;
import models.Alumno;
import models.Cocina;
import models.User;
import services.UsuarioServicio;
import utils.Validaciones;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * Clase de autentificar
 */

public class AuathService {

    /**
     * Metodo de logueo del usuario
     * @return devuelve el usuario del User
     */
    public static String login(){
        Scanner sc = new Scanner(System.in);
        String nameL = "";
        String contraL = "";

        if (Validaciones.captcha()){
            System.out.println("Escribe tu nombre de usuario");
            for (int i = 0; i < 4; i++) {
                nameL = sc.nextLine();
                for (User usuario : GesData.usuarios) {
                    if (nameL.equals(usuario.getUsuario())) {
                        for (int j = 0; j < 4; j++) {
                            System.out.println("Escribe tu contraseña");
                            contraL = sc.nextLine();
                            if (contraL.equals(usuario.getPassword())) {
                                return usuario.getUsuario();
                            } else {
                                System.out.println("Contraseña no encontrada");
                            }
                            if (j == 3) {
                                System.out.println("Demasiados intentos");
                                return null;
                            }
                        }
                    }
                }
                System.out.println("Usuario no encontrado");
                if (i == 3){
                    System.out.println("Demasiados intentos");
                    return null;
                }
            }
        } else {
            System.out.println("Se cancelo el login");
            return null;
        }
        return null;
    }
}
