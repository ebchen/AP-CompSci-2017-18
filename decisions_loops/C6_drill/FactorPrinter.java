import java.util.Scanner;

public class FactorPrinter
{
    public static void main( String [] args)
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        FactorGenerator gen = new FactorGenerator(n);
        while ( gen.hasMoreFactors())
        {
            System.out.println(gen.nextFactor());
        }
    }
}
