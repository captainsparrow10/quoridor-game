package movement;
//Clase walls
public class Wall{
    int walls = 10;

    public void colocarVallaHorizontal(int x1,int x2, int y1, int y2, String[][] tablero){
        if(this.walls>0){
            if(tablero[x1][y1]=="x" && tablero[x1][y2]=="x"){
                tablero[x1][y1] = "valla";
                tablero[x2][y2] = "valla";
                this.walls =- 1;
            }else{
                System.out.println("Usted no puede colocar una valla aqui.");
            }
        }else{
            System.out.println("Usted no cuenta con mas vallas.");
        }
    }

    public void colocarVallaVertical(int x1,int x2, int y1,int y2, String[][] tablero){
        if(this.walls>0){
            if(tablero[x1][y1]=="x" && tablero[x2][y2]=="x"){
                tablero[x1][y1] = "valla";
                tablero[x2][y2] = "valla";
                this.walls =- 1;
            }else{
                System.out.println("Usted no puede colocar una valla aqui.");
            }
        }else{
            System.out.println("Usted no cuenta con mas vallas.");
        }
    }
}