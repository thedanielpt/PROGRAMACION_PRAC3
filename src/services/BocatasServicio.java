package services;

import data.GesData;
import models.*;
import org.junit.jupiter.api.Test;
import utils.Validaciones;

import java.awt.font.FontRenderContext;
import java.util.ArrayList;

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

        double precio = Validaciones.costeBocata();

        boolean caliente = Validaciones.validarCalienteBocata();

        insertarBocatas(id_bocata,nombre,descripcion,ingredientes,alergenos,precio,caliente);

    }
}
