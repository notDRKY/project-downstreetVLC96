# DOWNSTREET VLC.96'
Proyecto downstreet, que tendrá 3 clases:

## CLASE JUGADOR
    Atributos de la clase jugador
        - `private static String[] clases = {...}` Guardará un número de Strings que serán las clases 
            disponibles. // Podría hacerse con herencia(?).
        - `private String nombre` Guaradará el nombre del jugador.
        - `private int salud` Será un entero que representará la salud del jugador.
        - `private int daño` Será un entero que representará el impacto en daño sobre los MONSTRUOS.
        - `private String clase` Será un String que coincidirá con alguno de los Strings de clases[] y determinará la **clase** del jugador.
    Métodos de la clase jugador
        Constructor


## CLASE PARTIDA
    Atributos de la clase partida
        - `private static final int DURACION` Determinará de la duración de la partida. NO PUEDE SER MAYOR QUE EL NÚMERO DE MAPAS 
            A NO SER QUE SE QUIERAN REPETIR
        - `private static String[] mapas = {...}` El array mapas[] contiene los mapas jugables en la Partida.

    Métodos de la clase jugador
        - `public static String mapaAleatorio()`
        - `public static void main(String[] args)`


## CLASE MONSTRUO
    Atributos de la clase monstruo
        - `private int salud`
        - `private int daño`
        - `private `
    Métodos de la clase monstruo
        Construtor

