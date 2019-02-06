import java.util.ArrayList;
public class RadixSorter
{
   
   public static void sort(int[] a)
   {  
      ArrayList<Integer>[] digits = new ArrayList[10];
      boolean moreDigits = true;
      int place = 10;
      while (moreDigits)
      {
          for (int i = 0; i < 10; i++)
          {
              if (a[i] < (place/10)) moreDigits = false;
              else moreDigits = true;
              int digit = (a[i] % place)/(place/10);
              
              digits[digit].add(a[i]);
          }
          place*=10;
          
          for (int i = 0; i < 10; i++)
          {
              
          }
          
      }
      
   }
}
