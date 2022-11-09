package consola.estructura;

import consola.tablero.Tablero;

public class FuncionSalir {
    
    public void salir(Pawn pawn1, Pawn pawn2, Tablero table){
        System.out.println("Saliendo del juego...");
        System.out.println("Posición de cada jugador...");
        table.mostrarTablero();
        System.out.println();
        pawn1.obtenerHistorial();
        pawn2.obtenerHistorial();
  
    }
}
