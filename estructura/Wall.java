package estructura;

import java.awt.Color;
import javax.swing.*;
import tablero.TableroGUI;

//Clase walls
public class Wall {

    public Boolean colocarVallaHorizontal(int x, int y1, int y2, int y3, String[][] tablero, int walls,
            TableroGUI table2) {
        if (walls > 0) {

            if (tablero[x][y3] == "x" && tablero[x][y2] == "x" && tablero[x][y1] == "x") {
                tablero[x][y1] = "v";
                tablero[x][y2] = "v";
                tablero[x][y3] = "v";
                int y0;
                int y4;
                if (y2 < y1) {
                    y0 = y2;
                    y2 = y1;
                    y1 = y0;
                }
                y0 = y1 - 1;
                y4 = y2 + 1;
                if (y0 > -1 && y0 < 17) {

                    if (tablero[x][y0] == "x" && tablero[x][y0 - 1] == "v"
                            || tablero[x][y0] == "x" && tablero[x - 1][y0] == "v"
                            || tablero[x][y0] == "x" && tablero[x + 1][y0] == "v") {
                        tablero[x][y0] = "v";
                        table2.boxes[x][y0].setBackground(Color.yellow);
                    }
                }

                if (y4 > -1 && y4 < 17) {

                    if (tablero[x][y4] == "x" && tablero[x][y4 + 1] == "v"
                            || tablero[x][y4] == "x" && tablero[x - 1][y4] == "v"
                            || tablero[x][y4] == "x" && tablero[x + 1][y4] == "v") {
                        System.out.println("True");
                        table2.boxes[x][y4].setBackground(Color.yellow);
                    }

                }

                table2.boxes[x][y1].setBackground(Color.yellow);
                table2.boxes[x][y2].setBackground(Color.yellow);
                table2.boxes[x][y3].setBackground(Color.yellow);
                JOptionPane.showMessageDialog(null, "Vaya colocada correctamente", "mensaje de acierto", 1);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Usted no puede colocar una vaya aquí.", "mensaje de error.",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else

        {
            JOptionPane.showMessageDialog(null, "Usted no cuenta con mas vayas.", "mensaje de error.",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public Boolean colocarVallaVertical(int y, int x1, int x2, int x3, String[][] tablero, int walls,
            TableroGUI table2) {
        if (walls > 0) {
            if (tablero[x3][y] == "x" && tablero[x2][y] == "x" && tablero[x1][y] == "x") {
                tablero[x1][y] = "v";
                tablero[x2][y] = "v";
                tablero[x3][y] = "v";
                int x0;
                int x4;
                if (x2 < x1) {
                    x0 = x2;
                    x2 = x1;
                    x1 = x0;
                }
                x0 = x1 - 1;
                x4 = x2 + 1;
                if (x0 > -1 && x0 < 17) {
                    if (tablero[x0][y] == "x" && tablero[x0 - 1][y] == "v"
                            || tablero[x0][y] == "x" && tablero[x0][y - 1] == "v"
                            || tablero[x0][y] == "x" && tablero[x0][y + 1] == "v") {
                        tablero[x0][y] = "v";
                        table2.boxes[x0][y].setBackground(Color.yellow);

                    }
                }

                if (x4 > -1 && x4 < 17) {
                    if (tablero[x4][y] == "x" && tablero[x4 + 1][y] == "v"
                            || tablero[x4][y] == "x" && tablero[x4][y - 1] == "v"
                            || tablero[x4][y] == "x" && tablero[x4][y + 1] == "v") {
                        tablero[x4][y] = "v";
                        table2.boxes[x4][y].setBackground(Color.yellow);
                    }
                }

                table2.boxes[x1][y].setBackground(Color.yellow);
                table2.boxes[x2][y].setBackground(Color.yellow);
                table2.boxes[x3][y].setBackground(Color.yellow);
                JOptionPane.showMessageDialog(null, "Vaya colocada correctamente", "mensaje de acierto", 1);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Usted no puede colocar una vaya aquí.", "mensaje de error.",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usted no cuenta con mas vayas.", "mensaje de error.",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}