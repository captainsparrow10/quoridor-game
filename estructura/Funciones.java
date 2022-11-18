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
                    "Hacia quo direccion desea moverse?\nOpcion 1: Hacia arriba.\nOpcion 2: Hacia abajo.\nOpcion 3: Hacia la derecha.\nOpcion 4: Hacia la izquierda.\nOpcion 5: Volver.",
                    "\nTurno de: " + player.getName() + ".", JOptionPane.INFORMATION_MESSAGE));
            switch (option) {
                case 1:

                    //Validamos que el movimiento hacia esa dirrección esté dentro del rango del tablero.
                    if ((player.getPosition()[0] - 2) < 0) {
                        JOptionPane.showMessageDialog(null, "Movimiento no valido, sale del tablero.",
                                "movimiento no valido",
                                JOptionPane.ERROR_MESSAGE);
                        return false;
                    }

                    //Validamos en caso de que haya una vaya en ese sitio.
                    if (table.tablero[player.getPosition()[0] - 1][player
                            .getPosition()[1]] == "v") {

                        JOptionPane.showMessageDialog(null, "Hay una vaya aqui, prueba en otro lugar", "a",
                                JOptionPane.ERROR_MESSAGE);
                        return false;
                    }

                    // Eliminamos la posicion del peon actual en el tablero.
                    table.tablero[player.getPosition()[0]][player
                            .getPosition()[1]] = " ";

                    
                    // Validacion en caso de que un peon esté encima de otro, no borrar el color actual al moverse el que esté debajo.
                    if (table2.boxes[player.getPosition()[0]][player
                            .getPosition()[1]].getBackground().getRGB() == player.getColor()) {
                        table2.boxes[player.getPosition()[0]][player
                                .getPosition()[1]].setBackground(Color.black);
                    }

                    // Actualizamos la nueva posicion del jugador.
                    player.moveUp();

                    // Actualizamos la nueva posicion del peon en la tabla.
                    table.agregarPosicionPeon(player.getPosition()[0],
                            player.getPosition()[1], player.getId());

                    // Actualizar tableroGUI
                    table2.boxes[player.getPosition()[0]][player
                            .getPosition()[1]].setBackground(new Color((player.getColor())));

                    return true;

                case 2:

                    if ((player.getPosition()[0] + 2) > 16) {
                        JOptionPane.showMessageDialog(null, "Movimiento no valido, sale del tablero.",
                                "movimiento no valido",
                                JOptionPane.ERROR_MESSAGE);
                        return false;
                    }

                    if (table.tablero[player.getPosition()[0] + 1][player
                            .getPosition()[1]] == "v") {
                        JOptionPane.showMessageDialog(null, "Hay una vaya aqui, prueba en otro lugar", "a",
                                JOptionPane.ERROR_MESSAGE);
                        return false;
                    }

                    table.tablero[player.getPosition()[0]][player
                            .getPosition()[1]] = " ";
                    if (table2.boxes[player.getPosition()[0]][player
                            .getPosition()[1]].getBackground().getRGB() == player.getColor()) {
                        table2.boxes[player.getPosition()[0]][player
                                .getPosition()[1]].setBackground(Color.black);
                    }
                    player.moveDown();
                    table.agregarPosicionPeon(player.getPosition()[0],
                            player.getPosition()[1], player.getId());
                    table2.boxes[player.getPosition()[0]][player
                            .getPosition()[1]].setBackground(new Color((player.getColor())));
                    return true;

                case 3:

                    if ((player.getPosition()[1] + 2) > 16) {

                        JOptionPane.showMessageDialog(null, "Movimiento no valido, sale del tablero.",
                                "movimiento no valido",
                                JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                    if (table.tablero[player.getPosition()[0]][player
                            .getPosition()[1] + 1] == "v") {
                        JOptionPane.showMessageDialog(null, "Hay una vaya aqui, prueba en otro lugar", "a",
                                JOptionPane.ERROR_MESSAGE);
                        return false;
                    }

                    table.tablero[player.getPosition()[0]][player
                            .getPosition()[1]] = " ";
                    if (table2.boxes[player.getPosition()[0]][player
                            .getPosition()[1]].getBackground().getRGB() == player.getColor()) {
                        table2.boxes[player.getPosition()[0]][player
                                .getPosition()[1]].setBackground(Color.black);
                    }

                    player.moveRight();
                    table2.boxes[player.getPosition()[0]][player
                            .getPosition()[1]].setBackground(new Color((player.getColor())));
                    table.agregarPosicionPeon(player.getPosition()[0],
                            player.getPosition()[1], player.getId());

                    return true;

                case 4:
                    if ((player.getPosition()[1] - 2) < 0) {
                        System.out.println(player.getPosition()[1] - 2);
                        JOptionPane.showMessageDialog(null, "Movimiento no valido, sale del tablero.",
                                "movimiento no valido",
                                JOptionPane.ERROR_MESSAGE);
                        return false;
                    }

                    if (table.tablero[player.getPosition()[0]][player
                            .getPosition()[1] - 1] == "v") {
                        JOptionPane.showMessageDialog(null, "Hay una vaya aqui, prueba en otro lugar", "a",
                                JOptionPane.ERROR_MESSAGE);
                        return false;
                    }

                    table.tablero[player.getPosition()[0]][player
                            .getPosition()[1]] = " ";
                    if (table2.boxes[player.getPosition()[0]][player
                            .getPosition()[1]].getBackground().getRGB() == player.getColor()) {
                        table2.boxes[player.getPosition()[0]][player
                                .getPosition()[1]].setBackground(Color.black);
                    }

                    player.moveLeft();
                    table2.boxes[player.getPosition()[0]][player
                            .getPosition()[1]].setBackground(new Color((player.getColor())));
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
                    .showInputDialog("Opcion 1: Muro horizontal.\nOpcion 2: Muro vertical.\nOpcion 3: Volver."));

            switch (option) {
                case 1:

                
                    positionX = Integer.parseInt(JOptionPane.showInputDialog(
                            "Eliga el numero de 'fila' donde desea colocar el muro")) - 1;

                    positionY = Integer.parseInt(JOptionPane.showInputDialog(
                            "Eliga el numero de 'columna' donde desea colocar el muro")) - 1;

                            //Validamos que la posición introducida sea válida, que sea un muro horizontal

                    if ((positionX + 1) % 2 != 0 || (positionY + 1) % 2 == 0) {

                        JOptionPane.showMessageDialog(null, "Fila o Columna no valida", "a", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }

                    option = Integer.parseInt(JOptionPane
                            .showInputDialog(
                                    "Hacia quion lado desea extender el muro?\nOpcion 1: Izquierda.\nOpcion 2: Derecha.\nOpcion 3: Volver."));

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
                        // valla ahi.
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

                    table2.walls[pawn.getIdN()][pawn.walls].setBackground(Color.black);

                    return true;

                case 2:
                    positionX = Integer.parseInt(JOptionPane.showInputDialog(
                            "Eliga el nomero de 'fila' donde desea colocar el muro")) - 1;

                    positionY = Integer.parseInt(JOptionPane.showInputDialog(
                            "Eliga el nomero de 'columna' donde desea colocar el muro")) - 1;

                    if ((positionX + 1) % 2 == 0 || (positionY + 1) % 2 != 0) {
                        JOptionPane.showMessageDialog(null, "Fila o Columna no valida", "a", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }

                    option = Integer.parseInt(JOptionPane.showInputDialog(
                            "Hacia quion lado desea extender el muro?\nOpcion 1: Arriba.\nOpcion 2: Abajo.\nOpcion 3: Volver."));
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
                    table2.walls[pawn.getIdN()][pawn.walls].setBackground(Color.black);
                    return true;

                default:
                    JOptionPane.showMessageDialog(null, "Regresando...", "a", 1);
                    return false;

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha introcido algún valor invalido, intente nuevamente", "a",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }


    //Metodo para salir del juego.
    public void salirJuego(Pawn pawn1, Pawn pawn2, Tablero table, TableroGUI table2) {
        JOptionPane.showMessageDialog(null, "Saliendo del juego.", "a", 1);
        pawn1.obtenerHistorial();
        pawn2.obtenerHistorial();
        table2.destroyGame();

    }


    //Metodo para iniciar jugadores.
    public void iniciarJugadores(Tablero table, ArrayList<Pawn> listaPlayers, TableroGUI table2) {
        String name;
        table.llenartablero();
        table2.createAndDisplayGUI();

        name = JOptionPane.showInputDialog("Ingrese nombre del jugador #1");

        // Inicializamos el primer player y lo agregaros a la lista de jugadores.
        Pawn player1 = new Pawn(name, "A", 0, 8, -1, 0);
        listaPlayers.add(player1);
        table2.boxes[0][8].setBackground(Color.white);

        // Actualizamos la posicion del player en el tablero.
        table.agregarPosicionPeon(listaPlayers.get(0).getPosition()[0], listaPlayers.get(0).getPosition()[1],
                listaPlayers.get(0).getId());

        name = JOptionPane.showInputDialog("Ingrese nombre del jugador #2");

        Pawn player2 = new Pawn(name, "B", 16, 8, -65536, 1);
        listaPlayers.add(player2);
        table2.boxes[16][8].setBackground(Color.RED);
        table.agregarPosicionPeon(listaPlayers.get(1).getPosition()[0], listaPlayers.get(1).getPosition()[1],
                listaPlayers.get(1).getId());

    }


    //Metodo para el jugador ganador.
    public Boolean jugadorGanador(ArrayList<Pawn> listaPlayers, TableroGUI table2) {
        if (listaPlayers.get(0).getPosition()[0] == 16) {
            JOptionPane.showMessageDialog(null, "Felicidades " + listaPlayers.get(0).getName() + ", haz ganado.",
                    "mensaje de acierto", 1);
            table2.destroyGame();
            return true;
        }

        if (listaPlayers.get(1).getPosition()[0] == 0) {
            JOptionPane.showMessageDialog(null, "Felicidades " + listaPlayers.get(1).getName() + ", haz ganado.",
                    "mensaje de acierto", 1);
            table2.destroyGame();
            return true;
        }

        return false;
    }

}
