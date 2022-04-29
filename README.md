Project's name: DOWNSTREET VLC.96' ©

Short description:
Ambientado en los barrios bajos de VLC, te pones en la piel de un aventurero que recorre estos barrios con todos los peligros que eso representa.

El "videojuego" constará de una serie de niveles, dónde el jugador se enfrentará contra los mismísimos mostros que se le aparecerán en VLC a las 3AM; tendrá que superar todos los niveles para llegar a casa. 

Technical remarks:
Clase JUGADOR que será el propio usuario, en la cúal quedarán plasmados atributos de este. (salud, daño, probabilidad de esquivar...).
Una clase con el método main, en la cúal se "jugará"; en un principio sería un bucle con un duración determinada por una constante y en cada pasada se incrementarán las estadisticas de los enemigos (en un principio será un enemigo por pasada, si no será muy complicado). También tengo pensado generar un array (con la longitud de niveles) donde se guardará la puntuación del usuario en cada nivel (teniendo en cuenta el porcentaje de su salud únicamente) y el contenido de este se escribiría en un archivo de texto.
Clase ENEMIGO dónde se determinarán las propias estadisticas de los enemigos, se me ocurre que podria tener herencias para diferentes clases de enemigos (but no creo que sea capaz de programarlo).
