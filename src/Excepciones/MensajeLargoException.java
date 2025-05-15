package Excepciones;

public class MensajeLargoException {
    protected String mensaje;

    public MensajeLargoException(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}