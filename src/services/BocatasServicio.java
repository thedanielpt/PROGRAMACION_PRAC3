package services;

import data.GesData;
import models.*;
import org.junit.jupiter.api.Test;
import utils.Validaciones;

import java.awt.font.FontRenderContext;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase donde se ubican los servicios de los bocatas
 */

public class BocatasServicio {

    /**
     * Metodo que muestra todos los bocatas diferenciando entre calientes y frios
     */

    public static void mostrarTodosBocatas(){
        System.out.println("FRIOS");
        for (Bocatas bocata: GesData.bocatas) {
            if (!bocata.isCaliente()) {
                System.out.println(bocata.toString());
            }
        }

        System.out.println("\nCALIENTES");
        for (Bocatas bocata: GesData.bocatas) {
            if (bocata.isCaliente()) {
                System.out.println(bocata.toString());
            }
        }
    }

    /**
     * Este metodo obtiene todos los bocatas
     * @return todos los bocatas en un ArrayList<String>
     */

    public static ArrayList<Bocatas> obtenerTodos(){
        ArrayList<Bocatas> bocatas = new ArrayList<>();
        for (Bocatas bocata: GesData.bocatas) {
            bocatas.add(bocata);
        }
        return bocatas;
    }

    /**
     * Este metodo busca un bocata
     * @param bocadillo nombre del bocadillo
     * @return devuelve el bocadillo si se encontro, si no devuelve null
     */

    public static Bocatas buscar(String bocadillo){
        for (Bocatas bocata: GesData.bocatas) {
            if (bocata.getNombre().equalsIgnoreCase(bocadillo)) {
                return bocata;
            }
        }
        return null;
    }

    /**
     * Metodo que instancia un bocadillo, con sus atributos
     * @param id del bocadillo
     * @param nombre del bocadillo
     * @param descrip del bocadillo
     * @param ingredientes del bocadillo
     * @param alergenos del bocadillo
     * @param precio del bocadillo
     * @param caliente del bocadillo
     */

    public static void insertarBocatas(int id, String nombre, String descrip, ArrayList<String> ingredientes, ArrayList<String> alergenos, double precio, boolean caliente) {
        GesData.bocatas.add(new Bocatas(id, nombre,descrip, ingredientes, alergenos, precio, caliente));
    }

    /**
     * MEtodo para eliminar un bocadillo
     * @param eliminar nombre del bocadillo
     */

    public static void eliminar(String eliminar){
        for (Bocatas bocata: GesData.bocatas) {
            if (bocata.getNombre().equals(eliminar)) {
                GesData.bocatas.remove(bocata);
                break;
            }
        }
    }

    /**
     *Metodo para crear un bocadillo junto con sus atributos
     */

    public static void registroBocatas(){

        int id_bocata = Validaciones.validarIdBocata();

        String nombre = Validaciones.validarNombreBocata();

        String descripcion = Validaciones.validarDescripcionBocata();

        ArrayList<String> ingredientes = Validaciones.validarIngredientesBocatas();

        ArrayList<String> alergenos = Validaciones.validarAlergenosBocatas();

        double precio = Validaciones.validarPrecioBocata();

        boolean caliente = Validaciones.validarCalienteBocata();

        insertarBocatas(id_bocata,nombre,descripcion,ingredientes,alergenos,precio,caliente);
    }

    public static void modificarNombreBocata(Bocatas bocata){
        Scanner sc = new Scanner(System.in);
        boolean next = true;

        do {
            String nombre  = Validaciones.validarNombreBocata();

            System.out.println("¿Quieres cambiar de nombre: "+ bocata.getNombre()+" por nombre: "+nombre+"?");
            if (Validaciones.validarEstasSeguro()) {
                bocata.setNombre(nombre);
                break;
            } else {
                System.out.println("No se ha cambiado el nombre del bocata");
                break;
            }
        }while (next);
    }

    public static void modificarDescripcionBocata(Bocatas bocata){
        Scanner sc = new Scanner(System.in);
        boolean next = true;

        do {
            String descripcion  = Validaciones.validarDescripcionBocata();

            System.out.println("¿Quieres cambiar de descripción: \n"+ bocata.getDescrip()+"\n por esta descripción: \n"+descripcion+"?");
            if (Validaciones.validarEstasSeguro()) {
                bocata.setDescrip(descripcion);
                break;
            } else {
                System.out.println("No se ha cambiado la descripción del bocata");
                break;
            }
        }while (next);
    }

    public static void modificarIngredientesBocata(Bocatas bocata){
        Scanner sc = new Scanner(System.in);
        boolean next = true;

        do {
            ArrayList<String> ingredientes  = Validaciones.validarIngredientesBocatas();

            System.out.println("¿Quieres cambiar los ingredientes: \n"+ bocata.getIngredientes()+" por estos ingredientes: \n"+ingredientes+"?");
            if (Validaciones.validarEstasSeguro()) {
                bocata.setIngredientes(ingredientes);
                break;
            } else {
                System.out.println("No se ha cambiado los ingredientes del bocata");
                break;
            }
        }while (next);
    }

    public static void modificarAlergenosBocata(Bocatas bocata){
        Scanner sc = new Scanner(System.in);
        boolean next = true;

        do {
            ArrayList<String> alergenos  = Validaciones.validarAlergenosBocatas();

            System.out.println("¿Quieres cambiar los alergenos: "+ bocata.getAlergenos()+" por estos alergenos: "+alergenos+"?");
            if (Validaciones.validarEstasSeguro()) {
                bocata.setAlergenos(alergenos);
                break;
            } else {
                System.out.println("No se ha cambiado el nombre del bocata");
                break;
            }
        }while (next);
    }

    public static void modificarPrecioBocata(Bocatas bocata){
        Scanner sc = new Scanner(System.in);
        boolean next = true;

        do {
            double precio  = Validaciones.validarPrecioBocata();

            System.out.println("¿Quieres cambiar el precio: "+ bocata.getPrecio()+" por este precio: "+precio+"?");
            if (Validaciones.validarEstasSeguro()) {
                bocata.setPrecio(precio);
                break;
            } else {
                System.out.println("No se ha cambiado el precio del bocata");
                break;
            }
        }while (next);
    }

    public static void modificarCalienteBocata(Bocatas bocata){
        Scanner sc = new Scanner(System.in);
        boolean next = true;

        do {
            boolean caliente  = Validaciones.validarCalienteBocata();

            if (caliente = bocata.isCaliente()) {
                System.out.println("Es el mismo estado");
                break;
            }

            if (Validaciones.validarEstasSeguro()) {
                bocata.setCaliente(caliente);
                break;
            } else {
                System.out.println("No se ha cambiado el precio del bocata");
                break;
            }
        }while (next);
    }
}
