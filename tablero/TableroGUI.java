package tablero;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import estructura.Funciones;

public class TableroGUI extends JFrame implements ActionListener {
    private static int boxSize = 50;
    public static int[] actualBox = new int[2];
    public final JButton[][] boxes = new JButton[17][17];
    public final JButton[][] walls = new JButton[2][10];
    int a = 0;
    int b = 0;
    private JButton startButton;
    private JButton finishButton;
    private JButton moveButton;
    private JButton putWallButton;
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
                box.setActionCommand((i + 1) + "-" + (j + 1));
                box.setFont(font);
                box.setForeground(Color.WHITE);
                box.setMargin(new Insets(1, 1, 1, 1));
                if (i == 0 || i == 18) {
                    if (j % 2 == 0) {
                        box.setPreferredSize(new Dimension(boxSize, boxSize));
                        box.setBackground(Color.decode("#663300"));

                    } else {
                        c.fill = GridBagConstraints.VERTICAL;
                        box.setPreferredSize(new Dimension(5, 5));
                        box.setBackground(Color.yellow);
                        if ( b == 10) {
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
                                box.setBackground(Color.decode("#663300"));
                            } else {
                                box.setPreferredSize(new Dimension(boxSize, boxSize));
                                box.setBackground(Color.black);
                            }

                        } else {
                            c.fill = GridBagConstraints.VERTICAL;
                            box.setPreferredSize(new Dimension(5, 5));
                            box.setBackground(Color.gray);
                        }
                    } else {
                        box.setPreferredSize(new Dimension(5, 5));
                        box.setBackground(Color.gray);
                    }
                }
                box.addActionListener(this);
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

    public void createOption() {

        leftPanel = new JPanel();

        startButton = new JButton();
        startButton.setText("Iniciar");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

            }
        });

        moveButton = new JButton();
        moveButton.setText("Mover");
        moveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

            }
        });

        putWallButton = new JButton();
        putWallButton.setText("Colocar muro");
        putWallButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

            }
        });

        finishButton = new JButton();
        finishButton.setText("Terminar");
        finishButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

            }
        });

        leftPanel.add(startButton);
        leftPanel.add(finishButton);
        leftPanel.add(moveButton);
        leftPanel.add(putWallButton);

        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
    }

    // Todavía no tiene uso, probablemente lo utilizaremos para cuando el control
    // sea mediante clicks a las casillas.
    @Override
    public void actionPerformed(ActionEvent e) {

        // for (int i = 0; i < gridSize; i++) {
        // for (int j = 0; j < gridSize; j++) {
        // if (e.getSource() == boxes[i][j]) {
        // actualBox[0] = i + 1;
        // actualBox[1] = j + 1;
        // }

        // }
        // }

    }

    public void destroyGame() {
        this.dispose(); // Destroy the JFrame object
    }

}
