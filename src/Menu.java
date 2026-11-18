import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class Menu extends JFrame {


    public BufferedImage wp, buttonStart, buttonGetout, buttonSettings;


    int buttonStartWidth = 200;
    int buttonStartHeight = 110;

    int buttonSettingsWidth = 200;
    int buttonSettingsHeight = 110;

    int buttonGetOutWidth = 200;
    int buttonGetOutHeight = 110;

    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {

            if (e.getPoint().x > 860  && e.getPoint().x < 1060 && e.getPoint().y > 345 && e.getPoint().y < 455) {

                new Main();

            }
            if (e.getPoint().x > 860  && e.getPoint().x < 1060 && e.getPoint().y > 485 && e.getPoint().y < 595) {

                System.out.println("start");

            }
            if (e.getPoint().x > 860  && e.getPoint().x < 1060 && e.getPoint().y > 625 && e.getPoint().y < 735) {

                System.exit(0);

            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };


    Menu(){
        try{
            wp = ImageIO.read(new File("src/pictures/7241501.png"));

            buttonStart = ImageIO.read(new File("src/pictures/ButtonPlay.png"));
            buttonSettings = ImageIO.read(new File("src/pictures/ButtonSettings.png"));
            buttonGetout = ImageIO.read(new File("src/pictures/ButtonGetOut.png"));

        } catch (Exception e){
            throw new RuntimeException(e);

        }
        setSize(1920, 1080);
        setVisible(true);
        addMouseListener(ml);


    }
    public void paint(Graphics g)

    {
        super.paint(g);


        g.drawImage(wp, 0, 0, 1920, 1080, this);


        g.drawImage(buttonStart, 860, 345, buttonStartWidth, buttonStartHeight, this);

        g.drawImage(buttonSettings, 860, 485, buttonSettingsWidth, buttonSettingsHeight, this);

        g.drawImage(buttonGetout, 860, 625, buttonGetOutWidth, buttonGetOutHeight, this);

    }
    public static void main(String[] args)
    {
        new Menu();
    }
}