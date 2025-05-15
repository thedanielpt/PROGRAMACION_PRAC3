import ui.MenuAutenticar;
import data.GesData;

public class Main {
    public static void main(String[] args) {
        GesData.cargarDatos();
        MenuAutenticar.menAutentificar();
    }
}
