

import java.util.Scanner;
import java.util.Stack;

/**
   Class for reversing the order of a sentence.
*/
public class SentenceReverser
{
   /**
      Reverses the given sentence.
      @param sentence Sentence to be reversed.
      @return reversed sentence.
   */
   public static String reverse(String sentence)
   {
      Stack <String> st = new Stack<String>();

      Scanner s = new Scanner(sentence);
      String finalOutput ="";
      while (s.hasNext())
      {
         String word = s.next().toLowerCase();


         st.push(word);

         if (word.contains("."))
         {
            word = word.substring(0,word.length()-1);
            st.pop();
            st.push(word);
            String output = "";
            while (!st.empty())
            {
               output += st.pop();
               if (!st.empty()) output +=" ";
            }
            output+=".";
            finalOutput+= (output.substring(0,1).toUpperCase() + output.substring(1) + " ");
         }
      }



      return finalOutput;

   }
}
