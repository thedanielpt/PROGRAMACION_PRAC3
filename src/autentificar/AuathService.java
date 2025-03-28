package autentificar;

import data.GesData;
import models.User;
import utils.Validaciones;

import java.util.Scanner;

public class AuathService {
    public static String login(){
        Scanner sc = new Scanner(System.in);
        String nameL = "";
        String contraL = "";
        GesData.cargarUsuaios();


        if (Validaciones.captcha()){
            System.out.println("Pon el nombre de usuario");
            nameL = sc.nextLine();
            for (int i = 0; i < 4; i++) {
                for (User user: GesData.usuarios) {
                    if (user.getUsuario().equals(nameL)) {
                        for (int j = 0; j < 4; j++) {
                            System.out.println("Ahora escribe su contraseña");
                            contraL = sc.nextLine();
                            if (contraL.equals(user.getPassword())) {
                                System.out.println("Usuario logueado");
                                return nameL;
                            } else if (j == 3){
                                System.out.println("No te has logueada");
                                return null;
                            } else {
                                System.out.println("Contraseña no valida");
                                contraL = sc.nextLine();
                            }
                        }
                    } else {
                        System.out.println("Usuario no encontrado, vuelve a ponerlo");
                        nameL = sc.nextLine();
                    }
                }
                if (i == 3) {
                    System.out.println("No se pudo loguear");
                    return null;
                }
            }
        } else {
            System.out.println("Se cancelo el registro");
        }
        return null;
    }
}
