import Excepciones.MensajeLargoException;
import Excepciones.MenuUsuarioNoEncontrado;
import services.UsuarioServicio;
import ui.MenuAutenticar;
import data.GesData;

public class Main {
    public static void main(String[] args) throws MensajeLargoException, MenuUsuarioNoEncontrado {
        GesData.cargarBocatas();
        GesData.cargarCalendario();
        GesData.cargarUsuario();
        GesData.cargarPedidos();
        MenuAutenticar.menAutentificar();
    }
}
