import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TreeViewer
{
    private final int WIDTH = 1000;
    private final int HEIGHT = 1000;
    private JPanel panel;
    private JFrame frame;

    //-----------------------------------------------------------------
    //  Sets up the components for the applet.
    //-----------------------------------------------------------------
    public static void main(String[] args)
    {
        TreeViewer viewer = new TreeViewer();
    }

    public TreeViewer()
    {
        panel = new TreePanel (0.8,  5, 20);
        frame = new JFrame();
        frame.setSize(WIDTH, HEIGHT);
        frame.setTitle("Litty Tree");  
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
