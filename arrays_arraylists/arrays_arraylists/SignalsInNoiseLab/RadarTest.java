
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Write a description of test class RadarTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RadarTest
{
    /**
     * Default constructor for objects of class RadarTest
     */
    public RadarTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @Test
    public void testRadarCase1()
    {
        // test that the Radar class successfully finds the location of the monster after several scans

        Radar radar =  new Radar(100,100);
        radar.setNoiseFraction(0.10);
        Location monsterLocation = new Location(30,60);
        radar.setMonsterLocation(monsterLocation);
        for (int i = 0; i < 100; i ++)
        {
            radar.scan();
        }

        Location found = radar.findMonster();
        
        assertEquals(30, found.getRow());
        assertEquals(60, found.getCol());

    }
    
    @Test
    public void testRadarCase2()
    {
        // test that the Radar class successfully finds the location of the monster after several scans

        Radar radar =  new Radar(100,100);
        radar.setNoiseFraction(0.05);
        Location monsterLocation = new Location(10,87);
        radar.setMonsterLocation(monsterLocation);
        for (int i = 0; i < 100; i ++)
        {
            radar.scan();
        }

        Location found = radar.findMonster();
        
        assertEquals(10, found.getRow());
        assertEquals(87, found.getCol());

    }
    
    @Test
    public void testRadarCase3()
    {
        // test that the Radar class successfully finds the location of the monster after several scans

        Radar radar =  new Radar(100,100);
        radar.setNoiseFraction(0.20);
        Location monsterLocation = new Location(99,64);
        radar.setMonsterLocation(monsterLocation);
        for (int i = 0; i < 100; i ++)
        {
            radar.scan();
        }

        Location found = radar.findMonster();
        
        assertEquals(99, found.getRow());
        assertEquals(64, found.getCol());

    }
    
    @Test
    public void testRadarCase4()
    {
        // test that the Radar class successfully finds the location of the monster after several scans

        Radar radar =  new Radar(100,100);
        int row = (int)(Math.random()*100);
        int col = (int)(Math.random()*100);
        Location monsterLocation = new Location(row,col);
        radar.setMonsterLocation(monsterLocation);
        for (int i = 0; i < 100; i ++)
        {
            radar.scan();
        }

        Location found = radar.findMonster();
        
        assertEquals(row, found.getRow());
        assertEquals(col, found.getCol());

    }
}
