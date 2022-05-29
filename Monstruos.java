package downstreet;

/**
 *
 * @author Francesc Tàpia Martorell
 * @version dv-v2
 */
public class Monstruos {

    /**
     * Establecerá la salud máxima de Monstruos
     */
    private int saludMax;

    /**
     * Establecerá la salud actual de Monstruos
     */
    private int saludRestante;

    /**
     * Establecerá el daño que inflinge Monstruos
     */
    private int dano;

    /**
     * Boolean que identifica si algún Monstruos es un jefe de zona.
     */
    private boolean jefe;

    /**
     * Evasion es la probabilidad de evitar el daño de un ataque.
     */
    private double evasion;

    /**
     * Crítico es la probabilidad de multiplicar x 2 el daño que infligirá el
     * ataque de Jugador
     */
    private double critico;

    /**
     * Establece el porcentaje de robo de salud tiene Jugador sobre la salud
     * restante de Jugador
     */
    private double roboSalud;
    
    /**
     * Constructor por defecto de la clase Monstruos recibirá todos los atributos de la clase Monstruos
     * menos la salud restante, que ha la hora de crear 
     * @param saludMax | Establecerá la salud máxima de Monstruos
     * @param dano | Establecerá el daño que inflinge Monstruos.
     * @param jefe | Boolean que identifica si Monstruos es un jefe de zona.
     * @param evasion | Evasion es la probabilidad de evitar el daño de un ataque.
     * @param critico | Crítico es la probabilidad de multiplicar x 2 el daño que infligirá el
     * ataque de Jugador
     * @param roboSalud | Establece el porcentaje de robo de salud tiene Jugador sobre la salud
     * restante de Jugador
     */
    public Monstruos(int saludMax, int dano, boolean jefe, double evasion, double critico, double roboSalud) {
        this.saludMax = saludMax;
        this.saludRestante = saludMax;
        this.dano = dano;
        this.jefe = jefe;
        this.evasion = evasion;
        this.critico = critico;
        this.roboSalud = roboSalud;
    }
    
    /**
     * Método toString que devuelve un String con los datos de Monstruos.
     * @return | Devulve un String con los datos de Monstruos.
     */
    @Override
    public String toString() {
        return "MONSTRUO" + "\nSALUD MÁXIMA:\t" + saludMax
                + "\nSALUD RESTANTE:\t" + saludRestante
                + "\nDAÑO:\t" + dano
                + "\nBOSS:\t" + jefe
                + "\n% DE EVASIÓN\t" + evasion
                + "\n% DE CRÍTICO:\t" + critico
                + "\n% DE ROBO DE VIDA:\t" + roboSalud;
    }
    
    /**
     * El método ataqueM apunta a un Jugador, se tendrá en cuenta
     * si el Jugador j puede esquivar, si Montruos ha realizado un golpe crítico,
     * @param j | Recibe por parámetro a el Jugador que apuntará el ataqueM().
     */
    public void ataqueM(Jugador j) {
        // Guardo el daño ya calculado en danoAplicable para usar esta variable
        // varias veces:
        int danoAplicable = (this.getDano() - j.getSaludRestante());
        // Si Jugador no puede esquivar...
        if (!j.puedeEsquivar()) {
            // Si hay impacto crítico...
            if (this.golpeCritico()) {
                j.setSaludRestante(danoAplicable * 2);
            } else {
                // Si no hay impacto crítico
                j.setSaludRestante(danoAplicable);
            }
            // Aplicar el robo de vida a SaludRestante de Monstruos
            this.setSaludRestante(Math.max(this.getSaludMax(), (int)(this.getRoboSalud() + 1)));
        }
        // Si Jugador esquiva el ataque no pasa nada.
    }

    /**
     * @return Devuelve un boolean que habilitará la evasión sobre el ataque del
     * Jugador
     */
    public boolean puedeEsquivar() {
        return (this.getEvasion() <= Math.round(Math.random()));
    }

    /**
     * @return Devuelve un boolean que habilitará el crítico en el daño del
     * ataque del Monstruos
     */
    public boolean golpeCritico() {
        return (this.getCritico() <= Math.round(Math.random()));
    }

    /*
     * GETTERS DE TODOS LOS ATRIBUTOS DE LA CLASE MONSTRUOS
     */
    public int getSaludMax() {
        return saludMax;
    }

    public int getSaludRestante() {
        return saludRestante;
    }

    public int getDano() {
        return dano;
    }

    public boolean isJefe() {
        return jefe;
    }

    public double getEvasion() {
        return evasion;
    }

    public double getCritico() {
        return critico;
    }

    public double getRoboSalud() {
        return roboSalud;
    }

    /*
     * SETTERS DE TODOS LOS ATRIBUTOS DE LA CLASE MONSTRUOS
     */
    public void setSaludMax(int saludMax) {
        this.saludMax = saludMax;
    }

    public void setSaludRestante(int saludRestante) {
        this.saludRestante = saludRestante;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public void setJefe(boolean jefe) {
        this.jefe = jefe;
    }

    public void setEvasion(double evasion) {
        this.evasion = evasion;
    }

    public void setCritico(double critico) {
        this.critico = critico;
    }

    public void setRoboSalud(double roboSalud) {
        this.roboSalud = roboSalud;
    }
}
