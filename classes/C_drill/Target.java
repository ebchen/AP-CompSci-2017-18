import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.awt.Color;


public class Target
{
    private int diameter;
    private int x;
    private int y;
    
    public Target(int d, int x1, int y1)
    {
        diameter = d;
        x = x1;
        y= y1;
    }
    
    public void draw(Graphics2D g2)
    {
        Ellipse2D.Double ellipse1 = new Ellipse2D.Double(x-diameter/2,y-diameter/2, diameter, diameter);
        Ellipse2D.Double ellipse2 = new Ellipse2D.Double(x-diameter*.8/2,y-diameter*.8/2, diameter*.8, diameter*.8);
        Ellipse2D.Double ellipse3 = new Ellipse2D.Double(x-diameter*.6/2,y-diameter*.6/2, diameter*.6, diameter*.6);
        Ellipse2D.Double ellipse4 = new Ellipse2D.Double(x-diameter*.4/2,y-diameter*.4/2, diameter*.4, diameter*.4);
        Ellipse2D.Double ellipse5 = new Ellipse2D.Double(x-diameter*.2/2,y-diameter*.2/2, diameter*.2, diameter*.2);
        g2.setColor (Color.BLACK);
        g2.draw(ellipse1);
        g2.fill(ellipse1);
        g2.setColor (Color.WHITE);
        g2.draw(ellipse2);
        g2.fill(ellipse2);
        g2.setColor (Color.BLACK);
        g2.draw(ellipse3);
        g2.fill(ellipse3);
        g2.setColor (Color.WHITE);
        g2.draw(ellipse4);
        g2.fill(ellipse4);
        g2.setColor (Color.BLACK);
        g2.draw(ellipse5);
        g2.fill(ellipse5);
    }
    
    
}
