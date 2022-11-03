import tablero.Tablero;
import java.util.Scanner;
import movement.Pawn;

class Main {
  public static void main(String[] args) {
    // Aqui se relaizar�n toda las llamadas que se van a realizar
    String name, playerActual;
    int optionMain, optionSecond;
    Boolean end = false;
    Scanner sc = new Scanner(System.in);

    System.out.println("Ingrese nombre del jugador #1");
    name = sc.nextLine();

    // Inicializamos el primer player
    Pawn player1 = new Pawn(name, "1");
    player1.setPosition(9, 0);

    System.out.println("Ingrese nombre del jugador #2");
    name = sc.nextLine();

    // Inicializamos el segundo player
    Pawn player2 = new Pawn(name, "2");
    player2.setPosition(9, 17);

    // Colocamos el player actual
    playerActual = player2.getId();

    // Iniciamos el tablero
    Tablero.llenartablero();

    // Iniciamos el juego.
    while (!end) {

      // Turnamos a los jugadores
      playerActual = playerActual.equals("2") ? "1" : "2";

      // Le preguntas a el jugador qu� desea hacer
      System.out.println("Turno del jugador #: " + playerActual + ".");
      System.out.println("Opci�n 1: Moverse.\nOpci�n 2: Colocar muro.");

      optionMain = sc.nextInt();

      if (optionMain != 1 && optionMain != 2) {
        System.out.println("Opci�n no v�lida");
        continue;
      }

      if (optionMain == 1) {
        System.out.println("�Hacia qu� direcc��n desea moverse?\nOpci�n 1: Hacia arriba.\n Opci�n 2: Hacia abajo.\nOpci�n 3: Hacia la derecha.\nOpci�n 4: Hacia la izquierda.");

        optionSecond = sc.nextInt();

        switch (optionSecond){
          case 1:
            //Crear algoritmo para saber si es posible moverse hacia este sitio, en caso que haya un muro se sale del switch con un break;

            //Actualizamos la nueva posici�n del jugador.
            if(playerActual.equals("1")){
              player1.moveUp();
            } else{
              player2.moveUp();
            }

            //Opcional (Falta trabajar en el problema de que los dos jugadores quieran estar en la misma posici�n en el array del tablero)
            if(playerActual.equals("1")){
              Tablero.agregarPosicionPeon(player1.getPosition()[0],player1.getPosition()[0]);
            } else{
              Tablero.agregarPosicionPeon(player2.getPosition()[0],player2.getPosition()[0]);
            }
            

          break;

          case 2:
            if(playerActual.equals("1")){
              player1.moveDown();
            } else{
              player2.moveDown();
            }
          break;

          case 3:
            if(playerActual.equals("1")){
              player1.moveRight();
            } else{
              player2.moveRight();
            }
          break;
            
          case 4:
            if(playerActual.equals("1")){
              player1.moveLeft();
            } else{
              player2.moveLeft();
            }
          break;
        }
        

      } else {
        // Opci�n 2: Mover vallas ( Falta clase de Vallas (Federico) )
      }

      
    }

    sc.close();

  }
}