import javax.swing.JFrame;
import java.awt.BorderLayout;


/**
 * The window for the drawing editor.
 * 
 * @author gcschmit
 * @version 23 June 2015
 */
public class DrawingEditor extends JFrame
{
    // frame width
    private static final int FRAME_WIDTH = 1000;
    // frame height
    private static final int FRAME_HEIGHT = 1000;
    
    /**
     * Default constructor for objects of class DrawingEditor
     */
    
    
    public DrawingEditor()
    {
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        
        this.setTitle( "Drawing Editor" );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        DrawingPanel canvas = new DrawingPanel();
        ControlPanel controls = new ControlPanel( canvas );
        
        // add the canvas and controls panels to the frame
        // read the BorderLayout class documentation for specifics
        this.add(canvas, BorderLayout.CENTER); 
        this.add(controls, BorderLayout.SOUTH);
        
        
        
        this.pack();
        this.setVisible( true );
    }
    
    /**
     * the main method to create a drawing editor object
     */
    public static void main( String[] args )
    {
       DrawingEditor drawingEditor = new DrawingEditor();
    }

}
