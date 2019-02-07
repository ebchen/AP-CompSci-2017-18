
public class VendingMachine
{
    private int totalCans;
    private int totalTokens;
    
    public VendingMachine()
    {
        totalCans = 10;
        totalTokens = 0;
    }
    
    public VendingMachine(int initCans)
    {
        totalCans = initCans;
        totalTokens = 0;
    }
    
    
    public void fillUp (int cans)
    {
        totalCans += cans;
    }
    
    public void insertToken()
    {
        totalCans--;
        totalTokens++;
    }
    
    public int getCanCount()
    {
        return totalCans;
    }
    
    public int getTokenCount()
    {
        return totalTokens;
    }
    
    
}
