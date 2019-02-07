import java.util.Scanner;

public class StringParsing
{
    
    public static void main( String [] args)
        {
          Scanner s = new Scanner(System.in);
          System.out.print ("Enter the number: ");
          String input = s.nextLine();
          String first = input.substring(0,input.length()-4);
          String second = input.substring(input.length()-3);
          System.out.println(first+second);
        }
    
}