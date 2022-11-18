package tablero;

import java.awt.*;
import javax.swing.*;
import estructura.Funciones;

public class TableroGUI extends JFrame{
     //Declaración del tablero en GUI
    private static int boxSize = 50;
    public static int[] actualBox = new int[2];
    public final JButton[][] boxes = new JButton[17][17];
    public final JButton[][] walls = new JButton[2][10];

    //Variables para recorrer un ciclo.
    int a = 0;
    int b = 0;
    JPanel leftPanel;
    Font font = new Font("Arial", Font.BOLD, 15);
    Funciones func = new Funciones();

    //Función  para crear y desplegar el tablero en GUI
    public void createAndDisplayGUI() {

        //Creamos el panel principal.
        JPanel contentPane = new JPanel();


        // Panel del botón
        JPanel buttonPanel = new JPanel();

        //Le creamos un layout personalizado a el panel.
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //Ciclo para la creación del tablero
        for (int i = 0; i < 19; i++) {
            c.gridy = i;
            for (int j = 0; j < 21; j++) {
                c.gridx = j;
                c.weightx = 0.5;
                // Creación del botón
                JButton box = new JButton();

                //Colocar la fuente
                box.setFont(font);

                //Colocar el color de la font
                box.setForeground(Color.white);

                //Colocar el margin de los botones
                box.setMargin(new Insets(1, 1, 1, 1));


                //Ciclos para la creación de las coordenadas en el tablero.
                if ((i == 0 && (j >= 2 && j <= 18)) && j % 2 == 0) {
                    box.setText((j - 1) + "");
                }

                if((j == 0 && (i >= 1 && i <= 17)) && i % 2 != 0){
                    box.setText((i) + "");
                }


                // Ciclos para la creación de los walls externos en el tablero.
                if (i == 0 || i == 18) {
                    if (j % 2 == 0) {
                        box.setPreferredSize(new Dimension(boxSize, boxSize));
                        box.setBackground(Color.decode("#663300"));

                    } else {
                        c.fill = GridBagConstraints.VERTICAL;
                        box.setPreferredSize(new Dimension(12, 12));
                        box.setBackground(Color.yellow);
                        if (b == 10) {
                            a = 1;
                            b = 0;
                        }

                        walls[a][b] = box;
                        b++;

                    }
                } else {

                    //Ciclo para colorear y darle tamaño a las casillas
                    if (i % 2 != 0) {
                        c.fill = GridBagConstraints.HORIZONTAL;
                        if (j % 2 == 0) {
                            if (j == 0 || j == 20) {
                                //funciones para dar tamaño  a las casillas
                                box.setPreferredSize(new Dimension(boxSize, boxSize));
                                //Funciones para colorear casillas
                                box.setBackground(Color.gray);
                            } else {
                                box.setPreferredSize(new Dimension(boxSize, boxSize));
                                box.setBackground(Color.black);
                            }

                        } else {
                            c.fill = GridBagConstraints.VERTICAL;
                            box.setPreferredSize(new Dimension(12, 12));
                            box.setBackground(Color.gray);
                        }
                    } else {
                        box.setPreferredSize(new Dimension(12, 12));
                        box.setBackground(Color.gray);
                    }
                }

                //Añadimos las casillas al tablero.
                buttonPanel.add(box, c);
                
                //Ciclo para guardar las casillas en un array de JButton
                if (i > 0 && i < 18) {
                    if (j > 1 && j < 19) {

                        boxes[i - 1][j - 2] = box;
                    }
                }

            }
        }

        //Agregamos el panel de botones a el panel principal.
        contentPane.add(buttonPanel);
        

        //Se agrega el panel a la ventana.
        this.setContentPane(contentPane);

        //Se agrega el tamaño de la ventana.
        this.setSize(800, 800);
        this.pack();

        this.setLocationByPlatform(true);
        //Hacemos visible la ventana.
        this.setVisible(true);
        //Hacemos que al seleccionar la "X" de la ventana se cierre.
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Colocamos el título de la ventana.
        this.setTitle("Quoridor Game");

    }

    // Función para destruir la ventana.
    public void destroyGame() {
        this.dispose(); 
    }

}
