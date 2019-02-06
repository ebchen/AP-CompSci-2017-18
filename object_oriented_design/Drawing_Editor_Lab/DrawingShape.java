import java.awt.geom.Point2D;
import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Abstract class that is extended by the shapes
 * 
 * @author ebchen
 * @version 2/27/18
 */
public abstract class DrawingShape
{
    private double radius;
    // apothem of shape
    private Point2D.Double center;
    // coordinate point of shape center
    private Color color;
    // shape color
    
    
    /**
     * Constructor
     * 
     * @param center coordinate point of center
     * @param radius length of shape radius/apothem
     * @param color color of shape
     */
    public DrawingShape(Point2D.Double center, double radius, Color color) 
    {
        this.center = center;
        this.radius = radius;
        this.color = color;
    }

    
    /**
     * Returns the shape center
     * 
     * @return center the shape's center
     */
    public Point2D.Double getCenter()
    {
        return center;
    }    

    
    /**
     * Returns the shape radius
     * 
     * @return radius the shape's radius
     */
    public double getRadius()
    {
        return radius;
    }

    
    /**
     * Returns the shape color
     * 
     * @return color the shape's color
     */
    public Color getColor()
    {
        return color;
    }

    
    /**
     *  Moves the shape by moving the center
     * 
     * @param x new x-coordinate
     * @param y new y-coordinate
     */
    public  void move(double x, double y)
    {
        center = new Point2D.Double(x,y);
    }

    /**
     * Resizes the shape
     * 
     * @param point the point to resize to
     */
    public  abstract void resize(Point2D.Double point);
    
    /**
     * Sets the shape's radius
     * 
     * @param r the new radius
     */
    public  void setRadius(double r)
    {
        radius = r;
    }

    
    /**
     * Checks if a point is inside the shape
     * 
     * @param point to be checked
     */
    public  abstract boolean isInside(Point2D.Double point);

    
    /**
     * Checks to see if a point is on the border of the shape
     * 
     * @param point point to be checked
     */
    public   abstract boolean isOnBorder(Point2D.Double point);

    
    /**
     * Draws the shape
     * 
     * @param g2 the graphics object
     * @param filled if the shape is filled or not
     */
    public  abstract void draw(Graphics2D g2, boolean filled);

}
