package downstreet;

/**
 *
 * @author Francesc Tàpia Martorell
 * @version dv-v2
 */
public class Jugador {

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

    /**
     * Establecerá el daño que inflinge Jugador
     */
    private int dano;

    /**
     * tipos[] contiene lis tipos de personajes que se pueden elegir para jugar,
     * cada uno tendrá unas características.
     */
    private static final String[] tipos = {"GUERRERO", "PÍCARO", "MAGO"};

    /**
     * tipo será un número entero que determinará el tipo Jugador en el array
     * tipos[].
     */
    private int tipo;

    /**
     * Pociones restantes es un número entero que no podrá ser negativo y
     * determina las pociones (veces que se podrá curar Jugador) restantes.
     */
    private int pocionesRestantes;

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
     * restante de Monstruo
     */
    private double roboSalud;

    /**
     * Constructor de la clase Jugador que recibirá dos parametros: 
     * @param nombre | Determina el nombre del Jugador
     * @param tipo | Determina el tipo de Jugador, según el tipo tendrá
     * unas estadisticas u otras.
     */
    public Jugador(String nombre, int tipo) {
        switch (tipo) {
            // GUERRERO
            case 0 -> {
                this.nombre = nombre;
                this.saludMax = 150;
                this.saludRestante = this.getSaludMax();
                this.dano = 35;
                this.tipo = tipo;
                this.pocionesRestantes = 3;
                this.evasion = 0.02;
                this.critico = 0.02;
                this.roboSalud = 0;
            }
            // PÍCARO
            case 1 -> {
                this.nombre = nombre;
                this.saludMax = 75;
                this.saludRestante = this.getSaludMax();
                this.dano = 40;
                this.tipo = tipo;
                this.pocionesRestantes = 3;
                this.evasion = 0.10;
                this.critico = 0.10;
                this.roboSalud = 0.05;
            }
            // MAGO
            case 2 -> {
                this.nombre = nombre;
                this.saludMax = 60;
                this.saludRestante = this.getSaludMax();
                this.dano = 50;
                this.tipo = tipo;
                this.pocionesRestantes = 3;
                this.evasion = 0;
                this.critico = 0.07;
                this.roboSalud = 0;
            }
        }
    }

    /**
     * Método toString que devuelve un String con los datos de Jugador.
     * @return | Devuelve un String con los datos de Jugador.
     */
    @Override
    public String toString() {
        return "JUGADOR" + "\nNOMBRE:\t\t" + nombre
                + "\nSALUD MÁXIMA:\t" + saludMax
                + "\nSALUD RESTANTE:\t" + saludRestante
                + "\nDAÑO:\t\t" + dano
                + "\nTIPO:\t\t" + tipos[tipo]
                + "\nPOCIONES RESTANTES:\t" + pocionesRestantes
                + "\n% DE EVASIÓN:\t" + evasion
                + "\n% DE CRÍTICO:\t\t" + critico
                + "\n% DE ROBO DE VIDA:\t" + roboSalud;
    }

    /**
     * El método ataqueJ apunta a un Monstruos determiando, se tendrá en cuenta
     * si el Monstruos m puede esquivar, si Jugador j ha realizado un golpe crítico,
     * Jugador al final del método deberá lanzar el método curarse().
     * @param m | Recibe por parámetro a el Monstruos que apuntará el ataqueJ().
     */
    public void ataqueJ(Monstruos m) {
        // Guardo el daño ya calculado en danoAplicable para usar esta variable
        // varias veces:
        int danoAplicable = (m.getSaludRestante() - this.getDano());
        // Si no puede esquivar...
        if (!m.puedeEsquivar()) {
            if (this.golpeCritico()) {
                m.setSaludRestante(danoAplicable * 2);
            } else {
                m.setSaludRestante(danoAplicable);
            }
            // Aplicar el robo de vida a SaludRestante de Monstruos
            this.setSaludRestante(Math.max(this.getSaludMax(), (int) (this.getRoboSalud() + 1)));
        }
        // Comprobamos si Jugador necesita curarse cada vez que haya atacado.
        this.curacionJ();
        // Si Monstruos esquiva el ataque no pasa nada.
    }

    /**
     * El método curacionJ() se activará cada vez que durante un combate y
     * mientras pocionesRestante sea > que 3, se curará a Jugador
     * automáticamente un 40% de la salud restante
     */
    public void curacionJ() {
        // Si saludRestante baja del 35%...
        if (this.getSaludRestante() < (this.getSaludMax() * 0.35)) {
            // Le sumaremos a la saludRestante de Jugador un 40% sobre esta misma.
            this.setSaludRestante((int) (this.getSaludRestante() * 1.4));
            // Ajustamos las pocionesRestantes de Jugador
            this.setPocionesRestantes(this.getPocionesRestantes() - 1);
        }
    }

    /**
     * @return Devuelve un boolean que habilitará la evasión sobre el ataque del
     * Monstruo
     */
    public boolean puedeEsquivar() {
        return (this.getEvasion() <= Math.round(Math.random()));
    }

    /**
     * @return Devuelve un boolean que habilitará el crítico en el daño del
     * ataque del Jugador
     */
    public boolean golpeCritico() {
        return (this.getCritico() <= Math.round(Math.random()));
    }

    /*
     * GETTERS DE TODOS LOS ATRIBUTOS DE LA CLASE JUGADOR
     */
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

    public static String[] getTipos() {
        return tipos;
    }

    public int getTipo() {
        return tipo;
    }

    public int getPocionesRestantes() {
        return pocionesRestantes;
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
     * SETTERS DE TODOS LOS ATRIBUTOS DE LA CLASE JUGADOR
     */
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

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setPocionesRestantes(int pocionesRestantes) {
        this.pocionesRestantes = pocionesRestantes;
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
