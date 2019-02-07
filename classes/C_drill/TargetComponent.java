import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JComponent;
import java.awt.Graphics2D;

public class TargetComponent extends JComponent
{
    public void paintComponent (Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        BigEllipse big1 = new BigEllipse(width, height);
        big1.draw(g2);
      /*  Target target1 = new Target(100,300,300);
        Target target2 = new Target(50,50,100);
        Target target3 = new Target(200,400,500);
        target1.draw(g2);
        target2.draw(g2);
        target3.draw(g2);*/
        
    }
    
    
}
