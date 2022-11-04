package movement;
    //Clase peones
public class Pawn {
    String name;
    String id;
    int[][]position;
    // Arreglo que almacena el recorrido 
    /* 
     * Asi se almacena un arreglo de dos dimenciones donde van extrar la ultima posicion
     * Y usaran eso para moverse en posiciones cardinales
     */

    //Constructor para colocarle un nombre a el peón (Jugador) al declarar el objeto.
    public Pawn(String name, String id){
        this.name = name;
        this.id = id;
    }
}
