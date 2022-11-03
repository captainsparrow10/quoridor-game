package movement;
    //Clase peones
public class Pawn {
    String name;
    String id;
    int walls = 10;
    int[] position = new int[2];

    //Constructor para colocarle un nombre a el peón (Jugador) al declarar el objeto.
    public Pawn(String name, String id){
        this.name = name;
        this.id = id;
    }

    //Funciones para actualizar la posición del peón
    public void moveUp(){
        this.position[1] += 2;
    }

    public void moveDown(){
        this.position[1] -= 2;
    }

    public void moveLeft(){
        this.position[0] -= 2;
    }

    public void moveRight(){
        this.position[0] += 2;
    }

    // Función para obtener la posición del peón, para luego mostrarla.
    public int[] getPosition(){
        return position;
    }

    // Función para actualizar la posición del peón luego de moverse.

    public void setPosition(int newPositionX, int newPositionY) {
        this.position[0] = newPositionX;
        this.position[1] = newPositionY;
    }

    //Funciones para obtener y actualizar la cantidad de walls del peón. (Jugador)

    public int getWalls() {
        return walls;
    }

    public void setWalls(int newWalls) {
        this.walls = newWalls;
    }

    //Función para obtener y mostrar el id

    public String getId(){
        return this.id;
    }

}
