
public class ATMCard extends Card
{
    private String cardNumber;
    private String pin;

    public ATMCard(String n, String cardNumber, String pin)
    {  
        super(n);
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    public String toString()
    {
        String name = super.toString();
        String output = "";
        output = output + "ATM Card: " + name + "; Card Number: " + this.cardNumber
        + "; PIN: " + pin;
        return output;
    }

    public String getCardNumber()
    {
        return cardNumber;
    }

    public String getPin()
    {
        return pin;
    }

    public boolean equals(Object card1)
    {
        if (card1== null) return false;
        if (this.getClass() == card1.getClass())
        {
            ATMCard other = (ATMCard) card1;
            return super.equals(other)
                && this.cardNumber.equals(other.cardNumber)
                && this.pin.equals(other.pin);
        }
        else return false;
    }
}
