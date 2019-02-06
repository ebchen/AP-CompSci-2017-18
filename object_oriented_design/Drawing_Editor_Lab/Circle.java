import java.awt.geom.Point2D;
import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Ellipse2D;

/**
 * Circle class that extends DrawingShape
 * 
 * @author ebchen
 * @version 2/27/18
 */
public class Circle extends DrawingShape
{
    /**
     * Constructs the Circle
     */
    public Circle(Point2D.Double center, double radius, Color color)
    {
        super (center, radius, color);
    }
    
    /**
     * Checks if a point is inside the circle
     * 
     * @param point to be checked
     */
    public boolean isInside(Point2D.Double point)
    {
        double distanceFromCenter = Math.hypot(super.getCenter().getX() - point.getX(), super.getCenter().getY() - point.getY());
        if (distanceFromCenter < super.getRadius()) return true;
        return false;
    }

    /**
     * Resizes the circle
     * 
     * @param the point to be resized to 
     */
    public  void resize(Point2D.Double point)
    {

        double x = point.getX();
        double y = point.getY();
        double distanceFromCenter = Math.hypot(super.getCenter().getX() - point.getX(), super.getCenter().getY() - point.getY());
        
       

        if (isOnBorder(point))
        {
            super.setRadius(distanceFromCenter);
        }
    }
    /**
     * Checks to see if a point is on the border of the circle
     * 
     * @param point point to be checked
     */
    public boolean isOnBorder(Point2D.Double point)
    {
        double distanceFromCenter = Math.hypot(super.getCenter().getX() - point.getX(), super.getCenter().getY() - point.getY());
        double EPSILON = 10;
        if (Math.abs(distanceFromCenter - super.getRadius()) < EPSILON) return true;
        return false;
    }

    
    /**
     * Draws the circle
     * 
     * @param g2 the graphics object
     * @param filled if the shape is filled or not
     */
    public void draw(Graphics2D g2, boolean filled)
    {
        Ellipse2D.Double circle = new Ellipse2D.Double(super.getCenter().getX() - super.getRadius(), super.getCenter().getY() - super.getRadius(),
                super.getRadius()*2, super.getRadius()*2);
        
        g2.setColor(super.getColor());
        g2.draw(circle);
        if (filled)
        {
            g2.fill(circle);
        }
    }
}
