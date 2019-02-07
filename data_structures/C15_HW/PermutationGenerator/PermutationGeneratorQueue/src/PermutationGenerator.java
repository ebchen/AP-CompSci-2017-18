import java.util.*;

public class PermutationGenerator
{
   /**
      Gets all permutations of a given word.
      @param word a word not containing the character '+'
      @return a list containing all permutations of word
   */
   public List<String> getPermutations(String word)
   {
      Stack <String> stack = new Stack<>();
      List<String> permutations = new ArrayList<String>();
      stack.push(word+"+");

      while (!stack.empty())
      {
         String top = stack.pop();
         if (top.substring(top.length()-1) == "+")
         {
            permutations.add(top.substring(0, top.length()-1));
         }
         else
         {

         }
      }

      return permutations;
   } 
}
