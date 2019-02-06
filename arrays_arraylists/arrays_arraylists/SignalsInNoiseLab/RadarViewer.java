import javax.swing.JFrame;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Class that contains the main method for the program and creates the frame containing the component.
 * 
 * @author @gcschmit
 * @version 19 July 2014
 */
public class RadarViewer
{
    /**
     * main method for the program which creates and configures the frame for the program
     *
     */
    public static void main(String[] args) throws InterruptedException
    {

        Scanner s = new Scanner (System.in);
        // create the radar, set the monster location, and perform the initial scan
        final int ROWS = 100;
        final int COLS = 100;

        // list of inputed monster locations
        ArrayList <Location> allMonsterLocations = new ArrayList <Location>();

        Radar radar = new Radar(ROWS, COLS);
        radar.setNoiseFraction(0.10);

        
        // prompts the user to enter how many monsters there should be
        System.out.print ("How many monsters: ");
        int numberOfMonsters = s.nextInt();
        
        // prompt the user to optionally enter the location of the monster
        //  (if they don't, leave the location randomly determined)
        System.out.print ("Manually enter monster location(s)? (y/n) ");
        String yesOrNo = s.next();
        int x;
        int y;
        Location mLocation;
        // if it is "y", user is prompted to enter x and y values of monsters
        if (yesOrNo.equals("y"))
        {
            for (int n = 0; n < numberOfMonsters; n++)
            {
                System.out.print ("x-coordinate of monster #" + (n+1) + ": ");
                x = s.nextInt();
                System.out.print ("y-coordinate of monster #" + (n+1) + ": ");
                y = s.nextInt();
                mLocation = new Location (x,y);
                allMonsterLocations.add(mLocation);
                //radar.setMonsterLocation(mLocation);
               
            }
            radar.setMonsterLocations(allMonsterLocations);
        }
        
        // if it is "n", monster locations are randomized
        else
        {
           radar.randomizeMonsterLocations(numberOfMonsters);
        }

        
       
        radar.scan();
        JFrame frame = new JFrame();
        frame.setTitle("Signals in Noise Lab");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // a frame contains a single component; create the radar component and add it to the frame
        RadarComponent component = new RadarComponent(radar);
        frame.add(component);

        // set the size of the frame to encompass the contained component
        frame.pack();

        // make the frame visible which will result in the paintComponent method being invoked on the
        //  component.
        frame.setVisible(true);

        // perform 100 scans of the radar wiht a slight pause between each
        // after each scan, instruct the Java Run-Time to redraw the window
        for(int i = 0; i < 100; i++)
        {
            Thread.sleep(100); // sleep 100 milliseconds (1/10 second)

            radar.scan();

            frame.repaint();
        }
    }

}
