package consola.estructura;

import consola.tablero.Tablero;
import java.util.Scanner;

public class FuncionWall {
    Scanner sc = new Scanner(System.in);
    public Boolean colocarMuro(Pawn playerActual, Tablero table) {
        int option, positionX, positionY;
        Boolean responseWalls = false;
        Wall walls = new Wall();
     

        System.out.println("Opci�n 1: Muro horizontal.\nOpci�n 2: Muro vertical.\nOpci�n 3: Volver.");
        option = sc.nextInt();

        switch (option) {
            case 1:
                System.out.println("Eliga el n�mero de 'fila' donde desea colocar el muro");
                positionX = sc.nextInt() - 1;

                System.out.println("Eliga el n�mero de 'columna' donde desea colocar el muro");
                positionY = sc.nextInt() - 1;

                System.out.println(
                        "�Hacia qui�n lado desea extender el muro?\nOpci�n 1: Izquierda.\nOpci�n 2: Derecha.\nOpci�n 3: Volver.");

                option = sc.nextInt();

                    if (option != 1 && option != 2) {

                        if (option == 3) {
                            System.out.println("Regresando...");
                        } else {
                            System.out.println("Opci�n no v�lida");
                        }
                        return false;
                    }

                    if (option == 1) {

                        // Guardamos la respuesta (true o false) para ver si es posible colocar una
                        // valla ah�.
                        responseWalls = walls.colocarVallaHorizontal(positionX, positionY, positionY - 2, table.tablero,
                                playerActual.walls);

                        // En caso de que no se pueda colocar un vaya, repetimos el turno.
                        if (!responseWalls) {
                            return false;
                        }
                    } else {
                        responseWalls = walls.colocarVallaHorizontal(positionX, positionY, positionY + 2, table.tablero,
                                playerActual.walls);
                        if (!responseWalls) {
                            return false;
                        }
                    }
                    table.mostrarTablero();
                    return true;
                   

            case 2:

                System.out.println("Eliga el n�mero de 'fila' donde desea colocar el muro");
                positionX = sc.nextInt() - 1;

                System.out.println("Eliga el n�mero de 'columna' donde desea colocar el muro");
                positionY = sc.nextInt() - 1;

                System.out.println(
                        "�Hacia qui�n lado desea extender el muro?\nOpci�n 1: Arriba.\nOpci�n 2: Abajo.\nOpci�n 3: Volver.");

                option = sc.nextInt();

                if (option != 1 && option != 2) {

                    if (option == 3) {
                        System.out.println("Regresando...");
                    } else {
                        System.out.println("Opci�n no v�lida");
                    }
                    return false;
                }

                if (option == 1) {
                    responseWalls = walls.colocarVallaVertical(positionY, positionX, positionX - 2, table.tablero,
                            playerActual.walls);
                    if (!responseWalls) {
                        return false;
                    }
                } else {
                    responseWalls = walls.colocarVallaVertical(positionY, positionX, positionX + 2, table.tablero,
                            playerActual.walls);
                    if (!responseWalls) {
                        return false;
                    }
                }
                table.mostrarTablero();
                return true;

            default:
                System.out.println("Opción inválida");
                return false;

        }
    }
    

}
