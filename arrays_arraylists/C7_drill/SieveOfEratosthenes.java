import java.util.Scanner;

public class SieveOfEratosthenes
{
    
    private int limit;
    private int[] numbers;
    
    public SieveOfEratosthenes(int l)
    {
        limit = l;
        numbers = new int[limit - 2];
    }
    public static void main(String []args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println ("Limit : ");
        int l = s.nextInt();
        
    }
}
