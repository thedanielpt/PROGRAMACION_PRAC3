package services;

import data.GesData;
import models.Alumno;
import models.Bocatas;
import models.Pedidos;
import models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PedidosServicio {

    /**
     * Coje todos los pedidos registrados
     * @return devuelve los pedidos en un ArrayList<Pedidos>
     */
    public static ArrayList<Pedidos> optenerTodosLosPedidos(){
        ArrayList<Pedidos> pedidos = new ArrayList<>();
        for (Pedidos pedido: GesData.pedidos) {
            pedidos.add(pedido);
        }
        return pedidos;
    }

    /**
     * Busca un pedido
     * @param id_pedido id del pedido
     * @return devuelve el pedido si lo encuentra, si no devuelve null
     */
    public static Pedidos buscarPedido(int id_pedido){
        for (Pedidos pedido: GesData.pedidos) {
            if (pedido.getId_pedido() == id_pedido) {
                return pedido;
            }
        }
        return null;
    }

    /**
     * Crea una instancia de un pedido
     * @param id_pedido id del peiddo
     * @param id_usuario id del usuario que lo ha pedido
     * @param id_bocadillo id del bocadillo que ha pedido
     * @param fecha fecha del momento en el que lo pide
     * @param estado estado en el que se encuentra el pedido
     */
    public static void insertarPedido( int id_pedido, String id_usuario, int id_bocadillo, LocalDate fecha, String estado){
        GesData.pedidos.add(new Pedidos(id_pedido, id_usuario, id_bocadillo, fecha, estado));
    }

    /**
     * Elimina el bocadillo elegido
     * @param id_pedido id del bocadillo
     */
    public static void eliminarPedido(int id_pedido){
        for (Pedidos pedido: GesData.pedidos) {
            if (pedido.getId_pedido() == id_pedido) {
                GesData.pedidos.remove(pedido);
            }
        }
    }

    /**
     * Muestra los pedidos de un alumno
     * @param user alumno elegido
     */
    public static void mostrarPedidosDeAlumno(User user){
        try {
            for (Pedidos pedido: GesData.pedidos){
                if (user.getUsuario().equals(pedido.getId_usuario())) {
                    System.out.println(pedido);
                }
            }
        } catch (NullPointerException n) {
            System.out.println("Error en la busqueda");
        }
    }

    /**
     * Cambia el estado de los bocadillos a finalizado
     */
    public static void cambiarEstadoAFinalizado(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Pedidos> pedidos = new ArrayList<>();
        int contador = 0;
        boolean next = true;

        for (Pedidos pedido: GesData.pedidos) {
            pedidos.add(pedido);
        }
        while (next) {
            for (Pedidos pedido: pedidos) {
                System.out.println(pedido);
            }
            System.out.println("Pon el id del pedido para cambiarle de estado, si quieres salir por 'termine'");
            String respuesta = sc.nextLine();
            if (respuesta.equals("termine")) {
                return;
            }
            try {
                int respuesta_id = Integer.parseInt(respuesta);
                for (Pedidos pedido: pedidos) {
                    if (respuesta_id == pedido.getId_pedido()) {
                        pedido.setEstado("Finalizado");
                        System.out.println(pedido.getEstado());
                    }
                }
            } catch (NumberFormatException n) {
                System.out.println("Tienes que poner un numero");
            }
        }
    }
}
