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

public class CircleFrame extends JFrame
{
    private static final int FRAME_WIDTH = 1000;
    private static final int FRAME_HEIGHT = 1000;
    private JButton buttonA;
    private CircleComponent component;
    private JPanel circlePanel;
    private JOptionPane pane;
    
    public CircleFrame()
    {
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        
        circlePanel = new JPanel();
        pane = new JOptionPane();
        buttonA = new JButton ("DRAW");
        
        String x = pane.showInputDialog("x position: ");
        String y = pane.showInputDialog("y position: ");
        String r = pane.showInputDialog("radius: ");
        
        double cx = Double.parseDouble(x);
        double cy = Double.parseDouble(y);
        double radius = Double.parseDouble(r);
        
        component = new CircleComponent(cx, cy, radius);
        
        ActionListener1 listenerA = new ActionListener1();
        buttonA.addActionListener(listenerA);
        circlePanel.add(buttonA);
        
        add(circlePanel);
    }
    
    public class ActionListener1 implements ActionListener
    {
        public void actionPerformed ( ActionEvent event )
        {
            circlePanel.add(component);
        }
    }
}


