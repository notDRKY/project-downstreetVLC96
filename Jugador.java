package downstreet;

/**
 *
 * @author Francesc Tàpia Martorell
 * @version dv-v1
 */
public class Jugador {
    
    /**
     * Guardará un número de Strings que serán las clases disponibles.
     * Según la clase, Jugador tendrá una salud, y un dano.
     */
    private static String[] clases = {"Programador", "EquitareTrip", "Fallero"};
    
    /**
     * Guaradará el nombre del Jugador
     */
    private String nombre;
    /**
     * Establecerá la salud máxima de Jugador
     */
    private int saludMax;
    /**
     * Establecerá la salud actual del Jugador
     */
    private int saludRestante;
    /*
     * Establecerá el daño que inflinge Jugador
     */
    private int dano;
    /**
     * [DV] Será la clase con la que jugará Jugador, está establecerá la saludMax y el daño.
     */
    private String clase;
    
    // Constructor de PRUEBAS
    public Jugador(String nombre, int saludMax, int dano) {
        this.nombre = nombre;
        this.saludMax = saludMax;
        this.saludRestante = saludMax;
        this.dano = dano;
    }
    
    public void ataqueJ(Monstruos m){
        m.setSaludRestante(this.dano - m.getSaludRestante());
    }
    
    @Override
    public String toString() {
        return "PLAYER " + nombre + "\n"
                + "Salud máxima: " + saludMax + "\n"
                + "Salud restante: " + saludRestante + "\n"
                + "Daño: " + dano + "\n"
                + "Clase: " + clase;
    }
    
    // GETTERS 
    public static String[] getClases() {
        return clases;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSaludMax() {
        return saludMax;
    }

    public int getSaludRestante() {
        return saludRestante;
    }

    public int getDano() {
        return dano;
    }

    public String getClase() {
        return clase;
    }
    
    // SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSaludMax(int saludMax) {
        this.saludMax = saludMax;
    }

    public void setSaludRestante(int saludRestante) {
        this.saludRestante = saludRestante;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }
    
}
