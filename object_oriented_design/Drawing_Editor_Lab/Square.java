import java.awt.geom.Point2D;
import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.geom.Rectangle2D;

/**
 * Square class that extends DrawingShape
 * 
 * @author ebchen
 * @version 2/27/18
 */
public class Square extends DrawingShape
{
    /**
     * Constructs the Square
     */
    public Square(Point2D.Double center, double radius, Color color)
    {
        super (center, radius, color);
    }

    /**
     * Checks if a point is inside the square
     * 
     * @param point to be checked
     */
    public boolean isInside(Point2D.Double point)
    {
        double x = point.getX();
        double y = point.getY();

        double rightXBound = super.getCenter().getX() + super.getRadius();
        double upperYBound = super.getCenter().getY() + super.getRadius();
        double leftXBound = super.getCenter().getX() - super.getRadius();
        double lowerYBound = super.getCenter().getY() - super.getRadius();

        if (x < rightXBound && x > leftXBound && y < upperYBound && y > lowerYBound)
            return true;
        else return false;
    }

    /**
     * Checks to see if a point is on the border of the square
     * 
     * @param point point to be checked
     */
    public boolean isOnBorder(Point2D.Double point)
    {

        double EPSILON = 10;
        double x = point.getX();
        double y = point.getY();
        double rightXBound = super.getCenter().getX() + super.getRadius();
        double upperYBound = super.getCenter().getY() + super.getRadius();
        double leftXBound = super.getCenter().getX() - super.getRadius();
        double lowerYBound = super.getCenter().getY() - super.getRadius();

        if ((Math.abs(x - rightXBound) < EPSILON) && (y < upperYBound) && (y>lowerYBound))
            return true;
        else if ((Math.abs(x - leftXBound) < EPSILON) && (y < upperYBound) && (y>lowerYBound))
            return true;
        else if ((Math.abs(y - upperYBound) < EPSILON) && (x < rightXBound) && (x > leftXBound))
            return true;
        else if ((Math.abs(y - lowerYBound) < EPSILON) && (x < rightXBound) && (x > leftXBound))
            return true;
        else return false;
    }

    /**
     * Resizes the square
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
     * Draws the square
     * 
     * @param g2 the graphics object
     * @param filled if the shape is filled or not
     */
    public void draw(Graphics2D g2, boolean filled)
    {
        Rectangle2D.Double square = new Rectangle2D.Double(super.getCenter().getX() - super.getRadius(), super.getCenter().getY() - super.getRadius(),
                super.getRadius()*2, super.getRadius()*2);

        g2.setColor(super.getColor());
        g2.draw(square);
        if (filled)
        {
            g2.fill(square);
        }
    }
}
