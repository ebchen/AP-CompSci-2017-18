import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.awt.Color;


public class BigEllipse
{
    private int width;
    private int height;
    
    public BigEllipse(int w, int h)
    {
        width = w;
        height = h;
    }
    
    public void draw(Graphics2D g2)
    {
        Ellipse2D.Double ellipse1 = new Ellipse2D.Double(0,0, width, height);
        g2.setColor (Color.CYAN);
        g2.draw(ellipse1);
        g2.fill(ellipse1);
        
    }
    
    
}
