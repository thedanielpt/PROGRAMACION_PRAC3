package autentificar;

import data.GesData;
import models.User;
import services.UsuarioServicio;
import utils.Validaciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class AuathService {
    public static String login(){
        Scanner sc = new Scanner(System.in);
        String nameL = "";
        String contraL = "";
        GesData.cargarUsuaios();

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
                                return usuario.getNombre();
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

    public static void registro(){

        String usuario = Validaciones.validarUsuario();

        String nombre = Validaciones.nombreApellidos();

        String curso = Validaciones.cursoUsuario();

        String correo = Validaciones.validarGmail();

        String password = Validaciones.validarContrasena();

        LocalDate año_nacimiento = Validaciones.validarFecha();

        int rol = Validaciones.rolEsoGm(curso);

        boolean alergico = Validaciones.tienesalergias();

        if (alergico) {
            ArrayList alergias = Validaciones.alergiasUsuario();
            UsuarioServicio.insertarUsuariosConAlergias(usuario, nombre, curso, correo, password, alergico, alergias,año_nacimiento, rol);
        } else {
            UsuarioServicio.insertarUsuariosSinAlergias(usuario, nombre, curso, correo, password, alergico,año_nacimiento, rol);
        }
    }
}
