

import java.util.LinkedList;
import java.util.ListIterator;

/**
   This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
   /**
      Reverses the elements in a linked list
      @param strings the linked list to reverse
   */
   public static void reverse(LinkedList<String> strings)
   {
       /*
      ListIterator<String> it = strings.listIterator();

      LinkedList<String> stringCopy = new LinkedList<>();
      while (it.hasNext())
      {
          String n = it.next();
          stringCopy.add(n);
      }

      ListIterator<String> it2 = stringCopy.listIterator();
      while (it2.hasNext())
      {
          String n = it2.next();
          it.previous();
          it.set(n);
      }
      */
      //
       if (strings.size() >1)
       {
           String s = strings.removeFirst();
           reverse(strings);
           strings.addLast(s);
       }
   }


}