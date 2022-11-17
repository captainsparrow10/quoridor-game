package tablero;

import java.awt.*;
import javax.swing.*;
import estructura.Funciones;

public class TableroGUI extends JFrame{
    private static int boxSize = 50;
    public static int[] actualBox = new int[2];
    public final JButton[][] boxes = new JButton[17][17];
    public final JButton[][] walls = new JButton[2][10];
    int a = 0;
    int b = 0;;
    JPanel leftPanel;
    Font font = new Font("Arial", Font.BOLD, 15);
    Funciones func = new Funciones();

    public void createAndDisplayGUI() {

        JPanel contentPane = new JPanel();

        // Panel de opciones.
        // Todavía no tiene función las opciones.

        // Panel del botón
        JPanel buttonPanel = new JPanel();

        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        for (int i = 0; i < 19; i++) {
            c.gridy = i;
            for (int j = 0; j < 21; j++) {
                c.gridx = j;
                c.weightx = 0.5;
                JButton box = new JButton();
                box.setFont(font);
                box.setForeground(Color.white);
                box.setMargin(new Insets(1, 1, 1, 1));

                if ((i == 0 && (j >= 2 && j <= 18)) && j % 2 == 0) {
                    box.setText((j - 1) + "");
                }

                if((j == 0 && (i >= 1 && i <= 17)) && i % 2 != 0){
                    box.setText((i) + "");
                }

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
                    if (i % 2 != 0) {
                        c.fill = GridBagConstraints.HORIZONTAL;
                        if (j % 2 == 0) {
                            if (j == 0 || j == 20) {
                                box.setPreferredSize(new Dimension(boxSize, boxSize));
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

                buttonPanel.add(box, c);
                if (i > 0 && i < 18) {
                    if (j > 1 && j < 19) {

                        boxes[i - 1][j - 2] = box;
                    }
                }

            }
        }

        contentPane.add(buttonPanel);

        this.setContentPane(contentPane);
        this.setSize(800, 800);
        this.pack();
        this.setLocationByPlatform(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Quoridor Game");

    }

    // Todavía no tiene uso, probablemente lo utilizaremos para cuando el control
    // sea mediante clicks a las casillas.


    public void destroyGame() {
        this.dispose(); // Destroy the JFrame object
    }

}
