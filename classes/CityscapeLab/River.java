/**
* Creates a river
*
* @author ebchen
* @version 4 October 2017
*/
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.awt.Color;


public class River
{
    private double height;      //height of the river
    private double width;       //width of the river
    private double xCoord;      //x-coordinate of upper-right corner of the river
    private double yCoord;      //y-coordinate of upper-right corner of the river
    private Color color;        //color of the river
    

    /**
     * Constructor for River class.
     * 
     * @param x the x-coordinate of river's top right corner
     * @param y the y-coordinate of river's top right corner
     * @param width the width of river
     * @param height the height of river
     * @param color the color of the river
     */
    public River (double x, double y, double width, double height, Color color)
    {
        this.height = height;
        this.width = width;
        this.xCoord = x;
        this.yCoord = y;
        this.color = color;
    }
    
    /**
     * Draws and fills the river.
     * 
     * @param g2 the graphics
     */
    
    public void draw(Graphics2D g2)
    {
        g2.setColor (color);
        Rectangle2D.Double river = new Rectangle2D.Double(xCoord,yCoord,width, height);
        g2.draw(river);
        g2.fill(river);
    }
}
