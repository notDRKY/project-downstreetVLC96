# DOWNSTREET VLC.96'
Proyecto Downstreet, que tendrá 3 clases:

## CLASE JUGADOR
    ### Descripción: 
    Jugador será el Jugador de Downstreet, tendrá métodos para atacar y perfeccionar este ataque, 
    se entiende que por Partida sólo habrá un Jugador.

    ### Atributos de la clase Jugador
        private static String[] tipos: Array de String que incluye las clases.
        private String nombre: Nombre del jugador.
        private int saludMax: Determina la salud máxima del Jugador.
        private int saludRestante: Determina la salud ACTUAL del Jugador.
        private int dano: Indica el daño que hará Jugador a la saludRestante() de Monstruos.
        private double evasion: Indica la probabilidad de evasión que tiene Jugador.
        private double critico: Indica la probabilidad de evasión que tiene Jugador.
        private double roboSalud: Indica el porcentaje de robo de vida de Jugador.
        private int tipo: Entero para seleccionar la posición en el array tipos[].
        private pocionesRestantes: Indica las veces que Jugador podrá curarse.
        

    ### Métodos de la clase Jugador
        Getters y Setters correspondietes para cada atributo de la clase Jugador.
        Constructor de la clase Jugador: El constructor de Jugador tendrá diferentes configuraciones según el tipo (atributo) introducido.
        public String toString(); Devuelve un String con los datos del objeto Jugador.
        public int AtaqueJ(): Inflinge daño a la salud restante de Monstruos. Se tendrán en cuenta la probabilidad de crítico, robo de salud de Jugador y la probabilidad de esquivar de Monstruos.
        public boolean puedeEsquivar(): Devuelve un boolean si el objeto Jugador puede esquivar según su probabilidad de evasión.
        public boolean golpeCritico(): Devuelve un boolean si el objeto Jugador multiplica su daño por 2 en el ataqueJ().
        public int curacionJ(): Cuando saludRestante baje del 35% Jugador se curará un 40% si tiene pocionesRestantes disponibles.

## CLASE PARTIDA
    ### Descripción: 
    Partida es dónde se juega Downstreet, tendrá los mapas para jugar y enfrentará a Jugador con los Monstruos de cada zona.

    ### Atributos de la clase Partida
        private static final int DURACION: Determinará la duración de jugar();
        private static String[] mapas: Contiene un array de Strings con los mapas.
        private String mapa: Contiene el mapa actual.
        private Jugador j: Jugador con el que sé jugará en la clase Partida.
        private <Montruos>listaMonstruos<>(): Se necesita una lista de monstruos para cada "zona" o combate(), los Monstruos deberán ser cargados a través de un fichero.

    ### Métodos de la clase Partida
        Constructor de la clase Partida: Llamará a los métodos elecciónJugador() y mapaAleatorio().
        private void lecturaMonstruos(): Cargará los Monstruos de un fichero txt en los ArrayList (dependiendo de las zonas o niveles que se hayan creado).
        private Jugador eleccionJugador(): Lanzará un menú para crear a Jugador en la Partida, el usuario sólo introduce el nombre y el tipo(atributos de Jugador).
        private boolean seJuegaCartas(): Método que devuelve un boolean si se juega o no a las cartas.
        private boolean combate(Monstruos m): En combate hay que enfrentar a Jugador con los Monstruos y implementar el Juego de cartas a partir de el método seJuegaCartas
        este juego se sacarán dos cartas la primera será revelada, y la segunda el Jugador deverá adivinar si es menor o mayor que la primera.
        private void jugar(): Jugar se encarga de enfrentar a los Monstruos de las "zonas" contra jugador y comprobar que jugador no ha muerto por ninguna de estas zonas.
        private String mapaAleatorio(): Devuelve un String aleatorio del array mapas[].
        public static void main(String[] args): Main dónde se llamarán a los métodos necesarios para jugar.


## CLASE MONSTRUOS
    ### Descripción
    Clase hermana de Jugador, Monstruos también tiene métodos de ataque hacía Jugador y atributos que perfeccionan este.

    ### Atributos de la clase Monstruos
        private int saludMax: Determina la salud máxima del Monstruos.
        private int SaludRestante: Determina la salud ACTUAL del Monstruos.
        private int dano: Indica el daño que hará Monstruos a la saludRestante() de Jugador.
        private boolean jefe: Indica si el Mosntruos es un jefe o no.
        private double evasion: Indica la probabilidad de evasión que tiene Mosntruos.
        private double critico: Indica la probabilidad de evasión que tiene Mosntruos.
        private double roboSalud: Indica el porcentaje de robo de vida de Mosntruos.

    ### Métodos de la clase Monstruos
        Getters y Setters correspondietes para cada atributo de la clase Monstruo.
        Constructor de la clase Monstruos: Constructor por defecto para introducir todos los atributos de la clase.
        public String toString(): Devuelve un String con los datos del objeto Monstruos.
        public void ataqueM(Jugador j): Inflinge daño a la salud restante de Jugador. Se tendrán en cuenta la probabilidad de crítico, robo de salud de Monstruos y la probabilidad de esquivar de Jugador.
        public boolean puedeEsquivar(): Devuelve un boolean si el objeto Monstruos puede esquivar según su probabilidad de evasión.
        public boolean golpeCritico(): Devuelve un boolean si el objeto Monstruos multiplica su daño por 2 en el ataqueM().