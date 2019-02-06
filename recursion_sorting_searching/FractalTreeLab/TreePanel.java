
import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

public class TreePanel extends JPanel
{
    private final int PANEL_WIDTH = 400;
    private final int PANEL_HEIGHT = 400;
    private double lengthRatio;
    private int lengthMinimum;
    private int angleBetween;
    private Color[] rainbow = new Color[7];

    public TreePanel (double ratio, int minimum, int angle)
    {
        setBackground (Color.BLACK);
        setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

        lengthRatio = ratio;
        lengthMinimum = minimum;
        angleBetween = angle;

        // colors of the rainbow
        rainbow[0] = new Color(255,0,0);
        rainbow[1] = new Color(255,165,0);
        rainbow[2] = new Color(255,255,0);
        rainbow[3] = new Color(0,255,0);
        rainbow[4] = new Color(0,0, 255);
        rainbow[5] = new Color(75,0,130);
        rainbow[6] = new Color(128,0,128);
    }

    public void drawTree (int x1, int y1, Graphics page, int prevLength, int angle, int order)
    {
        Graphics2D g2 = (Graphics2D) page;

        // randomly generates snowflakes as terminating condition
        if (prevLength <= lengthMinimum)
        {
            int ice = (int)(Math.random() * 11);
            if (ice == 0)
            {

                final int SNOWFLAKE_SIZE = 4;
                int length = (int)(prevLength * lengthRatio);

                g2.setStroke(new BasicStroke(1));
                g2.setColor(new Color(255,255,255));
                g2.drawLine(x1-SNOWFLAKE_SIZE,y1-SNOWFLAKE_SIZE, x1+SNOWFLAKE_SIZE, y1+SNOWFLAKE_SIZE);
                g2.drawLine(x1-SNOWFLAKE_SIZE,y1+SNOWFLAKE_SIZE,x1+SNOWFLAKE_SIZE,y1-SNOWFLAKE_SIZE);
                g2.drawLine(x1-SNOWFLAKE_SIZE,y1, x1+SNOWFLAKE_SIZE, y1);
                g2.drawLine(x1, y1+SNOWFLAKE_SIZE, x1, y1-SNOWFLAKE_SIZE);
            }
            return;
        }
        else
        {
            int length = (int)(prevLength * lengthRatio);
            int x2 = x1 + (int)(Math.cos(Math.toRadians(angle)) * length);
            int y2 = y1 - (int)(Math.sin(Math.toRadians(angle)) * length);
            //line width is proportional to lenth
            g2.setStroke(new BasicStroke(length/10));
            //loops through the colors of the rainbow
            g2.setColor(rainbow[order%7]);
            g2.drawLine(x1,y1, x2, y2);
            
            drawTree (x2, y2, page, length, angle + 2*angleBetween, order-1);
            drawTree (x2, y2, page, length, angle - angleBetween, order-1);
            
        }
    }

    public void paintComponent (Graphics page)
    {
        super.paintComponent (page);

        drawTree (500,670, page, 180, 90, 20);
    }
}

