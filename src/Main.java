
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main extends JFrame{
    public BufferedImage wp;
    public BufferedImage pers;



    Main(){

        setSize(800, 600);


        setVisible(true);

        try{
            wp = ImageIO.read(new File("src/pictures/wpplay.jpg"));

            pers = ImageIO.read(new File("src/pictures/ProtectS.png"));


        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        setTitle(" game ");
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        int width = getWidth();
        int height = getHeight();

        g.drawImage(wp, 0, 0, width,height, this);
        g.drawImage(pers, 0, 0, 300,200, this);



    }


    public static void main(String[] args)
    {
        new Main();
    }
}