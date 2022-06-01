package downstreet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Francesc Tàpia Martorell
 * @version dv-v3.2
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
     * ArrayList dónde se almacenaran los Mosntruos de cada zona (un ArrayList
     * por zona).
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
     * Constructor Partida, no recibirá parámetros, y lanzará los métodos
     * eleccionJugador() (para asignar Jugador) y mapaAleatorio()(para asignar
     * el mapa).
     */
    public Partida() {
        this.jugador = eleccionJugador();
        this.mapa = mapaAleatorio();
    }

    /**
     * lecturaMonstruos leerá un archivo de texto y cargará los datos en los
     * ArrayList de Monstruos (tantos cómo se tengan).
     */
    private void lecturaMonstruos() throws IOException {
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
                for (int i = 0; i < Integer.valueOf(linea); i++) {
                    String[] datos = br.readLine().split(" ");
                    saludMaxM = Integer.valueOf(datos[0]);
                    evasionM = Double.valueOf(datos[1]);
                    danoM = Integer.valueOf(datos[2]);
                    esJefeM = Boolean.valueOf(datos[3]);
                    criticoM = Double.valueOf(datos[4]);
                    roboSaludM = Double.valueOf(datos[5]);

                    listaMonstruos1.add(new Monstruos(saludMaxM, danoM, esJefeM,
                            evasionM, criticoM, roboSaludM));
                }
                linea = br.readLine();
                for (int i = 0; i < Integer.valueOf(linea); i++) {
                    String[] datos = br.readLine().split(" ");
                    saludMaxM = Integer.valueOf(datos[0]);
                    evasionM = Double.valueOf(datos[1]);
                    danoM = Integer.valueOf(datos[2]);
                    esJefeM = Boolean.valueOf(datos[3]);
                    criticoM = Double.valueOf(datos[4]);
                    roboSaludM = Double.valueOf(datos[5]);

                    listaMonstruos2.add(new Monstruos(saludMaxM, danoM, esJefeM,
                            evasionM, criticoM, roboSaludM));
                }
                linea = br.readLine();
                for (int i = 0; i < Integer.valueOf(linea); i++) {
                    String[] datos = br.readLine().split(" ");
                    saludMaxM = Integer.valueOf(datos[0]);
                    evasionM = Double.valueOf(datos[1]);
                    danoM = Integer.valueOf(datos[2]);
                    esJefeM = Boolean.valueOf(datos[3]);
                    criticoM = Double.valueOf(datos[4]);
                    roboSaludM = Double.valueOf(datos[5]);

                    listaMonstruos3.add(new Monstruos(saludMaxM, danoM, esJefeM,
                            evasionM, criticoM, roboSaludM));
                }
                linea = br.readLine();
                for (int i = 0; i < Integer.valueOf(linea); i++) {
                    String[] datos = br.readLine().split(" ");
                    saludMaxM = Integer.valueOf(datos[0]);
                    evasionM = Double.valueOf(datos[1]);
                    danoM = Integer.valueOf(datos[2]);
                    esJefeM = Boolean.valueOf(datos[3]);
                    criticoM = Double.valueOf(datos[4]);
                    roboSaludM = Double.valueOf(datos[5]);

                    listaMonstruos4.add(new Monstruos(saludMaxM, danoM, esJefeM,
                            evasionM, criticoM, roboSaludM));
                }
                linea = br.readLine();
                for (int i = 0; i < Integer.valueOf(linea); i++) {
                    String[] datos = br.readLine().split(" ");
                    saludMaxM = Integer.valueOf(datos[0]);
                    evasionM = Double.valueOf(datos[1]);
                    danoM = Integer.valueOf(datos[2]);
                    esJefeM = Boolean.valueOf(datos[3]);
                    criticoM = Double.valueOf(datos[4]);
                    roboSaludM = Double.valueOf(datos[5]);

                    listaMonstruos5.add(new Monstruos(saludMaxM, danoM, esJefeM,
                            evasionM, criticoM, roboSaludM));
                }
            }
        }
    }

    /**
     * eleccionJugador() lanza un mini menú donde se configurará el Jugador de
     * la Partida.
     *
     * @return | Devuelve el Jugador ya configurado.
     */
    private Jugador eleccionJugador() {
        Scanner teclado = new Scanner(System.in);
        String nombrePj;
        int tipoPj;
        System.out.println("CREACIÓN PJ");
        System.out.print("NOMBRE: ");
        nombrePj = teclado.nextLine();
        do {
            System.out.println("CLASES:\n[0] -> GUERRERO\n[1] -> PÍCARO\n[2] -> MAGO");
            tipoPj = teclado.nextInt();
        } while (!(tipoPj >= 0 && tipoPj < 3));

        //teclado.nextLine();
        Jugador j = new Jugador(nombrePj, tipoPj);
        System.out.println("TÚ PERSONAJE SERÁ: ");
        System.out.println(j.toString());
        return j;
    }

    /**
     * seJuegaCartas determina si se lanza el juego de cartas en el método
     * combate.
     *
     * @return | Devuelve un boolean que determina si se lanza el juego de
     * cartas en el método combate.
     */
    private boolean seJuegaCartas() {
        // 25% de probabilidad
        return 25 > (Math.random() * 100) + 1;
    }

    /**
     * combate() intercambia los ataques de Jugador y Monstruos hasta que la
     * salud de uno de los dos llegue a 0, también se tiene que llamar al método
     * se juega cartas para comprobar si se juega o no.
     *
     * @return | Devuelve un boolean que indica si Jugador ha sido eliminado o
     * no.
     */
    private boolean combate(Monstruos m) {
        if (seJuegaCartas()) {
            Scanner teclado = new Scanner(System.in);
            String decision;
            int c1 = (int) Math.round(Math.random() * 10) + 1;
            System.out.println("¡SE JUEGA A LAS CARTAS!");
            System.out.println("  La primera carta es un: " + c1);
            System.out.print("  La segunda carta será mayor o menor? ");
            int c2 = (int) Math.round(Math.random() * 10) + 1;

            decision = teclado.nextLine();
            if (decision.trim().toLowerCase().equals("mayor") && c2 > c1) {
                System.out.println("  Correcto! La carta era: " + c2);
                return true;
            } else if (decision.trim().toLowerCase().equals("menor") && c2 < c1) {
                System.out.println("  Correcto! La carta era: " + c2);
                return true;
            } else {
                System.out.println("  Incorrecto! La carta era: " + c2);
                /*
                 * Si comentamos este return cuando Jugador falle en el
                 * juego de cartas, se ejecutará el while de más abajo
                 * que es justo lo que queremos.
                 */
                return false;
            }
        }
        while (jugador.getSaludRestante() > 0 && m.getSaludRestante() > 0) {
            System.out.println("  ---TURNO JUGADOR---");
            jugador.ataqueJ(m);
            if (m.getSaludRestante() > 0) {
                System.out.println("  ---TURNO MONSTRUO---");
                m.ataqueM(jugador);
            }
        }
        return (jugador.getSaludRestante() > 0);
    }

    /**
     * jugar() tendrá las "zonas" (arraylist) de la Partida y llamará al método
     * combate para enfrentar a Jugador contra los Mosntruos de cada zona, para
     * controlar que jugar sigue en pie, se usa el boolean siguesVivo que será =
     * llamar a combate(arraylistX.get()). Se deberá lanzar el método que carga
     * los Monstruos en los arraylist lecturaMonstruos().
     */
    private void jugar() {
        Scanner teclado = new Scanner(System.in);
        boolean siguesVivo = true;
        //while (siguesVivo) {
        try {
            lecturaMonstruos();
        } catch (IOException ex) {
            System.out.println("¡ERROR EN LA LECTURA DE MONSTRUOS (Fichero config.txt)!");
        }
        System.out.println("[ZONA 1] ESTAS EN: " + mapaAleatorio() + " ¡han aparecido " + listaMonstruos1.size() + " monstruos!");
        for (int i = 0; siguesVivo && i < listaMonstruos1.size(); i++) {
            siguesVivo = combate(listaMonstruos1.get(i));
            System.out.println(" -> PULSA ENTER PARA CONTINUAR <- ");
            teclado.nextLine();
        }
        System.out.println("[ZONA 2] ESTAS EN: " + mapaAleatorio() + " ¡han aparecido " + listaMonstruos2.size() + " monstruos!");
        for (int i = 0; siguesVivo && i < listaMonstruos2.size(); i++) {
            siguesVivo = combate(listaMonstruos2.get(i));
            System.out.println(" -> PULSA ENTER PARA CONTINUAR <- ");
            teclado.nextLine();
        }
        System.out.println("[ZONA 3] ESTAS EN: " + mapaAleatorio() + " ¡han aparecido " + listaMonstruos3.size() + " monstruos!");
        for (int i = 0; siguesVivo && i < listaMonstruos3.size(); i++) {
            siguesVivo = combate(listaMonstruos3.get(i));
            System.out.println(" -> PULSA ENTER PARA CONTINUAR <- ");
            teclado.nextLine();
        }
        System.out.println("[ZONA 4] ESTAS EN: " + mapaAleatorio() + " ¡han aparecido " + listaMonstruos4.size() + " monstruos!");
        for (int i = 0; siguesVivo && i < listaMonstruos4.size(); i++) {
            siguesVivo = combate(listaMonstruos4.get(i));
            System.out.println(" -> PULSA ENTER PARA CONTINUAR <- ");
            teclado.nextLine();
        }
        System.out.println("[ZONA 5] ESTAS EN: " + mapaAleatorio() + " ¡han aparecido " + listaMonstruos5.size() + " monstruos!");
        for (int i = 0; siguesVivo && i < listaMonstruos5.size(); i++) {
            siguesVivo = combate(listaMonstruos5.get(i));
            System.out.println(" -> PULSA ENTER PARA CONTINUAR <- ");
            teclado.nextLine();
        }
        //siguesvivo = llamar a combate(arraylist1.get())
        // se carga array list 2
        // se recorre el array list 2
        //lamar a combate(arraylist2.get())
    }
    //}

    /**
     * Devuelve un String aleatorio del array mapas.
     */
    private String mapaAleatorio() {
        return MAPAS_DISPONIBLES[(int) Math.round(
                Math.random() * (MAPAS_DISPONIBLES.length - 1))];
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String candado = "";
        do {
            Partida p1 = new Partida();
            p1.jugar();
            System.out.print("¿Quieres volver a jugar? [S / N] ");
            candado = teclado.nextLine();
        } while (candado.trim().toLowerCase().equals("s"));
    }
}
