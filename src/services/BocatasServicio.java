package services;

import data.GesData;
import models.*;

import java.awt.font.FontRenderContext;
import java.util.ArrayList;

public class BocatasServicio {
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

    public static ArrayList<Bocatas> obtenerTodos(){
        ArrayList<Bocatas> bocatas = new ArrayList<>();
        for (Bocatas bocata: GesData.bocatas) {
            bocatas.add(bocata);
        }
        return bocatas;
    }

    public static Bocatas buscar(String bocadillo){
        for (Bocatas bocata: GesData.bocatas) {
            if (bocata.getNombre().equalsIgnoreCase(bocadillo)) {
                return bocata;
            }
        }
        return null;
    }

    public static void insertarBocatas(int id, String nombre, String descrip, ArrayList<String> ingredientes, ArrayList<String> alergenos, String ciudadpopular, double precio, boolean caliente) {
        GesData.bocatas.add(new Bocatas(id, nombre, ingredientes,descrip, alergenos, ciudadpopular, precio, caliente));
    }

    public static void eliminar(String eliminar){
        for (Bocatas bocata: GesData.bocatas) {
            if (bocata.getNombre().equals(eliminar)) {
                GesData.bocatas.remove(bocata);
                break;
            }
        }
    }
}
