
/**
 * A shape for an animated ice float
 *
 * @author ebchen
 * @version 6 October 2017
 */
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.Polygon;
import java.util.Random;

public class Ice
{
    private Color color;                    //color of ice
    private double height = 40;             //height of ice
    private int xCoord[] = {0,0,0,0,0};     //array for the x-coordinates of the 4 corners
    private int yCoord[] = {0,0,0,0,0};     //array for the x-coordinates of the 3 corners
    private int x;                          //x-coordinate of ice's right-most vertex
    private int y;                          //y-coordinate of ice's right-most vertex
    
    /**
     * Constructor for Ice class.
     * 
     * @param x the x-coordinate of ice's right-most vertex
     * @param y the y-coordinate of ice's right-most vertex
     * @param color the color of the ice
     */
    
    public Ice(int x, int y, Color color)
    {
        this.color = color;
        this.x = x;
        this.y = y;
        xCoord[0] = x;
        yCoord[0] = y;
        xCoord[1] = x+ 20;
        yCoord[1] = y- 20;
        xCoord[2] = x+ 40;
        yCoord[2] = y;
        xCoord[3] = x+ 35;
        yCoord[3] = y+ 10;
        xCoord[4] = x+ 15;
        yCoord[4] = y+ 5;
        
    }
    
    /**
     * Moves the ice forward by incrementing the x-coordinates. Resets to the starting point when it reaches the end of screen.
     * 
     */
    public void floatForward (int speed)
    {
        xCoord[0] += speed;
        xCoord[1] += speed;
        xCoord[2] += speed;
        xCoord[3] += speed;
        xCoord[4] += speed;
        
        if (xCoord[0] >= 796)
        {
            xCoord[0] = 0;
            xCoord[1] = 20;
            xCoord[2] = 40;
            xCoord[3] = 35;
            xCoord[4] = 15;
        }
        
    }
    
    /**
     * Draws and fills the bridge.
     * 
     * @param g2 the graphics
     */
    public void draw(Graphics2D g2)
    {
        
        g2.setColor (color);
        
        Polygon iceberg = new Polygon(xCoord, yCoord, 5);
        g2.draw(iceberg);
        g2.fill(iceberg);
        
    }
}
