import tablero.Tablero;
import java.util.Scanner;
import movement.Pawn;
import movement.Wall;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    // Aqui se relaizarán toda las llamadas que se van a realizar
    String name;
    int optionMain, optionSecond, optionThird, positionX, positionY, playerActual;
    ArrayList<Pawn> listaPlayers = new ArrayList<Pawn>();
    Boolean end = false, endOption = false, responseWalls = false;
    Wall walls = new Wall();
    Tablero table = new Tablero();
    Scanner sc = new Scanner(System.in);

    // Iniciamos el tablero
    table.llenartablero();
    table.mostrarTablero();
  



    System.out.println("Ingrese nombre del jugador #1");
    name = sc.nextLine();

    // Inicializamos el primer player
    Pawn player1 = new Pawn(name, "A");
    player1.setPosition(8, 0);
    listaPlayers.add(player1);
    table.agregarPosicionPeon(listaPlayers.get(0).getPosition()[0], listaPlayers.get(0).getPosition()[1]);

    System.out.println("Ingrese nombre del jugador #2");
    name = sc.nextLine();

    // Inicializamos el segundo player
    Pawn player2 = new Pawn(name, "B");
    player2.setPosition(8, 16);
    listaPlayers.add(player2);
    table.agregarPosicionPeon(listaPlayers.get(1).getPosition()[0], listaPlayers.get(1).getPosition()[1]);

    // Colocamos el player actual
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

      endOption= false;
      while (!endOption) {
        System.out.println("Opción 1: Moverse.\nOpción 2: Colocar muro.");

        optionMain = sc.nextInt();

        if (optionMain != 1 && optionMain != 2) {
          System.out.println("Opción no válida");
          continue;
        }

        if (optionMain == 1) {
          System.out.println(
              "¿Hacia qué direccíón desea moverse?\nOpción 1: Hacia arriba.\nOpción 2: Hacia abajo.\nOpción 3: Hacia la derecha.\nOpción 4: Hacia la izquierda.");

          optionSecond = sc.nextInt();

        
          switch (optionSecond) {
            case 1:

              // Comprobamos que no haya una vaya.
              if (table.tablero[listaPlayers.get(playerActual).getPosition()[0] - 1][listaPlayers.get(playerActual)
                  .getPosition()[1]] == "v") {
                System.out.println("Hay una valla aquí, prueba en otro lugar.");
                continue;
              }
              table.tablero[listaPlayers.get(playerActual).getPosition()[0]][listaPlayers.get(playerActual).getPosition()[1]] = " ";

              // Actualizamos la nueva posición del jugador.
              listaPlayers.get(playerActual).moveUp();

              // Actualizamos la posición del peón en la tabla
              table.agregarPosicionPeon(listaPlayers.get(playerActual).getPosition()[0],
                  listaPlayers.get(playerActual).getPosition()[1]);

                endOption = true;
              break;

            case 2:

              if (table.tablero[listaPlayers.get(playerActual).getPosition()[0] + 1][listaPlayers.get(playerActual)
                  .getPosition()[1]] == "v") {
                System.out.println("Hay una valla aquí, prueba en otro lugar.");
                continue;
              }
              table.tablero[listaPlayers.get(playerActual).getPosition()[0]][listaPlayers.get(playerActual).getPosition()[1]] = " ";

              listaPlayers.get(playerActual).moveDown();
              table.agregarPosicionPeon(listaPlayers.get(playerActual).getPosition()[0],
                  listaPlayers.get(playerActual).getPosition()[1]);

                endOption = true;
              break;

            case 3:
              if (table.tablero[listaPlayers.get(playerActual).getPosition()[0]][listaPlayers.get(playerActual)
                  .getPosition()[1] + 1] == "v") {
                System.out.println("Hay una valla aquí, prueba en otro lugar.");
                continue;
              }
              table.tablero[listaPlayers.get(playerActual).getPosition()[0]][listaPlayers.get(playerActual).getPosition()[1]] = " ";

              listaPlayers.get(playerActual).moveRight();
              table.agregarPosicionPeon(listaPlayers.get(playerActual).getPosition()[0],
                  listaPlayers.get(playerActual).getPosition()[1]);

                endOption = true;
              break;

            case 4:
              if (table.tablero[listaPlayers.get(playerActual).getPosition()[0]][listaPlayers.get(playerActual)
                  .getPosition()[1] - 1] == "v") {
                System.out.println("Hay una valla aquí, prueba en otro lugar.");
                continue;
              }

              table.tablero[listaPlayers.get(playerActual).getPosition()[0]][listaPlayers.get(playerActual).getPosition()[1]] = " ";
              listaPlayers.get(playerActual).moveLeft();
              table.agregarPosicionPeon(listaPlayers.get(playerActual).getPosition()[0],
                  listaPlayers.get(playerActual).getPosition()[1]);
                endOption = true;
              break;

              default:
                System.out.println("Opción inválida");
          }

        } else {
          System.out.println("Opción 1: Muro horizontal.\nOpción 2: Muro vertical.");

          optionSecond = sc.nextInt();

          if (optionSecond != 1 && optionSecond != 2) {
            System.out.println("Opción no válida");
            continue;
          }

          if (optionSecond == 1) {
            System.out.println("Eliga el número de 'fila' donde desea colocar el muro");
            positionX = sc.nextInt();

            System.out.println("Eliga el número de 'columna' donde desea colocar el muro");
            positionY = sc.nextInt();

            System.out.println("¿Hacia qué lado desea extender el muro?\nOpción 1: Izquierda.\nOpción 2: Derecha.");

            optionThird = sc.nextInt();

            if (optionSecond != 1 && optionSecond != 2) {
              System.out.println("Opción no válida");
              continue;
            }

            if (optionThird == 1) {
              responseWalls = walls.colocarVallaHorizontal(positionX, positionY, positionY - 2, table.tablero,
                  listaPlayers.get(playerActual).walls);
                  if(!responseWalls) {
                    continue;
                  }
                  endOption = true;
            } else {
              responseWalls = walls.colocarVallaHorizontal(positionX, positionY, positionY + 2, table.tablero,
                  listaPlayers.get(playerActual).walls);
                  if(!responseWalls) {
                    continue;
                  }
                  endOption = true;
            }

          } else {
            System.out.println("Eliga el número de 'fila' donde desea colocar el muro");
            positionX = sc.nextInt();

            System.out.println("Eliga el número de 'columna' donde desea colocar el muro");
            positionY = sc.nextInt();

            System.out.println("¿Hacia qué lado desea extender el muro?\nOpción 1: Arriba.\nOpción 2: Abajo.");

            optionThird = sc.nextInt();

            if (optionSecond != 1 && optionSecond != 2) {
              System.out.println("Opción no válida");
              continue;
            }

            if (optionThird == 1) {
              responseWalls = walls.colocarVallaVertical(positionY, positionX, positionX - 2, table.tablero,
                  listaPlayers.get(playerActual).walls);
                  if(!responseWalls) {
                    continue;
                  }
                  endOption = true;
            } else {
              responseWalls = walls.colocarVallaVertical(positionY, positionX, positionX + 2, table.tablero,
                  listaPlayers.get(playerActual).walls);
                  if(!responseWalls) {
                    continue;
                  }
                  endOption = true;
            }

          }

        }

      }

    }

    sc.close();


  }

}