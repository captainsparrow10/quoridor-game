package tablero;
import java.util.Arrays;

public class Tablero2 {

  public String[][] tablero = new String[17][17];


  public void llenartablero() {
    // Coordenadas en Y
    System.out.println("   "+1+"     "+2+"     "+3+"     "+4+"     "+5+"     "+6+"     "+7+"     "+8+"     "+9);
    for (int i = 0; i < tablero.length; i++) {  
      for (int j = 0; j < tablero.length; j++) {
        if(i != 0 && i%2 != 0) {
          tablero[i][j] = "x";
        }else {
          if(j != 0 && j%2 != 0){
            tablero[i][j] = "x";
          }else {
            tablero[i][j] = " ";
          }
          
        }
      }
    }
    }

  //Función para agregar actualizar la posición del peón en el tablero.

  public void agregarPosicionPeon(int posicionX, int posicionY, String id) {
    tablero[posicionX][posicionY] = id;
    this.mostrarTablero();
  }

  //Función para agregar una valla en el tablero.

  public void agregarPosicionValla(int posicion1X, int posicion1Y, int posicion2X, int posicion2Y) {
    tablero[posicion1X][posicion1Y] = "v";
    tablero[posicion2X][posicion2Y] = "v";
    this.mostrarTablero();
    
  }

  //Función para mostrar el tablero en pantalla.

  public void mostrarTablero(){
    int counter =1;
    for(int i=0;i<tablero.length; i++){
        if(i%2==0){
            //Coordenadas en X
            System.out.print(counter+ " ");
            counter++;
        }else{
            System.out.print("  ");
        }
        for(int j=0;j<tablero.length; j++){
        System.out.print("["+tablero[i][j]+"]");
    } 
    System.out.println("\t");
  }


}
}
