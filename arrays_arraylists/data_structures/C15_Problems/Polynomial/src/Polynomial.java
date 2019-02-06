import java.util.LinkedList;
import java.util.ListIterator;

/**
   A class to represent a polynomial.
*/
public class Polynomial
{
   public LinkedList<Term> poly;
   public Polynomial()
   {
      poly = new LinkedList<>();
   }

   /**
      Constructs a new polynomial with the given term
      @param t the term to initialize the polynomial with
   */
   public Polynomial(Term t)
   {
      poly = new LinkedList<>();
      poly.add(t);
   }

   /**
      Adds the polynomial such that the terms are in sorted order
      from highest power to lowest
      @param p the polynomial to add
   */
   public void add(Polynomial p)
   {
      ListIterator <Term> it = poly.listIterator();

      ListIterator<Term> it2 = p.poly.listIterator();
      while (it2.hasNext())
      {
         Term t = it2.next();
         int pow = t.getPower();

         while (it.hasNext() )
         {
            Term t2 = it.next();
            int powC = t2.getPower();
            if (powC == pow)
            {
               it.set(new Term(t2.getCoefficient() + t.getCoefficient(), powC));
            }
            else if (powC > pow)
            {
               it.add(t);
            }
         }
      }
   }

   /**
      Multiplies the given polynomial with this one and returns the result
      @param p the polynomial to multiply
      @return this * p
   */
   //public Polynomial multiply(Polynomial p)
   {



   }

   /**
      Prints the polynomial "nicely" so that it reads
      from highest term to lowest and doesn't have a
      leading "+" if the first term is positive.
   */
   public void print()
   {
      ListIterator<Term> it = poly.listIterator();
      System.out.println("Size: " + poly.size());
      while (it.hasNext())
      {
         Term t = it.next();
         System.out.print(t.getCoefficient());
         System.out.print("x^");
         System.out.print(t.getPower());
         System.out.print(" + ");
      }


   }
}
