
public class Customer
{
    private double sales;
    private String names;
    public Customer( String name, double sale)
    {
        names = name;
        sales = sale;   
    }
    
    public double getSale()
    {
        return sales;
    }
    
    public String getName()
    {
        return names;
    }
    
    public void print()
    {
        System.out.println(names+"("+sales+") ");
    }
}
