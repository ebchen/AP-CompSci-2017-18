

import java.util.Stack;
import java.util.Scanner;

/**
   Class for simulating a driveway and a street, using stacks
   of cars with license plate numbers as representation.
*/
public class Driveway
{
   /**
      Stack representing the cars in the driveway.
   */
   private Stack<Integer> driveway;
   /**
      Stack representing the cars in the street.
   */
   private Stack<Integer> street;

   /**
      Constructor.
   */
   public Driveway()
   {
      driveway = new Stack<>();
      street = new Stack<>();
   }

   /**
      Add the given license plate to the driveway.
    //  @param licencePlate number of license plate.
   */
   public void add(int licensePlate)
   {
      driveway.push(licensePlate);
      print();

   }

   /**
      Remove the given license plate from the driveway.
     // @param licencePlate number of license plate.
   */
   public void remove(int licensePlate)
   {
      boolean found = false;
      if (!driveway.contains(licensePlate)) return;
      while (!found)
      {
         int curr = driveway.pop();
         street.push(curr);
         if (curr == licensePlate) found = true;
         print();
      }

      street.pop();
      while (!street.empty())
      {
         driveway.push(street.pop());
         print();
      }

   }

   /**
      Prints the driveway and street details to the screen.
   */
   public void print()
   {
      System.out.println("In Driveway, starting at first in (one license plate per line):");
      Stack <Integer> printStack = new Stack<>();
      while (!driveway.empty())
      {
         printStack.push(driveway.pop());
      }
      while (!printStack.empty())
      {
         driveway.push(printStack.pop());
         System.out.print(driveway.peek() + " ");
      }
      System.out.println();

      System.out.println("In Street, starting at first in (one license plate per line):");
      Stack <Integer> printStack2 = new Stack<>();
      while (!street.empty())
      {
         printStack2.push(street.pop());
      }
      while (!printStack2.empty())
      {
         street.push(printStack2.pop());
         System.out.print(street.peek() + " ");
      }
      System.out.println();

   }
}
