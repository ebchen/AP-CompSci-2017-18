

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class VendingMachineTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class VendingMachineTest
{
    /**
     * Default constructor for test class VendingMachineTest
     */
    public VendingMachineTest()
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
    public void testFillUp()
    {
        VendingMachine testMachine = new VendingMachine(10);
        testMachine.fillUp(10);
        int amount = testMachine.getCanCount();
        assertEquals (20, amount);
    }
    
    @Test
    public void testInsertToken()
    {
        VendingMachine testMachine = new VendingMachine(10);
        testMachine.insertToken();
        int amount = testMachine.getCanCount();
        int amount2 = testMachine.getTokenCount();
        assertEquals (9, amount);
        assertEquals (1, amount2);
    }
    
    @Test
    public void testGetCanCount()
    {
        VendingMachine testMachine = new VendingMachine(12);
        int amount = testMachine.getCanCount();
        assertEquals (12, amount);
    }
    
    @Test
    public void testGetTokenCount()
    {
        VendingMachine testMachine = new VendingMachine(12);
        testMachine.insertToken();
        int amount = testMachine.getTokenCount();
        assertEquals (1, amount);
    }
    
}
