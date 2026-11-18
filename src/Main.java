
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter; // chitaet nazatia + class KeyListener
import java.awt.event.KeyEvent; // reakcia na nazatia + class KeyEvent
import java.awt.image.BufferedImage;
import java.io.File;

public class Main extends JFrame{
    public BufferedImage wp;
    public BufferedImage pers;
    public BufferedImage rock;

    int step = 25;
    int persX = 50;
    int persY = 50;
    int persW = 300;
    int persH = 200;


    int rockX = 300;
    int rockY = 300;
    int rockW = 200;
    int rockH = 200;



    Main(){

        try{
            wp = ImageIO.read(new File("src/pictures/wpplay.jpg"));
            pers = ImageIO.read(new File("src/pictures/ProtectS.png"));
            rock = ImageIO.read(new File("src/pictures/rock.png"));
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int newX = persX;
                int newY = persY;
                int k = e.getKeyCode();

                if (k == KeyEvent.VK_W)  newY = newY - step;
                if (k == KeyEvent.VK_S)  newY = newY + step;
                if (k == KeyEvent.VK_A)  newX = newX - step;
                if (k == KeyEvent.VK_D)  newX = newX + step;

                boolean hit = false;

                if (newX + 300 > 300 && newX < 500 && newY + 200 > 300 && newY < 500) {
                    hit = true;
                }
                if (newX < 500 && newX + 300 > 300 && newY + 200 > 300 && newY < 500) {
                    hit = true;
                }
                if (newY + 200 > 300 && newY < 500 && newX + 300 > 300 && newX < 500) {
                    hit = true;
                }
                if (newY < 500 && newY + 200 > 300 && newX + 300 > 300 && newX < 500) {
                    hit = true;
                }

                if (!hit) {
                    persX = newX;
                    persY = newY;
                }

                repaint();
            }
        });

        setSize(1920, 1080);
        setTitle(" game ");
        setVisible(true);
        }


    public void paint(Graphics g)
    {
        super.paint(g);

        g.drawImage(wp, 0, 0, 1920,1080, this);
        g.drawImage(pers, persX, persY, persW, persH, this);
        g.drawImage(rock, rockX, rockY, rockW, rockH, this);
    }

    public static void main(String[] args)
    {
        new Main();
    }
}