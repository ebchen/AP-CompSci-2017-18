import java.util.Scanner;
public class Substring
{
    public static void main (String [] args)
    {
        Scanner s = new Scanner ( System.in );
        String theString = s.next();
        
        for (int i = 1; i <= theString.length(); i++)
        {
            for (int j = 0; j < theString.length()-i+1; j++ )
            {
                System.out.println(theString.substring(j,j+i));
            }
            
        }
        
    }
}
