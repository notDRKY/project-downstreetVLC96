package downstreet;

/**
 *
 * @author Francesc Tàpia Martorell
 * @version dv-v1
 */
public class Monstruos {
    private static int numMonstruos = 0;
    private int saludMax;
    private int saludRestante;
    private int dano;
    
    
    public Monstruos(int saludMax, int dano) {
        this.saludMax = saludMax;
        this.saludRestante = saludMax;
        this.dano = dano;
        numMonstruos++;
    }

    @Override
    public String toString() {
        return "Monstruos " + "\n"
                + "Salud máxima: " + saludMax + "\n"
                + "Salud restante: " + saludRestante + "\n"
                + "Daño: " + dano;
    }
    
    // GETTERS

    public static int getNumMonstruos() {
        return numMonstruos;
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
    
    // SETTERS
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
