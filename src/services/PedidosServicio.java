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
    public static ArrayList<Pedidos> optenerTodosPedidos(){
        ArrayList<Pedidos> pedidos = new ArrayList<>();
        for (Pedidos pedido: GesData.pedidos) {
            pedidos.add(pedido);
        }
        return pedidos;
    }

    public static Pedidos buscarPedido(int id_pedido){
        for (Pedidos pedido: GesData.pedidos) {
            if (pedido.getId_pedido() == id_pedido) {
                return pedido;
            }
        }
        return null;
    }

    public static void inseerarPedido( int id_pedido, String id_usuario, int id_bocadillo, LocalDate fecha, String estado){
        GesData.pedidos.add(new Pedidos(id_pedido, id_usuario, id_bocadillo, fecha, estado));
    }

    public static void eliminarPedido(int id_pedido){
        for (Pedidos pedido: GesData.pedidos) {
            if (pedido.getId_pedido() == id_pedido) {
                GesData.pedidos.remove(pedido);
            }
        }
    }

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
