package Excepciones;

public class MensajeLargoException extends Exception{
    protected String mensaje;

    public MensajeLargoException(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}