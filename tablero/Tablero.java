package tablero;

import java.util.Arrays;

public class Tablero {

  public String[][] tablero = new String[17][17];

  public void llenartablero() {
    System.out.println(0+" "+1+" "+2+" "+3+" "+5+" "+6+" "+7+" "+8+" "+9);//coordenadas x
    for (int i = 0; i < tablero.length; i++) {
       System.out.print(i+" "); //coordenadas y
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

  public void agregarPosicionPeon(int posicionX, int posicionY) {
    tablero[posicionX][posicionY] = "p";
    System.out.println(Arrays.deepToString(tablero).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
  }

  public void agregarPosicionValla(int posicion1X, int posicion1Y, int posicion2X, int posicion2Y) {
    tablero[posicion1X][posicion1Y] = "v";
    tablero[posicion2X][posicion2Y] = "v";
    System.out.println(Arrays.deepToString(tablero));
  }

  public void mostrarTablero(){
    System.out.println(Arrays.deepToString(tablero).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
  }


}
