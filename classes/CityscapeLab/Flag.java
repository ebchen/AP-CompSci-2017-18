
/**
* A shape for an animated flag on a pole
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

public class Flag
{
    private double poleBaseX;       //x-coordinate of the base of the pole
    private double poleBaseY;       //y-coordinate of the base of the pole
    private double flagBaseX;       //base of the flag; x-coordinate
    private double flagBaseY;       // base of the flat; y-coordinate
    private Color color;            //color of flag
    private double height = 40;     //height of the flag
    private boolean goingDown = false;      //if the flag is going down
    private boolean goingUp = false;        //if the flag is going up
    private int xCoord[] = {0,0,0};      //array for the x-coordinates of the 3 corners
    private int yCoord[] = {0,0,0};      //array for the y-coordinates of the 3 corners
    
    /**
     * Constructor for Flag class.
     * 
     * @param baseX the x-coordinate of flag's bottom left corner
     * @param baseY the y-coordinate of flag's bottom left corner
     * @param color the color of the flag
     */
    public Flag(double baseX, double baseY, Color color)
    {
        this.poleBaseX = baseX;
        this.poleBaseY = baseY;
        this.color = color;
        
       
        this.flagBaseX = this.poleBaseX+2;
        this.flagBaseY = this.poleBaseY;
        xCoord[0] = (int) flagBaseX;
        yCoord[0] = (int) flagBaseY;
        xCoord[1] = (int) flagBaseX;
        yCoord[1] = (int) flagBaseY-20;
        xCoord[2] = (int) flagBaseX+30;
        yCoord[2] = (int) flagBaseY-10;
        
    }
    
    /**
     * Changes the height of the flag by incrementing or decrementing the array values.
     * 
     */
    public void changeHeight (int increment)
    {
        if (goingDown == true)
        {
            yCoord[0] = yCoord[0] + increment;
            yCoord[1] = yCoord[1] + increment;
            yCoord[2] = yCoord[2] + increment;
                //flagBaseY += increment;
        }
        else if (goingUp ==true)
        {
            yCoord[0] = yCoord[0] - increment;
            yCoord[1] = yCoord[1] - increment;
            yCoord[2] = yCoord[2] - increment;
        }
        if (yCoord[0] <= poleBaseY - 20)
        {
            goingDown = true;
            goingUp = false;
        }
        else if (yCoord[0] >= poleBaseY)
        {
            goingDown = false;
            goingUp = true;
        }
    }
    
    /**
     * Draws and fills the flag.
     * 
     * @param g2 the graphics
     */
    public void draw(Graphics2D g2)
    {
        
        g2.setColor (Color.BLACK);
        Rectangle2D.Double pole = new Rectangle2D.Double(poleBaseX, poleBaseY-height, 2,height);
        g2.fill(pole);
        g2.setColor (color);
        Polygon flag = new Polygon(xCoord, yCoord, 3);
        g2.draw(flag);
        g2.fill(flag);
        /*
        Line2D.Double first = new Line2D.Double(flagBaseX,flagBaseY, flagBaseX + 15, flagBaseY - 5);
        Line2D.Double second = new Line2D.Double(flagBaseX,flagBaseY-10, flagBaseX + 15, flagBaseY - 5);
        Line2D.Double third = new Line2D.Double(flagBaseX,flagBaseY, flagBaseX, flagBaseY - 10);
        g2.draw(first);
        g2.fill(first);
        g2.draw(second);
        g2.fill(second);
        g2.draw(third);
        g2.fill(third);*/
    }
}
