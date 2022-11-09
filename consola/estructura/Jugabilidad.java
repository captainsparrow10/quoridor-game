package consola.estructura;

import java.util.Scanner;
import javax.swing.*;
import consola.estructura.Pawn;
import consola.estructura.Wall;
import consola.tablero.Tablero;

import java.util.ArrayList;

public class Jugabilidad {
  public static void main(String[] args) {
    // Nombre del jugador
    String name;
    //
    int optionMain, optionSecond, optionThird, positionX, positionY, playerActual, option = 0;
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
    Pawn player1 = new Pawn(name, "A", 9, 0);
    listaPlayers.add(player1);

    // Actualizamos la posici�n del player en el tablero.
    table.agregarPosicionPeon(listaPlayers.get(0).getPosition()[0], listaPlayers.get(0).getPosition()[1],
        listaPlayers.get(0).getId());

    System.out.println("Ingrese nombre del jugador #2");
    name = sc.nextLine();

    Pawn player2 = new Pawn(name, "B", 9, 16);
    listaPlayers.add(player2);
    table.agregarPosicionPeon(listaPlayers.get(1).getPosition()[0], listaPlayers.get(1).getPosition()[1],
    listaPlayers.get(1).getId());

//     // Colocamos el player actual.
//     playerActual = listaPlayers.indexOf(player2);

//     // Iniciamos el juego.
//     while (!end) {

//       // Turnamos a los jugadores
//       if (listaPlayers.get(playerActual).getId() == "B") {
//         playerActual = 0;
//       } else {
//         playerActual = 1;
//       }

//       System.out.println("\nTurno de: " + listaPlayers.get(playerActual).getName() + ".");

//       // Ciclo para poder repetir las opciones de un jugador sin cambiar el turno.
//       endOption = false;
//       while (!endOption) {
//         System.out.println("Opci�n 1: Moverse.\nOpci�n 2: Colocar muro.");

//         optionMain = sc.nextInt();

//         // En caso de que el valor no est� dentro de las opciones, repetimos el ciclo
//         // (con el turno actual).
//         switch (option) {
//           case 1:

//             break;
//           case 2:
//             break;

//           default:
//             System.out.println("Opci�n no v�lida");
//             break;
//         }
//         if (optionMain != 1 && optionMain != 2) {

//           continue;
//         }

//         else {
//           System.out.println("Opci�n 1: Muro horizontal.\nOpci�n 2: Muro vertical.\nOpci�n 3: Volver.");

//           optionSecond = sc.nextInt();

//           if (optionSecond != 1 && optionSecond != 2) {

//             if (optionSecond == 3) {
//               System.out.println("Regresando...");
//             } else {
//               System.out.println("Opci�n no v�lida");
//             }

//             continue;
//           }

//           if (optionSecond == 1) {
//             System.out.println("Eliga el n�mero de 'fila' donde desea colocar el muro");
//             positionX = sc.nextInt();

//             System.out.println("Eliga el n�mero de 'columna' donde desea colocar el muro");
//             positionY = sc.nextInt();

//             System.out.println(
//                 "�Hacia qui�n lado desea extender el muro?\nOpci�n 1: Izquierda.\nOpci�n 2: Derecha.\nOpci�n 3: Volver.");

//             optionThird = sc.nextInt();

//             if (optionSecond != 1 && optionSecond != 2) {

//               if (optionSecond == 3) {
//                 System.out.println("Regresando...");
//               } else {
//                 System.out.println("Opci�n no v�lida");
//               }
//               continue;
//             }

//             if (optionThird == 1) {

//               // Guardamos la respuesta (true o false) para ver si es posible colocar una
//               // valla ah�.
//               responseWalls = walls.colocarVallaHorizontal(positionX, positionY, positionY - 2, table.tablero,
//                   listaPlayers.get(playerActual).walls);

//               // En caso de que no se pueda colocar un vaya, repetimos el turno.
//               if (!responseWalls) {
//                 continue;
//               }
//               endOption = true;
//             } else {
//               responseWalls = walls.colocarVallaHorizontal(positionX, positionY, positionY + 2, table.tablero,
//                   listaPlayers.get(playerActual).walls);
//               if (!responseWalls) {
//                 continue;
//               }
//               endOption = true;
//             }

//           } else {
//             System.out.println("Eliga el n�mero de 'fila' donde desea colocar el muro");
//             positionX = sc.nextInt();

//             System.out.println("Eliga el n�mero de 'columna' donde desea colocar el muro");
//             positionY = sc.nextInt();

//             System.out.println(
//                 "�Hacia qui�n lado desea extender el muro?\nOpci�n 1: Arriba.\nOpci�n 2: Abajo.\nOpci�n 3: Volver.");

//             optionThird = sc.nextInt();

//             if (optionSecond != 1 && optionSecond != 2) {

//               if (optionSecond == 3) {
//                 System.out.println("Regresando...");
//               } else {
//                 System.out.println("Opci�n no v�lida");
//               }
//               continue;
//             }

//             if (optionThird == 1) {
//               responseWalls = walls.colocarVallaVertical(positionY, positionX, positionX - 2, table.tablero,
//                   listaPlayers.get(playerActual).walls);
//               if (!responseWalls) {
//                 continue;
//               }
//               endOption = true;
//             } else {
//               responseWalls = walls.colocarVallaVertical(positionY, positionX, positionX + 2, table.tablero,
//                   listaPlayers.get(playerActual).walls);
//               if (!responseWalls) {
//                 continue;
//               }
//               endOption = true;
//             }

//           }

//         }

//       }

//       if (listaPlayers.get(0).getPosition()[1] == 16) {
//         System.out.println("Felicidades, " + listaPlayers.get(0).getName() + " haz ganado.");
//         end = true;
//       }

//       if (listaPlayers.get(1).getPosition()[1] == 0) {
//         System.out.println("Felicidades, " + listaPlayers.get(1).getName() + " haz ganado.");
//         end = true;
//       }

//     }

//     sc.close();

  }

}