import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class TriangleComponent extends JComponent
{
    private int x1, y1, x2, y2, x3, y3;
    private int state;

    public TriangleComponent()
    {
        MouseListener listener = new ClickListener();
        addMouseListener(listener);
        state = 3;
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        if (state == 0)
        {
            g2.drawLine(x1,y1,x1,y1);
        }
        else if (state == 1)
        {
            g2.drawLine(x1,y1,x2,y2);
            g2.drawLine(x1,y1,x1,y1);
        }
        else if (state == 2)
        {
            g2.drawLine(x2,y2,x3,y3);
            g2.drawLine(x1,y1,x2,y2);
            g2.drawLine(x1,y1,x3,y3);
        }
    }

    public void stateIncrement()
    {
        if ( state == 3 ) state = 0;
        else state++;
    }

    public void addPoint(int x, int y)
    {
        if (state == 3)
        {
            x1 = x;
            y1 = y;
        }
        else if (state == 0)
        {
            x2 = x;
            y2 = y;
        }
        else if (state == 1)
        {
            x3 = x;
            y3 = y;
        }
        else
        {
            x1 = 0;
            x2 = 0;
            x3 = 0;
            y1 = 0;
            y2 = 0;
            y3 = 0;
        }

        
        
        repaint();
        stateIncrement();
    }

    class ClickListener implements MouseListener
    {

        public void mousePressed ( MouseEvent event )
        {
            int x = event.getX();
            int y = event.getY();
            addPoint(x,y);
        }

        public void mouseReleased(MouseEvent event) {}

        public void mouseClicked(MouseEvent event) {}

        public void mouseEntered(MouseEvent event) {}

        public void mouseExited(MouseEvent event) {}

    }
}
