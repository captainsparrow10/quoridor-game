package consola.estructura;

import java.util.Scanner;
import consola.tablero.Tablero;

import java.util.ArrayList;

public class Jugabilidad {
    public void iniciarJuego(){
      Tablero table = new Tablero();
      Scanner sc = new Scanner(System.in);
      Funciones funct = new Funciones();
      ArrayList<Pawn> listaPlayers = new ArrayList<Pawn>();
      int playerActual, option = 0;
      Boolean end = false, endOption = false;
    
    funct.iniciarJugadores(table, listaPlayers);

    // Colocamos el player actual.
    playerActual = 1;

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
          endOption = funct.movilidadPeon(listaPlayers.get(playerActual), table);
            break;
          case 2:
          endOption = funct.colocarMuro(listaPlayers.get(playerActual), table);
            break;

          case 3:
            funct.salirJuego(listaPlayers.get(0), listaPlayers.get(1), table);
            return;

          default:
            System.out.println("Opci�n no v�lida");
            break;
        }

        //Wincodition
        end = funct.jugadorGanador(listaPlayers);

      }
    }

    sc.close();

  }

}