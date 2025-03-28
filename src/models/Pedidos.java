package models;

import java.time.LocalDate;

public class Pedidos {
    private int id_pedido;
    private String id_usuario;
    private int id_bocadillo;
    private LocalDate fecha;
    private String estado;

    public Pedidos(int id_pedido, String id_usuario, int id_bocadillo, LocalDate fecha, String estado) {
        this.id_pedido = id_pedido;
        this.id_usuario = id_usuario;
        this.id_bocadillo = id_bocadillo;
        this.fecha = fecha;
        this.estado = estado;
    }

    public String mostrarDetallesPedidos(){

        return "id_pedido = "+id_pedido+"\nid_usuario = "+id_usuario+"\nid_bocadillo = "+id_bocadillo+"\nfecha del pedido= "+fecha+"\nEstado del peiddo = "+estado;
    }

    public void marcarRetirado(String estado) {
        String pedido = "pedido";
        String retirado = "retirado";

        System.out.println("id_pedido: "+ estado);
        if (estado.equals(pedido)) {
            estado = retirado;
        } else if (estado.equals(retirado)) {
            estado = pedido;
        }else {
            System.out.println("Lo siento, solo sirve para modificar el estado del pedido");
        }
    }

    public void mostrarNotificaciones(String alergias_user[], String alergenos_bocata[]){
        boolean alerta = false;

        for (int i = 0; i < alergias_user.length; i++) {
            for (int j = 0; j < alergenos_bocata.length; j++) {
                if (alergenos_bocata[j].equals(alergias_user[i])){
                    alerta = true;
                }
            }
        }

        if (alerta) {
            System.out.println("No puede pedir este bocata, porque tiene alergenos");
        } else {
            System.out.println("El bocata no tiene alergenos que le puedan afectar al usuario");
        }
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public int getId_bocadillo() {
        return id_bocadillo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setId_bocadillo(int id_bocadillo) {
        this.id_bocadillo = id_bocadillo;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
