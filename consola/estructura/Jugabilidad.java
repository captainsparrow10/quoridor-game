package consola.estructura;

import java.util.Scanner;
import consola.tablero.Tablero;

import java.util.ArrayList;

public class Jugabilidad {
    public void iniciarJuego(){
    // Nombre del jugador
    String name;
    int playerActual, option = 0;
    Boolean end = false, endOption = false;

    Tablero table = new Tablero();
    Scanner sc = new Scanner(System.in);
    FuncionPeon funcionPeon = new FuncionPeon();
    FuncionWall funcionWall = new FuncionWall();
    FuncionSalir funcionSalir = new FuncionSalir();
    ArrayList<Pawn> listaPlayers = new ArrayList<Pawn>();

    // Iniciamos el tablero y lo imprimimos.
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
        System.out.println("Opci�n 1: Moverse.\nOpci�n 2: Colocar muro.\nOpción 3: Salir del juego.");
        option = sc.nextInt();

      
        switch (option) {
          case 1:
          endOption = funcionPeon.movilidadPeon(listaPlayers.get(playerActual), table);
            break;
          case 2:
          endOption = funcionWall.colocarMuro(listaPlayers.get(playerActual), table);
            break;

          case 3:
            end = true;
            endOption = true;
            funcionSalir.salir(player1, player2, table);
            break;

          default:
            System.out.println("Opci�n no v�lida");
            break;
        }

        //Wincodition

          if(listaPlayers.get(0).getPosition()[0] == 16){
            System.out.println("Felicidades " + listaPlayers.get(0).getName() + ", haz ganado.");
            end = true;
        } 

        if (listaPlayers.get(1).getPosition()[0] == 0){
            System.out.println("Felicidades " + listaPlayers.get(1).getName() + ", haz ganado.");
            end = true;
        } 

      }
    }

    sc.close();

  }

}