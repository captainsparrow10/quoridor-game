package estructura;


//Clase walls
public class Wall{

    public Boolean colocarVallaHorizontal(int x, int y1, int y2, String[][] tablero, int walls){
        if(walls>0){
            if(tablero[x][y1]=="x" && tablero[x][y2]=="x"){
                tablero[x][y1] = "v";
                tablero[x][y2] = "v";
                System.out.println("Vaya colocada correctamente.");
                return true;
            }else{
                System.out.println(tablero[x][y1]=="x");
                System.out.println(tablero[x][y2]=="x");
                System.out.println("x:" + x);
                System.out.println("y1:" + y1);
                System.out.println("y2:" + y2);
                System.out.println("Usted no puede colocar una valla aqui.");
                return false;
            }
        }else{
            System.out.println("Usted no cuenta con mas vallas.");
            return false;
        }
    }

    public Boolean colocarVallaVertical(int y, int x1,int x2, String[][] tablero, int walls){
        if(walls>0){
            if(tablero[x1][y]=="x" && tablero[x2][y]=="x" ){
                tablero[x1][y] = "v";
                tablero[x2][y] = "v";
                System.out.println("Vaya colocada correctamente.");
                return true;
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