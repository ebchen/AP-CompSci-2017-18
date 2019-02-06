import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.Dimension;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;



public class CircleComponent extends JComponent
{
    private double cx,cy;
    private double radius;

    public CircleComponent(double x, double y, double r)
    {
        cx = x;
        cy = y;
        radius = r;
        setPreferredSize ( new Dimension(500,500));
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        Ellipse2D circle = new Ellipse2D.Double(cx,cy, 2*radius, 2*radius);
        g2.draw(circle);
    }

    
}
