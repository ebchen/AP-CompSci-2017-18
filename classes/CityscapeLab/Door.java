
/**
 * This class creates a shape for a door
 *
 * @author ebchen
 * @version 6 October 2017
 */

import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.awt.Color;


public class Door
{
    private double height;                   //height of the door
    private double width;                    //width of the door
    private double x;                        //x-coordinate for the middle of the arch of the door
    private double y;                        //y-coordinate for the middle of the arch of the door
    private Color color;                     //color of the door
    
    /**
     * Constructor for Door class.
     * 
     * @param x1 the x-coordinate for the middle of the arch of the door
     * @param y1 the y-coordinate for the middle of the arch of the door
     * @param w1 the width of the door
     * @param h1 the height of the door
     * @param color the color of the door
     */
    public Door(double x1, double y1, double w1, double h1, Color color)
    {
        height = h1;
        width = w1;
        x = x1;
        y= y1;
        this.color = color;
    }
    
    /**
     * Draws and fills the door.
     * 
     * @param g2 the graphics
     */
    public void draw(Graphics2D g2)
    {
        Ellipse2D.Double arch = new Ellipse2D.Double(x-width/2,y,width,width);
        Rectangle2D.Double base = new Rectangle2D.Double(x-width/2,y+width/2, width, height-width/2);
        g2.setColor (color);
        g2.draw(arch);
        g2.fill(arch);
        g2.draw(base);
        g2.fill(base);
    }
}
