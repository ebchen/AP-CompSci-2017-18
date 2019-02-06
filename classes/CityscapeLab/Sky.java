
 /**
 * Creates a background
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


public class Sky
{
    private double height;                   //height of the sky
    private double width;                    //width of the sky
    private int rVal = 0;                    //red value for sky's color
    private int gVal = 190;                  //green value for sky's color
    private int bVal = 245;                  //blue value for sky's color
    private boolean gettingDarker = false;   //if sky is getting lighter or darker

    /**
     * Constructor for Sky class.
     * 
     * @param width the width of the background
     * @param length the length of the background
     */
    public Sky(int width, int height)
    {
        this.height = height;
        this.width = width;
    }
    
    /**
     * Changes the color of the sky by incrementing or decrementing green and blue values.
     * 
     */
    
    public void changeBlue()
    {
        if (gettingDarker == true)
        {
           bVal-=10;
           gVal -= 8;
        }
        else if (gettingDarker == false)
        {
           bVal+=10;
           gVal += 8;
        }
        if (bVal <= 50)
        {
            gettingDarker = false;
        }
        else if (bVal >= 235)
        {
           gettingDarker = true;
        }
    }
    
    /**
     * Draws and fills the sky.
     * 
     * @param g2 the graphics
     */
    public void draw(Graphics2D g2)
    {
        g2.setColor (new Color(rVal, gVal, bVal));
        Rectangle2D.Double sky1 = new Rectangle2D.Double(0,0,width, height);
        g2.draw(sky1);
        g2.fill(sky1);
    }
}
