
public class BubbleSorter
{
  
   public static void sort(int[] a)
   {  
       boolean sorted = false;
      while (!sorted)
      {
          sorted = true;
          for (int i = 0; i < a.length-1; i++)
          {
             
              if (a[i+1] < a[i])
              {
                  a[i+1] = a[i+1] ^ a[i];
                  a[i] = a[i] ^ a[i+1];
                  a[i+1] = a[i+1] ^ a[i];
                  sorted = false; 
              }
          }
      }
   }

   
}
