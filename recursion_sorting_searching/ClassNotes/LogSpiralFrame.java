import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class LogSpiralFrame extends JFrame
{
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 1000;
    private LogSpiralPanel panel;
    
    public LogSpiralFrame()
    {
        panel = new LogSpiralPanel();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        
        this.add(panel);
    }
    
    public static void main(String[] args)
    {
        LogSpiralFrame frame = new LogSpiralFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
