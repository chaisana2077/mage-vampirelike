
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main extends JFrame{
    public BufferedImage wp;
    public BufferedImage buttonStart;
    public BufferedImage buttonSettings;
    public BufferedImage buttonGetOut;


    Main(){

        /*setSize(800, 600);*/
        setExtendedState(JFrame.MAXIMIZED_BOTH); 

        setVisible(true);

        try{
            wp = ImageIO.read(new File("C:/Users/plato/Downloads/7241501.png"));

            buttonStart = ImageIO.read(new File("C:/Users/plato/Downloads/ButtonPlay.png"));
            buttonSettings = ImageIO.read(new File("C:/Users/plato/Downloads/ButtonSettings.png"));
            buttonGetOut = ImageIO.read(new File("C:/Users/plato/Downloads/ButtonGetOut.png"));
            
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

public void paint(Graphics g)
{
    super.paint(g);
     int width = getWidth();
     int height = getHeight();
    
    g.drawImage(wp, 0, 0, width,height, this);

    int buttonStartWidth = 200;  
    int buttonStartHeight = 110;

    int buttonSettingsWidth = 200;  
    int buttonSettingsHeight = 110;
    
    int buttonGetOutWidth = 200;  
    int buttonGetOutHeight = 110;

    g.drawImage(buttonStart,(width / 2) - (buttonStartWidth / 2) , 200, buttonStartWidth, buttonStartHeight, this);
    
    g.drawImage(buttonSettings,(width / 2) - (buttonStartWidth / 2) , 400, buttonSettingsWidth, buttonSettingsHeight, this);
    
    g.drawImage(buttonGetOut,(width / 2) - (buttonStartWidth / 2) , 600, buttonGetOutWidth, buttonGetOutHeight, this);

}


    public static void main(String[] args)
    {
        new Main();
    }
}