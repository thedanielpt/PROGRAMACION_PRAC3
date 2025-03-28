import autentificar.AuathService;
import data.GesData;
import models.User;

public class Main {
    public static void main(String[] args) {
        String usuario;

        usuario = AuathService.login();
        if (!usuario.equals(null)) {
            System.out.println("Bienvenido "+usuario);
        } else {
            System.out.println("No te has podido loguear");
        }
    }
}
