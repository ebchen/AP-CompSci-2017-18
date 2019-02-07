import java.util.Scanner;

public class Algorithms
{
    /*
    * Loop Algorithm #6: Compare Adjacent Values
    * reads a series of numbers (ends with a letter)
    * if an adjacent duplicate number is entered, the loop is exited
    * return the adjacent duplicate number that was entered
    */
   public static int compareAdjacent()
   {
       int previous;
       Scanner s = new Scanner ( System.in);
       previous = s.nextInt();
       while (s.hasNextInt())
       {
           int number = s.nextInt();
           if ( number == previous)
           {
               System.out.println("adjacent number: " + number);
               return number;
            }
           previous = number;
       }
       System.out.println("no adjacent duplicates");
       return 0;
   }
}
