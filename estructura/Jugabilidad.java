package estructura;

import tablero.Tablero;
import tablero.TableroGUI;
import java.util.ArrayList;
import javax.swing.*;

public class Jugabilidad {
  public void iniciarJuego() {
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
        try {
          option = Integer.parseInt(JOptionPane.showInputDialog(null,
              "Opcion 1: Moverse.\nOpcion 2: Colocar muro.\nOpcion 3: Salir del juego.",
              "\nTurno de: " + listaPlayers.get(playerActual).getName() + ".", JOptionPane.INFORMATION_MESSAGE));
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Caracter no valido", "mensaje de error.", JOptionPane.ERROR_MESSAGE);
        }

        //Switch para elegir entre moverse y colocar muro.
        switch (option) {
          case 1:
            endOption = funct.movilidadPeon(listaPlayers.get(playerActual), table, table2);
            break;
          case 2:
            endOption = funct.colocarMuro(listaPlayers.get(playerActual), table, table2);
            break;

          case 3:
            JOptionPane.showMessageDialog(null, "Salida interrumpida.", "mensaje de error.", JOptionPane.ERROR_MESSAGE);
            funct.salirJuego(listaPlayers.get(0), listaPlayers.get(1), table, table2);
            return;

          default:
            JOptionPane.showMessageDialog(null, "Opcion no valida", "mensaje de error.", JOptionPane.ERROR_MESSAGE);
            break;
        }

        // Aquí se verifica si uno de los dos jugadores a ganado.
        end = funct.jugadorGanador(listaPlayers, table2);
        if(end == true){
          funct.salirJuego(listaPlayers.get(0), listaPlayers.get(1), table, table2);
        }

      }
    }

  }

}