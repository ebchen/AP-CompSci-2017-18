
public class StudentIDCard extends Card
{
    private String idNumber;

    public StudentIDCard(String n, String id)
    {  
        super(n);
        idNumber = id;
    }

    public String toString()
    {
        String name = super.toString();
        String output = "";
        output = output + "Student ID Card: " + name + "; ID Number: " + this.idNumber;
        return output;
    }
    
    public String getIDNumber()
    {
        return idNumber;
    }
    
    public boolean equals(Object card1)
    {
        if (card1== null) return false;
        if (this.getClass() == card1.getClass())
        {
            StudentIDCard other = (StudentIDCard) card1;
            return super.equals(other)
                && this.idNumber.equals(other.idNumber);
        }
        else return false;
    }
}
