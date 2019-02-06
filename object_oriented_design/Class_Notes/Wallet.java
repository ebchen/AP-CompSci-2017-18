
public class Wallet
{
    private Card card1;
    private Card card2;
   
    public Wallet()
    {
    }
    
    public void addCard(Card newCard)
    {
        if (card1 == null)
        {
            card1 = newCard;
        }
        
        else if (card2 == null)
        {
            card2 = newCard;
        }
    }
    
    public String toString()
    {
        String result = "[" + card1.toString() + "|" +card2.toString()+"]";
        return result;
    }
    
    public int getExpiredCardCount()
    {
        int count = 0;
        if (card1.isExpired()) count++;
        if (card2.isExpired()) count++;
        return count;
    }
}
