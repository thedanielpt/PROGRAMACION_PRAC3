package Excepciones;

public class MenuUsuarioNoEncontrado extends Exception{

    protected String mensaje;

    public MenuUsuarioNoEncontrado(String mensaje){
        this.mensaje=mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
