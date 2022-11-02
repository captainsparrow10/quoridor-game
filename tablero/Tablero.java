package tablero;

import java.util.Arrays;

public class Tablero {

  static String[][] tablero = new String[17][17];

  static public void llenartablero() {
    for (int i = 0; i < tablero.length; i++) {
      for (int j = 0; j < tablero.length; j++) {
          tablero[i][j] = " ";
      }
    }
  }

  static public void agregarPosicionPeon(int posicionX, int posicionY) {
    tablero[posicionX][posicionY] = "p";
    System.out.println(Arrays.deepToString(tablero).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
  }

  static public void agregarPosicionValla(int posicion1X, int posicion1Y, int posicion2X, int posicion2Y) {
    tablero[posicion1X][posicion1Y] = "valla";
    tablero[posicion2X][posicion2Y] = "valla";
    System.out.println(Arrays.deepToString(tablero));
  }
}
