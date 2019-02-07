public class MilkJarCalculator
{
   public static void main(String[] args)
   {
      double milk = 5.5; // gallons
      double jarCapacity = 0.75; // gallons
      //int completelyFilledJars = milk / jarCapacity;
      /*
       * can't use int, must use double
       */
      int completelyFilledJars = (int) ( milk / jarCapacity);
      System.out.println(completelyFilledJars);
   }
}
