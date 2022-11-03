import java.util.Arrays;
import java.util.Scanner;;
public class MovimientoPrueba1{
    public static void main(String[] args) {
        int[][] mesa = new int[6][6];
        for(int a = 0; a<6; a++){
            for(int b=0 ; b<6; b++){
                mesa[a][b]=0;
            }
        }
        Scanner scan = new Scanner(System.in);
        mesa[0][3]=9;
        int x = 0, y=3;
        int resp;
        do{
            for(int[]vista : mesa){
                System.out.println(Arrays.toString(vista));
            }
            System.out.println("Que movimiento quiere realizar\n"+ "1. Arriba \n"+"2. Abajo \n"+"3. Izquierda \n"+"4. Derecha\n"+"5. Salir");
            resp = scan.nextInt();
            if(resp ==1){
                arriba(mesa, x, y);
                x-=1;
            }
            else if(resp==2){
                abajo(mesa, x, y);
                x+=1;
            }
            else if(resp==3){
                izquierda(mesa, x, y);
                y-=1;
            }
            else if(resp==4){
                derecha(mesa, x, y);
                y+=1;
            }
            else if(resp==5){
                System.out.println("salio del programa");
            }
            else{
                System.out.println("NO WE QUE HACE");
            }
        }while(resp!=5);
        scan.close();
    }

    static void abajo(int[][]mesa, int x, int y){
        mesa[x][y]=0;
        if(x+1<0){
            System.out.println("NO PUEDE MOVER PARA ARRIBA, AHI ESTA EL BORDE");
        }
        else{
            mesa[x+1][y]=9;
        }
    }
    static void arriba(int[][]mesa, int x, int y){
        mesa[x][y]=0;
        if(x-1>6){
            System.out.println("NO PUEDE MOVER PARA ABAJO, AHI ESTA EL BORDE");
        }
        else{
            mesa[x-1][y]=9;
        }
    }
    static void izquierda(int[][]mesa, int x, int y){
        mesa[x][y]=0;
        if(y-1<0){
            System.out.println("NO PUEDE MOVER PARA IZQUIERDA, AHI ESTA EL BORDE");
        }
        else{
            mesa[x][y-1]=9;
        }
    }
    static void derecha(int[][]mesa, int x, int y){
        mesa[x][y]=0;
        if(y+1>6){
            System.out.println("NO PUEDE MOVER PARA DERECHA, AHI ESTA EL BORDE");
        }
        else{
            mesa[x][y+1]=9;
        }
    }
}