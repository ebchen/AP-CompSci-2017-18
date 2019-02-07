import java.util.Scanner;

public class NumericalMethods
{
    public static void fibonacci( String [] args)
    {
        Scanner s = new Scanner(System.in);
        int f1 = 0, f2 = 0, f3 = 0;
        int n = s.nextInt();
        for (int i = 0 ; i < n; i++)
        {

            if (i == 0)
            {
                f1 = 0;
            }
            else if (i == 1)
            {
                f2 = 1;
            }
            else
            {
                f3 = f1 + f2;
                f1 = f2;
                f2 = f3;
            }
        }
        System.out.println(f2);

    }
    
   
}
