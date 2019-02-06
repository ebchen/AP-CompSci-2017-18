import javax.swing.JColorChooser;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.awt.Point;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;

/**
 * The panel in which draws all of the shapes in the drawing editor
 * 
 * @author gcschmit
 * @version 23 June 2015
 */
public class DrawingPanel extends JPanel
{
    //fill color
    Color fillColor;
    //Array list of all shapes in the panel
    private ArrayList<DrawingShape> shapes;
    //the current active shape
    private DrawingShape activeShape;
    //the center of the panel where new shapes are spawned
    private Point2D.Double centerOfPanel;

    /**
     * Default constructor for objects of class DrawingPanel
     */
    public DrawingPanel()
    {
        // this.requestFocusInWindow();
        this.setBackground(Color.WHITE);
        fillColor = Color.BLACK;
        shapes = new ArrayList<DrawingShape>();
        setPreferredSize ( new Dimension(900,900));
        centerOfPanel = new Point2D.Double(450,450);
        ClickListener cl = new ClickListener();
        MotionListener ml = new MotionListener();
        addMouseMotionListener(ml);
        addMouseListener(cl);
        ArrowListener al = new ArrowListener();
        addKeyListener(al);
    }

    /**
     * Adds a circle to the ArrayList of shapes
     */
    public void addCircle()
    {
        int radius = (int)(Math.random() * 50);
        Circle circle = new Circle(centerOfPanel, radius, fillColor);
        shapes.add(circle);
        activeShape = circle;
        repaint();
    }

    /**
     * Adds a square to the ArrayList of shapes
     */
    public void addSquare()
    {
        int radius = (int)(Math.random() * 50);
        Square square = new Square(centerOfPanel, radius, fillColor);
        shapes.add(square);
        activeShape = square;
        repaint();
    }

    /**
     * Invoked when the "Pick Color" button is clicked. Displays a JColorChooser and sets the
     *  selected color as the new fill color. Leaves the fill color unchanged if the user clicks
     *  "Cancel"
     *
     */
    public void pickColor()
    {
        Color selectedColor = JColorChooser.showDialog( this, "select the fill color", this.fillColor );

        if( selectedColor != null )
        {
            this.fillColor = selectedColor;
        }
    }

    /**
     * Paint Component class
     * 
     * @param g graphics object
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        for (DrawingShape shape: shapes)
        {
            if (shape != null  && shape == activeShape) shape.draw(g2, false);
            else shape.draw(g2, true);
        }
    }

    /**
     * The listener class for mouse clickes.
     * 
     * @author ebchen
     * @version 6 March 2018
     */
    class ClickListener implements MouseListener
    {
        /**
         * Executed when mouse press event received. Sets the active shape
         * 
         * @param event the mouse event received
         */
        public void mousePressed ( MouseEvent event )
        {
            int x = event.getX();
            int y = event.getY();
            Point2D.Double point = new Point2D.Double(x,y);
            boolean found = false;
            if (shapes.size() > 0 )
            {
                for (int i = shapes.size()-1; i >=0; i--)
                {
                    if (shapes.get(i).isInside(point) || shapes.get(i).isOnBorder(point))
                    {
                        activeShape = shapes.get(i);
                        found = true;
                        break;
                    }
                }
            }
            if (found == false) activeShape = null;

            repaint();

        }

        //non-implemented function
        public void mouseReleased(MouseEvent event) {}

        public void mouseClicked(MouseEvent event) {}

        public void mouseEntered(MouseEvent event) {}

        public void mouseExited(MouseEvent event) {}

    }

    /**
     * The listener class for mouse motion.
     * 
     * @author ebchen
     * @version 6 March 2018
     */
    class MotionListener implements MouseMotionListener
    {

        /**
         * Executed when mouse dragged event received. Calls the move method to set object location
         * 
         * @param event the mouse event received
         */
        public void mouseDragged ( MouseEvent event )
        {
            double xPosition = 0;
            xPosition = event.getX();
            double yPosition = 0;
            yPosition = event.getY();

            if (activeShape != null && activeShape.isOnBorder(new Point2D.Double(xPosition, yPosition)))
                activeShape.resize(new Point2D.Double(xPosition, yPosition));
            else if (activeShape != null) activeShape.move(xPosition, yPosition);

            repaint();
        }

        //non implemented method
        public void mouseMoved(MouseEvent event) {}

    }

    /**
     * The listener class for the keyboard.
     * 
     * @author ebchen
     * @version 9 March 2018
     */
    class ArrowListener implements KeyListener
    {
        /**
         * Executed when key is pressed. Calls the move method to increment the shape location
         * 
         * @param event the keyboard event
         */
        public void keyPressed( KeyEvent event)
        {
            
            String key = KeyStroke.getKeyStrokeForEvent(event).toString();
            key = key.replace("pressed ", "");
            
            if (key.equals("LEFT"))
            {
                if (activeShape!=null)
                {
                    activeShape.move(activeShape.getCenter().getX()-5, activeShape.getCenter().getY());
                }
            }
            if (key.equals("RIGHT"))
            {
                if (activeShape!=null)
                {
                    activeShape.move(activeShape.getCenter().getX()+5, activeShape.getCenter().getY());
                }
            }
            if (key.equals("UP"))
            {
                if (activeShape!=null)
                {
                    activeShape.move(activeShape.getCenter().getX(), activeShape.getCenter().getY()-5);
                }
            }
            if (key.equals("DOWN"))
            {
                if (activeShape!=null)
                {
                    activeShape.move(activeShape.getCenter().getX(), activeShape.getCenter().getY()+5);
                }
            }
            repaint();
        }
        // Do-nothing methods
        public void keyReleased(KeyEvent event) {}
        public void keyTyped(KeyEvent event) {}
    }
}
