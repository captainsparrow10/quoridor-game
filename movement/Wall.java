package movement;
<<<<<<< HEAD

//Clase walls
public class Wall{

    public Boolean colocarVallaHorizontal(int x, int y1, int y2, String[][] tablero, int walls){
        if(walls>0){
            if(tablero[x][y1]=="x" && tablero[x][y2]=="x"){
                tablero[x][y1] = "v";
                tablero[x][y2] = "v";
                System.out.println("Vaya colocada correctamente.");
                return true;
=======
//Clase walls
public class Wall{
    int walls = 10;

    public void colocarVallaHorizontal(int x1,int x2, int y1, int y2, String[][] tablero){
        if(this.walls>0){
            if(tablero[x1][y1]=="x" && tablero[x1][y2]=="x"){
                tablero[x1][y1] = "valla";
                tablero[x2][y2] = "valla";
                this.walls =- 1;
>>>>>>> 8f71fe7f1613ac2f93d270cac286e898bc20c868
            }else{
                System.out.println("Usted no puede colocar una valla aqui.");
                return false;
            }
        }else{
            System.out.println("Usted no cuenta con mas vallas.");
            return false;
        }
    }

<<<<<<< HEAD
    public Boolean colocarVallaVertical(int y, int x1,int x2, String[][] tablero, int walls){
        if(walls>0){
            if(tablero[x1][y]=="x" && tablero[x2][y]=="x" ){
                tablero[x1][y] = "v";
                tablero[x2][y] = "v";
                System.out.println("Vaya colocada correctamente.");
                return true;
=======
    public void colocarVallaVertical(int x1,int x2, int y1,int y2, String[][] tablero){
        if(this.walls>0){
            if(tablero[x1][y1]=="x" && tablero[x2][y2]=="x"){
                tablero[x1][y1] = "valla";
                tablero[x2][y2] = "valla";
                this.walls =- 1;
>>>>>>> 8f71fe7f1613ac2f93d270cac286e898bc20c868
            }else{
                System.out.println("Usted no puede colocar una valla aqui.");
                return false;
            }
        }else{
            System.out.println("Usted no cuenta con mas vallas.");
            return false;
        }
    }

}