/**
* Creates a layer of snowfall
*
* @author ebchen
* @version 6 October 2017
*/

import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Line2D;
import java.util.Random;



public class Snow
{
    private int diameter;       //snow diameter
    private int xCoord;         //x-coordinate for the top-right of each snow
    private int yCoord;         //x-coordinate for the top-right of each snow
    private int endHeight;      //y-value where the snow stops
    
    
    /**
     * Constructor for Snow class.
     * 
     * @param x the x-coordinate for the top-right of each snow
     * @param y the x-coordinate for the top-right of each snow
     * @param d the snow diameter
     * @param end the y-value where the snow stops
     */
    public Snow (int x, int y, int d, int end)
    {
        this.xCoord = x;
        this.yCoord = y;
        this.diameter = d;
        this.endHeight = end;
    }
    
    /**
     * Simulates snow falling by decrementing y-values and randomizing x-values in a certain range.
     * 
     */
    public void descent()
    {
        Random gen = new Random();

        if (yCoord < endHeight)
        { 
            xCoord = gen.nextInt(25);
            yCoord += 5;
           
        }
        else if (yCoord >= endHeight)
        {
            xCoord = 0;
        }
    }
    
    /**
     * Draws and fills the snow.
     * 
     * @param g2 the graphics
     */
    public void draw(Graphics2D g2)
    {
        Random generator = new Random();
        for (int i = 0; i < 10; i++)
        {
                Ellipse2D.Double snow = new Ellipse2D.Double(i*80 + generator.nextInt(4)*xCoord,yCoord,diameter, diameter);
                g2.setColor (Color.WHITE);
                g2.draw(snow);
                g2.fill(snow);
        }
    }
        
    }
  