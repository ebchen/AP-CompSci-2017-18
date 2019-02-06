

import java.util.Scanner;
import java.util.*;
import java.io.*;

/**
   A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      System.out.println("Compute primes up to which integer?");
      int n = in.nextInt();

      Set<Integer> primes = new HashSet<>();

      for (int i = 1 ; i <=n; i++)
      {
         primes.add(i);
      }


      for (int i = 2; i <= n/2; i++) {
         Iterator<Integer>it = primes.iterator();
         while (it.hasNext())
         {
            int x = it.next();
            if (x/i > 1 && x % i == 0)
            {
               it.remove();
            }
         }
      }

      Iterator<Integer>it = primes.iterator();
      while (it.hasNext())
      {
         System.out.println(it.next());
      }

   }
}
