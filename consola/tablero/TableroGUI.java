package consola.tablero;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import consola.estructura.Funciones;

public class TableroGUI extends JFrame implements ActionListener {
    private static int gridSize = 17;
    private static int boxSize = 50;
    public static int[] actualBox = new int[2];
    public final JButton[][] boxes = new JButton[gridSize][gridSize];
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
        createOption();

        contentPane.add(leftPanel);

        // Panel del botón
        JPanel buttonPanel = new JPanel();

        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        for (int i = 0; i < gridSize; i++) {
            c.gridy = i;
            for (int j = 0; j < gridSize; j++) {
                c.gridx = j;
                
                c.weightx = 0.5;
                JButton box = new JButton();
                box.setActionCommand((i + 1) + "-" + (j + 1));
                box.setFont(font);
                box.setForeground(Color.WHITE);
                box.setMargin(new Insets(1, 1, 1, 1));
                if (i % 2 == 0) {
                    c.fill = GridBagConstraints.HORIZONTAL;
                    if (j % 2 == 0) {
                        box.setPreferredSize(new Dimension(boxSize, boxSize));
                        box.setBackground(Color.black);
                 
                    } else {
                        c.fill = GridBagConstraints.VERTICAL;
                        box.setPreferredSize(new Dimension(5, 5));
                        box.setBackground(Color.gray);

                    }
                } else {
                    box.setPreferredSize(new Dimension(5, 5));
                    box.setBackground(Color.gray);
                }

                box.addActionListener(this);
                buttonPanel.add(box, c);
                boxes[i][j] = box;
            }
        }

        contentPane.add(buttonPanel);

        this.setContentPane(contentPane);
        this.setSize(800, 800);
        this.pack();
        this.setLocationByPlatform(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
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

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (e.getSource() == boxes[i][j]) {
                    actualBox[0] = i + 1;
                    actualBox[1] = j + 1;
                }

            }
        }

    }

}
