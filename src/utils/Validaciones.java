package utils;

import data.GesData;
import models.*;
import org.junit.jupiter.api.Test;
import services.UsuarioServicio;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Validaciones {

    //VALIDACIONES


    /**
     * Comprueba aquí que tengas caracteres antes del arroba, que el ultimo punto que pongas no este detras
     * del arroba, que en medio del punto y arroba alla un caracter y que el punto tenga delante un caracter
     * @param cadena Este es el gmail que habra puesto
     * @return boolean Devolvera false si esta bien, si no te devolvera true
     */
    public static boolean noDelanteArrobPunto(String cadena){
        int arroba = cadena.indexOf('@');
        int punto = cadena.lastIndexOf('.');

        if (arroba > 0 && punto > arroba + 1 && punto < cadena.length() - 1){
            return false;
        } else {
            return true;
        }
    }

    /**
     * Calcula si hay mas arrobas de los deberian haber
     * @param cadena Aqui esta el gmail que habra escrito
     * @return boolean Si es valido y solo tiene un @ te devolvera false, si no es el caso te devolvera true
     */
    public static boolean siTieneMasArroba(String cadena){
        int contadorArr = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == '@' ){
                contadorArr++;
            }
        }
        if (contadorArr == 1){
            return false;
        } else {
            return true;
        }
    }

    /**
     * Comprueba si hay mayusculas
     * @param cadena Cadena que se utilizara para comprobar si hay mayusculas
     * @return boolean Si hay alguna mayuscula te devolvera true, si es el caso cotrasrio te devolvera false
     */
    public static boolean hayMayus(String cadena){
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) >= 'A' && cadena.charAt(i) <= 'Z'){
                return true;
            }
        }
        return false;
    }

    /**
     * Comprueba las minusculas
     * @param caracter Cadena utilizada para ver si hay minusculas
     * @return boolean Si hay minusculas te devolvera true, en caso contrario te devolvera false
     */
    public static boolean hayMinus(String caracter){
        for (int i = 0; i < caracter.length(); i++) {
            if (caracter.charAt(i) >= 'a' && caracter.charAt(i) <='z'){
                return true;
            }
        }
        return false;
    }

    /**
     * Comprueba si hay numeros
     * @param cadena cadena para ver si hay algun numero
     * @return boolean Si hay algun numero te devolvera true, en caso contrario te devolvera false
     */
    public static boolean hayNum(String cadena){
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) >= '0' && cadena.charAt(i) <= '9')
                return true;
        }
        return false;
    }

    /**
     * Comprueba que solo sean numeros
     * @param num La cadena que se quiere comprobar si solo son numeros
     * @return boolean Si todos son numeros te devolvera true en caso contrario te devolvera false
     */
    public static boolean soloNum(String num){
        int cuenta = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) >= '0' && num.charAt(i) <= '9'){
                cuenta++;
            }
        }
        if (cuenta == num.length()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Comprueba si hay espacios, si hay algun espacio te devuelve true
     * @param cadena Cadena para comprobar si hay espacios
     * @return boolean Si hay espacios te devolvera true, si no te devolvera false
     */
    public static boolean hayEspacio(String cadena){
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == ' '){
                return true;
            }
        }
        return false;
    }

    /**
     * Comprueba si hay caracteres especiales
     * @param cadena Cadena que se comprueba
     * @return boolean Si hay un caracter especial te devuelve true, si no es el caso te devuelve false
     */
    public static boolean hayEspecial(String cadena){
        String caracEspecia = "!@#$%^&\\*()_+-=[]{}|;:,.<>?";
        for (int i = 0; i < cadena.length(); i++) {
            if (caracEspecia.indexOf(cadena.charAt(i)) >= 0){
                return true;
            }
        }
        return false;
    }

    /**
     * Comprueba si hay caracteres especiales
     * @param cadena Esta variable contiene el gmail del usuario
     * @return boolean Te devolvera false si no tienes nigun caracter especial de la cadena caracEspecia y si tiene uno te
     * devolvera true
     */
    public static boolean espeGmail(String cadena){
        String caracEspecia = "!#$%^&*()_+-=\\[]{}|;:,<>¿?";
        for (int i = 0; i < cadena.length(); i++) {
            if (caracEspecia.indexOf(cadena.charAt(i)) >= 0){
                return true;
            }
        }
        return false;
    }

    /**
     * Valida el alfabeto latino y si hay alguna letra que no es te deuelve true
     * @param cadena Cadena que valida
     * @return boolean Te devuelve true si la cadena es valida en caso contrario te devuelve false
     */

    public static boolean validarAlfabetoLat(String cadena){
        String nueboNombre=cadena.toLowerCase();
        for (int i = 0; i < nueboNombre.length(); i++) {
            if ((nueboNombre.charAt(i) < 'a' && nueboNombre.charAt(i) > 'z') &&
                    (nueboNombre.charAt(i) != 'á' ||
                            nueboNombre.charAt(i) != 'é' ||
                            nueboNombre.charAt(i) != 'í' ||
                            nueboNombre.charAt(i) != 'ó' ||
                            nueboNombre.charAt(i) != 'ú' ||
                            nueboNombre.charAt(i) != 'ñ' ||
                            nueboNombre.charAt(i) != ' '
                    )
            )
            {
                return false;
            }
        }
        return true;
    }

    //CAPTCHA

    /**
     * El captcha esta hecho para sumar dos numeros creados por Math.random
     * @return boolean Si el usuario no hacierta la suma que se genera, pondra falso, caso contrario sera verdadero
     */
    public static boolean captcha () {
        Scanner scan = new Scanner(System.in);
        int num2 = (int) (Math.random() * 10);
        int num1 = (int) (Math.random() * 10);
        String respuesta;
        int respuestaPreg;
        int resultado;
        System.out.println("Haz esta suma");
        System.out.println(num1 + " + " + num2);
        for (int i = 0; i < 3; i++) {
            respuesta = scan.nextLine();
            //Comprueba si solo son numeros
            if (Validaciones.soloNum(respuesta)) {
                respuestaPreg = Integer.parseInt(respuesta);
                resultado = num1 + num2;
                //Comprueba si la respuesta puesta es igual al resultado, haciendo de que te saque de la funcion con un true
                if (respuestaPreg == resultado) {
                    return true;
                    //Si lo has intentado 3 veces te devuelve false
                } else if (i == 2) {
                    return false;
                } else {
                    System.out.println("Vuelve a intentarlo");
                }
            } else {
                System.out.println("Vuelve a intenarlo");
            }
        }
        return false;
    }

    //NOMBRE Y APELLIDOS

    /**
     * Este método lo que hace es devolver el nombre y apellido del usuario
     * @return String Devuelve el nombre y el apellido
     */

    public static String nombreApellidos(){

        Scanner sc = new Scanner(System.in);

        String nombre = "";
        String apellido1 = "";
        String apellido2 = "";

        do {
            System.out.println("Introduce el nombre");
            nombre = sc.nextLine();
        }while (!Validaciones.validarAlfabetoLat(nombre));

        do {
            System.out.println("Introduce el primer apellido: ");
            apellido1 = sc.nextLine();
        }while (!Validaciones.validarAlfabetoLat(apellido1));

        do {
            System.out.println("Introduce el segundo apellido: ");
            apellido2 = sc.nextLine();
        }while (!Validaciones.validarAlfabetoLat(apellido2));

        String nombreApellidos = nombre + " " + apellido1 + " " + apellido2;

        return nombreApellidos;
    }

    //NOMBRE DE USUARIO


    /**
     * Valida el nombre de usuario
     * @return nameUser Contiene el nombre de usuario
     */

    public static String validarUsuario() {
        Scanner scan = new Scanner(System.in);
        String nameUser;
        boolean next;
        // Creación de nombre de usuario
        do {
            System.out.println("Pon el nombre de usuario que quieras, pero con estas restricciones:");
            System.out.println("- No puede tener menos de 5 letras");
            System.out.println("- No puede tener caracteres especiales");
            nameUser = scan.nextLine();
            /*Valida si hay espacios, si hay caracteres especiales y si mide menos de 5 caracteres
            Si no cumple saldras del bucle  */
            if (nameUser.length() < 5 || Validaciones.hayEspacio(nameUser) || Validaciones.hayEspecial(nameUser)) {
                System.out.println("Usuario no valido");
                next = true;
            } else next = false;


        } while (next);
        return nameUser;
    }

    //GMAIL

    /**
     * valida el gmail
     * @return gmail Contiene el gmail del usuario
     */
    public static String validarGmail(){
        Scanner scan = new Scanner(System.in);
        boolean next;
        String gmail;
        do {
            System.out.println("Ahora pon tu correo electronico");
            gmail = scan.nextLine();
            //Comprueba si tienes mas de un arroba
            if (Validaciones.siTieneMasArroba(gmail)){
                System.out.println("Tiene que tener solo un arroba y un punto");
                next = true;
            } else {
                //Comprueba si gmail tiene caracteres especiales que no se perimiten en el gmail
                if (Validaciones.espeGmail(gmail)){
                    System.out.println("no puede tener caracteres especiales");
                    next = true;
                } else {
                    //Comprueba si hay espacios
                    if (Validaciones.hayEspacio(gmail)){
                        System.out.println("No puede tener espacios");
                        next = true;
                    } else {
                        /*
                        Comprueba aquí que tengas caracteres antes del arroba, que el ultimo punto que pongas no este detras
                        del arroba, que en medio del punto y arroba alla un caracter y que el punto tenga delante un caracter
                         */
                        if (Validaciones.noDelanteArrobPunto(gmail)){
                            System.out.println("Tiene que tener el arroba delante del punto y con algo en medio");
                            System.out.println("No has puesto delante del punto nada o detras del arroba");
                            next = true;
                        } else {
                            System.out.println("Este es tu gmail " + gmail);
                            next = false;
                        }
                    }
                }
            }
        } while (next);
        return gmail;
    }

    //CONTRASEÑA

    /**
     * Valida la contraseña
     * @return contrasena Contiene la contraseña del usuario
     */
    public static String validarContrasena() {
        String contrasena;
        Scanner scan = new Scanner(System.in);
        String compContrasena;
        boolean next = true;
        do {
            System.out.println("Pon la contraseña que quieras, pero con estas caracteristicas:");
            System.out.println("- Minimo tiene que tener un caracter especial");
            System.out.println("- Minimo tiene que tener ocho letras");
            System.out.println("- Minimo tiene que tener una letra mayuscula");
            System.out.println("- Minimo tiene que tener una letra miniscula");
            System.out.println("- Minimo tiene que tener un numero");
            contrasena = scan.nextLine();
            //Comprueba si contrasena tiene caracteres especiales, si mide mas de 8 caracteres, si hay mayusculas, si hay minusculas y
            //si hay numeros.
            //Si no tiene alguno de estas caracteristicas, se repite el bucle
            if (Validaciones.hayEspecial(contrasena) && contrasena.length() >= 8 && Validaciones.hayMayus(contrasena)
                    && Validaciones.hayMinus(contrasena) && Validaciones.hayNum(contrasena)) {
                System.out.println("Ponme otra vez la contraseña que has escrito");
                for (int i = 0; i < 3; i++) {
                    compContrasena = scan.nextLine();
                    if (compContrasena.equals(contrasena)) {
                        next = false;
                        break;
                    } else {
                        System.out.println("vuelve a intentarlo");
                    }
                }
            } else {
                System.out.println("Contraseña no valida");
                next = true;
            }
        } while (next);
        return contrasena;
    }

    //Fecha

    /**
     * Este metodo devuelve la fecha del usuario que se halla
     * @return Fecha de usuario
     */

    /*public static LocalDate validarFecha(){
        Scanner sc = new Scanner(System.in);
        LocalDate fecha = null;
        LocalDate hoy = LocalDate.now();
        int anoActual = hoy.getYear();

        String selec = "";
        int anoU = 0;
        int mesU = 0;
        int diaU = 0;
        boolean next = true;
        //AÑO

        do {
            System.out.println("Pon tu año de nacimiento");
            selec = sc.nextLine();

            if (Validaciones.soloNum(selec)){
                anoU = Integer.parseInt(selec);
                if (anoU < 1950 || anoU > anoActual) {
                    System.out.println("Año no valido");
                    next = true;
                } else {
                    System.out.println("Tu año es = "+anoU);
                    next = false;
                }
            } else {
                System.out.println("Tiene que ser solo números");
                next = true;
            }
        } while (next);

        //MES

        do {
            System.out.println("Pon tu mes de nacimiento");
            selec = sc.nextLine();

            if (Validaciones.soloNum(selec)){
                mesU = Integer.parseInt(selec);
                if (mesU < 1 || 12 < mesU ) {
                    System.out.println("mes no valido");
                    next = true;
                } else {
                    System.out.println("Tu mes es = "+mesU);
                    next = false;
                }
            } else {
                System.out.println("Tiene que ser solo números");
                next = true;
            }
        } while (next);

        //Esto sirve para saber la longitud del mes.
        //Primero ponemos los valores del año y el mes en fecha
        fecha = LocalDate.of(anoU,mesU,1);

        //Ahora se le pide que diga la longitud del mes
        int longitudMesActual = fecha.lengthOfMonth();

        //DÍA

        do {
            System.out.println("Pon tu día de nacimiento");
            selec = sc.nextLine();

            if (Validaciones.soloNum(selec)){
                diaU = Integer.parseInt(selec);
                if (diaU < 1 || diaU > longitudMesActual) {
                    System.out.println("Día no valido");
                    next = true;
                } else {
                    System.out.println("Tu día es = "+diaU);
                    next = false;
                }
            } else {
                System.out.println("Tiene que ser solo números");
                next = true;
            }
        } while (next);
        fecha = LocalDate.of(anoU, mesU,diaU);
        System.out.println(fecha);
        return fecha;
    }/*

    /**
     * Sirve para desbloquear a un usuario
     * @param pregunta
     * @param respuesta
     * @param block
     * @return te devuelve true si has contestado bien o false si no lo intentas demasiadas veces
     */

    public static boolean gestionBloqueo(String pregunta, String respuesta, boolean block){
        Scanner sc = new Scanner(System.in);
        String respuestaPre = "";

        //Comprueba si te has registrado
        if (Validaciones.captcha()){
            System.out.println(pregunta);
            for (int i = 0; i < 3; i++) {
                respuestaPre = sc.nextLine();
                //Comprueba si respuestaPre es igual a respuesta
                if (respuestaPre.equals(respuesta)) {
                    System.out.println("Se te a desbloqueado el usuario");
                    return true;
                    //Si lo intento tres veces le saca del bucle, sin desbloquear al usuario
                } else  if (i == 2){
                    System.out.println("Los intentos se han agotado");
                    return false;
                } else {
                    System.out.println("vuelve a intenatrlo");
                }
            }
        } else {
            System.out.println("Captcha no aceptado");
        }
        return false;
    }

    // RECUPERACIÓN CONTRASEÑA

    /**
     * Recuperar la contraseña
     * @param pregunta Pregunta elegida cuando se haya hecho el registro
     * @param respuesta Respuesta escrita por el usuario, para responder a la pregunta
     * @return contrasenaNueva Contiene la nueva contraseña que se a esrito el usuario, si el usuario no a podido cambiarla, no
     * tendra ningun caracter
     */
    public static String recuperacionContrasena(String pregunta, String respuesta) {
        Scanner scan = new Scanner(System.in);
        boolean next = false;
        String contrasena = "";
        String compContrasena = "";
        String contrasenaNueva = "";
        String respuestaPre = "";
        boolean vete = false;
        do {
            for (int i = 0; i < 3; i++) {
                System.out.println(pregunta);
                respuestaPre = scan.nextLine();
                //Comprueba si la respuesta qeu a escrito es igual a la respuesta correcta
                if (respuestaPre.equals(respuesta)) {
                    System.out.println("Pon tu nueva contraseña");
                    for (int j = 0; j < 3; j++) {
                        contrasenaNueva = scan.nextLine();
                        /*
                        Comprueba si contrasena tiene caracteres especiales, si mide 8 caracteres, si hay mayusculas, si hay
                        mminusculas y si hay numeros
                         */
                        if (Validaciones.hayEspecial(contrasenaNueva) && contrasenaNueva.length() >= 8 && Validaciones.hayMayus(contrasenaNueva) &&
                                Validaciones.hayMinus(contrasenaNueva) && Validaciones.hayNum(contrasenaNueva)) {
                            System.out.println("Ponme otra vez la contraseña que  has escrito");
                            for (int e = 0; e < 3; e++) {
                                compContrasena = scan.nextLine();
                                //Devuelve a repetir que pongas la contrasena para que se canvie.
                                if (compContrasena.equals(contrasenaNueva)) {
                                    contrasena = contrasenaNueva;
                                    return contrasena;
                                    //Si lo intentas tres veces y no funciona te saca y no habras cambieado la contraseña
                                } else if (e == 2) {
                                    contrasena = "";
                                    vete = true;
                                    System.out.println("La has puesto mal demasiadas veces");
                                    return contrasena;
                                } else {
                                    System.out.println("vuelve a intentarlo");
                                }
                            }
                        } else if (j == 2) {
                            System.out.println("demasiados intentos");
                            return contrasena;
                        } else {
                            System.out.println("vuelve a intentarlo");
                        }
                    }
                    System.out.println("Confirma la nueva contraseña");
                } else {
                    System.out.println(" vuelve a intentarlo");
                    if (i == 2) {
                        return contrasena;
                    }
                }
            }
        } while (next);

        vete = false;
        return contrasenaNueva;
    }

    public static String cursoUsuario(){
        Scanner sc= new Scanner(System.in);
        String elec = "";
        String curso = "";
        boolean next = true;

        do {
            System.out.println("Elige al curso que perteneces");
            System.out.println("1. ESO");
            System.out.println("2. Grado Medio");
            elec = sc.nextLine();

            switch (elec) {
                case "1":
                    do {
                        System.out.println("Selecciona a ESO perteneces");
                        System.out.println("1. 1ºESO");
                        System.out.println("2. 2ºESO");
                        System.out.println("3. 3ºESO");
                        System.out.println("4. 4ºESO");
                        System.out.println("5. No es lo que quería seleccionar");
                        elec = sc.nextLine();

                        switch (elec) {
                            case "1":
                                System.out.println("Eres de 1ºESO");
                                curso = "1ªESO";
                                next = false;
                                break;
                            case "2":
                                System.out.println("Eres de 2ºESO");
                                curso = "2ªESO";
                                next = false;
                                break;
                            case "3":
                                System.out.println("Eres de 3ºESO");
                                curso = "3ªESO";
                                next = false;
                                break;
                            case "4":
                                System.out.println("Eres de 4ºESO");
                                curso = "4ªESO";
                                next = false;
                                break;
                            case "5":
                                next = false;
                                break;
                            default:
                                System.out.println("No has seleccionado nada");
                                next = true;
                                break;
                        }
                    } while (next);
                    break;
                case "2":
                    do {
                        System.out.println("Selecciona el año junto a su grado medio");
                        System.out.println("1. 1ºAño GM Informatica");
                        System.out.println("2. 2ºAño GM Informatica");
                        System.out.println("3. 1ºAño GM Jardinería");
                        System.out.println("4. 2ºAño GM Jardinería");
                        System.out.println("5. No es lo que quería seleccionar");
                        elec = sc.nextLine();

                        switch (elec) {
                            case "1":
                                curso = "1ºAño GM Informatica";
                                next = false;
                                break;
                            case "2":
                                curso = "2ºAño GM Informatica";
                                next = false;
                                break;
                            case "3":
                                curso = "1ºAño GM Jardinería";
                                next = false;
                                break;
                            case "4":
                                curso = "2ºAño GM Jardinería";
                                next = false;
                                break;
                            case "5":
                                next = false;
                                break;
                            default:
                                next = true;
                                break;
                        }

                    } while (next);
                    break;
                default:
                    System.out.println("Tienes que seleccionar una opción");
                    break;
            }
        } while (curso.length()<3);

        System.out.println("Curso seleccionado = "+curso +"\n");

        return curso;
    }

    public static boolean tienesAlergias(){
        Scanner sc = new Scanner(System.in);
        String elec;
        boolean next = true;

        do {
            System.out.println("¿Tienes alergias?");
            System.out.println("Si o no");
            elec = sc.nextLine();
            elec = elec.toLowerCase();

            switch (elec) {
                case "si":
                    return true;
                case "no":
                    return false;
                default:
                    System.out.println("Tienes que elegir");
                    break;
            }
        }while (next);
        return false;
    }

    /**
     * Este metodo sirve para la creación del expediente del usuario
     * @param curso coje el curso al que pertenece el usuario
     * @return devuelve el expediente creado
     */

    public static String validar_expediente(String curso){
        int cuenta = 0;
        String total = "";

        for (User user: GesData.usuarios) {
            if (user instanceof Alumno) {
                Alumno a = (Alumno) user;
                if (curso.equals(a.getCurso())) {
                    cuenta++;
                }
            }
        }

        ++cuenta;

        if (cuenta < 10) {
            total = "000"+cuenta;
        } else {
            total = "00"+cuenta;
        }

        return curso+"_"+total;
    }

    public static boolean validar_alta(){
        Scanner sc = new Scanner(System.in);
        boolean next = true;


        System.out.println("¿Quieres dar de alta a este usuario?");
        if (estasSeguro()) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * En este metodo se tienen que poner todas las alergias del usuario
     * @return devuelve un ArrayLinst con las alergias que tiene
     */

    public static ArrayList alergiasUsuario(){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        ArrayList alergias = new ArrayList<>();

        System.out.println("Ingrese sus lergias, cuando las pongas todas pon terminado");

        while (next) {
            String alergia = sc.nextLine();
            if (alergia.equalsIgnoreCase("terminado")) {
                break;
            }
            alergias.add(alergia);
            System.out.println("Siguiente alergia:");
        }
        return alergias;
    }

    /**
     * Valida la pregunta que el usuario tiene que elegir
     * @return devuelve la pregunta elegida
     */

    public static String validarPregunta(){
        Scanner sc = new Scanner(System.in);
        boolean next = true;

        do {
            System.out.println("Ahora elige entre estas preguntas de seguridad");
            System.out.println("1. ¿Cual es tu comida favorita?");
            System.out.println("2. ¿Cual es tu juego favorito?");
            System.out.println("3. ¿Cual es tu numero favorito?");
            String elec = sc.nextLine();
            switch (elec){
                case "1":
                    return "¿Cual es tu comida favorita?";
                case "2":
                    return "¿Cual es tu juego favorito?";
                case "3":
                    return "¿Cual es tu numero favorito?";
                default:
                    System.out.println("Tienes que elegir una opción");
                    next = true;
            }
        } while (next);
        return null;
    }

    /**
     * Te pide que pngas al usuario que quieres buscar y te lo busca
     * @return devuelve el usuario del User
     */

    public static String pregunta_buscar() {
        Scanner sc=new Scanner(System.in);
        boolean next = true;

        UsuarioServicio.mostrarTodosUsers();
        System.out.println();

        do {
            System.out.println("¿Que usuario quieres? y si no quieres borrarlo pon 'no'");

            String elec = sc.nextLine();

            if (UsuarioServicio.buscar(elec) != null) {
                return elec;
            } else if (elec.equals("no")) {
                return null;
            } else {
                System.out.println("Usuario no encontrado");
            }
        }while (next);
        return null;
    }

    /**
     * Valida si la hora esta dentro del rango o no
     * @return true si esta dentro del rango de la hora
     */

    public static boolean validarHora(){
        LocalTime ahora = LocalTime.now();
        LocalTime limite_principio = LocalTime.of(8, 0, 0);
        LocalTime limite_final = LocalTime.of(10, 30, 0);

        if (ahora.isBefore(limite_principio) && ahora.isAfter(limite_final)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Nos da el id del bocata que se quiere crear, sumando todos los bocatas y luego sumando uno a esa cuenta
     * @return devuelve la cuenta que se ha hecho
     */

    public static int validarIdBocata() {
        int cuenta = 0;

        for (Bocatas bocata : GesData.bocatas) {
            if (bocata.getId() == cuenta) {
                cuenta++;
            } else {
                return cuenta;
            }
        }
        return 0;
    }

    /**
     * Metodo para la creacion del nombre del bocata
     * @return devuelve el nombre del bocata que tu hayas puesto
     */

    public static String validarNombreBocata(){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        String nombre = "";


        do {
            System.out.println("¿Que nombre le quieres poner al bocata?");

            nombre = sc.nextLine();

            System.out.println("Quieres ponerle de nombre: "+nombre);
            if (estasSeguro()) {
                return nombre;
            } else {
                next = true;
            }
        }while (next);
        return null;
    }

    /**
     * Valida la descripcion del bocadillo
     * @return devuelve la descripcion del bocadillo
     */

    public static String validarDescripcionBocata(){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        String descripcion = "";

        do {
            System.out.println("¿Que descripción le quieres poner al bocata?");

            descripcion = sc.nextLine();

            System.out.println("¿Quieres esta descripción para tu bocata?: "+descripcion);
            if (estasSeguro()) {
                return descripcion;
            } else {
                next = true;
            }
        }while (next);
        return null;
    }

    /**
     * Este metodo le pide al admin los alergenos del bocata
     * @return devuelve los alergenos del bocata
     */

    public static ArrayList validarAlergenosBocatas(){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        ArrayList alergias = new ArrayList<>();

        System.out.println("Ingrese los alergenos, cuando las pongas todas pon 'terminado'");

        while (next) {
            String alergia = sc.nextLine();
            if (alergia.equalsIgnoreCase("terminado")) {
                break;
            }
            alergias.add(alergia);
            System.out.println("Siguiente alergeno:");
        }
        return alergias;
    }

    /**
     * Este metodo le pide al admin los ingredientes del bocata
     * @return devuelve los ingredientes del bocata
     */

    public static ArrayList validarIngredientesBocatas(){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        ArrayList ingredientes = new ArrayList<>();

        System.out.println("Ingrese los ingredientes del bocata, cuando pongas todos los ingredientes pon 'terminado'");

        while (next) {
            String ingrediente = sc.nextLine();
            if (ingrediente.equalsIgnoreCase("terminado")) {
                break;
            }
            ingredientes.add(ingredientes);
            System.out.println("Siguiente ingrediente:");
        }
        return ingredientes;
    }

    /**
     * Valida el coste del bocata
     * @return devuelve el coste del bocata que le hayas puesto
     */

    public static float validarPrecioBocata(){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        float precio_final = 0;

        do {
            System.out.println("Pon el coste del bocata");

            String precio = sc.nextLine();

            try {
                precio_final = Float.parseFloat(precio);
                System.out.println("¿Quieres que cueste "+precio_final+"?");
                System.out.println("Di 'si' o 'no'");
                if (estasSeguro()) {
                    precio_final = (precio_final + ((precio_final*Bocatas.iva)/100));
                    return precio_final;
                } else {
                    next = true;
                }
            }catch (NumberFormatException e) {
                System.out.println("Tiene que ser solo nuemros");
                next = true;
            }
        }while (next);
        return precio_final;
    }

    /**
     * Te pregunta si o no
     * @return un booleano dependiendo de la respuesta
     */

    public static boolean validarEstasSeguro(){
        Scanner sc = new Scanner(System.in);
        String elec = "";
        boolean next = true;

        System.out.println("si o no");

        elec = sc.nextLine();
        elec=elec.toLowerCase();

        switch (elec){
            case "si":
                return true;
            case "no":
                return false;
            default:
                System.out.println("elige una opcion");
                break;
        }
        return false;
    }

    

    public static boolean validarCalienteBocata() {
        Scanner sc = new Scanner(System.in);
        boolean caliente = true;
        boolean next = true;
        String elec = "";

        do {
            System.out.println("¿Que tipo de bocadillo quieres caliente o frio?");
            System.out.println("Pon 'caliente' o 'frio'");

            elec = sc.nextLine();
            elec = elec.toLowerCase();

            switch (elec) {
                case "frio":
                    caliente = false;
                    next = false;
                    break;
                case "caliente":
                    caliente = true;
                    next = false;
                    break;
                default:
                    System.out.println("Elige una de las opciones");
                    break;
            }
            System.out.println("¿Estas seguro que quieres que el estado sea: "+caliente+"?");
            if (estasSeguro()) {
                return caliente;
            } else {
                next = true;
            }
        } while (next);
        return false;
    }
}
