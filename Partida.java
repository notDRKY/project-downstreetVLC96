package downstreet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Francesc Tàpia Martorell
 * @version dv-v2
 */
public class Partida {

    /**
     * Determinará la duración de la partida. NO PUEDE SER MAYOR QUE EL NÚMERO
     * DE MAPAS A NO SER QUE SE QUIERAN REPETIR
     */
    private final int DURACION = 5;

    /**
     * El array mapas[] contiene los mapas jugables en la Partida.
     */
    private final String[] MAPAS_DISPONIBLES = {"EL CABAÑAL", "EL CARMEN", "LA FONTSANTA", "EL POLÍGONO", "EL METRO", "EL BARRIO CHINO"};

    /**
     * ArrayList dónde se almacenaran los Mosntruos de cada zona (un ArrayList por 
     * zona).
     */
    private ArrayList<Monstruos> listaMonstruos1 = new ArrayList<>();

    private ArrayList<Monstruos> listaMonstruos2 = new ArrayList<>();

    private ArrayList<Monstruos> listaMonstruos3 = new ArrayList<>();

    private ArrayList<Monstruos> listaMonstruos4 = new ArrayList<>();

    private ArrayList<Monstruos> listaMonstruos5 = new ArrayList<>();

    /**
     * Jugador de la Partida actual.
     */
    private Jugador jugador;

    /**
     * Mapa actual.
     */
    private String mapa;
    
    /*
     * Constructor Partida, no recibirá parámetros, y lanzará los métodos eleccionJugador()
     * (para asignar Jugador) y mapaAleatorio()(para asignar el mapa).
     */
    public Partida() {
        this.jugador = eleccionJugador();
        this.mapa = mapaAleatorio();
    }

    /**
     * lecturaMonstruos leerá un archivo de texto y cargará los datos en los ArrayList
     * de Monstruos (tantos cómo se tengan).
     */
    private void lecturaMonstruos() throws IOException {
        Scanner s = new Scanner("src/config.txt");
        int saludMaxM;
        double evasionM;
        int danoM;
        boolean esJefeM;
        double criticoM;
        double roboSaludM;

        try (FileReader fr = new FileReader("src/config.txt");
                BufferedReader br = new BufferedReader(fr)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                for (int i = 0; i < s.nextInt(); i++) {
                    saludMaxM = s.nextInt();
                    evasionM = s.nextDouble();
                    danoM = s.nextInt();
                    esJefeM = s.nextBoolean();
                    criticoM = s.nextDouble();
                    roboSaludM = s.nextDouble();

                    listaMonstruos1.add(new Monstruos(saludMaxM, danoM, esJefeM, evasionM, criticoM, roboSaludM));
                }
                for (int i = 0; i < s.nextInt(); i++) {
                    saludMaxM = s.nextInt();
                    evasionM = s.nextDouble();
                    danoM = s.nextInt();
                    esJefeM = s.nextBoolean();
                    criticoM = s.nextDouble();
                    roboSaludM = s.nextDouble();

                    listaMonstruos2.add(new Monstruos(saludMaxM, danoM, esJefeM, evasionM, criticoM, roboSaludM));
                }
                for (int i = 0; i < s.nextInt(); i++) {
                    saludMaxM = s.nextInt();
                    evasionM = s.nextDouble();
                    danoM = s.nextInt();
                    esJefeM = s.nextBoolean();
                    criticoM = s.nextDouble();
                    roboSaludM = s.nextDouble();

                    listaMonstruos3.add(new Monstruos(saludMaxM, danoM, esJefeM, evasionM, criticoM, roboSaludM));
                }
                for (int i = 0; i < s.nextInt(); i++) {
                    saludMaxM = s.nextInt();
                    evasionM = s.nextDouble();
                    danoM = s.nextInt();
                    esJefeM = s.nextBoolean();
                    criticoM = s.nextDouble();
                    roboSaludM = s.nextDouble();

                    listaMonstruos4.add(new Monstruos(saludMaxM, danoM, esJefeM, evasionM, criticoM, roboSaludM));
                }
                for (int i = 0; i < s.nextInt(); i++) {
                    saludMaxM = s.nextInt();
                    evasionM = s.nextDouble();
                    danoM = s.nextInt();
                    esJefeM = s.nextBoolean();
                    criticoM = s.nextDouble();
                    roboSaludM = s.nextDouble();

                    listaMonstruos5.add(new Monstruos(saludMaxM, danoM, esJefeM, evasionM, criticoM, roboSaludM));
                }
            }
        }
    }
    
    /**
     * eleccionJugador() lanza un mini menú donde se configurará el Jugador de 
     * la Partida.
     * @return | Devuelve el Jugador ya configurado.
     */
    private Jugador eleccionJugador() {
        Scanner teclado = new Scanner(System.in);
        String nombrePj;
        int tipoPj;
        System.out.println("CREACIÓN PJ");
        System.out.print("Nombre: ");
        nombrePj = teclado.nextLine();
        do {
            System.out.println("Clase:\n(0)GUERRERO\n(1)PÍCARO\n(2)MAGO");
            tipoPj = teclado.nextInt();
        } while (!(tipoPj >= 0 && tipoPj < 3));

        teclado.nextLine();

        Jugador j = new Jugador(nombrePj, tipoPj);
        System.out.println("TÚ PERSONAJE SERÁ: ");
        System.out.println(j.toString());
        return j;
    }
    
    /**
     * seJuegaCartas determina si se lanza el juego de cartas en el método
     * combate.
     * @return | Devuelve un boolean que determina si se lanza el juego de cartas en el método
     * combate.
     */
    private boolean seJuegaCartas() {
        return (0.05 <= Math.round(Math.random() + 1));
    }
    
    /**
     * combate() intercambia los ataques de Jugador y Monstruos hasta que la salud
     * de uno de los dos llegue a 0, también se tiene que llamar al método se juega
     * cartas para comprobar si se juega o no.
     * @return | Devuelve un boolean que indica si Jugador ha sido eliminado
     * o no.
     */
    private boolean combate(Monstruos m) {
        if (seJuegaCartas()) {
            Scanner teclado = new Scanner(System.in);
            String decision;
            int c1 = (int)Math.round(Math.random() + 1);
            int c2 = (int)Math.round(Math.random() + 1);
            System.out.println("SE JUEGA A LAS CARTAS");
            System.out.println("La primera carta es: " + c1);
            System.out.println("La segunda carta será mayor o menor?");
            decision = teclado.nextLine();
            if (decision.equals("mayor") && c2 > c1) {
                return true;
            } else return decision.equals("menor") && c2 < c1;
        } else {
            while (jugador.getSaludRestante() > 0 && m.getSaludRestante() > 0) {
                jugador.ataqueJ(m);
                m.ataqueM(jugador);
            }
            return jugador.getSaludRestante() >= 0;
        }
    }
    
    /**
     * jugar() tendrá las "zonas" (arraylist) de la Partida y llamará al método
     * combate para enfrentar a Jugador contra los Mosntruos de cada zona,
     * para controlar que jugar sigue en pie, se usa el boolean siguesVivo
     * que será = llamar a combate(arraylistX.get()). Se deberá lanzar el método
     * que carga los Monstruos en los arraylist lecturaMonstruos().
     */
    private void jugar() {
        boolean siguesVivo = true;
        while (siguesVivo) {
            try {
                lecturaMonstruos();
            } catch (IOException ex) {
                System.out.println("¡ERROR EN LA LECTURA DE MONSTRUOS!");
            }
            for (int i = 0; i < listaMonstruos1.size(); i++) {
                this.mapa = mapaAleatorio();
                System.out.println("ESTAS EN: " + this.mapa);
                siguesVivo = combate(listaMonstruos1.get(i));
            }
            for (int i = 0; i < listaMonstruos2.size(); i++) {
                this.mapa = mapaAleatorio();
                System.out.println("ESTAS EN: " + this.mapa);
                siguesVivo = combate(listaMonstruos2.get(i));
            }
            for (int i = 0; i < listaMonstruos3.size(); i++) {
                this.mapa = mapaAleatorio();
                System.out.println("ESTAS EN: " + this.mapa);
                siguesVivo = combate(listaMonstruos3.get(i));
            }
            for (int i = 0; i < listaMonstruos4.size(); i++) {
                this.mapa = mapaAleatorio();
                System.out.println("ESTAS EN: " + this.mapa);
                siguesVivo = combate(listaMonstruos4.get(i));
            }
            for (int i = 0; i < listaMonstruos5.size(); i++) {
                this.mapa = mapaAleatorio();
                System.out.println("ESTAS EN: " + this.mapa);
                siguesVivo = combate(listaMonstruos5.get(i));
            }
            //siguesvivo = llamar a combate(arraylist1.get())
            // se carga array list 2
            // se recorre el array list 2
            //lamar a combate(arraylist2.get())
        }
    }

    /**
     * Devuelve un String aleatorio del array mapas.
     */
    private String mapaAleatorio() {
        return MAPAS_DISPONIBLES[(int) Math.round(Math.random() * (MAPAS_DISPONIBLES.length - 1))];
    }
    
    public static void main(String[] args) {
        Partida p1 = new Partida();
        p1.jugar();
    }
}
