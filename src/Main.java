import autentificar.AuathService;
import autentificar.MenuAutenticar;
import data.GesData;
import models.User;

public class Main {
    public static void main(String[] args) {
        GesData.cargarUsuaios();
        GesData.cargarBocatas();
        GesData.cargarPedidos();
        GesData.cargarCalendario();
        MenuAutenticar.menAutentificar();
    }
}
