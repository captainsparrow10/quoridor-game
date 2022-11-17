package estructura;

import java.util.ArrayList;

import javax.swing.JOptionPane;

//Clase peones
public class Pawn {
    String name;
    int color;
    String id;
    int idN;
    public int walls = 10;
    int counter = 0;
    // https://www.educba.com/2d-arraylist-in-java/
    ArrayList<ArrayList<Integer>> posiciones = new ArrayList<ArrayList<Integer>>();

    public Pawn(String name, String id, int px, int py, int color, int idN) {
        this.color = color;
        this.name = name;
        this.id = id;
        this.idN = idN;
        this.posiciones.add(new ArrayList<Integer>());
        this.posiciones.get(this.counter).add(0, px);
        this.posiciones.get(this.counter).add(1, py);
    }

    public void moveRight() {
        this.counter++;
        this.posiciones.add(new ArrayList<Integer>());
        this.posiciones.get(this.counter).add(0, posiciones.get(this.counter - 1).get(0));
        this.posiciones.get(this.counter).add(1, posiciones.get(this.counter - 1).get(1) + 2);  
    }

    public void moveLeft() {
        this.counter++;
        this.posiciones.add(new ArrayList<Integer>());
        this.posiciones.get(this.counter).add(0, posiciones.get(this.counter - 1).get(0));
        this.posiciones.get(this.counter).add(1, posiciones.get(this.counter - 1).get(1) - 2);    
    }

    public void moveUp() {
        this.counter++;
        this.posiciones.add(new ArrayList<Integer>());
        this.posiciones.get(this.counter).add(0, posiciones.get(this.counter - 1).get(0) - 2);
        this.posiciones.get(this.counter).add(1, posiciones.get(this.counter - 1).get(1));   
    }

    public void moveDown() {
        this.counter++;
        this.posiciones.add(new ArrayList<Integer>());
        this.posiciones.get(this.counter).add(0, posiciones.get(this.counter - 1).get(0) + 2);
        this.posiciones.get(this.counter).add(1, posiciones.get(this.counter - 1).get(1));   
    }

    // Función para obtener la posición del peón, para luego mostrarla.
    public int[] getPosition() {
        int posicion[] = { this.posiciones.get(this.counter).get(0), this.posiciones.get(this.counter).get(1) };
        return posicion;
    }

    public void obtenerHistorial(){
        String message = "";
        message += "Recorrido de " + this.name + "\n" + "Walls: " + this.walls + "\n";
        for(int i = 0; i < posiciones.size(); i++){
          message +=  "Turno número " + (i+1) + " de " + this.name + ":\n" + "X: " + posiciones.get(i).get(0) + "   Y: " + posiciones.get(i).get(1) + "\n";
        }
        JOptionPane.showMessageDialog(null, message, "a", 1);
        
        
    }

    // Funciones para obtener y actualizar la cantidad de walls del peón. (Jugador)
    public int getWalls() {
        return walls;
    }

    // Función para obtener y mostrar el id

    public String getId() {
        return this.id;
    }

    public int getIdN(){
        return this.idN;
    }

    public String getName() {
        return this.name;
    }

    public int getColor() {
        return this.color;
    }

}
