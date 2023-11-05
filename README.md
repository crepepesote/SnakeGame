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

## Características del Juego
Las características del juego se describen a continuación:

### Puntuación
El juego implementa un sistema de puntuación que se actualiza cada vez que la serpiente consume un objeto de comida. La puntuación puede aumentar en función de la estrategia elegida; por ejemplo, se puede incrementar la puntuación en una unidad cada vez que la serpiente "come". Además, la comida puede tener un valor aleatorio, y la puntuación se incrementa según el valor de la comida. La puntuación se muestra en la pantalla del juego.

### Comida
El juego presenta un sistema de comida que aparece y desaparece a intervalos regulares en la pantalla. Si la serpiente come la comida, se genera inmediatamente un nuevo objeto de comida en el tablero del juego. En caso de que la serpiente no consuma la comida antes de que expire el tiempo, aparecerá una nueva comida en una ubicación diferente. Cada pieza de comida tiene una forma, imagen o figura distintiva de las barreras del juego, y al consumirla, la serpiente crece.

### Barreras
El juego incluye obstáculos que aparecen y desaparecen a intervalos de tiempo predefinidos. Si la serpiente colisiona con una barrera, el juego finaliza y se muestra un mensaje de "fin de juego" en la pantalla. Las barreras tienen una forma, imagen o figura distintiva de la comida del juego.

### Movimiento
El juego permite que la serpiente se mueva continuamente. Al inicio, la serpiente se mueve en una dirección específica (derecha, izquierda, arriba, abajo) y sigue moviéndose en esa dirección hasta que el jugador presione una tecla para cambiarla. Las teclas de flecha y las teclas w (arriba), s (abajo), d (izquierda) y a (derecha) permiten al jugador cambiar la dirección de la serpiente. Si la serpiente choca con una pared, reaparece en el lado opuesto de la misma. La serpiente tiene un tamaño inicial basado en el nivel del juego, y crece cada vez que come una pieza de comida. A medida que la serpiente crece, su velocidad aumenta según el nivel, lo que hace que sea más rápida. El incremento de velocidad se especifica en un archivo de configuración.

### Fin de Juego
El juego finaliza si la serpiente colisiona con un obstáculo o consigo misma. En ese caso, se muestra un mensaje de "YOU LOST" en la pantalla.

Este README proporciona una descripción general de las características y el funcionamiento del juego Snake. Puedes personalizar este documento y agregar cualquier otra información relevante o detalles específicos de tu proyecto.
