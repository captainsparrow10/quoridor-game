package estructura;

import java.awt.Color;
import java.util.ArrayList;
import tablero.Tablero;
import tablero.TableroGUI;
import javax.swing.*;

public class Funciones {
    public Boolean movilidadPeon(Pawn player, Tablero table, TableroGUI table2) {
        int option;
        try {

            option = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "�Hacia qu� direcci�n desea moverse?\nOpci�n 1: Hacia arriba.\nOpci�n 2: Hacia abajo.\nOpci�n 3: Hacia la derecha.\nOpci�n 4: Hacia la izquierda.\nOpci�n 5: Volver.",
                    "\nTurno de: " + player.getName() + ".", JOptionPane.INFORMATION_MESSAGE));
            switch (option) {
                case 1:


                    if ((player.getPosition()[0] - 2) < 0) {
                        JOptionPane.showMessageDialog(null, "Movimiento no válido, sale del tablero.", "movimiento no valido",
                                JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                    if (table.tablero[player.getPosition()[0] - 1][player
                            .getPosition()[1]] == "v") {

                        JOptionPane.showMessageDialog(null, "Hay una vaya aquí, prueba en otro lugar", "a",
                                JOptionPane.ERROR_MESSAGE);
                        return false;
                    }


                    // Eliminamos la posici�n del pe�n actual en el tablero.
                    table.tablero[player.getPosition()[0]][player
                            .getPosition()[1]] = " ";

                    table2.boxes[player.getPosition()[0]][player
                            .getPosition()[1]].setBackground(Color.BLACK);

                    // Actualizamos la nueva posici�n del jugador.
                    player.moveUp();

                    // Actualizamos la nueva posici�n del pe�n en la tabla.
                    table.agregarPosicionPeon(player.getPosition()[0],
                            player.getPosition()[1], player.getId());

                    // Actualizar tableroGUI
                    table2.boxes[player.getPosition()[0]][player
                            .getPosition()[1]].setBackground(Color.decode(player.getColor()));

                    return true;

                case 2:

                    if ((player.getPosition()[0] + 2) > 16) {
                        JOptionPane.showMessageDialog(null, "Movimiento no válido, sale del tablero.", "movimiento no valido",
                                JOptionPane.ERROR_MESSAGE);
                        return false;
                    }

                    if (table.tablero[player.getPosition()[0] + 1][player
                            .getPosition()[1]] == "v") {
                        JOptionPane.showMessageDialog(null, "Hay una vaya aquí, prueba en otro lugar", "a",
                                JOptionPane.ERROR_MESSAGE);
                        return false;
                    }

                    table.tablero[player.getPosition()[0]][player
                            .getPosition()[1]] = " ";
                    table2.boxes[player.getPosition()[0]][player
                            .getPosition()[1]].setBackground(Color.BLACK);
                    player.moveDown();
                    table.agregarPosicionPeon(player.getPosition()[0],
                            player.getPosition()[1], player.getId());
                    table2.boxes[player.getPosition()[0]][player
                            .getPosition()[1]].setBackground(Color.decode(player.getColor()));
                    return true;

                case 3:

                    if ((player.getPosition()[1] + 2) > 16) {
                        JOptionPane.showMessageDialog(null, "Movimiento no válido, sale del tablero.", "movimiento no valido",
                                JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                    if (table.tablero[player.getPosition()[0]][player
                            .getPosition()[1] + 1] == "v") {
                        JOptionPane.showMessageDialog(null, "Hay una vaya aquí, prueba en otro lugar", "a",
                                JOptionPane.ERROR_MESSAGE);
                        return false;
                    }

                    table.tablero[player.getPosition()[0]][player
                            .getPosition()[1]] = " ";
                    table2.boxes[player.getPosition()[0]][player
                            .getPosition()[1]].setBackground(Color.BLACK);

                    player.moveRight();
                    table2.boxes[player.getPosition()[0]][player
                            .getPosition()[1]].setBackground(Color.decode(player.getColor()));
                    table.agregarPosicionPeon(player.getPosition()[0],
                            player.getPosition()[1], player.getId());

                    return true;

                case 4:
                    if ((player.getPosition()[1] - 2) < 0) {
                        JOptionPane.showMessageDialog(null, "Movimiento no válido, sale del tablero.", "movimiento no valido",
                                JOptionPane.ERROR_MESSAGE);
                        return false;
                    }

                    if (table.tablero[player.getPosition()[0]][player
                            .getPosition()[1] - 1] == "v") {
                        JOptionPane.showMessageDialog(null, "Hay una vaya aquí, prueba en otro lugar", "a",
                                JOptionPane.ERROR_MESSAGE);
                        return false;
                    }

                    table.tablero[player.getPosition()[0]][player
                            .getPosition()[1]] = " ";
                    table2.boxes[player.getPosition()[0]][player
                            .getPosition()[1]].setBackground(Color.BLACK);

                    player.moveLeft();
                    table2.boxes[player.getPosition()[0]][player
                            .getPosition()[1]].setBackground(Color.decode(player.getColor()));
                    table.agregarPosicionPeon(player.getPosition()[0],
                            player.getPosition()[1], player.getId());

                    return true;

                case 5:
                    JOptionPane.showMessageDialog(null, "Regresando...", "a", 1);
                    return false;

                default:
                    JOptionPane.showMessageDialog(null, "Opcion valida", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                    return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor no valido..", "Mensaje de error", JOptionPane.ERROR_MESSAGE);

            return false;
        }

    }

    public Boolean colocarMuro(Pawn pawn, Tablero table, TableroGUI table2) {
        int option, positionX, positionY;
        Boolean responseWalls = false;
        Wall walls = new Wall();

        try {
            option = Integer.parseInt(JOptionPane
                    .showInputDialog("Opci�n 1: Muro horizontal.\nOpci�n 2: Muro vertical.\nOpci�n 3: Volver."));

            switch (option) {
                case 1:
                    positionX = Integer.parseInt(JOptionPane.showInputDialog(
                            "Eliga el n�mero de 'fila' donde desea colocar el muro")) - 1;

                    positionY = Integer.parseInt(JOptionPane.showInputDialog(
                            "Eliga el n�mero de 'columna' donde desea colocar el muro")) - 1;

                    if ((positionX + 1) % 2 != 0 || (positionY + 1) % 2 == 0) {

                        JOptionPane.showMessageDialog(null, "Fila o Columna no valida", "a", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }

                    option = Integer.parseInt(JOptionPane
                            .showInputDialog(
                                    "�Hacia qui�n lado desea extender el muro?\nOpci�n 1: Izquierda.\nOpci�n 2: Derecha.\nOpci�n 3: Volver."));

                    if (option != 1 && option != 2) {

                        if (option == 3) {
                            JOptionPane.showMessageDialog(null, "Regresando...", "a", 1);
                        } else {
                            JOptionPane.showMessageDialog(null, "Opcion no valida.", "a", JOptionPane.ERROR_MESSAGE);
                        }
                        return false;
                    }

                    if (option == 1) {

                        // Guardamos la respuesta (true o false) para ver si es posible colocar una
                        // valla ah�.
                        responseWalls = walls.colocarVallaHorizontal(positionX, positionY, positionY - 2, positionY - 1,
                                table.tablero,
                                pawn.walls, table2);

                        // En caso de que no se pueda colocar un vaya, repetimos el turno.
                        if (!responseWalls) {
                            return false;
                        }
                    } else {
                        responseWalls = walls.colocarVallaHorizontal(positionX, positionY, positionY + 2, positionY + 1,
                                table.tablero,
                                pawn.walls, table2);
                        if (!responseWalls) {
                            return false;
                        }
                    }
                    pawn.walls -= 1;
                    return true;

                case 2:
                    positionX = Integer.parseInt(JOptionPane.showInputDialog(
                            "Eliga el n�mero de 'fila' donde desea colocar el muro")) - 1;

                    positionY = Integer.parseInt(JOptionPane.showInputDialog(
                            "Eliga el n�mero de 'columna' donde desea colocar el muro")) - 1;

                    if ((positionX + 1) % 2 == 0 || (positionY + 1) % 2 != 0) {
                        JOptionPane.showMessageDialog(null, "Fila o Columna no valida", "a", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }

                    option = Integer.parseInt(JOptionPane.showInputDialog(
                            "�Hacia qui�n lado desea extender el muro?\nOpci�n 1: Arriba.\nOpci�n 2: Abajo.\nOpci�n 3: Volver."));
                    if (option != 1 && option != 2) {

                        if (option == 3) {
                            JOptionPane.showMessageDialog(null, "Regresando...", "a", 1);
                        } else {
                            JOptionPane.showMessageDialog(null, "Opcion no valida.", "a", JOptionPane.ERROR_MESSAGE);
                        }
                        return false;
                    }

                    if (option == 1) {
                        responseWalls = walls.colocarVallaVertical(positionY, positionX, positionX - 2, positionX - 1,
                                table.tablero,
                                pawn.walls, table2);
                        if (!responseWalls) {
                            return false;
                        }
                    } else {
                        responseWalls = walls.colocarVallaVertical(positionY, positionX, positionX + 2, positionX + 1,
                                table.tablero,
                                pawn.walls, table2);
                        if (!responseWalls) {
                            return false;
                        }
                    }
                    pawn.walls -= 1;
                    return true;

                default:
                    JOptionPane.showMessageDialog(null, "Regresando...", "a", 1);
                    return false;

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha introcido algún valor inválido, intente nuevamente", "a",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void salirJuego(Pawn pawn1, Pawn pawn2, Tablero table) {
        JOptionPane.showMessageDialog(null, "Saliendo del juego.", "a", 1);
        pawn1.obtenerHistorial();
        pawn2.obtenerHistorial();

    }

    public void iniciarJugadores(Tablero table, ArrayList<Pawn> listaPlayers, TableroGUI table2) {
        String name;
        table.llenartablero();
        table2.createAndDisplayGUI();

        name = JOptionPane.showInputDialog("Ingrese nombre del jugador #1");

        // Inicializamos el primer player y lo agregaros a la lista de jugadores.
        Pawn player1 = new Pawn(name, "A", 0, 8, "#FF0000");
        listaPlayers.add(player1);
        table2.boxes[0][8].setBackground(Color.RED);

        // Actualizamos la posici�n del player en el tablero.
        table.agregarPosicionPeon(listaPlayers.get(0).getPosition()[0], listaPlayers.get(0).getPosition()[1],
                listaPlayers.get(0).getId());

        name = JOptionPane.showInputDialog("Ingrese nombre del jugador #2");

        Pawn player2 = new Pawn(name, "B", 16, 8, "#0000ff");
        listaPlayers.add(player2);
        table2.boxes[16][8].setBackground(Color.BLUE);
        table.agregarPosicionPeon(listaPlayers.get(1).getPosition()[0], listaPlayers.get(1).getPosition()[1],
                listaPlayers.get(1).getId());

    }

    public Boolean jugadorGanador(ArrayList<Pawn> listaPlayers) {
        if (listaPlayers.get(0).getPosition()[0] == 16) {
            JOptionPane.showMessageDialog(null, "Felicidades " + listaPlayers.get(0).getName() + ", haz ganado.",
                    "mensaje de acierto", 1);

            return true;
        }

        if (listaPlayers.get(1).getPosition()[0] == 0) {
            JOptionPane.showMessageDialog(null, "Felicidades " + listaPlayers.get(1).getName() + ", haz ganado.",
                    "mensaje de acierto", 1);
            return true;
        }

        return false;
    }

}
