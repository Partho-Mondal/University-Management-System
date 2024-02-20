package university.management.system;
import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    Thread t;
    Splash() {
        
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image image2 = image1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel image = new JLabel(image3);
        add(image);
        
        t = new Thread(this);
        t.start();
        setVisible(true);
        
        int incrementVariable = 1;
        for(int i = 2; i <= 600; i += 4, incrementVariable += 1) {
            setLocation(650-((i+incrementVariable)/2), 150-(incrementVariable)/2);
            setSize(i + 3*incrementVariable, i + incrementVariable/2);
            
            try {
                Thread.sleep(10);
            } catch(Exception e) {}
        }
        
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(7000);
            setVisible(false);
            
            // Next Frame
            new Login();
        } catch(Exception e) {
            
        }
    }
    
    public static void main(String[] args) {
        new Splash();   // Anonymous Object
    }
}
