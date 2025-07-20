package services;

import data.GesData;
import models.*;
import utils.Validaciones;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PedidosServicio {

    public static void leerPedido () throws IOException {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("src/persistencia/Pedidos.dat");
            ois = new ObjectInputStream(fis);
            Pedidos p;
            while (true) {
                p = (Pedidos) ois.readObject();
                GesData.pedidos.add(p);
            }
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        } finally {
            if (ois!=null){
                ois.close();
                fis.close();
            }
        }
    }

    public static void escribirPedidos(){
        try {
            FileOutputStream fos = new FileOutputStream("src/persistencia/Pedidos.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (Pedidos p : GesData.pedidos) {
                oos.writeObject(p);
            }
            oos.flush();
            fos.close();
            oos.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }

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
     * Muestra todos los pedidos en pantalla
     */
    public static void mostrarTodosPedidos(){
        for(Pedidos pedido: GesData.pedidos) {
            System.out.println(pedido);
        }
    }

    /**
     * Elimina el bocadillo elegido
     * @param id_pedido id del bocadillo
     */
    public static void eliminarPedido(int id_pedido){
        for (Pedidos pedido: GesData.pedidos) {
            if (pedido.getId_pedido() == id_pedido) {
                GesData.pedidos.remove(pedido);
                return;
            }
        }
    }

    /**
     * Muestra los pedidos de un alumno
     * @param user alumno elegido
     */
    public static void mostrarPedidosDeAlumno(User user){
        try {
            int cuenta = 0;
            for (Pedidos pedido: GesData.pedidos){
                if (user.getUsuario().equals(pedido.getId_usuario())) {
                    System.out.println();
                    System.out.println(pedido);
                    cuenta++;
                }
            }
            if (cuenta == 0){
                System.out.println("No tienes hechos pedidos");
            }
        } catch (NullPointerException n) {
            System.out.println("Error en la busqueda");
        }
    }

    public static boolean siAlumnoTienePedidos(Alumno nombre_alumno){
        for (Pedidos pedido: GesData.pedidos){
            if (nombre_alumno.getUsuario().equals(pedido.getId_usuario())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Cambia el estado de los bocadillos a finalizado
     */
    public static void cambiarEstadoAFinalizado(){
        Scanner sc = new Scanner(System.in);
        int contador = 0;
        boolean next = true;

         do {
             contador = 0;
            for (Pedidos pedido: GesData.pedidos) {
                if (pedido.getEstado().equals("Pendiente")){
                    System.out.println(pedido);
                    contador++;
                }
            }
            if (contador == 0) {
                System.out.println("No hay pedidos pendientes");
                return;
            }
            System.out.println("Pon el id del pedido para cambiarle de estado, si quieres salir pon 'termine'");
            String respuesta = sc.nextLine();
            if (respuesta.equals("termine")) {
                return;
            }
            try {
                int respuesta_id = Integer.parseInt(respuesta);
                for (Pedidos pedido: GesData.pedidos) {
                    if (respuesta_id == pedido.getId_pedido()) {
                        pedido.setEstado("Finalizado");
                    }
                }
            } catch (NumberFormatException n) {
                System.out.println("Tienes que poner un numero");
            }
        }while (next);
    }

    /**
     * Pie el bocadillo que haya selecionado el alumno
     * @param a alumno que pide el bocata
     */
    public static void pedirBocadillo(Alumno a){
        Bocatas elec = new Bocatas();
        boolean next = true;

        System.out.println("Elige el menu de hoy");

        elec = CalendariosServicio.menuHoy(a);
        
        if (elec == null) {
            System.out.println("Bocata no pedido");
            return;
        }
            
        //}
        int id_pedido = Validaciones.validarIdPedido();

        PedidosServicio.insertarPedido(id_pedido, a.getUsuario(), elec.getId(), LocalDate.now(), "Pendiente");
        System.out.println("Bocadillo pedido con exito");
    }

    /**
     * Metodo que se utiliza para cancelar el pedido
     * @param a Alumno al que se le va a borrar el pedido
     */
    public static void cancelarPedido(Alumno a){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        String elec = "";
        int cuenta = 0;
        ArrayList<Pedidos> pedidosAlumno = new ArrayList<>();

        for(Pedidos pedido: GesData.pedidos) {
            if (pedido.getFecha().equals(LocalDate.now()) && pedido.getId_usuario().equals(a.getUsuario())) {
                System.out.println(pedido);
                pedidosAlumno.add(pedido);
                cuenta++;
            }
        }

        if (cuenta == 0) {
            System.out.println("No se ha encontrado ningun pedido");
            return;
        }

        System.out.println("Elige el id del pedido que quieres cancelar");
        cuenta = 0;
        do {
            elec = sc.nextLine();

            if (Validaciones.soloNum(elec)) {
                int id_buscando = Integer.parseInt(elec);
                for (Pedidos pedido : pedidosAlumno) {
                    if (id_buscando == pedido.getId_pedido() && pedido.getFecha().equals(LocalDate.now())) {
                        GesData.pedidos.remove(pedido);
                        System.out.println("Eliminado correctamente");
                        cuenta++;
                        return;
                    }
                }
                if (cuenta == 0) {
                    System.out.println("No se ha encontrado el pedido con la id recibida");
                }
            } else {
                System.out.println("Pedido no encontrado");
            }
        }while (next);
    }
}
