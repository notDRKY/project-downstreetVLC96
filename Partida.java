package downstreet;

/**
 *
 * @author Francesc Tàpia Martorell
 * @version dv-v1
 */
import java.util.Scanner;

public class Partida {
    /**
     * Determinará la duración de la partida.
     * NO PUEDE SER MAYOR QUE EL NÚMERO DE MAPAS A NO SER QUE SE QUIERAN REPETIR
     */
    private static final int DURACION = 5;
    // ¿podría ser una lista? -- probablemente no
    
    /**
     * El array mapas[] contiene los mapas jugables en la Partida.
     */
    private static String[] mapas = {"EL CABAÑAL", "EL CARMEN", "LA FONTSANTA", "EL POLÍGONO", "EL METRO", "EL BARRIO CHINO"};
    
    /**
     * Devuelve un String aleatorio del array mapas.
     */
    public static String mapaAleatorio(){
        return mapas[(int)Math.round(Math.random() * (mapas.length - 1))];
    }
    
//    public static Jugador creacionPj(String nombre, int classe) {
//        Jugador jugador;
//        jugador = switch (classe) {
//            case 1 -> new Jugador(nombre, 100, 20, 0.05, Jugador.tipos[0]);
//            case 2 -> new Jugador(nombre, 70, 25, 0.10, "PÍCARO");
//            case 3 -> new Jugador(nombre, 50, 30, 0.05, "MAGO");
//            default -> new Jugador(nombre, 1, 0, 0, "CULERO");
//        };
//        return jugador;
//    }
    
    public static void main(String[] args) {

    }
}
