# Tareas del proyecto
Todos tienen que codumentar su codigo y dejar en el readme que es lo que hace su codigo, funciones, y claes
# Tarea 1
## Federico
### Movilidad del peon
## Enrique Chino
### Relacion de las vallas y peon
<<<<<<< HEAD
#### Actualizacion #1
Se crearon las reglas basicas del juego, en donde el peon no se puede mover en x direccion cuando hay un muro/valla ocupando dicho espacio y lo de cuando hay un jugador adelante de el.
En el codigo se creo un prototipo del juego, en donde el tablero tendria dimensiones 4x4, el peon y el muro prediseñados.
El codigo tiene problemas de optimizacion ya que se hizo sin clases y por la falta de conocimiento/experiencia de la persona

##### Explicacion
El prototipo del juego es de la linea 8 al 134, en donde se establecieron los siguiente
0 = terreno de la tabla
1 = muros/vallas
9 = peon controlado por jugador
8 = peon estatico
89 = peon controlado por el jugador y peon estatico en el mismo lugar

Instruccion para saber si habia algun muro en la direccion que iba el peon jugador
![Muro en el camino](/readmeJugabilidad/jugabilidadMuro.png)
Aca se realiza una condicion para saber si el lugar del siguiente movimiento esta siendo ocupado por un muro (1), en dicho caso daria un mensaje de error de jugada
Instruccion para saber si habia algun peon en la direccion que iba el peon jugador
![Peon en el camino](/readmeJugabilidad/jugabilidadPeonCamino.png)
Aca se realizaba una condicion para saber si el lugar del siguiente movimiento esta siendo ocupado por un peon estatico o en caso de una partida de dos jugadores otro peon (8), en dicho caso los peones quedarian juntos hasta el siguiente movimiento
Instruccion para saber si el peon jugador y el peon estatico estaban en el mismo lugar
![Peones juntos](/readmeJugabilidad/jugabilidadPeonSeparacion.png)
Aca se realizaba una condicion si habian dos peones en el mismo lugar (89) y si ese era el caso, el peon del jugador iria al siguiente movimiento y el lugar en el que estaban ambos seria sustituido por otro valor, la cual seria 8 o el peon que no se movio de dicho lugar
=======

>>>>>>> 8f71fe7f1613ac2f93d270cac286e898bc20c868
## Enrique Negro
### Relación clase peón - vallas.

#### Actualización #1.

Se realizó la actualización de la clase peón hecha mediante el prototipo realizado por Enrique, de manera en la que quedó mucho más detallada y claro el funcionamiento de la movilidad del peón, como podrán observar posteriormente:

##### Prototipo
[Prototipo](imagenes/img-readme/quoridor3.png)

Este fue el primero prototipo realizado, el cual acumulaba todas las clases en un mismo archivo además de las comprobaciones.

#### Actualización #1.

[Act1](imagenes/img-readme/quoridor1.png)
[Act1.1](imagenes/img-readme/quoridor2.png)

Aquí se realizó una clase concreta para el peón, el cuál consta de sus atributos que lo identifican, y además sus funciones claves para su movilidad, los cuales son:
* Moverse hacia arriba.
* Moverse hacia abajo.
* Moverse hacia la derecha.
* Moverse hacia la izquierda

Además de otras funciones para poner interactuar con la posición y sus walls.


#### Actualización #2.

Se añadió la clase anterior (Peón) a el archivo main del proyecto, donde se realizó un prototipo de cómo sería el funcionamiento del juego simplemente con el movimiento del peón.

[Act2](imagenes/img-readme/quoridor4.png)

Aquí iniciamos a cada uno de los jugadores con su posición inicial, nombre, y identificador dentro del tablero, además del la inicialización del tablero.

[Act2.1](imagenes/img-readme/quoridor5.png)

Realizamos el algoritmo para turnar a cada uno de los jugadores.

[Act2.2](imagenes/img-readme/quoridor6.png)

Se realiza la comprobación de preguntarle a el jugador si desea mover o colocar un muro, luego en caso de que eliga mover el peón, le preguntamos en qué dirección de sea, luego se hace una comprobación en caso de que no haya muro (Algoritmo que todavía no se ha realizado) y en caso de que no haya muro, se procede a actualizar la posición del peón (atributos del peón) y su posición en el tablero.


# Tarea 2
No borren ni su nombre ni su tarea, solo borraran lo que les escribi que deben hacer a la hora de documentar, use el ejemplo de Enrique negro para documentar su parte. Documenten su codigo
## Federico
### Movilidad del peon
Quiero que el peon tome la posicion inical en el centro del tablero, se la puedes declarar y cada vez que el usuario ingrese una nueva posicion del peon que sea valida en el tablero, lo almacenes en un arreglo y cuando te quieras mover uses la ultima posicion
## Enrique Chino
### Tablero
Debes rellenar el tablero con X donde van las Vallas y hacer que el peon tenga una posicion inical en el centro en ambos lado 
## Enrique Negro
### Crer un menu
Crea el menu del juego solamente 