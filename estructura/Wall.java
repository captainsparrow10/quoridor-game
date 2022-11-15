package estructura;

import java.awt.Color;
import javax.swing.*;  
import tablero.TableroGUI;

//Clase walls
public class Wall {

    public Boolean colocarVallaHorizontal(int x, int y1, int y2,int y3, String[][] tablero, int walls, TableroGUI table2) {
        if (walls > 0) {
            if (tablero[x][y3] == "x" && tablero[x][y2] == "x" && tablero[x][y1] == "x") {
                tablero[x][y1] = "v";
                tablero[x][y2] = "v";
                tablero[x][y3] = "v";

                table2.boxes[x][y1].setBackground(Color.yellow);
                table2.boxes[x][y2].setBackground(Color.yellow);
                table2.boxes[x][y3].setBackground(Color.yellow);
                JOptionPane.showMessageDialog(null, "Vaya colocada correctamente", "mensaje de acierto", 1);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Usted no puede colocar una vaya aquí.", "mensaje de error.", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usted no cuenta con mas vayas.", "mensaje de error.", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public Boolean colocarVallaVertical(int y, int x1, int x2,int x3, String[][] tablero, int walls, TableroGUI table2) {
        if (walls > 0) {
            if (tablero[x3][y] == "x" && tablero[x2][y] == "x" && tablero[x1][y] == "x") {
                tablero[x1][y] = "v";
                tablero[x2][y] = "v";
                tablero[x3][y] = "v";
               
                table2.boxes[x1][y].setBackground(Color.yellow);
                table2.boxes[x2][y].setBackground(Color.yellow);
                table2.boxes[x3][y].setBackground(Color.yellow);
                JOptionPane.showMessageDialog(null, "Vaya colocada correctamente", "mensaje de acierto", 1);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Usted no puede colocar una vaya aquí.", "mensaje de error.", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usted no cuenta con mas vayas.", "mensaje de error.", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}