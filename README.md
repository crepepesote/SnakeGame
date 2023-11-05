# Snake Game

## Información de Desarrollador
- **Nombre:** Luis Alfonso Rojas Martinez
- **Código:** 202213325
- **Universidad:** Universidad Pedagogica y Tecnologica de Colombia 
- **Facultad:** Escuela de Ingeniería de Sistemas
- **Año:** 2023
- **Curso:** Programación III

## Descripción
El juego Snake es un juego de video de estilo arcade en el que el jugador controla una serpiente que se mueve por un tablero o pantalla de juego. El objetivo del juego es comer los objetos de comida que aparecen en la pantalla, lo que hace que la serpiente crezca. Sin embargo, el jugador debe evitar chocar con la propia cola de la serpiente o con los obstáculos del juego. El juego se vuelve más desafiante, ya que requiere maniobras cuidadosas para evitar colisiones consigo misma. El juego continúa hasta que la serpiente se topa con un obstáculo o consigo misma.

## Características
Las características del juego son las siguientes:

### Puntuación
Debes crear un hilo para administrar la puntuación del juego. La puntuación debe actualizarse cada vez que la serpiente consuma un objeto de comida. Puedes elegir la estrategia más adecuada para aumentar la puntuación; por ejemplo, puedes incrementar la puntuación en una unidad cada vez que la serpiente "coma". Por otro lado, la comida debe tener un valor aleatorio; en este caso, la puntuación debe aumentar de acuerdo con el valor de la comida. Finalmente, la puntuación debe mostrarse en la pantalla del juego.

Nota: La estrategia debe definirse en el archivo README.md del proyecto. Si no se define, se aplicará una deducción de 0.3 puntos a la calificación del taller.

### Comida
Debes crear un hilo para mostrar la comida en la pantalla del juego. Debe aparecer y desaparecer a intervalos regulares. Si la serpiente la come, un nuevo objeto de comida debe aparecer de inmediato en el tablero del juego. Sin embargo, si la serpiente no la consume antes de que expire el tiempo, un nuevo objeto de comida debe aparecer en una ubicación diferente. La comida debe tener una forma, imagen o figura distintiva de las barreras del juego, y cada vez que la serpiente come una pieza de comida, debe crecer.

Nota: El tiempo para el intervalo de la comida debe definirse en un archivo de configuración (archivo txt), y esto depende de la etiqueta. Puedes elegir la estrategia más adecuada según los niveles del juego, que se describirán en otra sección de este documento. Si el tiempo no se lee a través del archivo de configuración, se aplicará una deducción de 0.5 puntos a la calificación del taller.

### Barreras
Debes crear un hilo para gestionar los obstáculos del juego. Las barreras deben aparecer y desaparecer a intervalos de tiempo predefinidos. Si la serpiente se topa con una de ellas, el juego debe terminar y en la pantalla debe aparecer un mensaje de "fin de juego". Finalmente, los obstáculos deben tener una forma, imagen o figura distintiva de la comida del juego.

Nota: El intervalo de tiempo para las barreras debe definirse en un archivo de configuración (archivo txt), y esto depende de la etiqueta. Puedes elegir la estrategia más adecuada según los niveles del juego, que se describirán en otra sección de este documento. Es importante que el intervalo de tiempo sea diferente al de la comida. Si el intervalo de tiempo no se especifica en el archivo de configuración, se aplicará una deducción de 0.5 puntos a la calificación del taller.

### Movimiento
Debes crear un hilo que permita que la serpiente se mueva continuamente. Cuando el juego comienza, la serpiente debe tener una dirección (derecha, izquierda, arriba, abajo) y debe moverse continuamente en esa dirección hasta que el jugador presione una tecla y cambie esa dirección.
- Si el jugador presiona la flecha hacia arriba, la serpiente debe cambiar su dirección hacia arriba.
- Si el jugador presiona la flecha hacia abajo, la serpiente debe cambiar su dirección hacia abajo.
- Si el jugador presiona la flecha hacia la izquierda, la serpiente debe cambiar su dirección hacia la izquierda.
- Si el jugador presiona la flecha hacia la derecha, la serpiente debe cambiar su dirección hacia la derecha.
- Si el jugador presiona una tecla de flecha y la serpiente ya se está moviendo en esa dirección, no debe ocurrir nada.
- También debes configurar las teclas w (arriba), s (abajo), d (izquierda) y a (derecha).
- Si la serpiente se topa con una pared, debe reaparecer en el lado opuesto de la pared.
- Cuando el juego comienza, la serpiente debe tener un tamaño inicial basado en el nivel, y cada vez que la serpiente come una pieza de comida, debe crecer.
- A medida que la serpiente crece, su velocidad debe aumentar según el nivel. En pocas palabras, cuanto más grande sea la serpiente, más rápida será, y la tasa de aumento debe especificarse en el archivo de configuración. Por otro lado, puedes elegir la estrategia más adecuada para determinar la frecuencia de aumentos de velocidad.
- Si la serpiente se topa con un obstáculo o consigo misma, el juego debe terminar y debe aparecer un mensaje de "fin de juego" en la pantalla para mostrar la puntuación. Además, el nombre de usuario y la puntuación deben guardarse en un archivo serializado.
