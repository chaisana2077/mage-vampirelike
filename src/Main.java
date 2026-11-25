import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main extends JFrame {
    public BufferedImage wp;
    public BufferedImage pers;
    public BufferedImage rock;

    boolean up = false;
    boolean down = false;
    boolean left = false;
    boolean right = false;

    int step = 6;
    int persX = 50;
    int persY = 50;
    int persW = 35;
    int persH = 66;

    int rockX = 300;
    int rockY = 300;
    int rockW = 441;
    int rockH = 305;

    Main() {
        try {
            wp = ImageIO.read(new File("src/pictures/wpplay.jpg"));
            pers = ImageIO.read(new File("src/pictures/Mage.png"));
            rock = ImageIO.read(new File("src/pictures/rock.png"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(wp, 0, 0, 1920, 1080, this);
                g.drawImage(pers, persX, persY, persW, persH, this);
                g.drawImage(rock, rockX, rockY, rockW, rockH, this);

                g.setColor(Color.RED);
                g.drawRect(persX, persY, persW, persH);
                g.drawRect(rockX, rockY, rockW, rockH);}
        };
        add(panel);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int k = e.getKeyCode();
                if (k == KeyEvent.VK_W) up = true;
                if (k == KeyEvent.VK_S) down = true;
                if (k == KeyEvent.VK_D) right = true;
                if (k == KeyEvent.VK_A) left = true;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int k = e.getKeyCode();
                if (k == KeyEvent.VK_W) up = false;
                if (k == KeyEvent.VK_S) down = false;
                if (k == KeyEvent.VK_A) left = false;
                if (k == KeyEvent.VK_D) right = false;
            }
        });

        new Thread(() -> {
            while (true) {
                int newX = persX;
                int newY = persY;

                if (up) newY -= step;
                if (down) newY += step;
                if (left) newX -= step;
                if (right) newX += step;

                boolean hit = false;


                if (newX + persW > rockX && newX < rockX + rockW && newY + persH > rockY && newY < rockY + rockH) {
                    hit = true;
                }


                if (!hit) {
                    persX = newX;
                    persY = newY;
                }

                panel.repaint();

                try {
                    Thread.sleep(17);
                } catch (InterruptedException ignored) {}
            }
        }).start();

        setSize(1920, 1080);
        setTitle(" game ");
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
