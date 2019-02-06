
/**
 * This class creates a shape for a bridge
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

public class Bridge
{
    private double x;                       //x-coordinate of bridge's top right corner
    private double y;                       //y-coordinate of bridge's top right corner
    private Color color;                    //color of the bridge
    private double width;                   //far width of bridge
    private double length;                  //length of bridge
    private int xCoord[] = {0,0,0,0};       //array for the x-coordinates of the 4 corners
    private int yCoord[] = {0,0,0,0};       //array for the y-coordinates of the 4 corners
    
    /**
     * Constructor for Bridge class.
     * 
     * @param x the x-coordinate of bridge's top right corner
     * @param y the y-coordinate of bridge's top right corner
     * @param width the far width of bridge
     * @param length the length of bridge
     * @param color the color of the bridge
     */
    public Bridge(double x, double y, double width, double length, Color color)
    {
        this.x = x;
        this.y = y;
        this.color = color;
        this.width = width;
        this.length = length;
        
        xCoord[0] = (int) x;
        yCoord[0] = (int) y;
        xCoord[1] = (int) (x+width);
        yCoord[1] = (int) y;
        xCoord[3] = (int) (x-8);
        yCoord[3] = (int) (y+length);
        xCoord[2] = (int) (x+width+8);
        yCoord[2] = (int) (y+length);
        
    }
    
    /**
     * Draws and fills the bridge.
     * 
     * @param g2 the graphics
     */
    public void draw(Graphics2D g2)
    {
        
        g2.setColor (color);
        
        Polygon bridge = new Polygon(xCoord, yCoord, 4);
        g2.draw(bridge);
        g2.fill(bridge);
        
    }
}
