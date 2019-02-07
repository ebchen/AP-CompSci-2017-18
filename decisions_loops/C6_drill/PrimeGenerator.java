

public class PrimeGenerator
{
    private int number;
    private int lastPrime = 1;
    
    public PrimeGenerator(int primesUnder)
    {
        number = primesUnder;
    }
    
    public boolean isPrime(int underReview)
    {
        for (int i = 2; i < underReview; i++)
        {
            if (underReview % i == 0) return false;
        }
        return true;
    }
    
    public int nextPrime()
    {
        for (int i = lastPrime+1; i <= number; i++ )
        {
            if (isPrime(i))
            {
                return i;
            }
        }
        return 0;
    }
    
    
    
}
