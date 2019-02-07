import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JComponent;
import java.awt.Graphics2D;

public class TargetViewer
{
    public static void main(String [] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(600,600);
        frame.setTitle ("Target");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        TargetComponent tar = new TargetComponent();
        frame.add(tar);
        
        frame.setVisible(true);
    }
    
}
