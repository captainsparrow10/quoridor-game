// package consola.estructura;
// import consola.tablero.Tablero;
// import java.util.Scanner;
// import consola.estructura.Wall;

// public class FuncionWall {
//     Tablero table = new Tablero();
//     public void colocarMuro(int option, int playerActual){
//         int optionThird, positionX, positionY;
//         Boolean responseWalls = false;
//         Scanner sc = new Scanner(System.in);



//         switch(option){
//             case 1:
//                 System.out.println("Eliga el n�mero de 'fila' donde desea colocar el muro");
//                 positionX = sc.nextInt();

//                 System.out.println("Eliga el n�mero de 'columna' donde desea colocar el muro");
//                 positionY = sc.nextInt();

//                 System.out.println(
//                     "�Hacia qui�n lado desea extender el muro?\nOpci�n 1: Izquierda.\nOpci�n 2: Derecha.\nOpci�n 3: Volver.");

//                 optionThird = sc.nextInt();
//         }

//              if (option == 1) {
            

//             if (option != 1 && option != 2) {

//               if (option == 3) {
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

//             if (option != 1 && option != 2) {

//               if (option == 3) {
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
  
// }
