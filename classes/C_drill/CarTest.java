

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CarTest.
 *
 * 
 * @author EBChen
 * @version 11 September 2017
 */
public class CarTest
{
    /**
     * Default constructor for test class CarTest
     */
    public CarTest()
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
    public void testGetGasInTank()
    {
        Car testCar = new Car( 50 );
        double amount = testCar.getGasInTank();
        
        /*
         * The assertEquals method verifies that the expected value is equal
         *      to the returned (actual) value. If not, the test fails.
         * Specify the expected value forst amd the returned value second.
         * For doubles (only), specify the third value which is the epsilon
         *      (i.e., how close is close enough to be equal).
         */
        assertEquals ( 0, amount, 1e-6 /* 1 x 10^-6 */);
    }
    
    @Test
    public void testAddGas()
    {
        Car testCar = new Car (50);
        
        testCar.addGas( 10 );
        double amount = testCar.getGasInTank();
        assertEquals (10, amount, 1e-6);
        
        testCar.addGas(5);
        amount = testCar.getGasInTank();
        assertEquals ( 15, amount, 1e-6);
    }
    
    @Test
    public void testDrive()
    {
        Car testCar = new Car (50);
        
        testCar.addGas (10);
        testCar.drive (25);
        double amount = testCar.getGasInTank();
        assertEquals (9.5, amount, 1e-6);
        
        testCar.drive (100);
        amount = testCar.getGasInTank();
        assertEquals (7.5, amount, 1e-6);
    }
    
}
