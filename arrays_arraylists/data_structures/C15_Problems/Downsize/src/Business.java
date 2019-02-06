

import java.util.LinkedList;
import java.util.ListIterator;

/**
   Business utility methods.
*/
public class Business
{
   /**
      Removes every nth element from the linked list
      @param employeeNames the linked list to remove from
      @param n the parameter to determine "nth"
    */
   public static void downsize(LinkedList<String> employeeNames, int n)
   {
      ListIterator<String> it = employeeNames.listIterator();

      int count = 0;
      while (it.hasNext())
      {
         it.next();
         count++;

         if (count % n ==0)
         {
            it.remove();
         }
      }


   }
}
