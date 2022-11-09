package consola.estructura;

import consola.tablero.Tablero;

public class FuncionPeon {
  Tablero table = new Tablero();

  void movilidadPeon(int option, Pawn player) {

    System.out.println(
        "�Hacia qu� direcci�n desea moverse?\nOpci�n 1: Hacia arriba.\nOpci�n 2: Hacia abajo.\nOpci�n 3: Hacia la derecha.\nOpci�n 4: Hacia la izquierda.\nOpci�n 5: Volver.");

    switch (option) {
      case 1:

        if (table.tablero[player.getPosition()[1] - 1][player
            .getPosition()[1]] == "v") {
          System.out.println("Hay una valla aqu�, prueba en otro lugar.");
        }

        // Eliminamos la posici�n del pe�n actual en el tablero.
        table.tablero[player.getPosition()[0]][player
            .getPosition()[1]] = " ";

        // Actualizamos la nueva posici�n del jugador.
        player.moveUp();

        // Actualizamos la nueva posici�n del pe�n en la tabla.
        table.agregarPosicionPeon(player.getPosition()[0],
            player.getPosition()[1], player.getId());

        break;

      case 2:

        if (table.tablero[player.getPosition()[0] + 1][player
            .getPosition()[1]] == "v") {
          System.out.println("Hay una valla aqu�, prueba en otro lugar.");

        }

        table.tablero[player.getPosition()[0]][player
            .getPosition()[1]] = " ";
        player.moveDown();
        table.agregarPosicionPeon(player.getPosition()[0],
            player.getPosition()[1], player.getId());

        break;

      case 3:
        if (table.tablero[player.getPosition()[0]][player
            .getPosition()[1] + 1] == "v") {
          System.out.println("Hay una valla aqu�, prueba en otro lugar.");

        }

        table.tablero[player.getPosition()[0]][player
            .getPosition()[1]] = " ";
        player.moveRight();
        table.agregarPosicionPeon(player.getPosition()[0],
            player.getPosition()[1], player.getId());

        break;

      case 4:
        if (table.tablero[player.getPosition()[0]][player
            .getPosition()[1] - 1] == "v") {
          System.out.println("Hay una valla aqu�, prueba en otro lugar.");

        }

        table.tablero[player.getPosition()[0]][player
            .getPosition()[1]] = " ";
        player.moveLeft();
        table.agregarPosicionPeon(player.getPosition()[0],
            player.getPosition()[1], player.getId());

        break;

      case 5:
        System.out.println("Regresando...");

      default:
        System.out.println("Opci�n inv�lida");
    }

  }
}
