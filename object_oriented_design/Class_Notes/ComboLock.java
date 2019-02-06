public class ComboLock
{
    private int current;
    private int digit1;
    private int digit2;
    private int digit3;
    private int passed;

    public ComboLock( int secret1, int secret2, int secret3 )
    { 
        digit1 = secret1;
        digit2 = secret2;
        digit3 = secret3;
        current = 0;
        passed = 0;
    }

    public void reset()
    {
        current = 0;
    }

    public void turnLeft( int ticks )
    {
        current = (40+(current - ticks) % 40)%40;
        if (passed == 1 && current == digit2)
        {
            passed ++;
        }
        else passed = 0;
        System.out.println("current: " + current);
        System.out.println("passed: " + passed);
    }

    public void turnRight( int ticks )
    {
        current = (current + ticks)%40;
        if (passed == 0 && current == digit1)
        {
            passed ++;

        }
        else if (passed == 2 && current == digit3)
        {
            passed ++;

        }
        else passed = 0;
        
        System.out.println("current: " + current);
        System.out.println("passed: " + passed);
    }

    public boolean open() { 
        if (passed == 3) return true;
        else return false;
    }
}