# Tareas del proyecto
Todos tienen que codumentar su codigo y dejar en el readme que es lo que hace su codigo, funciones, y claes
## Federico
### Movilidad del peon
## Enrique Chino
### Relacion de las vallas y peon

## Relación clase peón - vayas.

### Actualización #1.

Se realizó la actualización de la clase peón hecha mediante el prototipo realizado por Enrique, de manera en la que quedó mucho más detallada y claro el funcionamiento de la movilidad del peón, como podrán observar posteriormente:

### Prototipo
[Prototipo](imagenes/img-readme/quoridor3.png)

Este fue el primero prototipo realizado, el cual acumulaba todas las clases en un mismo archivo además de las comprobaciones.

### Actualización #1.

[Act1](imagenes/img-readme/quoridor1.png)
[Act1.1](imagenes/img-readme/quoridor2.png)

Aquí se realizó una clase concreta para el peón, el cuál consta de sus atributos que lo identifican, y además sus funciones claves para su movilidad, los cuales son:
* Moverse hacia arriba.
* Moverse hacia abajo.
* Moverse hacia la derecha.
* Moverse hacia la izquierda

Además de otras funciones para poner interactuar con la posición y sus walls.


### Actualización #2.

Se añadió la clase anterior (Peón) a el archivo main del proyecto, donde se realizó un prototipo de cómo sería el funcionamiento del juego simplemente con el movimiento del peón.

[Act2](imagenes/img-readme/quoridor4.png)

Aquí iniciamos a cada uno de los jugadores con su posición inicial, nombre, y identificador dentro del tablero, además del la inicialización del tablero.

[Act2.1](imagenes/img-readme/quoridor5.png)

Realizamos el algoritmo para turnar a cada uno de los jugadores.

[Act2.2](imagenes/img-readme/quoridor6.png)

Se realiza la comprobación de preguntarle a el jugador si desea mover o colocar un muro, luego en caso de que eliga mover el peón, le preguntamos en qué dirección de sea, luego se hace una comprobación en caso de que no haya muro (Algoritmo que todavía no se ha realizado) y en caso de que no haya muro, se procede a actualizar la posición del peón (atributos del peón) y su posición en el tablero.

