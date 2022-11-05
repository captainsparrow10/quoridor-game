import tablero.Tablero;
import java.util.Scanner;
import movement.Pawn;
import movement.Wall;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    // Aqui se relaizar�n toda las llamadas que se van a realizar
    String name;
    int optionMain, optionSecond, optionThird, positionX, positionY, playerActual;
    ArrayList<Pawn> listaPlayers = new ArrayList<Pawn>();
    ArrayList<Integer> peonAPosicionX = new ArrayList();
    ArrayList<Integer> peonAPosicionY = new ArrayList();
    ArrayList<Integer> peonBPosicionX = new ArrayList();
    ArrayList<Integer> peonBPosicionY = new ArrayList();
    ArrayList<ArrayList<Integer>> peonAHistoria = new ArrayList<>();
    ArrayList<ArrayList<Integer>> peonBHistoria = new ArrayList<>();
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
        System.out.println("Opci�n 1: Moverse.\nOpci�n 2: Colocar muro.");

        optionMain = sc.nextInt();

        if (optionMain != 1 && optionMain != 2) {
          System.out.println("Opci�n no v�lida");
          continue;
        }

        if (optionMain == 1) {
          System.out.println(
              "�Hacia qu� direcc��n desea moverse?\nOpci�n 1: Hacia arriba.\nOpci�n 2: Hacia abajo.\nOpci�n 3: Hacia la derecha.\nOpci�n 4: Hacia la izquierda.");

          optionSecond = sc.nextInt();

        
          switch (optionSecond) {
            case 1:

              // Comprobamos que no haya una vaya.
              if (table.tablero[listaPlayers.get(playerActual).getPosition()[0] - 1][listaPlayers.get(playerActual)
                  .getPosition()[1]] == "v") {
                System.out.println("Hay una valla aqu�, prueba en otro lugar.");
                continue;
              }
              table.tablero[listaPlayers.get(playerActual).getPosition()[0]][listaPlayers.get(playerActual).getPosition()[1]] = " ";

              // Actualizamos la nueva posici�n del jugador.
              listaPlayers.get(playerActual).moveUp();
              //Añadimos el movimiento al historial
              if(playerActual==0){
                peonAPosicionX.add(listaPlayers.get(playerActual).getPosition()[0]);
                peonAPosicionY.add(listaPlayers.get(playerActual).getPosition()[1]);
              }
              else{
                peonBPosicionX.add(listaPlayers.get(playerActual).getPosition()[0]);
                peonBPosicionY.add(listaPlayers.get(playerActual).getPosition()[1]);
              }
              // Actualizamos la posici�n del pe�n en la tabla
              table.agregarPosicionPeon(listaPlayers.get(playerActual).getPosition()[0],
                  listaPlayers.get(playerActual).getPosition()[1]);

                endOption = true;
              
              break;

            case 2:

              if (table.tablero[listaPlayers.get(playerActual).getPosition()[0] + 1][listaPlayers.get(playerActual)
                  .getPosition()[1]] == "v") {
                System.out.println("Hay una valla aqu�, prueba en otro lugar.");
                continue;
              }
              table.tablero[listaPlayers.get(playerActual).getPosition()[0]][listaPlayers.get(playerActual).getPosition()[1]] = " ";

              listaPlayers.get(playerActual).moveDown();
              if(playerActual==0){
                peonAPosicionX.add(listaPlayers.get(playerActual).getPosition()[0]);
                peonAPosicionY.add(listaPlayers.get(playerActual).getPosition()[1]);
              }
              else{
                peonBPosicionX.add(listaPlayers.get(playerActual).getPosition()[0]);
                peonBPosicionY.add(listaPlayers.get(playerActual).getPosition()[1]);
              }
              table.agregarPosicionPeon(listaPlayers.get(playerActual).getPosition()[0],
                  listaPlayers.get(playerActual).getPosition()[1]);

                endOption = true;
              break;

            case 3:
              if (table.tablero[listaPlayers.get(playerActual).getPosition()[0]][listaPlayers.get(playerActual)
                  .getPosition()[1] + 1] == "v") {
                System.out.println("Hay una valla aqu�, prueba en otro lugar.");
                continue;
              }
              table.tablero[listaPlayers.get(playerActual).getPosition()[0]][listaPlayers.get(playerActual).getPosition()[1]] = " ";

              listaPlayers.get(playerActual).moveRight();
              if(playerActual==0){
                peonAPosicionX.add(listaPlayers.get(playerActual).getPosition()[0]);
                peonAPosicionY.add(listaPlayers.get(playerActual).getPosition()[1]);
              }
              else{
                peonBPosicionX.add(listaPlayers.get(playerActual).getPosition()[0]);
                peonBPosicionY.add(listaPlayers.get(playerActual).getPosition()[1]);
              }
              table.agregarPosicionPeon(listaPlayers.get(playerActual).getPosition()[0],
                  listaPlayers.get(playerActual).getPosition()[1]);

                endOption = true;
              break;

            case 4:
              if (table.tablero[listaPlayers.get(playerActual).getPosition()[0]][listaPlayers.get(playerActual)
                  .getPosition()[1] - 1] == "v") {
                System.out.println("Hay una valla aqu�, prueba en otro lugar.");
                continue;
              }

              table.tablero[listaPlayers.get(playerActual).getPosition()[0]][listaPlayers.get(playerActual).getPosition()[1]] = " ";
              listaPlayers.get(playerActual).moveLeft();
              if(playerActual==0){
                peonAPosicionX.add(listaPlayers.get(playerActual).getPosition()[0]);
                peonAPosicionY.add(listaPlayers.get(playerActual).getPosition()[1]);
              }
              else{
                peonBPosicionX.add(listaPlayers.get(playerActual).getPosition()[0]);
                peonBPosicionY.add(listaPlayers.get(playerActual).getPosition()[1]);
              }
              table.agregarPosicionPeon(listaPlayers.get(playerActual).getPosition()[0],
                  listaPlayers.get(playerActual).getPosition()[1]);
                endOption = true;
              break;

              default:
                System.out.println("Opci�n inv�lida");
          }

        } else {
          System.out.println("Opci�n 1: Muro horizontal.\nOpci�n 2: Muro vertical.");

          optionSecond = sc.nextInt();

          if (optionSecond != 1 && optionSecond != 2) {
            System.out.println("Opci�n no v�lida");
            continue;
          }

          if (optionSecond == 1) {
            System.out.println("Eliga el n�mero de 'fila' donde desea colocar el muro");
            positionX = sc.nextInt();

            System.out.println("Eliga el n�mero de 'columna' donde desea colocar el muro");
            positionY = sc.nextInt();

            System.out.println("�Hacia qu� lado desea extender el muro?\nOpci�n 1: Izquierda.\nOpci�n 2: Derecha.");

            optionThird = sc.nextInt();

            if (optionSecond != 1 && optionSecond != 2) {
              System.out.println("Opci�n no v�lida");
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
            System.out.println("Eliga el n�mero de 'fila' donde desea colocar el muro");
            positionX = sc.nextInt();

            System.out.println("Eliga el n�mero de 'columna' donde desea colocar el muro");
            positionY = sc.nextInt();

            System.out.println("�Hacia qu� lado desea extender el muro?\nOpci�n 1: Arriba.\nOpci�n 2: Abajo.");

            optionThird = sc.nextInt();

            if (optionSecond != 1 && optionSecond != 2) {
              System.out.println("Opci�n no v�lida");
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
    peonAHistoria.add(peonAPosicionX);
    peonAHistoria.add(peonAPosicionY);
    peonBHistoria.add(peonBPosicionX);
    peonBHistoria.add(peonBPosicionY);

    sc.close();


  }

}