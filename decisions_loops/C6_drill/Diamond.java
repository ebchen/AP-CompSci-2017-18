import java.util.Scanner;

public class Diamond
{
    public static void main( String [] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.print("side length: ");
        int n = s.nextInt();
        for ( int i = 1; i <=n ; i++)
        {
            for (int k = 0; k < n - i; k++)
            {
                System.out.print(" ");
            }
            for (int j = 0; j < 2*i-1; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        for ( int i = n-1; i >= 1 ; i--)
        {
            for (int k = 0; k < n - i; k++)
            {
                System.out.print(" ");
            }
            for (int j = 0; j < 2*i-1; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
