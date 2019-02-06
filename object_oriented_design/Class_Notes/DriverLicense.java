import java.util.GregorianCalendar;
import java.util.Calendar;
public class DriverLicense extends Card
{
    private int expirationYear;
    public DriverLicense(String n, int expirationYear)
    {  
        super(n);
        this.expirationYear = expirationYear;
    }
    
    public String toString()
    {
        String name = super.toString();
        String output = "";
        output = output + "Driver's License: " + name + "; Expiration Year: " + this.expirationYear;
        return output;
    }
    
    public boolean isExpired()
    {
        GregorianCalendar calendar = new GregorianCalendar();
        if (calendar.get(Calendar.YEAR) > expirationYear) return true;
        else return false;
    }
    
    public int getExpiration()
    {
        return expirationYear;
    }
    
    public boolean equals(Object card1)
    {
        if (card1== null) return false;
        if (this.getClass() == card1.getClass())
        {
            DriverLicense other = (DriverLicense) card1;
            return super.equals(other)
                && this.expirationYear == other.expirationYear;
        }
        else return false;
    }
}
