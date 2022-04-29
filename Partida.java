package downstreet;

/**
 *
 * @author Francesc Tàpia Martorell
 * @version dv-v1
 */
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
        return mapas[(int)Math.round(Math.random() * mapas.length - 1)];
    }
    
    public static void main(String[] args) {
        System.out.println(mapaAleatorio());
    }
}
