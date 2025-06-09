import Excepciones.MensajeLargoException;
import Excepciones.MenuUsuarioNoEncontrado;
import services.CalendariosServicio;
import services.UsuarioServicio;
import ui.MenuAutenticar;
import data.GesData;

import java.io.IOException;
import java.lang.reflect.GenericSignatureFormatError;

public class Main {
    public static void main(String[] args) throws MensajeLargoException, MenuUsuarioNoEncontrado, IOException {
        GesData.leerTodo();
        MenuAutenticar.menAutentificar();
        //GesData.escribirTodos();
    }
}
