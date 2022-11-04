# Tareas del proyecto
Todos tienen que codumentar su codigo y dejar en el readme que es lo que hace su codigo, funciones, y claes
## Federico
### Movilidad del peon
## Enrique Chino
### Relacion de las vallas y peon
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
## Enrique Negro
### Movilidad de las vallas
