package tablero;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;



public class TableroGUI {
  public static void Tablero() {

    JPanel peonPosition1 = new JPanel();
    peonPosition1.setBounds(240, 0, 50, 50);
    peonPosition1.setBackground(Color.red);

    JPanel peonPosition2 = new JPanel();
    peonPosition2.setBounds(240, 480, 50, 50);
    peonPosition2.setBackground(Color.blue);

    JFrame frame = new JFrame();
    frame.setSize(600, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    boolean isBlack = true;
    boolean isPar = false;
    frame.add(peonPosition1);
    frame.add(peonPosition2);
    for (int i = 0; i < 530;) {
      if (isPar) {
        for (int j = 0; j < 530; j += 50) {
          JPanel whitePanel = new JPanel();
          whitePanel.setBackground(Color.gray);
          whitePanel.setBounds(j, i, 50, 10);
          frame.add(whitePanel);
        }
        isPar = false;
        isBlack = true;
        i += 50;
      } else {
        for (int j = 0; j < 530;) {

          if (isBlack) {
            JPanel blackPanel = new JPanel();
            blackPanel.setBackground(Color.black);
            blackPanel.setBounds(j, i, 50, 50);
            frame.add(blackPanel);
            isBlack = false;
            j += 50;
          } else {
            JPanel whitePanel = new JPanel();
            whitePanel.setBackground(Color.gray);
            whitePanel.setBounds(j, i, 10, 50);
            frame.add(whitePanel);
            isBlack = true;
            j += 10;
          }
        }
        isPar = true;
        i += 10;
      }
    }

    frame.setVisible(true);
  }
}
