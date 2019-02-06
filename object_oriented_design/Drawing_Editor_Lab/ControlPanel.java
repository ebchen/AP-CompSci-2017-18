import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * The panel that contains the controls and indicators for the drawing editor
 * 
 * @author gcschmit
 * @version 23 June 2015
 */
public class ControlPanel extends JPanel
{
    //panel in which all shapes exist
    private DrawingPanel canvas;
    //the button to generate a square
    private JButton buttonSquare;
    //the button to generate a circle
    private JButton buttonCircle;
    //the button to pick a color
    private JButton buttonColor;
    //shows the current fillColor
    private JPanel colorPanel;

    /**
     * Constructor for objects of class ControlPanel
     */
    public ControlPanel( DrawingPanel canvas)
    {
        this.canvas = canvas;
        
        buttonSquare = new JButton ("Add square");
        buttonCircle = new JButton ("Add circle");
        buttonColor = new JButton("Pick color");
        colorPanel = new JPanel();
        colorPanel.setBackground(canvas.fillColor);
        
        //
        // ... create and add buttons and selected color panel
        //
        ActionListenerColor colorListener = new ActionListenerColor();
        ActionListenerSquare squareListener = new ActionListenerSquare();
        ActionListenerCircle circleListener = new ActionListenerCircle();
        
        buttonColor.addActionListener(colorListener);
        buttonSquare.addActionListener(squareListener);
        buttonCircle.addActionListener(circleListener);
        
        this.add(buttonColor);
        this.add(colorPanel);
        this.add(buttonSquare);
        this.add(buttonCircle);
        
        
    }

    
    /**
     * The listener class for the square button.
     * 
     * @author ebchen
     * @version 6 March 2018
     */
    public class ActionListenerSquare implements ActionListener
    {
        /**
         * adds a square when the square button is clicked
         * 
         * @param event the button event received
         */
        public void actionPerformed ( ActionEvent event )
        {
            canvas.addSquare();
            canvas.requestFocusInWindow();
        }
    }
    
    /**
     * The listener class for the circle button.
     * 
     * @author ebchen
     * @version 6 March 2018
     */
    public class ActionListenerCircle implements ActionListener
    {
        /**
         * adds a circle when the circle button is clicked
         * 
         * @param event the button event received
         */
        public void actionPerformed ( ActionEvent event )
        {
            canvas.addCircle();
            canvas.requestFocusInWindow();
        }
    }
    
    /**
     * The listener class for the color button.
     * 
     * @author ebchen
     * @version 6 March 2018
     */
    public class ActionListenerColor implements ActionListener
    {
        /**
         * opens up color picker to reset fill color. Sets color of preview panel.
         * 
         * @param event the button event received
         */
        public void actionPerformed ( ActionEvent event )
        {
            canvas.pickColor();
            colorPanel.setBackground(canvas.fillColor);
            canvas.requestFocusInWindow();
        }
    }
}
