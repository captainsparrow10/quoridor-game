package consola.estructura;

import java.awt.Color;

import consola.tablero.TableroGUI;

//Clase walls
public class Wall {

    public Boolean colocarVallaHorizontal(int x, int y1, int y2, String[][] tablero, int walls, TableroGUI table2) {
        if (walls > 0) {
            if (tablero[x][y1 - 1] == "x" && tablero[x][y2] == "x" && tablero[x][y1] == "x") {
                tablero[x][y1] = "v";
                tablero[x][y2] = "v";
                tablero[x][y2 - 1] = "v";

                table2.boxes[x][y1].setBackground(Color.yellow);
                table2.boxes[x][y2].setBackground(Color.yellow);
                System.out.println("Vaya colocada correctamente.");
                return true;
            } else {
                System.out.println("Usted no puede colocar una valla aqui.");
                return false;
            }
        } else {
            System.out.println("Usted no cuenta con mas vallas.");
            return false;
        }
    }

    public Boolean colocarVallaVertical(int y, int x1, int x2, String[][] tablero, int walls, TableroGUI table2) {
        if (walls > 0) {
            if (tablero[x1 + 1][y] != "x" && tablero[x2][y] == "x" && tablero[x1][y] == "x") {
                tablero[x1][y] = "v";
                tablero[x1 + 1][y] = "v";
                tablero[x2][y] = "v";
                table2.boxes[x1][y].setBackground(Color.yellow);
                table2.boxes[x1+1][y].setBackground(Color.yellow);
                table2.boxes[x2][y].setBackground(Color.yellow);
                System.out.println("Vaya colocada correctamente.");
                return true;
            } else {
                System.out.println("Usted no puede colocar una valla aqui.");
                return false;
            }
        } else {
            System.out.println("Usted no cuenta con mas vallas.");
            return false;
        }
    }

}