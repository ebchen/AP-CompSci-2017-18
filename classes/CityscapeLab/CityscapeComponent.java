import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Color;

/**
 * Class that creates instances of the classes that comprise the cityscape and delegates drawing the
 *  cityscape to these object.
 * 
 * @author @gcschmit
 * @version 18 July 2014
 */
public class CityscapeComponent extends JComponent
{
    private Sky sky1;               //background
    private River river1;           //river
    private River shore1;           //far shore
    private River shore2;           //close shore
    private Castle castle1;         //central castle
    private Castle battlement1;     //tall castle on left
    private Castle battlement2;     //tall castle on right
    private Castle wall1;           //wall in front of castles
    private Flag flag1;             //flag on central castle
    private Door door1;             //orange door in middle of wall
    private Door window1;           //window on left castle
    private Door window2;           //window on right castle
    private Door window3;           //first window from left on central castle
    private Door window4;           //second window from left on central castle
    private Door window5;           //third window from left on central castle
    private Door window6;           //fourth window from left on central castle
    private Door window7;           //fifth window from left on central castle
    private Bridge bridge1;         //bridge
    private Snow snow1;             //
    private Snow snow2;             //
    private Snow snow3;             //
    private Snow snow4;             //
    private Snow snow5;             //
    private Snow snow6;             //
    private Snow snow7;             //
    private Snow snow8;             //
    private Snow snow9;             //
    private Snow snow10;            //
    private Snow snow11;            //
    private Snow snow12;            //each is a layer of snowfall
    private Snow snow13;            //
    private Snow snow14;            //
    private Snow snow15;            //
    private Snow snow16;            //
    private Snow snow17;            //
    private Snow snow18;            //
    private Snow snow19;            //
    private Snow snow20;            //
    private Snow snow21;            //
    private Snow snow22;            //
    private Snow snow23;            //
    private Snow snow24;            //
    private Ice ice1;               // first ice object in river
    private Ice ice2;               // second ice object in river
    private Ice ice3;               // third ice object in river
   
    /**
     * Constructor for CityscapeComponent class
     */
    public CityscapeComponent()
    {
        sky1 = new Sky(800,600);
        river1 = new River (0, 450, 800, 150, Color.BLUE);
        shore1 = new River (0, 435, 800, 20, new Color(255,248,220));
        shore2 = new River (0, 560, 800, 40, new Color(255,248,220));
        castle1= new Castle(200, 200, 400,250, Color.GRAY, 5);
        battlement1 = new Castle(60, 150, 75, 300, Color.GRAY, 3);
        battlement2 = new Castle(665, 150, 75, 300, Color.GRAY, 3);
        wall1 = new Castle (50, 400, 700, 50, Color.DARK_GRAY, 21);
        flag1 = new Flag (castle1.getMiddleOfTopX(), castle1.getY(), Color.RED);
        door1 = new Door (400, 420, 30,30, new Color(229,89,38));
        window1 = new Door (97.5, 185, 30,30, Color.YELLOW);
        window2 = new Door (702.5, 185, 30,30, Color.YELLOW);
        window3 = new Door (266.67, 250, 10,10, Color.BLACK);
        window4 = new Door (333.34, 250, 10,10, Color.BLACK);
        window5 = new Door (400.01, 250, 10,10, Color.BLACK);
        window6 = new Door (466.68, 250, 10,10, Color.BLACK);
        window7 = new Door (533.35, 250, 10,10, Color.BLACK);
        bridge1 = new Bridge (385, 450, 30, 110, new Color (86,47,14));
        snow1 = new Snow ( 900, 0,  5, 450);
        snow2 = new Snow ( 900, -40,  5, 450);
        snow3 = new Snow ( 900, -80,  5, 450);
        snow4 = new Snow ( 900, -120,  5, 450);
        snow5 = new Snow ( 900, -160,  5, 450);
        snow6 = new Snow ( 900, -200,  5, 450);
        snow7 = new Snow ( 900, -240,  5, 450);
        snow8 = new Snow ( 900, -260,  5, 450);
        snow9 = new Snow ( 900, -280,  5, 450);
        snow10 = new Snow ( 900, -320,  5, 450);
        snow11 = new Snow ( 900, -360,  5, 450);
        snow12 = new Snow ( 900, -400,  5, 450);
        snow13 = new Snow ( 900, -440,  5, 450);
        snow14 = new Snow ( 900, -480,  5, 450);
        snow15 = new Snow ( 900, -520,  5, 450);
        snow16 = new Snow ( 900, -560,  5, 450);
        snow17 = new Snow ( 900, -600,  5, 450);
        snow18 = new Snow ( 900, -640,  5, 450);
        snow19 = new Snow ( 900, -680,  5, 450);
        snow20 = new Snow ( 900, -720,  5, 450);
        snow21 = new Snow ( 900, -760,  5, 450);
        snow22 = new Snow ( 900, -800,  5, 450);
        snow23 = new Snow ( 900, -840,  5, 450);
        snow24 = new Snow ( 900, -880,  5, 450);
        ice1 = new Ice (0, 550, new Color (151,255,238));
        ice2 = new Ice (460, 480, new Color (151,255,238));
        ice3 = new Ice (510, 510, new Color (151,255,238));
    }
    /**
     * This method is invoked by the Java Run-Time whenever the component needs to be redrawn.
     * It does not need to be invoked explicitly.
     *
     */
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        sky1.draw(g2);
        river1.draw(g2);
        shore1.draw(g2);
        shore2.draw(g2);
        castle1.draw(g2);
        battlement1.draw(g2);
        battlement2.draw(g2);
        wall1.draw(g2);
        flag1.draw(g2);
        
        door1.draw(g2);
        window1.draw(g2);
        window2.draw(g2);
        window3.draw(g2);
        window4.draw(g2);
        window5.draw(g2);
        window6.draw(g2);
        window7.draw(g2);
        
        ice1.draw(g2);
        ice2.draw(g2);
        ice3.draw(g2);
        bridge1.draw(g2);
        snow1.draw(g2);
        snow2.draw(g2);
        snow3.draw(g2);
        snow4.draw(g2);
        snow5.draw(g2);
        snow6.draw(g2);
        snow7.draw(g2);
        snow8.draw(g2);
        snow9.draw(g2);
        snow10.draw(g2);
        snow11.draw(g2);
        snow12.draw(g2);
        snow13.draw(g2);
        snow14.draw(g2);
        snow15.draw(g2);
        snow16.draw(g2);
        snow17.draw(g2);
        snow18.draw(g2);
        snow19.draw(g2);
        snow20.draw(g2);
        snow21.draw(g2);
        snow22.draw(g2);
        snow23.draw(g2);
        snow24.draw(g2);
    }
        
    /**
     * Animate the cityscape by updating the objects such that they appear to be animated when they are next drawn.
     *
     */
    public void nextFrame()
    {
        // update the objects in the cityscape so they are animated
        // ...
        sky1.changeBlue();
        flag1.changeHeight(2);
        snow1.descent();
        snow2.descent();
        snow3.descent();
        snow4.descent();
        snow5.descent();
        snow6.descent();
        snow7.descent();
        snow8.descent();
        snow9.descent();
        snow10.descent();
        snow11.descent();
        snow12.descent();
        snow13.descent();
        snow14.descent();
        snow15.descent();
        snow16.descent();
        snow17.descent();
        snow18.descent();
        snow19.descent();
        snow20.descent();
        snow21.descent();
        snow22.descent();
        snow23.descent();
        snow24.descent();
        ice1.floatForward(8);
        ice2.floatForward(4);
        ice3.floatForward(6);
        // request that the Java Runtime repaints this component by invoking its paintComponent method
        //  do not explicitly invoke the paintComponent method
        repaint();
    }

}
