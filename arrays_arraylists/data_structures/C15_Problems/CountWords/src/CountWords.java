import java.util.*;
import java.io.*;

import java.io.File;
import java.util.Scanner;
import java.util.TreeSet;
/**
   Write a program that reads text from a file and breaks
   it up into individual words. Insert the words into a tree set.
   At the end of the input file, print all words, followed
   by the size of the resulting set. This program determines
   how many unique words a text file has.
*/
public class CountWords
{
   public static void main(String[] args)
   {
      String fileName = "src/test3.txt";

      try (Scanner in = new Scanner(new File(fileName)))
      {

         TreeSet<String> words = new TreeSet<>();

         int numWords = 0;
         while (in.hasNext())
         {
            String word = clean(in.next());
            numWords++;
            words.add(word);

         }

         // Print the words
         Iterator <String> it =  words.iterator();
         while (it.hasNext())
         {
            System.out.print (it.next() + " ");
         }
         System.out.println();
         System.out.println("Number of words: " + numWords);
         System.out.println("Number of words in set: " + words.size());

      }
      catch (FileNotFoundException e)
      {
         System.out.println("Cannot open: " + fileName);
      }
   }

   public static String clean(String s)
   {
      String r = "";
      for (int i = 0; i < s.length(); i++)
      {
         char c = s.charAt(i);
         if (Character.isLetter(c))
         {
            r = r + c;
         }
      }
      return r.toLowerCase();
   }
}
