package consola.estructura;


import consola.tablero.Tablero;
import consola.tablero.TableroGUI;
import java.util.ArrayList;
import javax.swing.*;  

public class Jugabilidad {
    public void iniciarJuego(){
      Tablero table = new Tablero();
      Funciones funct = new Funciones();
      ArrayList<Pawn> listaPlayers = new ArrayList<Pawn>();
      TableroGUI table2 = new TableroGUI();
      
      int playerActual, option = 0;
      Boolean end = false, endOption = false;
    
    funct.iniciarJugadores(table, listaPlayers, table2);

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

      // Ciclo para poder repetir las opciones de un jugador sin cambiar el turno.
      endOption = false;
      while (!endOption) {
        try{
          option = Integer.parseInt(JOptionPane.showInputDialog(null,"Opci�n 1: Moverse.\nOpci�n 2: Colocar muro.\nOpción 3: Salir del juego.", "\nTurno de: " + listaPlayers.get(playerActual).getName() + ".", JOptionPane.INFORMATION_MESSAGE));
        }
        catch(Exception e){
          System.err.println(e);
        }

      
        switch (option) {
          case 1:
          endOption = funct.movilidadPeon(listaPlayers.get(playerActual), table, table2);
            break;
          case 2:
          endOption = funct.colocarMuro(listaPlayers.get(playerActual), table, table2);
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

   

  }

}