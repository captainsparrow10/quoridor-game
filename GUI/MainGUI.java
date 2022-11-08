import java.awt.Color;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.io.File;

public class MainGUI extends JPanel {
  public void paint(Graphics g) {
    try {
      BufferedImage img1 = ImageIO.read(new File("./imagenes/peon1.png"));
      BufferedImage img2 = ImageIO.read(new File("./imagenes/peon2.png"));
      g.fillRect(100, 100, 900, 900);
      for (int i = 100; i <= 900; i += 100) {
        for (int j = 100; j <= 900; j += 100) {
          g.clearRect(i, j, 50, 50);
          if (i == 500 && j == 100) {
            g.drawImage(img1, i, j, 50, 50, getFocusCycleRootAncestor());
          }
          if (i == 500 && j == 900) {
            g.drawImage(img2, i, j, 50, 50, getFocusCycleRootAncestor());
          }
        }
      }
    } catch (Exception e) {
      System.err.println(e);
    }
  }

  // https://www.youtube.com/watch?v=vO7wHV0HB8w&t=1071s&ab_channel=ScreenWorks
  // https://www.youtube.com/watch?v=no4m-TIX-rc&t=207s&ab_channel=1BestCsharpblog
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setSize(900, 900);
    frame.getContentPane().add(new MainGUI());
    frame.setLocationRelativeTo(null);
    frame.setBackground(Color.LIGHT_GRAY);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
