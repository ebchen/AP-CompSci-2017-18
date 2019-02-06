public class Card
{
    private String name;

    public Card()
    {
        name = "";
    }

    public Card(String n)
    {
        name = n;
    }

    public String getName()
    {
        return name;
    }

    public boolean isExpired()
    {
        return false;
    }

    public String toString()
    {
        return "Card holder: " + name;
    }

    public boolean equals(Object card1)
    {
        if (card1 == null)
        {
            return false;
        }
        if (this.getClass() == card1.getClass())
        {
            Card other = (Card) card1;
            return this.name.equals(other.name);
        }
        return false;
    }
}