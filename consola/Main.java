package consola;
import java.util.Scanner;

import consola.movement.Pawn;
import consola.movement.Wall;
import consola.tablero.Tablero;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    String name;
    int optionMain, optionSecond, optionThird, positionX, positionY, playerActual;
    Boolean end = false, endOption = false, responseWalls = false;
    Wall walls = new Wall();
    Tablero table = new Tablero();
    Scanner sc = new Scanner(System.in);
    ArrayList<Pawn> listaPlayers = new ArrayList<Pawn>();

    // Iniciamos el tablero y lo imprimimos.
    table.llenartablero();
    table.mostrarTablero();

    System.out.println("Ingrese nombre del jugador #1");
    name = sc.nextLine();

    // Inicializamos el primer player y lo agregaros a la lista de jugadores.
    Pawn player1 = new Pawn(name, "A");
    player1.setPosition(8, 0);
    listaPlayers.add(player1);

    // Actualizamos la posici�n del player en el tablero.
    table.agregarPosicionPeon(listaPlayers.get(0).getPosition()[0], listaPlayers.get(0).getPosition()[1], listaPlayers.get(0).getId());

    System.out.println("Ingrese nombre del jugador #2");
    name = sc.nextLine();

    Pawn player2 = new Pawn(name, "B");
    player2.setPosition(8, 16);
    listaPlayers.add(player2);
    table.agregarPosicionPeon(listaPlayers.get(1).getPosition()[0], listaPlayers.get(1).getPosition()[1], listaPlayers.get(1).getId());

    // Colocamos el player actual.
    playerActual = listaPlayers.indexOf(player2);

    // Iniciamos el juego.
    while (!end) {

      // Turnamos a los jugadores
      if (listaPlayers.get(playerActual).getId() == "B") {
        playerActual = 0;
      } else {
        playerActual = 1;
      }

      System.out.println("\nTurno de: " + listaPlayers.get(playerActual).getName() + ".");

      // Ciclo para poder repetir las opciones de un jugador sin cambiar el turno.
      endOption = false;
      while (!endOption) {
        System.out.println("Opci�n 1: Moverse.\nOpci�n 2: Colocar muro.");

        optionMain = sc.nextInt();

        // En caso de que el valor no est� dentro de las opciones, repetimos el ciclo
        // (con el turno actual).

        if (optionMain != 1 && optionMain != 2) {
          System.out.println("Opci�n no v�lida");
          continue;
        }

        if (optionMain == 1) {
          System.out.println(
              "�Hacia qu� direcci�n desea moverse?\nOpci�n 1: Hacia arriba.\nOpci�n 2: Hacia abajo.\nOpci�n 3: Hacia la derecha.\nOpci�n 4: Hacia la izquierda.\nOpci�n 5: Volver.");

          optionSecond = sc.nextInt();


          switch (optionSecond) {
            case 1:

              // Comprobamos que no haya una vaya.
              if (table.tablero[listaPlayers.get(playerActual).getPosition()[0] - 1][listaPlayers.get(playerActual)
                  .getPosition()[1]] == "v") {
                System.out.println("Hay una valla aqu�, prueba en otro lugar.");
                continue;
              }

              // Eliminamos la posici�n del pe�n actual en el tablero.
              table.tablero[listaPlayers.get(playerActual).getPosition()[0]][listaPlayers.get(playerActual)
                  .getPosition()[1]] = " ";

              // Actualizamos la nueva posici�n del jugador.
              listaPlayers.get(playerActual).moveUp();

              // Actualizamos la nueva posici�n del pe�n en la tabla.
              table.agregarPosicionPeon(listaPlayers.get(playerActual).getPosition()[0],
                  listaPlayers.get(playerActual).getPosition()[1], listaPlayers.get(playerActual).getId());

              endOption = true;
              break;

            case 2:

              if (table.tablero[listaPlayers.get(playerActual).getPosition()[0] + 1][listaPlayers.get(playerActual)
                  .getPosition()[1]] == "v") {
                System.out.println("Hay una valla aqu�, prueba en otro lugar.");
                continue;
              }

              table.tablero[listaPlayers.get(playerActual).getPosition()[0]][listaPlayers.get(playerActual)
                  .getPosition()[1]] = " ";
              listaPlayers.get(playerActual).moveDown();
              table.agregarPosicionPeon(listaPlayers.get(playerActual).getPosition()[0],
                  listaPlayers.get(playerActual).getPosition()[1], listaPlayers.get(playerActual).getId());
              endOption = true;
              break;

            case 3:
              if (table.tablero[listaPlayers.get(playerActual).getPosition()[0]][listaPlayers.get(playerActual)
                  .getPosition()[1] + 1] == "v") {
                System.out.println("Hay una valla aqu�, prueba en otro lugar.");
                continue;
              }

              table.tablero[listaPlayers.get(playerActual).getPosition()[0]][listaPlayers.get(playerActual)
                  .getPosition()[1]] = " ";
              listaPlayers.get(playerActual).moveRight();
              table.agregarPosicionPeon(listaPlayers.get(playerActual).getPosition()[0],
                  listaPlayers.get(playerActual).getPosition()[1], listaPlayers.get(playerActual).getId());
              endOption = true;
              break;

            case 4:
              if (table.tablero[listaPlayers.get(playerActual).getPosition()[0]][listaPlayers.get(playerActual)
                  .getPosition()[1] - 1] == "v") {
                System.out.println("Hay una valla aqu�, prueba en otro lugar.");
                continue;
              }

              table.tablero[listaPlayers.get(playerActual).getPosition()[0]][listaPlayers.get(playerActual)
                  .getPosition()[1]] = " ";
              listaPlayers.get(playerActual).moveLeft();
              table.agregarPosicionPeon(listaPlayers.get(playerActual).getPosition()[0],
                  listaPlayers.get(playerActual).getPosition()[1], listaPlayers.get(playerActual).getId());
              endOption = true;
              break;
            
              case 5:
                System.out.println("Regresando...");

            default:
              System.out.println("Opci�n inv�lida");
          }

        } else {
          System.out.println("Opci�n 1: Muro horizontal.\nOpci�n 2: Muro vertical.\nOpci�n 3: Volver.");

          optionSecond = sc.nextInt();

          if (optionSecond != 1 && optionSecond != 2) {

            if(optionSecond == 3) {
              System.out.println("Regresando...");
            } else {
              System.out.println("Opci�n no v�lida");
            }
         
            continue;
          }

          if (optionSecond == 1) {
            System.out.println("Eliga el n�mero de 'fila' donde desea colocar el muro");
            positionX = sc.nextInt();

            System.out.println("Eliga el n�mero de 'columna' donde desea colocar el muro");
            positionY = sc.nextInt();

            System.out.println("�Hacia qui�n lado desea extender el muro?\nOpci�n 1: Izquierda.\nOpci�n 2: Derecha.\nOpci�n 3: Volver.");

            optionThird = sc.nextInt();

            if (optionSecond != 1 && optionSecond != 2) {

              if(optionSecond == 3) {
                System.out.println("Regresando...");
              } else {
                System.out.println("Opci�n no v�lida");
              }
              continue;
            }

            if (optionThird == 1) {

              // Guardamos la respuesta (true o false) para ver si es posible colocar una valla ah�.
              responseWalls = walls.colocarVallaHorizontal(positionX, positionY, positionY - 2, table.tablero,
                  listaPlayers.get(playerActual).walls);

                // En caso de que no se pueda colocar un vaya, repetimos el turno.
              if (!responseWalls) {
                continue;
              }
              endOption = true;
            } else {
              responseWalls = walls.colocarVallaHorizontal(positionX, positionY, positionY + 2, table.tablero,
                  listaPlayers.get(playerActual).walls);
              if (!responseWalls) {
                continue;
              }
              endOption = true;
            }

          } else {
            System.out.println("Eliga el n�mero de 'fila' donde desea colocar el muro");
            positionX = sc.nextInt();

            System.out.println("Eliga el n�mero de 'columna' donde desea colocar el muro");
            positionY = sc.nextInt();

            System.out.println("�Hacia qui�n lado desea extender el muro?\nOpci�n 1: Arriba.\nOpci�n 2: Abajo.\nOpci�n 3: Volver.");

            optionThird = sc.nextInt();

            if (optionSecond != 1 && optionSecond != 2) {

              if(optionSecond == 3) {
                System.out.println("Regresando...");
              } else {
                System.out.println("Opci�n no v�lida");
              }
              continue;
            }

            if (optionThird == 1) {
              responseWalls = walls.colocarVallaVertical(positionY, positionX, positionX - 2, table.tablero,
                  listaPlayers.get(playerActual).walls);
              if (!responseWalls) {
                continue;
              }
              endOption = true;
            } else {
              responseWalls = walls.colocarVallaVertical(positionY, positionX, positionX + 2, table.tablero,
                  listaPlayers.get(playerActual).walls);
              if (!responseWalls) {
                continue;
              }
              endOption = true;
            }

          }

        }

      }

      if(listaPlayers.get(0).getPosition()[1] == 16){
          System.out.println("Felicidades, " + listaPlayers.get(0).getName() + " haz ganado.");
          end = true;
      } 

      if (listaPlayers.get(1).getPosition()[1] == 0){
          System.out.println("Felicidades, " + listaPlayers.get(1).getName() + " haz ganado.");
          end = true;
      } 
      

    }

    sc.close();

  }

}