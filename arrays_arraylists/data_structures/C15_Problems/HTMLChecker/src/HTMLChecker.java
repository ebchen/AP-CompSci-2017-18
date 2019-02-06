import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
   Write a program that checks whether a sequence of HTML tags
   is properly nested. For each opening tag, such as <p>, there
   must be a closing tag </p>. A tag such as <p> may have other
   tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>

   The inner tags must be closed before the outer ones.
   Your program should process a file containing tags.
   For simplicity, assume that the tags are separated by
   spaces, and that there is no text inside the tags.
*/
public class HTMLChecker
{
   public static void main(String[] args)
   {
      String filename = "src/TagSample3.html";

      try (Scanner in = new Scanner(new File(filename)))
      {
         Stack <String> s = new Stack<>();
         while (in.hasNext())
         {
            String tag = in.next();
            if (tag.contains("/"))
            {
               tag = tag.replace("/","");
               if (s.empty())
               {
                  System.out.println("Not nested properly");
                  return;
               }
               String startTag = s.pop();
               if (!startTag.equals(tag))
               {
                  System.out.println("Not nested properly");
                  return;
               }
            }
            else s.push(tag);
         }
         if (!s.empty()) System.out.println("Not nested properly");
         System.out.println("Nested properly");






      }
      catch (FileNotFoundException e)
      {
         System.out.println("Cannot open: " + filename);
      }

   }
}
