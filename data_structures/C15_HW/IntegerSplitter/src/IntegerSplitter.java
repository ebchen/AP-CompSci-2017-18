

import java.util.Scanner;
import java.util.Stack;
/**
   Class for splitting an integer into its individual digits.
*/
public class IntegerSplitter
{
   /**
      Splits the given integer into its individual digits
      and prints them to the screen.
      @param number Integer to be split.
   */
   public static void split(int number)
   {
      Stack <Integer> stack = new Stack<>();

      while (number >9)
      {
         int digit = number % 10;
         number /= 10;
         stack.push(digit);
      }
      stack.push(number);

      while (!stack.empty())
      {
         System.out.print (stack.pop() + " ");
      }






   }
}
