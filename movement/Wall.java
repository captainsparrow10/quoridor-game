package movement;

import javax.swing.text.Position;

//Clase walls
public class Wall{
    int walls;


    public Pawn(){
        this.walls = 10;
    }

    public void colocarVallaHorizontal(int x, int y1, int y2, String[][] tablero){
        if(this.walls>0){
            if(tablero[x][y1]=="x" && tablero[x][y2]=="x"){
                tablero[x][y1] = "valla";
                tablero[x][y2] = "valla";
                this.walls =- 1;
            }else{
                System.out.println("Usted no puede colocar una valla aqui.");
            }
        }else{
            System.out.println("Usted no cuenta con mas vallas.");
        }
    }

    public void colocarVallaVertical(int x1,int x2, int y, String[][] tablero){
        if(this.walls>0){
            if(tablero[x][y1]=="x" && tablero[x][y2]=="x"){
                tablero[x1][y] = "valla";
                tablero[x2][y] = "valla";
                this.walls =- 1;
            }else{
                System.out.println("Usted no puede colocar una valla aqui.");
            }
        }else{
            System.out.println("Usted no cuenta con mas vallas.");
        }
    }
}