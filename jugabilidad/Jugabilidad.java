package jugabilidad;
import java.util.Arrays;
import java.util.Scanner;

public class Jugabilidad {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Creamos y rellenamos un tablero 4x4, en donde pondremos un peon y tableros
        int[][] mesaJugabilidadTest = new int[4][4];
        for(int i = 0; i<4; i++){
            for(int j = 0; j<4;j++){
                mesaJugabilidadTest[i][j]=0;
            }
        }
        //Los 0 en la mesa serian como el terreno, el 1 los muros, el 9 el peon jugador y 8 el peon IA
        mesaJugabilidadTest[0][0]=9;
        mesaJugabilidadTest[1][0]=1;
        mesaJugabilidadTest[1][2]=1;
        mesaJugabilidadTest[0][3]=1;
        mesaJugabilidadTest[2][2]=1;
        mesaJugabilidadTest[3][2]=8;
        int prueba, y = 0, x = 0;
        //Movimientos del peon jugador
        do{
            for(int[]vista : mesaJugabilidadTest){
                System.out.println(Arrays.toString(vista));
            }
            System.out.println(Arrays.toString(mesaJugabilidadTest));
            System.out.println("1. Arriba \n"+"2. Abajo \n"+"3. Izquierda \n"+"4. Derecha\n"+"5. Salir");
            prueba=scan.nextInt();
            if(prueba==1){
                //Revisar si hay muro 
                if(mesaJugabilidadTest[y-1][x]==1){
                    System.out.println("No puede moverse en dicha direccion, hay un muro ahi");
                }
                //Revisar si hay peon IA
                else if(mesaJugabilidadTest[y-1][x]==8){
                    mesaJugabilidadTest[y][x]=0;
                    mesaJugabilidadTest[y-1][x]=89;
                    y-=1;
                }
                //Revisar si el peon jugador esta con el peon IA
                else if(mesaJugabilidadTest[y][x]==89){
                    mesaJugabilidadTest[y][x]=8;
                    mesaJugabilidadTest[y-1][x]=9;
                    y-=1;
                }
                //Movimiento normal
                else{
                    mesaJugabilidadTest[y][x]=0;
                    mesaJugabilidadTest[y-1][x]=9;
                    y-=1;
                }
            }
            else if(prueba==2){
                //Revisar si hay muro
                if(mesaJugabilidadTest[y+1][x]==1){
                    System.out.println("No puede moverse en dicha direccion, hay un muro ahi");
                }
                //Revisar si hay peon IA
                else if(mesaJugabilidadTest[y+1][x]==8){
                    mesaJugabilidadTest[y][x]=0;
                    mesaJugabilidadTest[y-1][x]=89;
                    y+=1;
                }
                //Revisar si el peon jugador esta con el peon IA
                else if(mesaJugabilidadTest[y][x]==89){
                    mesaJugabilidadTest[y][x]=8;
                    mesaJugabilidadTest[y-1][x]=9;
                    y+=1;
                }// Movimiento normal
                else{
                    mesaJugabilidadTest[y][x]=0;
                    mesaJugabilidadTest[y+1][x]=9;
                    y+=1;
                }
            }
            else if(prueba==3){
                //Revisar si hay muro
                if(mesaJugabilidadTest[y][x+1]==1){
                    System.out.println("No puede moverse en dicha direccion, hay un muro ahi");
                }
                //Revisar si hay peon IA
                else if(mesaJugabilidadTest[y][x+1]==8){
                    mesaJugabilidadTest[y][x]=0;
                    mesaJugabilidadTest[y][x+1]=89;
                    x+=1;
                }
                //Revisar si el peon jugador esta con el peon IA
                else if(mesaJugabilidadTest[y][x]==89){
                    mesaJugabilidadTest[y][x]=8;
                    mesaJugabilidadTest[y][x+1]=9;
                    x+=1;
                }
                //Movimiento normal
                else{
                    mesaJugabilidadTest[y][x]=0;
                    mesaJugabilidadTest[y][x+1]=9;
                    x+=1;
                }
            }
            else if(prueba==4){
                //Revisar si hay muro
                if(mesaJugabilidadTest[y][x-1]==1){
                    System.out.println("No puede moverse en dicha direccion, hay un muro ahi");
                }
                //Revisar si hay peon IA
                else if(mesaJugabilidadTest[y][x-1]==8){
                    mesaJugabilidadTest[y][x]=0;
                    mesaJugabilidadTest[y][x-1]=89;
                    x-=1;
                }
                //Revisar si el peon jugador esta con el peon IA
                else if(mesaJugabilidadTest[y][x]==89){
                    mesaJugabilidadTest[y][x]=8;
                    mesaJugabilidadTest[y][x-1]=9;
                    x-=1;
                }
                //Movimiento normal
                else{
                    mesaJugabilidadTest[y][x]=0;
                    mesaJugabilidadTest[y][x-1]=9;
                    x-=1;
                }
            }
            else if(prueba==5){
                System.out.println("ha salido");
            }
            else{
                System.out.println("tas loco");
            }
            
        }while(prueba!=5);
    }

}