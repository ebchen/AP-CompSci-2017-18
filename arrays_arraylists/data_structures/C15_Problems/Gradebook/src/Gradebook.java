
import java.io.*;
import java.util.*;
/*
   A program to add, remove, modify or print
   student names and grades.
*/
public class Gradebook
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);

      Map<String,String> gradebook = new TreeMap<>();

      boolean done = false;
      while(!done)
      {
         System.out.println("A)dd R)emove M)odify P)rint Q)uit");
         String input = in.next().toUpperCase();
         if (input.equals("Q"))
         {
            done = true;
         }
         else if (input.equals("A"))
         {
            System.out.print("Name: ");
            String n = in.next();
            System.out.println();
            System.out.print("Grade: ");
            String g = in.next();
            System.out.println();

            gradebook.put(n,g);
         }
         else if (input.equals("R"))
         {
            System.out.print("Name: ");
            String n = in.next();
            System.out.println();
            gradebook.remove(n);
         }
         else if (input.equals("M"))
         {
            System.out.print("Name: ");
            String n = in.next();
            System.out.println();
            System.out.print("New Grade: ");
            String g = in.next();
            System.out.println();

            gradebook.put(n,g);
         }
         else if (input.equalsIgnoreCase("P"))
         {
            for (String s : gradebook.keySet())
            {
               System.out.println(s+": " + gradebook.get(s));
            }
         }
         else
         {
            done = true;
         }
      }
   }
}
