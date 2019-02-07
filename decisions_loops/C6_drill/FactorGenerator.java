

public class FactorGenerator
{
    private int number;
    private int current;
    
    public FactorGenerator(int numberToFactor)
    {
        number = numberToFactor;
        current = number;
    }
    
    public int nextFactor()
    {
        for (int i = 2; i < this.number; i++)
        {
            if (current % i == 0)
            {
                current = current/i;
                return i;
            }
        }
        return this.number;
    }
    
    public boolean hasMoreFactors()
    {
        boolean next = false;
        for (int i = 2; i <= this.number; i++)
        {
            if (current % i == 0)
            {
                next = true;
            }
        }
        return next;
    }
}
