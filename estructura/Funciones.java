package estructura;
import java.util.ArrayList;
import java.util.Scanner;

import tablero.Tablero;

public class Funciones {
    Scanner sc = new Scanner(System.in);
   
    
    public Boolean movilidadPeon(Pawn player, Tablero table) {
        int option;
        try{

        
            System.out.println(
                "Hacia que direccion desea moverse?\nOpcion 1: Hacia arriba.\nOpcion 2: Hacia abajo.\nOpcion3: Hacia la derecha.\nOpcio 4: Hacia la izquierda.\nOpcio 5: Volver.");
        
                option = Integer.parseInt(sc.nextLine());
        
            switch (option) {
            case 1:
        
                if (table.tablero[player.getPosition()[1] - 1][player
                    .getPosition()[1]] == "v") {
                System.out.println("Hay una valla aqui prueba en otro lugar.");
                return false;
                }
        
                // Eliminamos la posici�n del pe�n actual en el tablero.
                table.tablero[player.getPosition()[0]][player
                    .getPosition()[1]] = " ";
        
                // Actualizamos la nueva posici�n del jugador.
                player.moveUp();
        
                // Actualizamos la nueva posici�n del pe�n en la tabla.
                table.agregarPosicionPeon(player.getPosition()[0],
                    player.getPosition()[1], player.getId());
                return true;
        
        
            case 2:
        
                if (table.tablero[player.getPosition()[0] + 1][player
                    .getPosition()[1]] == "v") {
                System.out.println("Hay una valla aqui prueba en otro lugar.");
                return false;
                }
        
                table.tablero[player.getPosition()[0]][player
                    .getPosition()[1]] = " ";
                player.moveDown();
                table.agregarPosicionPeon(player.getPosition()[0],
                    player.getPosition()[1], player.getId());
        
                return true;
        
            case 3:
                if (table.tablero[player.getPosition()[0]][player
                    .getPosition()[1] + 1] == "v") {
                System.out.println("Hay una valla aqui prueba en otro lugar.");
                return false;
                }
        
                table.tablero[player.getPosition()[0]][player
                    .getPosition()[1]] = " ";
                player.moveRight();
                table.agregarPosicionPeon(player.getPosition()[0],
                    player.getPosition()[1], player.getId());
        
                return true;
        
            case 4:
                if (table.tablero[player.getPosition()[0]][player
                    .getPosition()[1] - 1] == "v") {
                System.out.println("Hay una valla aqui prueba en otro lugar.");
                return false;
                }
        
                table.tablero[player.getPosition()[0]][player
                    .getPosition()[1]] = " ";
                player.moveLeft();
                table.agregarPosicionPeon(player.getPosition()[0],
                    player.getPosition()[1], player.getId());
        
                return true;
        
            case 5:
                System.out.println("Regresando...");
                return false;
                
            default:
                System.out.println("Opcio invaida");
                return false;
            }
        }
        catch(Exception e){
            System.out.println("Ha introducido algun valor invaido, intente nuevamente");
            return false;
        }
    
      }

    public Boolean colocarMuro(Pawn pawn, Tablero table) {
        int option, positionX, positionY;
        Boolean responseWalls = false;
        Wall walls = new Wall();
     
        try{
        System.out.println("Opcion 1: Muro horizontal.\nOpcion 2: Muro vertical.\nOpcion 3: Volver.");
        option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1:
                    System.out.println("Eliga el numero de 'fila' donde desea colocar el muro");
                    positionX = sc.nextInt() - 1;

                    System.out.println("Eliga el numero de 'columna' donde desea colocar el muro");
                    positionY = sc.nextInt() - 1;

                    System.out.println(
                            "Hacia que lado desea extender el muro?\nOpcion 1: Izquierda.\nOpcion 2: Derecha.\nOpcion 3: Volver.");

                    option = sc.nextInt();

                        if (option != 1 && option != 2) {

                            if (option == 3) {
                                System.out.println("Regresando...");
                            } else {
                                System.out.println("Opcion no valida");
                            }
                            return false;
                        }

                        if (option == 1) {

                            // Guardamos la respuesta (true o false) para ver si es posible colocar una
                            // valla ah�.
                            responseWalls = walls.colocarVallaHorizontal(positionX, positionY, positionY - 2, table.tablero,
                                    pawn.walls);

                            // En caso de que no se pueda colocar un vaya, repetimos el turno.
                            if (!responseWalls) {
                                return false;
                            }
                        } else {
                            responseWalls = walls.colocarVallaHorizontal(positionX, positionY, positionY + 2, table.tablero,
                                    pawn.walls);
                            if (!responseWalls) {
                                return false;
                            }
                        }
                        table.mostrarTablero();
                        return true;
                    

                case 2:

                    System.out.println("Eliga el numero de 'fila' donde desea colocar el muro");
                    positionX = sc.nextInt() - 1;

                    System.out.println("Eliga el numero de 'columna' donde desea colocar el muro");
                    positionY = sc.nextInt() - 1;

                    System.out.println(
                            "Hacia que lado desea extender el muro?\nOpcion 1: Arriba.\nOpcion 2: Abajo.\nOpcion 3: Volver.");

                    option = sc.nextInt();

                    if (option != 1 && option != 2) {

                        if (option == 3) {
                            System.out.println("Regresando...");
                        } else {
                            System.out.println("Opcion no valida");
                        }
                        return false;
                    }

                    if (option == 1) {
                        responseWalls = walls.colocarVallaVertical(positionY, positionX, positionX - 2, table.tablero,
                                pawn.walls);
                        if (!responseWalls) {
                            return false;
                        }
                    } else {
                        responseWalls = walls.colocarVallaVertical(positionY, positionX, positionX + 2, table.tablero,
                                pawn.walls);
                        if (!responseWalls) {
                            return false;
                        }
                    }
                    table.mostrarTablero();
                    return true;

                default:
                    System.out.println("Opcion invalida");
                    return false;

            }
        }
        catch(Exception e){
            System.out.println("Ha introcido algún valor inválido, intente nuevamente");
            return false;
        }    
    }

    public void salirJuego(Pawn pawn1, Pawn pawn2, Tablero table){
        System.out.println("Saliendo del juego...");
        System.out.println("Posición de cada jugador...");
        table.mostrarTablero();
        System.out.println();
        pawn1.obtenerHistorial();
        pawn2.obtenerHistorial();
  
    }

    public void iniciarJugadores(Tablero table, ArrayList<Pawn> listaPlayers ){
        String name;
        table.llenartablero();
        table.mostrarTablero();

    System.out.println("Ingrese nombre del jugador #1");
    name = sc.nextLine();

    // Inicializamos el primer player y lo agregaros a la lista de jugadores.
    Pawn player1 = new Pawn(name, "A", 0, 8);
    listaPlayers.add(player1);

    // Actualizamos la posici�n del player en el tablero.
    table.agregarPosicionPeon(listaPlayers.get(0).getPosition()[0], listaPlayers.get(0).getPosition()[1],
        listaPlayers.get(0).getId());

    System.out.println("Ingrese nombre del jugador #2");
    name = sc.nextLine();

    Pawn player2 = new Pawn(name, "B", 16, 8);
    listaPlayers.add(player2);
    table.agregarPosicionPeon(listaPlayers.get(1).getPosition()[0], listaPlayers.get(1).getPosition()[1],
        listaPlayers.get(1).getId());

    }

    public Boolean jugadorGanador(ArrayList<Pawn> listaPlayers){
        if(listaPlayers.get(0).getPosition()[0] == 16){
            System.out.println("Felicidades " + listaPlayers.get(0).getName() + ", haz ganado.");
            return true;
        } 

        if (listaPlayers.get(1).getPosition()[0] == 0){
            System.out.println("Felicidades " + listaPlayers.get(1).getName() + ", haz ganado.");
            return true;
        } 

        return false;
    }


}
