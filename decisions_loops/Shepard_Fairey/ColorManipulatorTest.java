

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.awt.Color;

/**
 * The test class ColorManipulatorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ColorManipulatorTest
{
    /**
     * Default constructor for test class CarTest
     */
    public ColorManipulatorTest()
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
    
    @Test
    public void testGrayscale()
    {
        Picture picture= new Picture( "selfiePortrait.jpg" );
        ColorManipulator testManipulator = new ColorManipulator( picture );
        
        
        testManipulator.grayscale();
        
        Pixel testPixel1 = picture.getPixel( 20, 20 );
        Color color1 = testPixel1.getColor();
        int red1 = color1.getRed();
        int green1 = color1.getGreen();
        int blue1 = color1.getBlue();
        
        Pixel testPixel2 = picture.getPixel( 1304, 704 );
        Color color2 = testPixel2.getColor();
        int red2 = color2.getRed();
        int green2 = color2.getGreen();
        int blue2 = color2.getBlue();
        
        Pixel testPixel3 = picture.getPixel( 1184, 2048 );
        Color color3 = testPixel3.getColor();
        int red3 = color3.getRed();
        int green3 = color3.getGreen();
        int blue3 = color3.getBlue();
      
        assertEquals ( 221, red1 );
        assertEquals ( 237, red2);
        assertEquals ( 45 , red3);
        assertEquals ( 221, green1 );
        assertEquals ( 237, green2);
        assertEquals ( 45 , green3);
        assertEquals ( 221, blue1 );
        assertEquals ( 237, blue2);
        assertEquals ( 45 , blue3);
        
    }
 
}
