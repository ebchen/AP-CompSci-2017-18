
/**
* Creates a castle
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


public class Castle
{
    private double height;      //height of the castle
    private double width;       //width of the castle
    private double x;           //x-coordinate of top corner
    private double y;           //y-coordinate of top corner
    private double segment;     //length of each brick on top
    private Color color;        //color of wall
    private int blocks;         //number of bricks on top
    
    /**
     * Constructor for Castle class.
     * 
     * @param x1 the x-coordinate of top corner
     * @param y1 the y-coordinate of top corner
     * @param w1 the width of the castle
     * @param h1 the height of the castle
     * @param c1 the color of the castle
     * @param numberBlocks the number of bricks on top
     */
    public Castle(double x1, double y1, double w1, double h1, Color c1, int numberBlocks)
    {
        this.height = h1;
        this.width = w1;
        this.x = x1;
        this.y= y1;
        this.blocks = numberBlocks;
        this.segment = width/(numberBlocks*2-1);
        this.color = c1;
    }
    
    /**
     * Returns the x-coordinate of the middle of the top of the castle
     * 
     * @return the x-coordinate of the middle of the top of the castle
     */
    public double getMiddleOfTopX()
    {
        return this.x + this.width/2;
        
    }
    
    /**
     * Returns the y-coordinate of the top of the castle
     * 
     * @return the y-coordinate of the top of the castle
     */
    public double getY()
    {
        return this.y;
    }
    
    /**
     * Draws and fills the castle.
     * 
     * @param g2 the graphics
     */
    public void draw(Graphics2D g2)
    {
        g2.setColor (this.color);
        Rectangle2D.Double base1 = new Rectangle2D.Double(this.x,this.y+10,this.width, this.height-10.0);
        g2.draw(base1);
        g2.fill(base1);
        for (int i = 0; i < this.blocks; i++)
        {
            double interval = this.segment*2*i;
            Rectangle2D.Double block1 = new Rectangle2D.Double(this.x+interval,this.y,this.segment, 10.0);
            g2.draw(block1);
            g2.fill(block1);
        }
    }
}
