import java.util.Scanner;

public class PrimePrinter
{
    public static void main( String [] args)
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        PrimeGenerator gen = new PrimeGenerator(n);
        for (int i = 2; i <= n; i++)
        {
            if (gen.isPrime(i)) System.out.println(i);
        }
    }
}
