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
            int width = getWidth();
            int height = getHeight();
           if (e.getPoint().x > 0  && e.getPoint().x < 2000 && e.getPoint().y > 0 && e.getPoint().y < 300) {

                new Main();

           }
            if (e.getPoint().x > 0  && e.getPoint().x < 2000 && e.getPoint().y > 300 && e.getPoint().y < 600) {

                System.out.println("start");

            }
            if (e.getPoint().x > 0  && e.getPoint().x < 2000 && e.getPoint().y > 600 && e.getPoint().y < 900) {

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
        setSize(800, 600);
        setVisible(true);
        addMouseListener(ml);


    }
    public void paint(Graphics g)

    {
        int width = getWidth();
        int height = getHeight();
        super.paint(g);


        g.drawImage(wp, 0, 0, width,height, this);


        g.drawImage(buttonStart,(width / 2) - (buttonStartWidth / 2) , 200, buttonStartWidth, buttonStartHeight, this);

        g.drawImage(buttonSettings,(width / 2) - (buttonStartWidth / 2) , 400, buttonSettingsWidth, buttonSettingsHeight, this);

        g.drawImage(buttonGetout,(width / 2) - (buttonStartWidth / 2) , 600, buttonGetOutWidth, buttonGetOutHeight, this);

    }
    public static void main(String[] args)
    {
        new Menu();
    }
}
